package br.com.fiap.FoodTech.repositories;

import br.com.fiap.FoodTech.entities.Usuario;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

    private final JdbcClient jdbcClient;

    public UsuarioRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM usuarios WHERE id = :id")
                .param("id", id)
                .query(Usuario.class)
                .optional();
    }

    @Override
    public List<Usuario> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM usuarios LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Usuario.class)
                .list();
    }

    @Override
    public Integer save(Usuario usuario) {
        return this.jdbcClient
                .sql("INSERT INTO usuarios (nome, email, login, senha, logradouro, numero, bairro, cidade, uf, cep, data_alteracao, tipo_usuario) " +
                        "VALUES (:nome, :email, :login, :senha, :logradouro, :numero, :bairro, :cidade, :uf, :cep, :data_alteracao, :tipo_usuario)")
                .param("nome", usuario.getNome())
                .param("email", usuario.getEmail())
                .param("login", usuario.getLogin())
                .param("senha", usuario.getSenha())
                .param("logradouro", usuario.getLogradouro())
                .param("numero", usuario.getNumero())
                .param("bairro", usuario.getBairro())
                .param("cidade", usuario.getCidade())
                .param("uf", usuario.getUf().getSigla())
                .param("cep", usuario.getCep())
                .param("data_alteracao", LocalDateTime.now())
                .param("tipo_usuario", usuario.getTipoUsuario().getDescricao())
                .update();
    }

    @Override
    public Integer update(Usuario usuario, Long id) {
        return this.jdbcClient
                .sql("UPDATE usuarios SET nome = :nome, email = :email, login = :login, logradouro = :logradouro, numero = :numero, " +
                     "bairro = :bairro, cidade = :cidade, uf = :uf, cep = :cep, data_alteracao = :data_alteracao," +
                     " tipo_usuario = :tipo_usuario WHERE id = :id")
                .param("nome", usuario.getNome())
                .param("email", usuario.getEmail())
                .param("login", usuario.getLogin())
                .param("logradouro", usuario.getLogradouro())
                .param("numero", usuario.getNumero())
                .param("bairro", usuario.getBairro())
                .param("cidade", usuario.getCidade())
                .param("uf", usuario.getUf().getSigla())
                .param("cep", usuario.getCep())
                .param("data_alteracao", LocalDateTime.now())
                .param("tipo_usuario", usuario.getTipoUsuario().getDescricao())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM usuarios WHERE id = :id")
                .param("id", id)
                .update();
    }
}