package com.resempreaviacion.resAviacion.Interfes;

import com.resempreaviacion.resAviacion.Model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}
