package br.lpm.business;

public class DistanceMeasure {
    public double calcDistance(Pessoa pessoa1, Pessoa pessoa2) {
        float distanciaAltura = pessoa1.getAltura() - pessoa2.getAltura();
        float distanciaPeso = pessoa1.getPeso() - pessoa2.getPeso();
        float distanciaRenda = pessoa1.getRenda() - pessoa2.getRenda();
        int distanciaGenero = 1;
        int distanciaHobby = 1;
        int distanciaEstadoCivil = 1;
        int distanciaEscolaridade = 1;
        int distanciaFeliz = 1;
        int distanciaMoradia = 1;
        double distanciaFinal = 0;

        if(pessoa1.getGenero() == pessoa2.getGenero()) {
            distanciaGenero = 0;
        }

        if(pessoa1.getHobby() == pessoa2.getHobby()) {
            distanciaHobby = 0;
        }

        if(pessoa1.getEstadoCivil() == pessoa2.getEstadoCivil()) {
            distanciaEstadoCivil = 0;
        }

        if(pessoa1.getEscolaridade() == pessoa2.getEscolaridade()) {
            distanciaEscolaridade = 0;
        }

        if(pessoa1.isFeliz() == pessoa2.isFeliz()) {
            distanciaFeliz = 0;
        }

        if(pessoa1.getMoradia() == pessoa2.getMoradia()) {
            distanciaMoradia = 0;
        }

        distanciaFinal = Math.sqrt(((distanciaAltura * distanciaAltura) + (distanciaPeso * distanciaPeso) + (distanciaRenda * distanciaRenda) + (distanciaEscolaridade * distanciaEscolaridade) + (distanciaEstadoCivil * distanciaEstadoCivil) + (distanciaGenero * distanciaGenero) + (distanciaFeliz * distanciaFeliz) + (distanciaHobby * distanciaHobby) + (distanciaMoradia * distanciaMoradia)) / 9);
        return distanciaFinal;
    }

}
