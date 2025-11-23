package br.com.fiap.FoodTech.controllers;

import br.com.fiap.FoodTech.entities.Usuario;
import br.com.fiap.FoodTech.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findUsuarioById(
            @PathVariable("id") Long id
    ) {

        logger.info("/usuarios/" + id);

        var usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuarios(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("/usuarios");
        var usuarios = this.usuarioService.findAllUsuarios(page, size);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Void> saveUsuario(@RequestBody Usuario usuario) {
        logger.info("POST -> /usuarios");
        this.usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUsuario(
            @PathVariable("id") Long id,
            @RequestBody Usuario usuario) {

        logger.info("PUT -> /usuarios/" + id);

        this.usuarioService.updateUsuario(usuario, id);
        return ResponseEntity.status(201).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(
        @PathVariable("id") Long id
    ) {
        logger.info("DELETE -> /usuarios/" + id);

        this.usuarioService.deleteUsuario(id);
        return ResponseEntity.status(201).build();
    }
}