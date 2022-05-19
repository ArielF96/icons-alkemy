package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import org.springframework.stereotype.Service;

@Service
public class ContinenteService {

    public ContinenteDTO save(ContinenteDTO dto) {
        // TODO: guardar continente
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }
}
