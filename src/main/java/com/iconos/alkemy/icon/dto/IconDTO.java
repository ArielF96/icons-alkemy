package com.iconos.alkemy.icon.dto;

import com.iconos.alkemy.icon.entity.PaisEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class IconDTO {

    private Long id;

    private String imagen;

    private String denominacion;

    private LocalDate fechaCreacion;

    private Long altura;

    private String historia;

    private List<PaisBasicDTO> paises;
}
