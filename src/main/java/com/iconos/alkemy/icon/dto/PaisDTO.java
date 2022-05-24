package com.iconos.alkemy.icon.dto;

import com.iconos.alkemy.icon.entity.ContinenteEntity;
import com.iconos.alkemy.icon.entity.IconEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaisDTO {

    private Long id;

    private String imagen;

    private String denominacion;

    private Long cantidadHabitantes;

    private Long superficie;

    private Long continenteId;

    private List<IconDTO> icons = new ArrayList<>();
}
