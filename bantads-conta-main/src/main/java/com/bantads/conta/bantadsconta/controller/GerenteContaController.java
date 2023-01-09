package com.bantads.conta.bantadsconta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.conta.bantadsconta.data.R.GerenteContaRepository;
import com.bantads.conta.bantadsconta.model.R.GerenteConta;

@CrossOrigin
@RestController
@RequestMapping("gerentes")
public class GerenteContaController {
    @Autowired
    private GerenteContaRepository gerenteContaRepository;

    @GetMapping("/contas")
    public ResponseEntity<List<GerenteConta>> getGrenteContas() {
        try {
            List<GerenteConta> gerentes = gerenteContaRepository.findAll();
            return ResponseEntity.ok().body(gerentes);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/health")
    public String health() {
        return "ʕ·͡ᴥ·ʔ";
    }
}
