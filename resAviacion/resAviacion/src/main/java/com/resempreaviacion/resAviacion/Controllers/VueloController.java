package com.resempreaviacion.resAviacion.Controllers;


import com.resempreaviacion.resAviacion.Interfes.VueloRepository;
import com.resempreaviacion.resAviacion.Model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
    @Autowired
    private VueloRepository vueloRepository;

    @GetMapping
    public List<Vuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> getVueloById(@PathVariable int id) {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);
        if (vuelo.isPresent()) {
            return ResponseEntity.ok(vuelo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Vuelo> insertVuelo(@RequestBody Vuelo vuelo) {
        Vuelo newVuelo = vueloRepository.save(vuelo);
        return ResponseEntity.ok(newVuelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> updateVuelo(@PathVariable int id, @RequestBody Vuelo vuelo) {
        Optional<Vuelo> vueloOptional = vueloRepository.findById(id);
        if (vueloOptional.isPresent()) {
            Vuelo existingVuelo = vueloOptional.get();
            existingVuelo.setIdReservacion(vuelo.getIdReservacion());
            existingVuelo.setIdPersona(vuelo.getIdPersona());
            existingVuelo.setNumeroAsiento(vuelo.getNumeroAsiento());
            existingVuelo.setHoraAbordaje(vuelo.getHoraAbordaje());
            existingVuelo.setDescripcionVuelo(vuelo.getDescripcionVuelo());

            Vuelo updatedVuelo = vueloRepository.save(existingVuelo);
            return ResponseEntity.ok(updatedVuelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVueloById(@PathVariable int id) {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);
        if (vuelo.isPresent()) {
            vueloRepository.delete(vuelo.get());
            return ResponseEntity.ok("Vuelo deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
