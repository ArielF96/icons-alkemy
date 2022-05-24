package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.entity.ContinenteEntity;
import com.iconos.alkemy.icon.mapper.ContinenteMapper;
import com.iconos.alkemy.icon.repo.ContinenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepo continenteRepo;


    public ContinenteDTO save(ContinenteDTO dto) {
        ContinenteEntity continente = continenteMapper.continenteDTO2Entity(dto);
        ContinenteEntity newContinente = continenteRepo.save(continente);
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(newContinente);
        return result;
    }


}
