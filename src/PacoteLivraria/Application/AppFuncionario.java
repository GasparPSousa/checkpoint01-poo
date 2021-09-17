package PacoteLivraria.Application;

import PacoteLivraria.Entities.Livraria;
import PacoteLivraria.Entities.Livro;

import java.util.Scanner;

public class AppFuncionario {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in); //gerando um buffer para leitura de números
        Scanner leitorString = new Scanner(System.in); // gerando um buffer para leitura de strings

        // declarando os tipos e os nomes das variáveis
        int menu;
        double valorInicial, valorFinal;
        String titulo, autor, genero;
        float preco;
        int isbn;

        // Criando um laço do...while para gerar um menu interativo
        do {
            exibirMenu();
            menu = leitor.nextInt();

            switch (menu) {
                case 1:// Para cadastrar os livros
                    System.out.println("Digite o título: ");
                    titulo = leitorString.nextLine();
                    System.out.println("Digite o autor: ");
                    autor = leitorString.nextLine();
                    System.out.println("Digite o gênero: ");
                    genero = leitorString.nextLine();
                    System.out.println("Digite o ISBN: ");
                    isbn = leitor.nextInt();
                    System.out.println("Digite o preço: ");
                    preco = leitor.nextFloat();


                    // Criando objetos
                    Livro livro01 = new Livro(titulo, autor, isbn, genero, preco);

                    // guardar objetos no ArrayList
                    Livraria.adicionarLivro(livro01);

                    System.out.println();

                    break;
                case 2: // Para listar os livros
                    System.out.println("=====> Listagem de Livros");
                    if (Livraria.listarLivro().isEmpty()) {
                        System.out.println("A lista encontra-se vazia!");
                    } else {
                        System.out.println(Livraria.listarLivro());
                    }


                    break;
                case 3: //Para remover um livro
                    System.out.println("====> Exclusão do Livro");
                    System.out.println("Digite o título do livro: ");
                    titulo = leitorString.nextLine();

                    if ( !(Livraria.getListaDeLivros().isEmpty())) { //acervo não vazio
                        if (Livraria.removerLivro(titulo)) {
                            System.out.println("O Livro " + titulo + " foi  removido com sucesso!!!");
                        } else {
                            System.out.println("Titulo nao encontrado!!!");
                        }
                    } else {
                        System.out.println("Acervo Vazio!");
                    }
                    break;
                case 4: // Para pesquisar por gênero
                    System.out.println("=====> Pesquisar pelo gênero");
                    System.out.println("Digite o gênero: ");
                    genero = leitorString.nextLine();

                    System.out.println("Existem " + Livraria.pesquisar(genero)
                            + " livro(s) do gênero " + genero);
                    break;
                case 5: // Para pesquisar por faixa de preços
                    System.out.println("=====> Pesquisar por Faixa de Preços");
                    System.out.println("Digite a faixa inicial e a faixa final");
                    valorInicial = leitor.nextDouble();
                    valorFinal = leitor.nextDouble();

                    System.out.println("Existem " + Livraria.pesquisar(valorInicial,valorFinal)
                            + " livro(s) com preço entre "
                            + String.format("R$ %.2f e R$ %.2f \n", valorInicial, valorFinal));
                    break;
                case 6: // Para calcular o valor total de todos os livros
                    System.out.println("=====> Total em R$ de livros no Acervo");
                    System.out.println("O total é: "
                            + String.format(" R$ %.2f \n", Livraria.calcularTotalAcervo()));

                    break;
                case 7: // Para sair do menu
                    System.out.println("Consulta Finalizada!");
                    break;
                default: // Para o caso de colocar um número de menu inválido
                    System.out.println("Opção de menu inválido!! Tente uma escolha correta ");
            }

        } while (menu != 7);


    } // fim do main

    static void exibirMenu() {
        System.out.println("=========== LIVRO ==========");
        System.out.println("1 - CADASTRAR");
        System.out.println("2 - LISTAR");
        System.out.println("3 - EXCLUIR LIVRO");
        System.out.println("4 - PESQUISAR POR GENERO");
        System.out.println("5 - PESQUISAR POR FAIXA DE PREÇO");
        System.out.println("6 - CALCULAR TOTAL DO ACERVO");
        System.out.println("7 - SAIR");
        System.out.println("=====> Escolha a opção: ");
        System.out.println();

    }



}
