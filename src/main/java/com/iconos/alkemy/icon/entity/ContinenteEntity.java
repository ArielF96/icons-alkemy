package com.iconos.alkemy.icon.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "continente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE continente SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ContinenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String denominacion;

    private boolean deleted = Boolean.FALSE;
}
