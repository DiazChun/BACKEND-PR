package com.resempreaviacion.resAviacion.Controllers;


import com.resempreaviacion.resAviacion.Interfes.ReservacionRepository;
import com.resempreaviacion.resAviacion.Model.Reservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservacionController {
    @Autowired
    private ReservacionRepository reservacionRepository;

    @GetMapping
    public List<Reservacion> getAllReservaciones() {
        return reservacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservacion> getReservacionById(@PathVariable int id) {
        Optional<Reservacion> reservacion = reservacionRepository.findById(id);
        if (reservacion.isPresent()) {
            return ResponseEntity.ok(reservacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Reservacion> insertReservacion(@RequestBody Reservacion reservacion) {
        Reservacion newReservacion = reservacionRepository.save(reservacion);
        return ResponseEntity.ok(newReservacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservacion> updateReservacion(@PathVariable int id, @RequestBody Reservacion reservacion) {
        Optional<Reservacion> reservacionOptional = reservacionRepository.findById(id);

        if (reservacionOptional.isPresent()) {
            Reservacion existingReservacion = reservacionOptional.get();
            existingReservacion.setIdPersona(reservacion.getIdPersona());
            existingReservacion.setDescripcionReservacion(reservacion.getDescripcionReservacion());
            existingReservacion.setSalida(reservacion.getSalida());
            existingReservacion.setDestino(reservacion.getDestino());
            existingReservacion.setLlegada(reservacion.getLlegada());

            Reservacion updatedReservacion = reservacionRepository.save(existingReservacion);
            return ResponseEntity.ok(updatedReservacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservacionById(@PathVariable int id) {
        Optional<Reservacion> reservacion = reservacionRepository.findById(id);
        if (reservacion.isPresent()) {
            reservacionRepository.delete(reservacion.get());
            return ResponseEntity.ok("Reservacion deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
