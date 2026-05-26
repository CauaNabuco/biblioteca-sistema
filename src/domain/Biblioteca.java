package domain;


import java.util.Scanner;

public class Biblioteca {
    private Livro [] livros = new Livro[100];
    private Leitores leitores;
    private Datas data= new Datas();
    private int contador =0;


    public Biblioteca(Leitores leitores) {
        this.leitores = leitores;
    }

    public void addLivro(Livro livro){
        if (contador < livros.length){
            livros[contador]=livro;
            contador++;
            System.out.println("✅ Livro cadastrado com sucesso!");
        }else{
            System.out.println("❌ Ops, A biblioteca está cheia");
        }
    }
    public void listarLivros(){
        if (contador==0){
            System.out.println("Acervo vazio");
        }else {
            System.out.println("Nosso acervo: ");
            for (int i = 0; i < contador; i++) {
                System.out.print((i + 1) + " - ");
                livros[i].detalhesLivro();

            }
        }
    }
    public void emprestarLivro(String nome, String leitorr) {
        for (int i = 0; i < contador; i++) {
            Leitor leitor = leitores.obterLeitor(leitorr);
            if (leitor!=null) {
                if (nome.equalsIgnoreCase(livros[i].getTitulo())) {
                    livros[i].detalhesLivro();
                    if (livros[i].getDisponibilidade()) {
                        livros[i].setDisponibilidade(false);
                        leitor.addLivro(livros[i]);
                        System.out.println("✅ Livro emprestado com sucesso");
                        System.out.print("Prazo para a devolução do livro em dias: ");
                        Scanner sc = new Scanner(System.in);
                        int prazo = sc.nextInt();
                        sc.nextLine();
                        relatorio(nome, prazo);

                    } else {
                        System.out.println("❌ Esse livro está indisponivel");
                    }
                    return;
                }



            }else {
                System.out.println("❌ Leitor não encontrado");
            }
        }
    }
    public void emprestarLivro(int id, String leitorr){
        for (int i = 0; i < contador; i++) {
            Leitor leitor = leitores.obterLeitor(leitorr);
            if (leitor != null) {
                if (leitor.contador==0) {
                    if (id == livros[i].getId()) {
                        livros[i].detalhesLivro();
                        if (livros[i].getDisponibilidade()) {
                            livros[i].setDisponibilidade(false);
                            leitor.addLivro(livros[i]);
                            System.out.println("✅ Livro emprestado com sucesso");
                            System.out.println();
                            System.out.print("Prazo para a devolução do livro em dias: ");
                            Scanner sc = new Scanner(System.in);
                            int prazo = sc.nextInt();
                            sc.nextLine();
                            relatorio(id, prazo);
                        } else {
                            System.out.println("❌ Esse livro está indisponivel");
                        }
                        return;
                    }
                }else {
                    System.out.println("❌ Ops, o leitor ja tem um livro emprestado no momento");
                }
            }else {
                System.out.println("❌ Leitor não encontrado");
            }
        }
        System.out.println("❌ Livro não encontrado");
    }
    public void relatorio(String nomeLivro, int prazo){
        System.out.println("------- Relatorio -------");
        System.out.println("Livro emprestado: "+ nomeLivro);
        System.out.print("Data do empréstimo: ");
        data.exibirDataAtual();
        System.out.print("Data de devolução: ");
        data.calcularData(prazo);
        System.out.println("-------------------------");
        System.out.println();
    }
    public void relatorio(int id, int prazo){
        System.out.println("------- Relatorio -------");
        System.out.println("Livro emprestado [id]: "+ id);
        System.out.print("Data do empréstimo: ");
        data.exibirDataAtual();
        System.out.print("Data de devolução: ");
        data.calcularData(prazo);
        System.out.println("-------------------------");
        System.out.println();
    }
    public void devolverLivro(String nome, String leitorr){
        for (int i = 0; i < contador; i++) {
            Leitor leitor = leitores.obterLeitor(leitorr);
            if (nome.equalsIgnoreCase(livros[i].getTitulo())) {
                livros[i].detalhesLivro();
                if (!livros[i].getDisponibilidade()) {
                    livros[i].setDisponibilidade(true);
                    leitor.devolverLivro(livros[i]);
                    System.out.println("✅ Livro devolvido com sucesso");

                } else {
                    System.out.println("❌ Esse livro não foi emprestado");
                }
                return;
            }

        }
        System.out.println("❌ Livro não encontrado");
    }
    public void devolverLivro(int id, String leitorr){
        for (int i = 0; i < contador; i++) {
            Leitor leitor = leitores.obterLeitor(leitorr);
            if (id == livros[i].getId()) {
                livros[i].detalhesLivro();
                if (!livros[i].getDisponibilidade()) {
                    livros[i].setDisponibilidade(true);
                    leitor.devolverLivro(livros[i]);
                    System.out.println("✅ Livro devolvido com sucesso");

                } else {
                    System.out.println("❌ Esse livro não foi emprestado");
                }
                return;
            }

        }
        System.out.println("❌ Livro não encontrado");
    }
}