package com.iconos.alkemy.icon.controller;

import com.iconos.alkemy.icon.dto.PaisDTO;
import com.iconos.alkemy.icon.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paises")
public class PaisController {

    @Autowired
    private PaisService paisService;
    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais) {
        PaisDTO paisGuardado = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisGuardado);
    }

}
