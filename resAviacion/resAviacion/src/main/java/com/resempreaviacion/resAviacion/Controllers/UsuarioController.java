package com.resempreaviacion.resAviacion.Controllers;

import com.resempreaviacion.resAviacion.Interfes.UsuarioRepository;
import com.resempreaviacion.resAviacion.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{nombreUsuario}/{contrasena}")
    public ResponseEntity<Integer> validarCredenciales(@PathVariable String nombreUsuario, @PathVariable String contrasena) {
        // Lógica para validar las credenciales
        Optional<Usuario> usuario = usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(1); // Credenciales válidas
        } else {
            return ResponseEntity.ok(0); // Credenciales inválidas
        }
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario existingUsuario = usuarioOptional.get();
            existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
            existingUsuario.setContrasena(usuario.getContrasena());
            existingUsuario.setIdPersona(usuario.getIdPersona());

            Usuario updatedUsuario = usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.ok("Usuario deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

