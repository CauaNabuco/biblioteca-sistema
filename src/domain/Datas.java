package domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Datas {

    public void exibirDataAtual(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate.format(dtf));
    }
    public void calcularData(int prazo) {
        LocalDate dataEmprestimo = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDevolução = dataEmprestimo.plusDays(prazo);
        System.out.println("Data de devolução: "+dataDevolução.format(dtf));
        System.out.println("Prazo: "+prazo+" dias");

    }
}
