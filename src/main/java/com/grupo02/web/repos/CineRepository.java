package com.grupo02.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo02.web.models.Cine;

public interface CineRepository extends JpaRepository<Cine, Long> {
    
}
