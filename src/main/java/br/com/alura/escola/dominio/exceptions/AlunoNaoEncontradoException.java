package br.com.alura.escola.dominio.exceptions;

import br.com.alura.escola.dominio.aluno.Cpf;

public class AlunoNaoEncontradoException extends RuntimeException{
    public AlunoNaoEncontradoException(Cpf cpf) {
        super("CPF Não encontrado: " + cpf);
    }
}
