package br.com.fiap.FoodTech.controllers;

import br.com.fiap.FoodTech.dtos.AtualizarSenhaDTO;
import br.com.fiap.FoodTech.services.SenhaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/senhas")
public class SenhaController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private SenhaService senhaService;

    public SenhaController(SenhaService senhaService) {
        this.senhaService = senhaService;
    }

    @PutMapping
    public ResponseEntity<?> updateSenha(
            @Valid @RequestBody AtualizarSenhaDTO senhaDto
            ) {
        this.senhaService.updateSenha(senhaDto);
        return ResponseEntity.ok("Login válido");
    }
}