package com.bantads.conta.bantadsconta.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.conta.bantadsconta.DTOs.MovimentacaoDTO;
import com.bantads.conta.bantadsconta.DTOs.MovimentacaoResponseDTO;
import com.bantads.conta.bantadsconta.DTOs.MovimentacoesResponseDTO;
import com.bantads.conta.bantadsconta.DTOs.GerentesContasResposeDTO;
import com.bantads.conta.bantadsconta.DTOs.MovimentacaoContaDTO;
import com.bantads.conta.bantadsconta.data.CUD.ContaCRepository;
import com.bantads.conta.bantadsconta.data.CUD.MovimentacaoCRepository;
import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.data.R.MovimentacaoRRepository;
import com.bantads.conta.bantadsconta.model.TipoMovimentacao;
import com.bantads.conta.bantadsconta.model.CUD.ContaC;
import com.bantads.conta.bantadsconta.model.CUD.MovimentacaoC;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;
import com.bantads.conta.bantadsconta.model.R.MovimentacaoR;
import com.bantads.conta.bantadsconta.services.SenderMovimentacao;

@CrossOrigin
@RestController
@RequestMapping("movimentacao")
public class MovimentacaoController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private SenderMovimentacao senderMov;

	@Autowired
	private ContaCRepository contaCRepository;

	@Autowired
	private MovimentacaoRRepository movimentacaoRRepository;

	@Autowired
	private MovimentacaoCRepository movimentacaoCRepository;

	@Autowired
	private GerenteContaRepository gerenteContaRepository;

	@PostMapping()
	public ResponseEntity<MovimentacaoContaDTO> insere(@RequestBody MovimentacaoDTO mov) {

		try {
			// INSERE A MOVIMENTACAO
			MovimentacaoC movimentacao = new MovimentacaoC(mov);

			Optional<ContaC> origemOpt = contaCRepository.findById(mov.getOrigem());
			if (!origemOpt.isPresent())
				return ResponseEntity.notFound().build();

			ContaC origem = origemOpt.get();
			ContaC destino = null;

			if (mov.getDestino() != 0) {
				destino = contaCRepository.findByNumero(mov.getDestino());
				movimentacao.setDestino(destino.getId());
			}

			movimentacaoCRepository.save(movimentacao);

			// ATUALIZA O SALDO DA CONTA
			switch (mov.getTipoMovimentacao()) {

				case 1:// deposito
					origem.setSaldo(origem.getSaldo().add(mov.getValor()));
					contaCRepository.save(origem);
					break;

				case 2:// saque
					if (mov.getValor().compareTo(origem.getSaldo().add(origem.getLimite())) == 1) {
						return ResponseEntity.status(400).build();
					} else {
						origem.setSaldo(origem.getSaldo().subtract(mov.getValor()));
						contaCRepository.save(origem);
					}
					break;

				case 3:// transferencia
					if (mov.getValor().compareTo(origem.getSaldo().add(origem.getLimite())) == 1) {
						return ResponseEntity.status(400).build();
					} else if (destino == null) {
						return ResponseEntity.notFound().build();
					} else {
						origem.setSaldo(origem.getSaldo().subtract(mov.getValor()));
						destino.setSaldo(destino.getSaldo().add(mov.getValor()));
						contaCRepository.save(origem);
						contaCRepository.save(destino);
					}
					break;

				default:
					return ResponseEntity.status(400).build();
			}

			// MANDA PRA FILA DE DO READ QUE ATUALIZA OS DOIS E O gerenteconta
			MovimentacaoContaDTO movSender = new MovimentacaoContaDTO(movimentacao, origem, destino);
			senderMov.sendInserirRead(movSender);

			return ResponseEntity.ok().body(movSender);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}

	@GetMapping("/obter-data/{cliente}/{dataInicio}/{dataFim}")
	public ResponseEntity<MovimentacoesResponseDTO> obtemPorData(@PathVariable UUID cliente,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFim) {
		try {
			List<MovimentacaoR> movimentacoes = movimentacaoRRepository.obtemMovimentacoesCliente(cliente, dataInicio,
					dataFim);
			MovimentacoesResponseDTO response = new MovimentacoesResponseDTO(movimentacoes);
			return ResponseEntity.ok().body(response);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}

	@GetMapping("/gerente-conta")
	public ResponseEntity<GerentesContasResposeDTO> obtemTop5Gerentes() {
		try {
			List<GerenteConta> resultado = gerenteContaRepository.findAll();
			GerentesContasResposeDTO response = new GerentesContasResposeDTO(resultado);
			return ResponseEntity.ok().body(response);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
}
