package domain;

public class Leitor {
    private String nome;
    private String endereco;
    private String numero;
    Livro[] livrosEmprestados;


    public void perfilLeitor(){
        System.out.println("Nome: "+nome+"\nNumero: "+numero+"\nEndereço: "+endereco);
    }
    public Leitor(String nome, String endereco, String numero) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
