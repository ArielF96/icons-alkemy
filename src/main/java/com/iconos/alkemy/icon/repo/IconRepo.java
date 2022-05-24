package com.iconos.alkemy.icon.repo;

import com.iconos.alkemy.icon.entity.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepo extends JpaRepository<IconEntity, Long> {
}
