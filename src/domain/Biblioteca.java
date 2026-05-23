package domain;

public class Biblioteca {
    private Livro [] livros = new Livro[100];
    private Leitores leitores;
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
                    } else {
                        System.out.println("❌ Esse livro está indisponivel");
                    }
                    return;
                }


            System.out.println("❌ Livro não encontrado");
            }else {
                System.out.println("❌ Leitor não encontrado");
            }
        }
    }
    public void emprestarLivro(int id, String leitorr){
        for (int i = 0; i < contador; i++) {
            Leitor leitor = leitores.obterLeitor(leitorr);
            if (leitor != null) {
                if (id == livros[i].getId()) {
                    livros[i].detalhesLivro();
                    if (livros[i].getDisponibilidade()) {
                        livros[i].setDisponibilidade(false);
                        leitor.addLivro(livros[i]);
                        System.out.println("✅ Livro emprestado com sucesso");
                    } else {
                        System.out.println("❌ Esse livro está indisponivel");
                    }
                    return;
                }

            }
        }
        System.out.println("❌ Livro não encontrado");
    }
    public void devolverLivro(String nome){
        for (int i = 0; i < contador; i++) {
            if (nome.equalsIgnoreCase(livros[i].getTitulo())) {
                livros[i].detalhesLivro();
                if (!livros[i].getDisponibilidade()) {
                    livros[i].setDisponibilidade(true);
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