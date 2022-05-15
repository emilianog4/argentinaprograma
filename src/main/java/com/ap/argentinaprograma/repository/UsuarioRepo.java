package com.ap.argentinaprograma.repository;

import com.ap.argentinaprograma.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    
}
