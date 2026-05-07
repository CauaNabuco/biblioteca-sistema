package domain;

public class Leitores {
    Leitor [] leitores = new Leitor[100];
    private int contador;

    public void addLeitor(Leitor leitor){
        if (contador<leitores.length){
            leitores[contador] = leitor;
        }else {
            System.out.println("Não é possivel cadastrar mais Leitores, assine o PLUS");
        }
    }
    public void listarLeitores(){
        for (int i = 0; i < contador; i++) {
            System.out.println((i+1)+" - "+leitores[i].getNome());

        }
    }
    public void buscarLeitor(String nome){

    }
}
