package br.com.fiap.FoodTech.controllers;

import br.com.fiap.FoodTech.entities.Usuario;
import br.com.fiap.FoodTech.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public ResponseEntity<?> findUsuarios(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nome
    ) {
        logger.info("GET -> /usuarios  id=" + id + " nome=" + nome);

        if (id != null) {
            var usuario = usuarioService.findById(id);

            if (usuario.isPresent()) {
                return ResponseEntity.ok(usuario.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        var usuarios = usuarioService.findUsersByName(nome);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Void> saveUsuario(@RequestBody Usuario usuario) {

        logger.info("POST /v1/usuarios");

        usuarioService.saveUsuario(usuario);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUsuario(@PathVariable Long id,
                                              @RequestBody Usuario usuario) {

        logger.info("PUT /v1/usuarios/{}", id);

        usuarioService.updateUsuario(usuario, id);

        return ResponseEntity.noContent().build(); // 204
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {

        logger.info("DELETE /v1/usuarios/{}", id);

        usuarioService.deleteUsuario(id);

        return ResponseEntity.noContent().build(); // 204
    }
}