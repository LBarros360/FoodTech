package br.com.fiap.FoodTech.services;

import br.com.fiap.FoodTech.entities.Usuario;
import br.com.fiap.FoodTech.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findById(Long id) {
        return this.usuarioRepository.findById(id);
    }

    public List<Usuario> findUsersByName (String nome) {
        return this.usuarioRepository.findUsersByName(nome);
    }

    public void saveUsuario(Usuario usuario) {

        emailExists(usuario.getEmail());

        var save = this.usuarioRepository.save(usuario);
        Assert.state(save == 1, "Erro ao salvar usuário " + usuario.getNome());
    }

    public void updateUsuario(Usuario usuario, Long id) {
        var update = this.usuarioRepository.update(usuario, id);
        Assert.state(update == 1, "Erro ao atualizar usuário " + usuario.getNome());
    }

    public void deleteUsuario(Long id) {
        var delete = this.usuarioRepository.delete(id);
        Assert.state(delete == 1, "Usuário nao encontrado, ID: " + id);
    }

    public void emailExists(String email) {
        if (this.usuarioRepository.emailExists(email)) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }
    }
}