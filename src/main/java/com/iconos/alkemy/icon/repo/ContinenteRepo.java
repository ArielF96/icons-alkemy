package com.iconos.alkemy.icon.repo;

import com.iconos.alkemy.icon.entity.ContinenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinenteRepo extends JpaRepository<ContinenteEntity, Long> {
}
