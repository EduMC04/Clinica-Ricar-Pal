package com.clinica.ricardo_palma.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinica.ricardo_palma.model.Usuario;
import com.clinica.ricardo_palma.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));

        // 💡 CAMBIO CLAVE: Usamos el constructor que acepta una lista de Authorities/Roles vacía
        return new User(
            usuario.getCorreo(),               // Username (correo)
            usuario.getContrasena(),           // Contraseña (DEBE ESTAR CIFRADA)
            Collections.emptyList()            // Lista de Authorities/Roles vacía
        );
    }

}
