package PacoteLivraria.Entities;

import java.util.ArrayList;

public class Livraria {

    private String nome;
    private String cnpj;

    private static ArrayList<Livro> listaDeLivros = new ArrayList<>();
    private ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public Livraria(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    // Método GET
    public static ArrayList<Livro> getListaDeLivros() {

        return listaDeLivros;
    }

    // Adiciona um objeto na lista
    static public void adicionarLivro(Livro livro) {

        listaDeLivros.add(livro);
    }

    // Listar os dados de todos os objetos da lista
    static public String listarLivro() {
        String saida = "";
        int k = 1;
        for (Livro livro : listaDeLivros) {
            saida += "\n===== LIVRO Nº " + (k++) + " ======\n";
            saida += livro.toString() + "\n";
        }
        return saida;
    }



    // Pesquisar por Gênero
    static public int pesquisar(String genero) {
        int quantidade = 0;

        for(Livro livro : listaDeLivros) {
            if (livro.getGenero().equalsIgnoreCase(genero)){
                quantidade++;
            }
        }

        return quantidade;

    }

    // Pesquisar por Faixa de Preço
    static  public int pesquisar(double valorInicial, double valorFinal) {
        int quantidade = 0;

        for(Livro livro : listaDeLivros) {
            if ((livro.getPreco() >= valorInicial) && (livro.getPreco() <= valorFinal)) {
                quantidade++;
            }
        }

        return quantidade;
    }

    // Remover um livro pelo título
    static public boolean removerLivro(String titulo) {
        for (Livro livro : listaDeLivros) {
            if(livro.getTitulo().equalsIgnoreCase(titulo)) {
                listaDeLivros.remove(livro);
                return true;
            }
        }
        return false;
    }

    // total do acervo
    static public double calcularTotalAcervo(){
        double total = 0;

        for (Livro livro : listaDeLivros) {
            total += livro.getPreco();

        }
        return total;
    }

    public ArrayList<Funcionario> getListaDeFuncionarios() {

        return listaDeFuncionarios;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        listaDeFuncionarios.add(funcionario);
//        System.out.println("---- Cadastrando Funcionario ----");
//        System.out.println(funcionario + " - Cadastro efetuado com sucesso");
//        System.out.println();

    }

    public String listarFuncionario() {
        String saida = "";
        int k = 1;
        for (Funcionario funcionario : listaDeFuncionarios) {
            saida += "\n===== FUNCIONARIO Nº " + (k++) + " ======\n";
            saida += funcionario.toString() + "\n";
        }
        return saida;
    }

    public boolean removerFuncionario(String nome, String sobrenome) {
        for (Funcionario funcionario : listaDeFuncionarios) {
            if((funcionario.getNome().equalsIgnoreCase(nome) && funcionario.getSobrenome().equalsIgnoreCase(sobrenome))) {
                listaDeFuncionarios.remove(funcionario);
                return true;
            }

        }
        return false;
    }




}
