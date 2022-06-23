package com.tobias.decalcenter.repositories;

import com.tobias.decalcenter.models.Decal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecalRepository extends JpaRepository<Decal, Long> {
    List<Decal> findAllDecalsByNameEqualsIgnoreCase(String name);
}
