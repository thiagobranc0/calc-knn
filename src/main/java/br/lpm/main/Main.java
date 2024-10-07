package br.lpm.main;

import br.lpm.business.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class

Main {
    public static DataSet pessoasData = new DataSet();


    public static void main(String[] args) {
        DistanceMeasure distanceMeasure = new DistanceMeasure();
        Pessoa pessoa1 = new Pessoa("Thiago Branco", LocalDate.of(1992, 9, 20), Genero.MASCULINO, 1.82f, 100, 1000, "Macapá", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);
        Pessoa pessoa2 = new Pessoa("Pedro", LocalDate.of(1980, 4, 12), Genero.MASCULINO, 1.90f, 75, 5000, "Guarulhos", Hobby.LIVRO, EstadoCivil.SOLTEIRO, Escolaridade.NENHUMA, false, Moradia.COM_FAMILIA);
        Pessoa pessoa3 = new Pessoa("Pepe", LocalDate.of(2005, 7, 13), Genero.MASCULINO, 1.20f,60, 1500f, "Internetland", Hobby.NENHUM, EstadoCivil.SOLTEIRO, Escolaridade.NENHUMA, true, Moradia.COM_FAMILIA);
        Pessoa pessoa4 = new Pessoa("Sol Badguy", LocalDate.of(1992, 9, 20), Genero.MASCULINO, 2f, 150, 0, "Briggs", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);
        Pessoa pessoa5 = new Pessoa("Dante", LocalDate.of(1981, 3, 15), Genero.MASCULINO, 1.82f, 90, 50, "Fortuna", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);
        Pessoa pessoa6 = new Pessoa("Vincent Law", LocalDate.of(1900, 12, 25), Genero.MASCULINO, 1.72f, 80, 20, "Mosk", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.NENHUMA, true, Moradia.ALUGUEL);

        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        pessoasData.addPessoa(pessoa3);
        pessoasData.addPessoa(pessoa4);
        pessoasData.addPessoa(pessoa5);
        pessoasData.addPessoa(pessoa6);
        pessoasData.normalizeField("altura");
        pessoasData.normalizeField("peso");
        pessoasData.normalizeField("renda");

        Knn knn = new Knn(pessoasData, 3);

        System.out.println(knn.classifyFeliz(pessoa6));


    }
}
