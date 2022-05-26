package com.iconos.alkemy.icon.service;

import com.iconos.alkemy.icon.dto.ContinenteDTO;
import com.iconos.alkemy.icon.entity.ContinenteEntity;
import com.iconos.alkemy.icon.mapper.ContinenteMapper;
import com.iconos.alkemy.icon.repo.ContinenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepo continenteRepo;
    @Autowired
    private PaisService paisService;


    public ContinenteDTO save(ContinenteDTO dto) {
        ContinenteEntity continente = continenteMapper.continenteDTO2Entity(dto);
        ContinenteEntity newContinente = continenteRepo.save(continente);
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(newContinente);
        return result;
    }

    public List<ContinenteDTO> findAll() {
//        List<ContinenteDTO> continentes = new ArrayList<>();
        List<ContinenteEntity> entities = continenteRepo.findAll();
        List<ContinenteDTO> dtos = continenteMapper.continenteEntityList2DTOList(entities);
        return dtos;
    }

    public ContinenteDTO getDetailsById(Long id) {
        Optional<ContinenteEntity> entity = continenteRepo.findById(id);
        if (entity.isPresent()) {
            ContinenteDTO dto = continenteMapper.continenteEntity2DTO(entity.get());
            return dto;
        }
        return null;
//        if (!entity.isPresent()) {
//            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
//        }
    }

    public void deletePaises(Long id) {
        Optional<ContinenteEntity> entity = continenteRepo.findById(id);
        if (entity.isPresent()) {
            paisService.buscarPorContinente(id);
        }
    }

    public void delete (Long id) {
        Optional<ContinenteEntity> entity = continenteRepo.findById(id);
        if (entity.isPresent()) {
            continenteRepo.delete(entity.get());
        }
    }

}
