package br.com.fiap.FoodTech.controllers;

import br.com.fiap.FoodTech.dtos.LoginRequestDTO;
import br.com.fiap.FoodTech.services.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AutenticacaoController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private final AuthService authService;

    public AutenticacaoController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid
            @RequestBody LoginRequestDTO loginDto
            ) {

        boolean valido = this.authService.validaLogin(loginDto);

        if (valido) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Login ou senha invalidos!");
    }
}
