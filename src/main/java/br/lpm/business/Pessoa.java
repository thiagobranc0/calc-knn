package br.lpm.business;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;
    private float altura;
    private float peso;
    private float renda;
    private String naturalidade;
    private Hobby hobby;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private boolean feliz;
    private Moradia moradia;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero, float altura, float peso, float renda, String naturalidade, Hobby hobby, EstadoCivil estadoCivil, Escolaridade escolaridade, boolean feliz, Moradia moradia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.renda = renda;
        this.naturalidade = naturalidade;
        this.hobby = hobby;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.feliz = feliz;
        this.moradia = moradia;
    }

    public Pessoa() {
        this.nome = "Fulano";
        this.dataNascimento = LocalDate.of(2000,01,01);
        this.genero = Genero.MASCULINO;
        this.altura = 1.30f;
        this.peso = 70f;
        this.renda = 1000;
        this.naturalidade = "Cidade";
        this.hobby = Hobby.GAME;
        this.estadoCivil = EstadoCivil.SOLTEIRO;
        this.escolaridade = Escolaridade.NENHUMA;
        this.feliz = false;
        this.moradia = Moradia.COM_FAMILIA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(ehStringValida(nome)) {
            this.nome = nome;
        }
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        if (peso >= 0 && peso < 600f) {
            this.peso = peso;
        }
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dia, int mês, int ano) {
        LocalDate data = LocalDate.of(ano, mês, dia);
        if(LocalDate.now().isAfter(data)) {
            this.dataNascimento = data;
        }
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if(altura >= 0 && altura < 2.60){
            this.altura = altura;
        }
    }

    public int getIdade() {
        int dia = dataNascimento.getDayOfMonth();
        int mes = dataNascimento.getMonthValue();
        int ano = dataNascimento.getYear();
        int idade = LocalDate.now().minusDays(dia).minusMonths(mes).minusYears(ano).getYear();
        return idade;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        if(renda >= 0) {
            this.renda = renda;
        }
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        if(ehStringValida(naturalidade)) {
            this.naturalidade = naturalidade;
        }
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isFeliz() {
        return feliz;
    }

    public void setFeliz(boolean feliz) {
        this.feliz = feliz;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }

    private boolean ehStringValida(String string) {
        char[] caractere = string.toCharArray();

        for(char possivelLetra : caractere) {
            if(!Character.isLetter(possivelLetra) && !Character.isWhitespace(possivelLetra)) {
                return false;
            }
        }

        return true;
    }

}
