package com.iconos.alkemy.icon.controller;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.dto.IconDTO;
import com.iconos.alkemy.icon.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> findAll() {
        List<ContinenteDTO> continentes = this.continenteService.findAll();
        return ResponseEntity.ok(continentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContinenteDTO> getDetailsById(@PathVariable Long id) {
        ContinenteDTO continente = this.continenteService.getDetailsById(id);
        return ResponseEntity.ok(continente);
    }
//
//    @GetMapping
//    public ResponseEntity<List<IconDTO>> getDetailsByFilters(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String date,
//            @RequestParam(required = false) Set<Long> cities,
//            @RequestParam(required = false, defaultValue = "ASC") String order
//    ) {
//        List<IconDTO> icons = this.iconService.getByFilters(name, date, cities, order);
//        return ResponseEntity.ok(icons);
//    }
//
//    @PostMapping
//    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
//        IconDTO result = this.iconService.save(icon);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon) {
//        IconDTO result = this.iconService.update(id, icon);
//        return ResponseEntity.ok().body(result);
//    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<ContinenteDTO> delete(@PathVariable Long id) {
        this.continenteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//
//    @PostMapping("/{id}/pais/{idPais}")
//    public ResponseEntity<Void> addPais(@PathVariable Long id, @PathVariable Long idPais) {
//        this.iconService.addPais(id, idPais);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @DeleteMapping("/{id}/pais/{idPais}")
//    public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idPais) {
//        this.iconService.removePais(id, idPais);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }


}
