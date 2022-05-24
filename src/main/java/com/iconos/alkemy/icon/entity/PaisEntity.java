package com.iconos.alkemy.icon.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pais")
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id=?" )
@Where(clause = "deleted=false")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    private boolean deleted = Boolean.FALSE;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie; //metros cuadrados

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    @NotNull
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private List<IconEntity> icons = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PaisEntity other = (PaisEntity) obj;
        return other.id == this.id;
    }
}
