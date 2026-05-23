package domain;

public class Leitor {
    private String nome;
    private String endereco;
    private int numero;
    Livro[] livrosEmprestados = new Livro[3];
    int contador = 0;

    public void addLivro(Livro livro){
        if (contador<livrosEmprestados.length){
            livrosEmprestados[contador] = livro;
            contador++;
        }else {
            System.out.println("Limite de livros emprestados atingido");

        }
    }

    public void perfilLeitor(){
        System.out.println("Nome: "+nome+"\nNumero: "+numero+"\nEndereço: "+endereco+"\nLivros emprestados: "+contador);
        if (contador>0){
            for (int i = 0; i < contador; i++) {
                System.out.println(livrosEmprestados[i].getTitulo());
            }
        }
    }
    public Leitor(String nome, String endereco, int numero) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
    }
    public Leitor() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
