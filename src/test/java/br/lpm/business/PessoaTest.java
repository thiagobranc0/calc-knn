package br.lpm.business;

import br.lpm.business.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    public static Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa();
    }

    @Test
    void testSetPeso() {
        pessoa.setPeso(45);
        assertEquals(45, pessoa.getPeso(), "Atribuição de peso válida");
        pessoa.setPeso(700);
        assertEquals(45, pessoa.getPeso(), "Atribuição de peso inválida");
    }

    @Test
    void testSetNome() {
        pessoa.setNome("Ana");
        assertEquals("Ana", pessoa.getNome(),"Atribuição de nome válida");
        pessoa.setNome("Ana%%");
        assertEquals("Ana", pessoa.getNome(), "Atribuição de nome inválida");
    }

    @Test
    void testSetGenero() {
        pessoa.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, pessoa.getGenero());
    }

    @Test
    void testSetDataNascimento() {
        pessoa.setDataNascimento(20, 9, 1992);
        assertEquals(LocalDate.of(1992, 9, 20).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Atribuição de data válida.");
        pessoa.setDataNascimento(20, 9, 3000);
        assertEquals(LocalDate.of(1992, 9, 20).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Atribuição de data inválida.");
    }

    @Test
    void testSetAltura() {
        pessoa.setAltura(1.82f);
        assertEquals(1.82f, pessoa.getAltura(), "Atribuição de altura válida");
        pessoa.setAltura(3);
        assertEquals(1.82f, pessoa.getAltura(), "Atribuição de altura inválida");
    }

    @Test
    void testSetRenda() {
        pessoa.setRenda(1200.74f);
        assertEquals(1200.74f, pessoa.getRenda(), "Atribuição de renda válida.");
        pessoa.setRenda(-1000000.75f);
        assertEquals(1200.74f, pessoa.getRenda(), "Atribuição de renda inválida.");
    }

    @Test
    void testSetNaturalidade() {
        pessoa.setNaturalidade("Macapá");
        assertEquals("Macapá", pessoa.getNaturalidade(),"Atribuição de naturalidade válida");
        pessoa.setNaturalidade("#Macapá");
        assertEquals("Macapá", pessoa.getNaturalidade(), "Atribuição de naturalidade inválida");
    }

    @Test
    void testSetHobby() {
        pessoa.setHobby(Hobby.GAME);
        assertEquals(Hobby.GAME, pessoa.getHobby(), "Atribuição de estado civil válida");
    }

    @Test
    void testSetEstadoCivil() {
        pessoa.setEstadoCivil(EstadoCivil.CASADO);
        assertEquals(EstadoCivil.CASADO, pessoa.getEstadoCivil(), "Atribuição de estado civil válida");
    }

    @Test
    void testSetEscolaridade() {
        pessoa.setEscolaridade(Escolaridade.SUPERIOR);
        assertEquals(Escolaridade.SUPERIOR, pessoa.getEscolaridade(), "Atribuição de escolaridade civil válida");
    }

    @Test
    void testSetMoradia() {
        pessoa.setMoradia(Moradia.ALUGUEL);
        assertEquals(Moradia.ALUGUEL, pessoa.getMoradia(), "Atribuição de moradia válida");
    }
}
