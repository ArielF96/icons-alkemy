package com.iconos.alkemy.icon.dto;

import com.iconos.alkemy.icon.entity.ContinenteEntity;
import com.iconos.alkemy.icon.entity.IconEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaisDTO {

    private Long id;

    private String imagen;

    private String denominacion;

    private Long cantidadHabitantes;

    private Long superficie;

    private ContinenteEntity continente;

    private Long continenteId;

    private List<IconEntity> icons = new ArrayList<>();
}
