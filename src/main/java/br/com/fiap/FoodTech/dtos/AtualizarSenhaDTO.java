package br.com.fiap.FoodTech.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarSenhaDTO (
        @NotNull(message = "O ID do usuário é obrigatório")
        Long usuarioId,

        @NotBlank(message = "A senha antiga é obrigatória")
        String senhaAntiga,

        @NotBlank(message = "A nova senha é obrigatória")
        String novaSenha
) {}