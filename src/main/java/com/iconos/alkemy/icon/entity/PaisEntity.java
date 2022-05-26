package com.iconos.alkemy.icon.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id=?" )
@Where(clause = "deleted=false")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String denominacion;

    private boolean deleted = Boolean.FALSE;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie; //metros cuadrados

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "icon_id"),
            inverseJoinColumns = @JoinColumn(name = "pais_id"))
    private List<IconEntity> icons = new ArrayList<>();

    public void addIcon(IconEntity icon) {this.icons.add(icon); }

    public void removeIcon(IconEntity icon) {this.icons.remove(icon); }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        final PaisEntity other = (PaisEntity) obj;
//        return other.id == this.id;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaisEntity pais = (PaisEntity) o;
        if (!Objects.equals(id, pais.id)) return false;
        return Objects.equals(icons, pais.icons);
    }

}
