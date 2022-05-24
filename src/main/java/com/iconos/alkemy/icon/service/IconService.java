package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.dto.IconDTO;
import com.iconos.alkemy.icon.entity.IconEntity;
import com.iconos.alkemy.icon.mapper.IconMapper;
import com.iconos.alkemy.icon.repo.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconService {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private IconRepo iconRepo;

    public IconDTO save(IconDTO dto) {
        IconEntity icon = iconMapper.iconDTO2Entity(dto);
        IconEntity newIcon = iconRepo.save(icon);
        IconDTO result = iconMapper.iconEntity2DTO(newIcon, true);
        return result;
    }

    /*public void addPais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(id);
        entity.getPaises().size();
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.addPais(paisEntity);
        this.iconRepository.save(entity);
    }

    public void removePais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(id);
        entity.getPaises().size();
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.removePais(paisEntity);
        this.iconRepository.save(entity);
    }

    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }
*/
}
