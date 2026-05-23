package test;

import domain.Biblioteca;
import domain.Leitor;
import domain.Leitores;
import domain.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Leitores leitores = new Leitores();
        Biblioteca biblioteca = new Biblioteca(leitores);
        int opcao;
        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("--- Cadastro ---");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Páginas: ");
                    int paginas;
                    while(true){
                        if (sc.hasNextInt()){
                            paginas = sc.nextInt();
                            sc.nextLine();
                            break;
                        }else {
                            System.out.println("❌ Escreva apenas números");
                            sc.next();
                        }
                    }
                    Livro livro = new Livro(nome,autor,paginas);
                    biblioteca.addLivro(livro);

                    break;

                case 2:

                    biblioteca.listarLivros();
                    break;

                case 3:
                    int opcaoLeitor = 0;
                    do{
                        menuLeitor();
                        opcaoLeitor = sc.nextInt();
                        sc.nextLine();

                        switch (opcaoLeitor){
                            case 1:
                                System.out.println("Nome: ");
                                String nomeL = sc.nextLine();
                                System.out.println("endereço: ");
                                String enderecoL = sc.nextLine();
                                System.out.println("Numero: ");
                                int numeroL;
                                while (true){
                                    if(sc.hasNextInt()){
                                        numeroL = sc.nextInt();
                                        sc.nextLine();
                                        break;
                                    }else {
                                        System.out.println("❌ Digite apenas números");
                                        sc.next();
                                    }
                                }
                                Leitor leitorr = new Leitor(nomeL, enderecoL, numeroL);
                                leitores.addLeitor(leitorr);
                                break;

                            case 2:
                                leitores.listarLeitores();
                                break;

                            case 3:
                                System.out.println("Buscar leitor:");
                                String busca = sc.nextLine();
                                leitores.buscarLeitor(busca);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("❌ Digite uma opção válida");
                                break;
                        }
                    }while(opcaoLeitor != 4);
                    break;
                case 4:
                    System.out.println("Nome do leitor: ");
                    String nomeLeitor = sc.nextLine();
                    System.out.println("Livro a ser emprestado [nome/id]: ");
                    int idLivro;
                    String nomeLivro;
                    if (sc.hasNextInt()){
                        idLivro = sc.nextInt();
                        sc.nextLine();
                       // biblioteca.emprestarLivro(idLivro);
                    }else {
                        nomeLivro = sc.nextLine();
                        biblioteca.emprestarLivro(nomeLivro, nomeLeitor);
                    }
                    break;

                case 5:
                    System.out.println("Livro devolvido [nome]: ");
                    String nomeLivroD = sc.nextLine();
                    biblioteca.devolverLivro(nomeLivroD);
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("❌ Digite uma opção válida.");

            }
        }while (opcao != 6);
        sc.close();
    }


    public static void menu(){
        System.out.println("--- AllSoft Lib System ---");
        System.out.print("  1- Cadastrar Livro\n  2- Listar Acervo\n  3- Leitor\n  4- Realizar Emprestimo\n  5- Devolução\n  6- Sair\n");
        System.out.print("Opção: ");
    }
    public static void menuLeitor(){
        System.out.println("--------- Leitor --------");
        System.out.print("  1- Cadastrar Leitor\n  2- Listar leitores\n  3- Buscar Leitor\n  4- Sair\n");
        System.out.print("Opção: ");
    }
}
