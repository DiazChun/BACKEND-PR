package com.resempreaviacion.resAviacion.Interfes;


import com.resempreaviacion.resAviacion.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);

}
