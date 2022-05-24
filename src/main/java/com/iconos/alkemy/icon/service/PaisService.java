package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.PaisDTO;
import com.iconos.alkemy.icon.entity.PaisEntity;
import com.iconos.alkemy.icon.mapper.PaisMapper;
import com.iconos.alkemy.icon.repo.PaisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    @Autowired
    private PaisMapper paisMapper;

    @Autowired
    private PaisRepo paisRepo;

    public PaisDTO save(PaisDTO dto) {
        PaisEntity pais = paisMapper.paisDTO2Entity(dto);
        PaisEntity newPais = paisRepo.save(pais);
        PaisDTO result = paisMapper.paisEntity2DTO(newPais, false);
        return result;
    }
}
