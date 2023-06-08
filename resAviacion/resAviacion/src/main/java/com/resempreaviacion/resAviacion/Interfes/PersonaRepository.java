package com.resempreaviacion.resAviacion.Interfes;

import com.resempreaviacion.resAviacion.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
