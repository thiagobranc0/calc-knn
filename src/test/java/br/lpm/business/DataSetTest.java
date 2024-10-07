package br.lpm.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DataSetTest {
    public DataSet pessoasData;
    public Pessoa pessoa1;
    public Pessoa pessoa2;
    public Pessoa pessoa3;
    public Pessoa pessoa4;
    public Pessoa pessoa5;
    public DistanceMeasure distanceMeasure;


    @BeforeEach
    public void setUp() {
        pessoasData = new DataSet();
        pessoa1 = new Pessoa("Thiago Branco", LocalDate.of(1992, 9, 20), Genero.MASCULINO, 1.82f, 100, 1000, "Macapá", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);
        pessoa2 = new Pessoa("Pedro", LocalDate.of(1980, 4, 12), Genero.MASCULINO, 1.90f, 75, 5000, "Guarulhos", Hobby.LIVRO, EstadoCivil.SOLTEIRO, Escolaridade.NENHUMA, false, Moradia.COM_FAMILIA);
        pessoa3 = new Pessoa("Pepe", LocalDate.of(2005, 7, 13), Genero.MASCULINO, 1.20f,60, 1500f, "Internetland", Hobby.NENHUM, EstadoCivil.SOLTEIRO, Escolaridade.NENHUMA, true, Moradia.COM_FAMILIA);
        pessoa4 = new Pessoa("Sol Badguy", LocalDate.of(1992, 9, 20), Genero.MASCULINO, 2f, 100, 1000, "Briggs", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);
        pessoa5 = new Pessoa("Dante", LocalDate.of(1981, 3, 15), Genero.MASCULINO, 1.82f, 90, 1000, "Fortuna", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.SUPERIOR, true, Moradia.ALUGUEL);

        distanceMeasure = new DistanceMeasure();
    }

    @Test
    void testAddPessoa() {
        pessoasData.addPessoa(pessoa1);
        assertEquals(pessoa1, pessoasData.getPessoaByName("Thiago Branco"), "Adicionando pessoa corretamente.");
    }

    @Test
    void testGetPessoaByName() {
        pessoasData.addPessoa(pessoa2);
        assertEquals(pessoa2, pessoasData.getPessoaByName("Pedro"), "Recuperando pessoa corretamente.");
    }

    @Test
    void testRemovePessoa() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.removePessoa(pessoa1);
        assertEquals(null, pessoasData.getPessoaByName("Thiago Branco"), "Removendo pessoas corretamente.");
    }

    @Test
    void testRemovePessoaByName() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.removePessoaByName("Thiago Branco");
        assertEquals(null, pessoasData.getPessoaByName("Thiago Branco"), "Pessoa removida corretamente após ser adicionada");
    }

    @Test
    void testReplacePessoa() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.replacePessoa(pessoa1, pessoa3);
        assertEquals(pessoa3, pessoasData.getPessoaByName("Pepe"), "Substituindo Thiago por Pepe corretamente");
    }

    @Test
    void testMaxAltura() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(1.90f, pessoasData.maxAltura(), "Retornando altura máxima corretamente.");
    }

    @Test
    void testMinAltura() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(1.82f, pessoasData.minAltura(), "Retornando altura minima corretamente.");
    }

    @Test
    void testAvgAltura() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(1.86f, pessoasData.avgAltura(), "Retornando média das altura corretamente.");
    }

    @Test
    void testMaxPeso() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(100, pessoasData.maxPeso(), "Retornando peso máximo corretamente.");
    }

    @Test
    void testMinPeso() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(75, pessoasData.minPeso(), "Retornando peso minimo corretamente.");
    }

    @Test
    void testAvgPeso() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(87.5f, pessoasData.avgPeso(), "Retornando média dos pesos corretamente.");
    }

    @Test
    void testPercentAdult() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(100f, pessoasData.percentAdult(), "Retornando o número a porcentagem de maiores de idade corretamente.");
    }

    @Test
    void percentEstadoCivil() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(50, pessoasData.percentEstadoCivil(EstadoCivil.CASADO), "Retornando a porcentagem correta de pessoas casadas.");
        assertEquals(50, pessoasData.percentEstadoCivil(EstadoCivil.SOLTEIRO), "Retornando a porcentagem correta de pessoas solteiras.");

    }

    @Test
    void modeEstadoCivil() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        assertEquals(EstadoCivil.SOLTEIRO, pessoasData.modeEstadoCivil(), "Retornando corretamente o estado civil solteiro como mais frequente.");
    }

    @Test
    void testPercentEscolaridade() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(50, pessoasData.percentEscolaridade(Escolaridade.SUPERIOR), "Retornando a porcentagem correta de pessoas casadas.");
        assertEquals(50, pessoasData.percentEscolaridade(Escolaridade.NENHUMA), "Retornando a porcentagem correta de pessoas casadas.");
    }

    @Test
    void testModeEscolaridade() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        assertEquals(Escolaridade.NENHUMA, pessoasData.modeEscolaridade(), "Retornando corretamente a escolaridade nenhuma como mais frequente.");
    }

    @Test
    void testPercentMoradia() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(50, pessoasData.percentMoradia(Moradia.ALUGUEL), "Retornando a porcentagem correta de situação de moradia.");
        assertEquals(50, pessoasData.percentMoradia(Moradia.COM_FAMILIA), "Retornando a porcentagem correta de situação de moradia.");
    }

    @Test
    void testModeMoradia() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        assertEquals(Moradia.COM_FAMILIA, pessoasData.modeMoradia(), "Retornando corretamente a moradia mais frequente.");
    }

    @Test
    void testPercentHobby() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(100f, pessoasData.percentHobby(), "Retornando corretamente a porcentagem de pessoas com algum hobby");
    }

    @Test
    void testPercentFeliz() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        assertEquals(50f, pessoasData.percentFeliz(), "Retornando corretamente a porcentagem de pessoas felizes");
    }

    @Test
    void testNormalizeField() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        pessoasData.normalizeField("altura");
        pessoasData.normalizeField("renda");
        pessoasData.normalizeField("peso");
        assertEquals(0.8857144f, pessoasData.getPessoaByName("Thiago Branco").getAltura());
        assertEquals(0, pessoasData.getPessoaByName("Thiago Branco").getRenda());
        assertEquals(1, pessoasData.getPessoaByName("Thiago Branco").getPeso());
    }

    @Test
    void testCalcDistanceVector() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        pessoasData.normalizeField("altura");
        pessoasData.normalizeField("Peso");
        pessoasData.normalizeField("renda");
        double[] distanceVector = pessoasData.calcDistanceVector(pessoa3);
        assertEquals(distanceVector[0], distanceMeasure.calcDistance(pessoa3, pessoa1), "Retornando corretamente a distância final entre pessoa 3 e pessoa 1");
        assertEquals(distanceVector[1], distanceMeasure.calcDistance(pessoa3, pessoa2), "Retornando corretamente a distância final entre pessoa 3 e pessoa 2");
        assertEquals(distanceVector[2], distanceMeasure.calcDistance(pessoa3, pessoa3), "Retornando corretamente a distância final entre pessoa 3 e ela própria");
    }

    @Test
    void testCalcDistanceMatrix() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        pessoasData.normalizeField("altura");
        pessoasData.normalizeField("Peso");
        pessoasData.normalizeField("renda");
        double[][] distanceMatrix = pessoasData.calcDistanceMatrix();
        assertEquals(distanceMatrix[0][1], distanceMeasure.calcDistance(pessoa1, pessoa2), "retornando corretamente a distância entre os pares de índice 0 e 1 da matriz");
        assertEquals(distanceMatrix[0][2], distanceMeasure.calcDistance(pessoa1, pessoa3), "retornando corretamente a distância entre os pares de índice 0 e 2 da matriz");
        assertEquals(distanceMatrix[1][2], distanceMeasure.calcDistance(pessoa2, pessoa3), "retornando corretamente a distância entre os pares de índice 1 e 2 da matriz");

    }

    @Test
    void testGetSimilar() {
        pessoasData.addPessoa(pessoa1);
        pessoasData.addPessoa(pessoa2);
        pessoasData.addPessoa(pessoa3);
        pessoasData.addPessoa(pessoa4);
        pessoasData.addPessoa(pessoa5);
        pessoasData.normalizeField("altura");
        pessoasData.normalizeField("Peso");
        pessoasData.normalizeField("renda");
        Pessoa[] pessoasSimilares = pessoasData.getSimilar(pessoa1, 2);
        assertEquals(pessoasSimilares[0], pessoa4, "Primeira pessoa similar alocada com sucesso");
        assertEquals(pessoasSimilares[1], pessoa5, "Segunda pessoa similar alocada com sucesso");
    }
}