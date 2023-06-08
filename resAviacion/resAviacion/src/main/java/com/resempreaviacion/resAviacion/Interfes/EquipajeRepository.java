package com.resempreaviacion.resAviacion.Interfes;

import com.resempreaviacion.resAviacion.Model.Equipaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipajeRepository extends JpaRepository<Equipaje, Integer> {
}
