package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.PaisDTO;
import com.iconos.alkemy.icon.entity.IconEntity;
import com.iconos.alkemy.icon.entity.PaisEntity;
import com.iconos.alkemy.icon.mapper.PaisMapper;
import com.iconos.alkemy.icon.repo.PaisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisMapper paisMapper;

    @Autowired
    private PaisRepo paisRepo;

    @Autowired
    private IconService iconService;

    public PaisDTO save(PaisDTO dto) {
        PaisEntity pais = paisMapper.paisDTO2Entity(dto);
        PaisEntity newPais = paisRepo.save(pais);
        PaisDTO result = paisMapper.paisEntity2DTO(newPais, true);
        return result;
    }

    public List<PaisDTO> findAll() {
//        List<ContinenteDTO> continentes = new ArrayList<>();
        List<PaisEntity> entities = paisRepo.findAll();
        List<PaisDTO> dtos = paisMapper.paisEntityList2DTOList(entities, true);
        return dtos;
    }

    public PaisEntity getEntityById(Long id) {
        PaisEntity pais = paisRepo.getById(id);
        return pais;
    }

    public void delete (Long id) {
        Optional<PaisEntity> entity = paisRepo.findById(id);
        if (entity.isPresent()) {
            paisRepo.delete(entity.get());
        }
    }

    public void addIcon(Long id, Long idIcon) {
        PaisEntity entity = this.paisRepo.getById(id);
        //entity.getPaises().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.addIcon(iconEntity);
        this.paisRepo.save(entity);
    }

    public void removeIcon(Long id, Long idIcon) {
        PaisEntity entity = this.paisRepo.getById(id);
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.removeIcon(iconEntity);
        this.paisRepo.save(entity);
    }

}
