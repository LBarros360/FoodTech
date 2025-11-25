package br.com.fiap.FoodTech.repositories;

import br.com.fiap.FoodTech.entities.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);

    List<Usuario> findUsersByName(String nome);

    Integer save(Usuario usuario);

    Integer update(Usuario usuario, Long id);

    Integer delete(Long id);

    boolean emailExists(String email);

    boolean existsByLoginAndSenha(String login, String senha);
}