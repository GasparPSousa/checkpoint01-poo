package PacoteLivraria.Entities;

public abstract class Funcionario {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public abstract void calcularPagamento();

    @Override
    public String toString() {
        return  nome
                + ' '
                + sobrenome;
    }
}
