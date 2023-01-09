package com.bantads.gerente.bantadsgerente.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.gerente.bantadsgerente.data.GerenteRepository;
import com.bantads.gerente.bantadsgerente.model.Gerente;

@CrossOrigin
@RestController
@RequestMapping("gerentes")
public class GerenteController {
    @Autowired
    private GerenteRepository gerenteRepository;

    @GetMapping("/health")
    public String getUsuarios() {
        return "ʕ·͡ᴥ·ʔ";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> getGerente(@PathVariable UUID id){
        try {
            Optional<Gerente> gerenteOp = gerenteRepository.findById(id);

            if (gerenteOp.isPresent()){
                Gerente gerente = gerenteOp.get();
                return ResponseEntity.ok(gerente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/por-usuario/{idExternoUsuario}")
    public ResponseEntity<Gerente> getGerentePorUsuario(@PathVariable UUID idExternoUsuario) {
        try {
            Gerente gerente = gerenteRepository.findByIdExternoUsuario(idExternoUsuario);

            if (gerente != null) {
                return ResponseEntity.ok(gerente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    @GetMapping("/por-cpf/{cpf}")
    public ResponseEntity<Gerente> getGerentePorUsuario(@PathVariable String cpf) {
        try {
            Gerente gerente = gerenteRepository.findByCpf(cpf);

            if (gerente != null) {
                return ResponseEntity.ok(gerente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Gerente> putGerente(@PathVariable UUID id, @RequestBody Gerente gerenteUp) {
        try {
        	Optional<Gerente> gerenteOp = gerenteRepository.findById(id);
        	if (gerenteOp.isPresent()){
                if(gerenteRepository.existsByCpf(gerenteUp.getCpf()))
                    return ResponseEntity.status(409).build();
                Gerente gerente = gerenteOp.get();
                gerente.setNome(gerenteUp.getNome());
                gerente.setCpf(gerenteUp.getCpf());
                
                gerente = gerenteRepository.save(gerente);
                return ResponseEntity.ok(gerente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}