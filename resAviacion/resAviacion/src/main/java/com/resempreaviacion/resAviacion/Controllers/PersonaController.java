package com.resempreaviacion.resAviacion.Controllers;


import com.resempreaviacion.resAviacion.Interfes.PersonaRepository;
import com.resempreaviacion.resAviacion.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable int id) {
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Persona> insertPersona(@RequestBody Persona persona) {
        Persona newPersona = personaRepository.save(persona);
        return ResponseEntity.ok(newPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable int id, @RequestBody Persona persona) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            Persona existingPersona = personaOptional.get();
            existingPersona.setApellido(persona.getApellido());
            existingPersona.setFechaNacimiento(persona.getFechaNacimiento());
            existingPersona.setNacionalidad(persona.getNacionalidad());

            Persona updatedPersona = personaRepository.save(existingPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            personaRepository.delete(persona.get());
            return ResponseEntity.ok("Persona deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
