package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.*;
import br.com.alura.escola.dominio.exceptions.AlunoNaoEncontradoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO aluno VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf().getCpf());
            ps.setString(2, aluno.getEmail().getEndereco());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean encontrou = resultSet.next();

            if (!encontrou) {
                throw new AlunoNaoEncontradoException(cpf);
            }

            String nome = resultSet.getString("nome");
            Email email = new Email(resultSet.getString("email"));
            Aluno encontrado = new Aluno(nome, cpf, email);

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String ddd = resultSet.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        return null;
    }
}
