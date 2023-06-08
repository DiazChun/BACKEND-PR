package com.resempreaviacion.resAviacion.Controllers;


import com.resempreaviacion.resAviacion.Interfes.EquipajeRepository;
import com.resempreaviacion.resAviacion.Model.Equipaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipajes")
public class EquipajeController {
    @Autowired
    private EquipajeRepository equipajeRepository;

    @GetMapping
    public List<Equipaje> getAllEquipajes() {
        return equipajeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipaje> getEquipajeById(@PathVariable int id) {
        Optional<Equipaje> equipaje = equipajeRepository.findById(id);
        if (equipaje.isPresent()) {
            return ResponseEntity.ok(equipaje.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Equipaje> insertEquipaje(@RequestBody Equipaje equipaje) {
        Equipaje newEquipaje = equipajeRepository.save(equipaje);
        return ResponseEntity.ok(newEquipaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipaje> updateEquipaje(@PathVariable int id, @RequestBody Equipaje equipaje) {
        Optional<Equipaje> equipajeOptional = equipajeRepository.findById(id);
        if (equipajeOptional.isPresent()) {
            Equipaje existingEquipaje = equipajeOptional.get();
            existingEquipaje.setIdPersona(equipaje.getIdPersona());
            existingEquipaje.setIdVuelo(equipaje.getIdVuelo());
            existingEquipaje.setDescripcion(equipaje.getDescripcion());
            existingEquipaje.setValidacion(equipaje.isValidacion());
            existingEquipaje.setRevision(equipaje.isRevision());

            Equipaje updatedEquipaje = equipajeRepository.save(existingEquipaje);
            return ResponseEntity.ok(updatedEquipaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipajeById(@PathVariable int id) {
        Optional<Equipaje> equipaje = equipajeRepository.findById(id);
        if (equipaje.isPresent()) {
            equipajeRepository.delete(equipaje.get());
            return ResponseEntity.ok("Equipaje deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
