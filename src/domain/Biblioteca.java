package domain;

public class Biblioteca {
    Livro [] livros = new Livro[100];
    private int contador =0;

    public void addLivro(Livro livro){
        if (contador < livros.length){
            livros[contador]=livro;
            contador++;
        }else{
            System.out.println("Ops, A biblioteca está cheia");
        }
    }
    public void listarLivros(){
        if (contador==0){
            System.out.println("Acervo vazio");
        }else {
            for (int i = 0; i < contador; i++) {
                System.out.println("dentro do for");
                System.out.print((i + 1) + " - ");
                livros[i].detalhesLivro();

            }
        }
    }
    public void emprestarLivro(String nome){
        for (int i = 0; i < contador; i++) {
            if (nome.equalsIgnoreCase(livros[i].getTitulo())){
                livros[i].detalhesLivro();
                if (livros[i].getDisponibilidade()){
                    livros[i].setDisponibilidade(false);
                }else {
                    System.out.println("Esse livro está indisponivel");
                }
            }else {
                System.out.println("Livro não encontrado");
            }
        }
    }
    public void emprestarLivro(int id){
        for (int i = 0; i < contador; i++) {
            if (id == livros[i].getId()){
                livros[i].detalhesLivro();
                if (livros[i].getDisponibilidade()){
                    livros[i].setDisponibilidade(false);
                }else {
                    System.out.println("Esse livro está indisponivel");
                }
            }else {
                System.out.println("Livro não encontrado");
            }
        }
    }
}
