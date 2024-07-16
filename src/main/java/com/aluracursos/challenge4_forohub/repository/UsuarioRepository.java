package com.aluracursos.challenge4_forohub.repository;

import com.aluracursos.challenge4_forohub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.security.core.userdetails.UserDetails;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  //  UserDetails findByNombreUsuario(String nombreUsuario);
}
