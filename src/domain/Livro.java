package domain;

public class Livro {
    private String titulo;
    private String autor;
    private int paginas;
    private int id;
    private Boolean disponibilidade;
    private static int contador=0;

    public Livro(String titulo, String autor, int paginas) {
        contador +=1;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.id = contador;
        this.disponibilidade = true;
    }
    public void detalhesLivro(){
        if (disponibilidade) {
            System.out.println("Livro: " + titulo + " - " + autor + ". pag: " + paginas + " ( Disponivel )");
        }else {
            System.out.println("Livro: " + titulo + " - " + autor + ". pag: " + paginas + " ( Indisponivel )");
        }
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static int getContador() {
        return contador;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }
}
