package com.resempreaviacion.resAviacion.Interfes;


import com.resempreaviacion.resAviacion.Model.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion, Integer> {
    //Optional<Reservacion> findByIdIdentificacion(Integer idIdentificacion);
}
