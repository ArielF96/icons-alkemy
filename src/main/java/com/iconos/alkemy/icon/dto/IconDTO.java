package com.iconos.alkemy.icon.dto;

import com.iconos.alkemy.icon.Entity.PaisEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private List<PaisDTO> paises;
}
