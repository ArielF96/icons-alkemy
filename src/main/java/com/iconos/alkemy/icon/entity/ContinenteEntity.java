package com.iconos.alkemy.icon.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "continente")
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?" )
@Where(clause = "deleted=false")
public class ContinenteEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    private boolean deleted = Boolean.FALSE;
}
