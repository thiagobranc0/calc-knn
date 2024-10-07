package br.lpm.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DistanceMeasureTest {
    public Pessoa pessoa1;
    public Pessoa pessoa2;
    public Pessoa pessoa3;
    public DistanceMeasure distanceMeasure;
    public DataSet pessoasData;

    @BeforeEach
    public void setUp() {
        pessoa1 = new Pessoa("Thiago Branco", LocalDate.of(1992, 9, 20), Genero.MASCULINO, 1.82f, 100, 1000, "Macapá", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);
        pessoa2 = new Pessoa("Pedro", LocalDate.of(1980, 4, 12), Genero.MASCULINO, 1.90f, 75, 5000, "Guarulhos", Hobby.LIVRO, EstadoCivil.SOLTEIRO, Escolaridade.NENHUMA, false, Moradia.COM_FAMILIA);
        pessoa3 = new Pessoa("Pepe", LocalDate.of(2005, 7, 13), Genero.MASCULINO, 1.20f,60, 1500f, "Internetland", Hobby.NENHUM, EstadoCivil.SOLTEIRO, Escolaridade.NENHUMA, true, Moradia.COM_FAMILIA);
        distanceMeasure = new DistanceMeasure();
        pessoasData = new DataSet();
    }


    @Test
    void testCalcDistance() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        pessoasData.normalizeField("altura");
        pessoasData.normalizeField("peso");
        pessoasData.normalizeField("renda");
        assertEquals(0.7748609987321013, distanceMeasure.calcDistance(pessoa1, pessoa2), "Retornando corretamente a distância final entre pessoa 1 e pessoa 2");
        assertEquals(0.8016988939388754, distanceMeasure.calcDistance(pessoa1, pessoa3), "Retornando corretamente a distância final entre pessoa 1 e pessoa 3");
        assertEquals(0.590726961689951, distanceMeasure.calcDistance(pessoa2, pessoa3), "Retornando corretamente a distância final entre pessoa 2 e pessoa 3");
    }
}