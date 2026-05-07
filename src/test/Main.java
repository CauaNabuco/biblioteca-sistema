package test;

import domain.Biblioteca;
import domain.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
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
                            System.out.println("Escreva apenas números");
                            sc.next();
                        }
                    }
                    Livro livro = new Livro(nome,autor,paginas);
                    biblioteca.addLivro(livro);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;



              //  default:
                //    System.out.println("Digite uma opção válida.");

            }
        }while (opcao != 6);
        sc.close();
    }


    public static void menu(){
        System.out.println("--- AllSoft Lib System ---");
        System.out.print("  1- Cadastrar Livro\n  2- Listar Acervo\n  3- Leitor\n  4- Realizar Emprestimo\n  5- Devolução\n  6- Sair\n");
        System.out.print("Opção: ");
    }
    public static void menuLeitro(){
        System.out.println("--------- Leitor --------");
        System.out.print("  1- Cadastrar Leitor\n  2- Listar leitores\n  3- Buscar Leitro\n");
        System.out.print("Opção: ");
    }
}
