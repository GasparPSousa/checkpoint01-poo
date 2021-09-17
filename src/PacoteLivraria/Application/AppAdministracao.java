package PacoteLivraria.Application;

import PacoteLivraria.Entities.*;

import java.util.Locale;
import java.util.Scanner;

public class AppAdministracao {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner leitor = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);

        // declarando os tipos e os nomes das variáveis
        int menu, escolha;
        String nome, sobrenome, cnpj;
        double salarioBase;

        System.out.println("Digite o nome da Livraria: ");
        nome = leitorString.nextLine();
        System.out.println("Digite o cnpj da Livraria: ");
        cnpj = leitorString.nextLine();

//        Livraria livraria = new Livraria("Saraiva", "1234");
        Livraria livraria = new Livraria(nome, cnpj);


        do {
            exibirMenu();
            menu = leitor.nextInt();

            switch (menu) {
                case 1: // Para cadastrar os funcionários
                    System.out.println("Que tipo de funcionario você quer cadastrar? \n1 - Gerente\n2 - Atendente\n3 - Caixa");
                    escolha = leitor.nextInt();
                    System.out.println("Digite o nome: ");
                    nome = leitorString.nextLine();
                    System.out.println("Digite o sobrenome: ");
                    sobrenome = leitorString.nextLine();

                    switch (escolha) {
                        case 1:
                            Funcionario gerente = new Gerente(nome, sobrenome);
                            livraria.cadastrarFuncionario(gerente);
                            break;
                        case 2:
                            Funcionario atendente = new Atendente(nome, sobrenome);
                            livraria.cadastrarFuncionario(atendente);
                            break;
                        case 3:
                            Funcionario caixa = new Caixa(nome, sobrenome);
                            livraria.cadastrarFuncionario(caixa);
                            break;
                        default:
                            System.out.println("Opção de escolha inválida!! Tente uma escolha correta ");

                    }
                    System.out.println();
                    break;
                case 2: // Para Listar os funcionários
                    if (livraria.listarFuncionario().isEmpty()) {
                        System.out.println("A lista encontra-se vazia!");
                    } else {
                        System.out.println(livraria.listarFuncionario());
                    }
                    break;
                case 3: // Para remover funcionário
                    System.out.println("====> Exclusão do Funcionario");
                    System.out.println("Digite nome do Funcionário: ");
                    nome = leitorString.nextLine();
                    System.out.println("Digite o sobrenome do Funcionário: ");
                    sobrenome = leitorString.nextLine();


                    if ( !(livraria.getListaDeFuncionarios().isEmpty())) { //Caso a lista de funcionário esteja populada
                        if (livraria.removerFuncionario(nome, sobrenome)) {
                            System.out.println("O funcionário " + nome + " " + sobrenome + " foi  removido com sucesso!!!");
                        } else {
                            System.out.println("Funcionário nao encontrado!!!");
                        }
                    } else {
                        System.out.println("Lista de Funcionários vazio!");
                    }
                    break;
                case 4:
                    System.out.println("Consulta Finalizada!");
                    break;
                default:
                    System.out.println("Opção de menu inválido!! Tente uma escolha correta ");

            }

        } while (menu != 4);


    }

    static void exibirMenu() {
        System.out.println("=========== FUNCIONÁRIO ==========");
        System.out.println("1 - CADASTRAR FUNCIONARIO");
        System.out.println("2 - LISTAR FUNCIONÁRIOS");
        System.out.println("3 - EXCLUIR FUNCIONÁRIO");
        System.out.println("4 - SAIR");
        System.out.println("=====> Escolha a opção: ");
        System.out.println();

    }


}
