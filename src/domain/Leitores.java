package domain;

import com.sun.security.jgss.GSSUtil;

public class Leitores {
    Leitor [] leitores = new Leitor[100];
    private int contador;

    public void addLeitor(Leitor leitor){
        if (contador<leitores.length){
            leitores[contador] = leitor;
            contador++;
            System.out.println("Leitor cadastrado com sucesso!");
        }else {
            System.out.println("Não é possivel cadastrar mais Leitores, assine o PLUS");
        }
    }
    public void listarLeitores(){
        if (contador == 0) {
            System.out.println("Nenhum leitor cadastrado");
        }
        else {
            System.out.println("Leitores: ");
            for (int i = 0; i < contador; i++) {
                System.out.println((i + 1) + " - " + leitores[i].getNome());


            }
        }
    }
    public void buscarLeitor(String nome){
        for (int i = 0; i < contador; i++) {
            if (nome.equalsIgnoreCase(leitores[i].getNome())){
                leitores[i].perfilLeitor();
                return;
            }
        }
        System.out.println("Leitor não encontrado");
    }
}
