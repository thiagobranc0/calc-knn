package br.lpm.business;

public class Knn {
    private DataSet dataset;
    private int k;

    public Knn(DataSet dataset, int k) {
        this.dataset = dataset;
        this.k = k;
    }

    public boolean classifyFeliz(Pessoa pessoa) {
        int contadorFeliz = 0;
        int contadorTriste = 0;
        Pessoa[] pessoas = dataset.getSimilar(pessoa, k);
        for (int i = 0; i < pessoas.length; i++) {
            System.out.println(pessoas[i].getNome());
            if (pessoas[i].isFeliz()) {
                contadorFeliz++;
            } else {
                contadorTriste++;
            }
        }

        return contadorFeliz >= contadorTriste;
    }
}
