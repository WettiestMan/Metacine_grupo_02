package com.grupo02.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo02.web.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Long>{
    
}
