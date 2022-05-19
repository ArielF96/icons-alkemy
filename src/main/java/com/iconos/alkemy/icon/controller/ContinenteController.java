package com.iconos.alkemy.icon.controller;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
        ContinenteDTO continenteGuardado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }
}
