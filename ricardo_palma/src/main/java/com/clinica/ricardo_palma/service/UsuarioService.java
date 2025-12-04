package com.clinica.ricardo_palma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ricardo_palma.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean existeUsuarioPorCorreoYContrasena(String correo, String contrasena) {
        return usuarioRepository.findAll().stream()
                .anyMatch(usuario -> usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena));
    }

}
