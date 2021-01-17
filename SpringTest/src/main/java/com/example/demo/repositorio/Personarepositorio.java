package com.example.demo.repositorio;

import com.example.demo.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Personarepositorio extends JpaRepository<Persona, Long>{

}
