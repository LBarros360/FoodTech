package br.com.fiap.FoodTech.services;

import br.com.fiap.FoodTech.dtos.LoginRequestDTO;
import br.com.fiap.FoodTech.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean validaLogin(LoginRequestDTO loginDto) {
        return this.usuarioRepository.existsByLoginAndSenha(loginDto.login(), loginDto.senha());

    }
}