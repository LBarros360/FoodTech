package br.com.fiap.FoodTech.services;

import br.com.fiap.FoodTech.dtos.AtualizarSenhaDTO;
import br.com.fiap.FoodTech.entities.Usuario;
import br.com.fiap.FoodTech.repositories.SenhaRepository;
import br.com.fiap.FoodTech.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SenhaService {

    public UsuarioRepository usuarioRepository;

    public SenhaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void updateSenha(AtualizarSenhaDTO dto) {

        var usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        validatePassword(dto.novaSenha());

        if (!dto.senhaAntiga().equals(usuario.getSenha())) {
            throw new IllegalArgumentException("Senha antiga não confere.");
        }

        usuario.setSenha(dto.novaSenha());

        var update = this.usuarioRepository.update(usuario, dto.usuarioId());
        Assert.state(update == 1, "Erro ao atualizar a senha de  " + usuario.getNome());
    }

    /**
     * Valida se a senha atende aos critérios mínimos.
     * Neste exemplo:
     * - mínimo de 8 caracteres
     * - pelo menos uma letra maiúscula
     * - pelo menos uma letra minúscula
     * - pelo menos um número
     * - pelo menos um caractere especial
     */
    public void validatePassword(String password) {

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("A senha não pode ser vazia.");
        }

        String regex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        if (!password.matches(regex)) {
            throw new IllegalArgumentException(
                    "Senha inválida. A senha deve conter no mínimo 8 caracteres, " +
                            "com letras maiúsculas, minúsculas, números e caracteres especiais."
            );
        }
    }
}
