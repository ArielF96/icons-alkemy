package com.iconos.alkemy.icon.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "icons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?" )
@Where(clause = "deleted=false")
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long altura;

    private String historia;

    private boolean deleted = Boolean.FALSE;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "pais_id")
//    private PaisEntity pais;

    @ManyToMany(mappedBy = "icons", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PaisEntity> paises = new ArrayList<>();

    //Add and remove paises
//    public void addPais(PaisEntity pais) {this.paises.add(pais); }
//    public void removePais(PaisEntity pais) {this.paises.remove(pais); }

}
