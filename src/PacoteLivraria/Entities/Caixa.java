package PacoteLivraria.Entities;

public class Caixa extends Funcionario{

    private double salarioBase;

    public Caixa(String nome, String sobrenome) {
        
        super(nome, sobrenome);
    }

    public Caixa(String nome, String sobrenome, double salarioBase) {
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

        System.out.println("Seu pagamento é :" + 1.0 * this.salarioBase);
    }

}
