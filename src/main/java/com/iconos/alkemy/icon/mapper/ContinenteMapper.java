package com.iconos.alkemy.icon.mapper;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

@Component
public class ContinenteMapper {

    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
        ContinenteEntity entity = new ContinenteEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        return entity;
    }

    public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity) {
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId((entity.getId()));
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }
//
//    private LocalDate string2LocalDate(String stringDate) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date = LocalDate.parse(stringDate, formatter);
//        return date;
//    }
//
//    public void iconEntityRefreshValues(IconEntity entity, IconDTO iconDTO) {
//        entity.setImagen(iconDTO.getImagen());
//        entity.setDenominacion(iconDTO.getDenominacion());
//        entity.setFechaCreacion(
//                this.string2LocalDate(iconDTO.getFechaCreacion())
//        );
//        entity.setAltura(iconDTO.getAltura());
//        entity.setHistoria(iconDTO.getHistoria());
//    }
//
//    public Set<IconEntity> iconDTOList2Entity(List<IconDTO> dtos) {
//        Set<IconEntity> entities = new HashSet<>();
//        for (IconDTO dto : dtos) {
//            entities.add(this.iconDTO2Entity(dto));
//        }
//        return entities;
//    }

        /**
         * @param entities (Set or List)
         * @param loadPaises
         */

//    public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadPaises) {
//        List<IconDTO> dtos = new ArrayList<>();
//        for (IconEntity entity : entities) {
//            dtos.add(this.iconEntity2DTO(entity, loadPaises));
//        }
//        return dtos;
//    }
//
//    public List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<IconEntity entities>) {
//        List<IconBasicDTO> dtos = new ArrayList<>();
//        IconBasicDTO basicDTO;
//        for (IconEntity entity : entities) {
//            basicDTO = new IconBasicDTO();
//            basicDTO.setId(entity.getId());
//            basicDTO.setImagen(entity.getImagen());
//            basicDTO.setDenominacion(entity.getDenominacion());
//            dtos.add(basicDTO);
//        }
//        return dtos;
//    }
}
