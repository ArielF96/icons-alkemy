package com.iconos.alkemy.icon.mapper;

import com.iconos.alkemy.icon.dto.IconDTO;
import com.iconos.alkemy.icon.entity.PaisEntity;
import com.iconos.alkemy.icon.dto.PaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;
    //TODO missing code


    /*entity.setCantidadHabitantes(dto.getCantidadHabitantes());
    entity.setContinenteId(dto.getContinenteId());
    entity.setSuperficie(dto.getSuperficie());
    //icons
    Set<IconEntity> icons = this.iconMapper.iconDTOList2Entity(dto.getIcons());
    entity.setIcons(icons);
    return entity;*/

    public PaisEntity paisDTO2Entity(PaisDTO dto) {
        PaisEntity entity = new PaisEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setContinenteId(dto.getContinenteId());
        entity.setSuperficie(dto.getSuperficie());
        return entity;
    }

    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setContinenteId(entity.getContinenteId());
        dto.setSuperficie(entity.getSuperficie());
        if (loadIcons) {
            List<IconDTO> iconDTOS = this.iconMapper.iconEntityList2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }
        return dto;
    }
//
    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(this.paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public List<PaisEntity> paisDTOList2Entity(List<PaisDTO> dtos) {
        List<PaisEntity> entities = new ArrayList<>();
        for (PaisDTO dto : dtos) {
            entities.add(this.paisDTO2Entity(dto));
        }
        return entities;
    }

}
