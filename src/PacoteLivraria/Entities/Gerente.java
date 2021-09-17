package PacoteLivraria.Entities;

public class Gerente extends Funcionario{

    private double salarioBase;

    public Gerente(String nome, String sobrenome) {

        super(nome, sobrenome);
    }

    public Gerente(String nome, String sobrenome, double salarioBase) {
        super(nome, sobrenome);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {

        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {

        this.salarioBase = salarioBase;
    }

    @Override
    public void calcularPagamento() {
        System.out.println(String.format("Seu pagamento é : R$ %.2f", 1.5 * salarioBase));
    }

}
