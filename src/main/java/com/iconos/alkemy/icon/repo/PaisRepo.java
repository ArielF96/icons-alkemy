package com.iconos.alkemy.icon.repo;

import com.iconos.alkemy.icon.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepo extends JpaRepository <PaisEntity, Long> {
}
