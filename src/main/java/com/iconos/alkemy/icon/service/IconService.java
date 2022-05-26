package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.IconBasicDTO;
import com.iconos.alkemy.icon.dto.IconDTO;
import com.iconos.alkemy.icon.entity.IconEntity;
import com.iconos.alkemy.icon.mapper.IconMapper;
import com.iconos.alkemy.icon.repo.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private IconRepo iconRepo;

    @Autowired
    private PaisService paisService;

    public IconDTO save(IconDTO dto) {
        IconEntity icon = iconMapper.iconDTO2Entity(dto);
        IconEntity newIcon = iconRepo.save(icon);
        IconDTO result = iconMapper.iconEntity2DTO(newIcon, true);
        return result;
    }

    public List<IconBasicDTO> findAll() {
//        List<ContinenteDTO> continentes = new ArrayList<>();
        List<IconEntity> entities = iconRepo.findAll();
        List<IconBasicDTO> dtos = iconMapper.iconEntityList2BasicDTOList(entities);
        return dtos;
    }

    public IconDTO getDetailsById(Long id) {
        Optional<IconEntity> entity = iconRepo.findById(id);
        if (entity.isPresent()) {
            IconDTO dto = iconMapper.iconEntity2DTO(entity.get(), true);
            return dto;
        }
        return null;
    }

//    public void addPais(Long id, Long idPais) {
//        IconEntity entity = this.iconRepo.getById(id);
//        entity.getPaises().size();
//        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
//        entity.addPais(paisEntity);
//        this.iconRepo.save(entity);
//    }

    public IconEntity getEntityById(Long id) {
        IconEntity icon = iconRepo.getById(id);
        return icon;
    }

    public void delete (Long id) {
        Optional<IconEntity> entity = iconRepo.findById(id);
        if (entity.isPresent()) {
            iconRepo.delete(entity.get());
        }
    }

    /*public void removePais(Long id, Long idPais) {
        IconEntity entity = this.iconRepository.getById(id);
        entity.getPaises().size();
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.removePais(paisEntity);
        this.iconRepository.save(entity);
    }



    @Override
    public List<CharacterBasicDTO> getByFilters(String name, Long age, List<Long> moviesId, String order) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, moviesId, order);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
        List<CharacterBasicDTO> dtos = characterMapper.characterEntityList2BasicDTOList(entities);
        return dtos;
    }

    public CharacterDetailledDTO getById (Long id) {
        Optional <CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        CharacterDetailledDTO character = characterMapper.characterEntity2DTO(entity.get(), true);
        return character;
    }

    public CharacterDetailledDTO update(Long id, CharacterDetailledDTO dto) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        characterMapper.update(entity.get(), dto);
        characterRepository.save(entity.get());
        CharacterDetailledDTO result = characterMapper.characterEntity2DTO(entity.get(), true);// CONSULTAR COMO AGREGAR EL LOADPELICULAS FALSE
        return result;
    }



}
*/
}
