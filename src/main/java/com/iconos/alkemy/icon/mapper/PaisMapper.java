package com.iconos.alkemy.icon.mapper;

import com.iconos.alkemy.icon.dto.IconBasicDTO;
import com.iconos.alkemy.icon.dto.PaisBasicDTO;
import com.iconos.alkemy.icon.entity.PaisEntity;
import com.iconos.alkemy.icon.dto.PaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;

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
            List<IconBasicDTO> iconDTOS = this.iconMapper.iconEntityList2BasicDTOList(entity.getIcons());
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

    public List<PaisBasicDTO> paisEntityList2BasicDTOList(List<PaisEntity> entities) {
        List<PaisBasicDTO> dtos = new ArrayList<>();
        PaisBasicDTO basicDTO;
        for (PaisEntity entity : entities) {
            basicDTO = new PaisBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            dtos.add(basicDTO);
        }
        return dtos;
    }

}
