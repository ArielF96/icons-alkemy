package com.iconos.alkemy.icon.controller;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.dto.PaisDTO;
import com.iconos.alkemy.icon.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PaisDTO>> findAll() {
        List<PaisDTO> paises = this.paisService.findAll();
        return ResponseEntity.ok(paises);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaisDTO> delete(@PathVariable Long id) {
        this.paisService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/icon/{idIcon}")
    public ResponseEntity<Void> addIcon(@PathVariable Long id, @PathVariable Long idIcon) {
        this.paisService.addIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/icon/{idIcon}")
    public ResponseEntity<Void> removeIcon(@PathVariable Long id, @PathVariable Long idIcon) {
        this.paisService.removeIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
