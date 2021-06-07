package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno ComNomeCpfEmail(String nome, String cpf, String email) {
         this.aluno = new Aluno(nome, new Cpf(cpf), new Email(email));
         return this;
    }

    public FabricaDeAluno ComTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }
}
