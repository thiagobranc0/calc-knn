package br.lpm.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataSet {
    public static final int MAX_PESSOAS = 10;
    private int quantidadePessoasCadastradas = 0;
    private Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];
    private DistanceMeasure distanceMeasure = new DistanceMeasure();

    public void addPessoa(Pessoa pessoa) {
        if(quantidadePessoasCadastradas < MAX_PESSOAS) {
            pessoas[quantidadePessoasCadastradas] = pessoa;
            quantidadePessoasCadastradas++;
        }
    }

    public void removePessoa(Pessoa pessoa) {
        if(quantidadePessoasCadastradas > 0) {
            for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                if (pessoas[i] == pessoa && pessoas[i + 1] != null) {
                    pessoas[i] = pessoas[i + 1];
                    pessoas[i + 1] = pessoa;
                } else if (pessoas[i] == pessoa && pessoas[i + 1] == null) {
                    pessoas[i] = null;
                }
            }
            quantidadePessoasCadastradas--;
        }
    }

    public void removePessoaByName(String nome) {
        if(quantidadePessoasCadastradas > 0 && nome != null) {
            for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                if (pessoas[i].getNome().equalsIgnoreCase(nome) && pessoas[i + 1] != null) {
                    Pessoa pessoaAuxiliar = pessoas[i];
                    pessoas[i] = pessoas[i + 1];
                    pessoas[i + 1] = pessoaAuxiliar;
                } else if (pessoas[i].getNome().equalsIgnoreCase(nome) && pessoas[i + 1] == null) {
                    pessoas[i] = null;
                }
            }

            quantidadePessoasCadastradas--;
        }
    }

    public void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        if(oldPessoa != null && newPessoa != null) {
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i] == oldPessoa) {
                    pessoas[i] = newPessoa;
                }
            }
        }
    }

    public Pessoa getPessoaByName(String nome) {
        if(quantidadePessoasCadastradas > 0 && nome != null) {
            for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                if (pessoas[i].getNome().equalsIgnoreCase(nome)) {
                    return pessoas[i];
                }
            }
        }
        return null;
    }

    public Pessoa[] getAll() {
        if(quantidadePessoasCadastradas > 0) {
            Pessoa[] vetorPessoas = new Pessoa[quantidadePessoasCadastradas];
            for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                vetorPessoas[i] = pessoas[i];
            }
            return vetorPessoas;
        }
        return null;
    }

    public void removeAll() {
        if(quantidadePessoasCadastradas > 0) {
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                pessoas[i] = null;
            }
        }
    }

    public int size() {
        return quantidadePessoasCadastradas;
    }

    public float maxAltura() {
        if(quantidadePessoasCadastradas > 0) {
            float maiorAltura = pessoas[0].getAltura();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getAltura() > maiorAltura) {
                    maiorAltura = pessoas[i].getAltura();
                }
            }
            return maiorAltura;
        }
        return 0;
    }

    public float minAltura() {
        if(quantidadePessoasCadastradas > 0) {
            float menorAltura = pessoas[0].getAltura();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getAltura() < menorAltura) {
                    menorAltura = pessoas[i].getAltura();
                }
            }
            return menorAltura;
        }
        return 0;
    }

    public float avgAltura() {
        if(quantidadePessoasCadastradas > 0) {
            float media = 0;
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                media += pessoas[i].getAltura();
            }
            return media / quantidadePessoasCadastradas;
        }
        return 0;
    }

    public float maxPeso() {
        if (quantidadePessoasCadastradas > 0) {
            float maiorPeso = pessoas[0].getPeso();
            for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                if (pessoas[i].getPeso() > maiorPeso) {
                    maiorPeso = pessoas[i].getPeso();
                }
            }
            return maiorPeso;
        }
        return 0;
    }

    public float minPeso() {
        if(quantidadePessoasCadastradas > 0) {
            float menorPeso = pessoas[0].getPeso();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getPeso() < menorPeso) {
                    menorPeso = pessoas[i].getPeso();
                }
            }
            return menorPeso;
        }
        return 0;
    }

    public float avgPeso() {
        if(quantidadePessoasCadastradas > 0) {
            float media = 0;
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                media += pessoas[i].getPeso();
            }
            return media / quantidadePessoasCadastradas;
        }
        return 0;
    }

    public float percentAdult() {
        if(quantidadePessoasCadastradas > 0) {
            float maioresDeIdade = 0;
            float percentAdult;
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                float idade = pessoas[i].getIdade();
                if(idade >= 18) {
                    maioresDeIdade++;
                }
            }
            return percentAdult = (maioresDeIdade * 100) / quantidadePessoasCadastradas;
        }
        return 0;
    }

    public float percentEstadoCivil(EstadoCivil estadoCivil) {
        float percentSolteiro = 0;
        float percentCasado = 0;
        float percentViuvo = 0;
        float percentSeparado = 0;
        float percentDivorciado = 0;

        for(int i = 0; i < quantidadePessoasCadastradas; i++) {
            if(pessoas[i].getEstadoCivil() == estadoCivil) {
                percentSolteiro++;
            }
            if(pessoas[i].getEstadoCivil() == estadoCivil) {
                percentCasado++;
            }
            if(pessoas[i].getEstadoCivil() == estadoCivil) {
                percentViuvo++;
            }
            if(pessoas[i].getEstadoCivil() == estadoCivil) {
                percentSeparado++;
            }
            if(pessoas[i].getEstadoCivil() == estadoCivil) {
                percentDivorciado++;
            }
        }
        if(estadoCivil == EstadoCivil.SOLTEIRO) {
            return percentSolteiro = (percentSolteiro * 100) / quantidadePessoasCadastradas;
        }
        if(estadoCivil == EstadoCivil.CASADO) {
            return percentCasado = (percentCasado * 100) / quantidadePessoasCadastradas;
        }
        if(estadoCivil == EstadoCivil.VIUVO) {
            return percentViuvo = (percentViuvo * 100) / quantidadePessoasCadastradas;
        }
        if(estadoCivil == EstadoCivil.SEPARADO) {
            return percentSeparado = (percentSeparado * 100) / quantidadePessoasCadastradas;
        }
        if(estadoCivil == EstadoCivil.DIVORCIADO) {
            return percentDivorciado = (percentDivorciado * 100) / 10;
        }

        return 0;
    }

    public EstadoCivil modeEstadoCivil() {
        if(quantidadePessoasCadastradas > 0) {
            int numeroSolteiros = 0;
            int numeroCasados = 0;
            int numeroViuvos = 0;
            int numeroSeparados = 0;
            int numeroDivorciados = 0;

            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getEstadoCivil() == EstadoCivil.SOLTEIRO) {
                    numeroSolteiros++;
                }
                if(pessoas[i].getEstadoCivil() == EstadoCivil.CASADO) {
                    numeroCasados++;
                }
                if(pessoas[i].getEstadoCivil() == EstadoCivil.VIUVO) {
                    numeroViuvos++;
                }
                if(pessoas[i].getEstadoCivil() == EstadoCivil.SEPARADO) {
                    numeroSeparados++;
                }
                if(pessoas[i].getEstadoCivil() == EstadoCivil.DIVORCIADO) {
                    numeroDivorciados++;
                }
            }

            int[] arrayContaEstadoCivil = {numeroSolteiros, numeroCasados, numeroViuvos, numeroSeparados, numeroDivorciados};
            int maisFrequente = 0;
            int indiceDoMaisFrequente = 0;
            for(int i = 0; i < arrayContaEstadoCivil.length; i++) {
                if(arrayContaEstadoCivil[i] > maisFrequente) {
                    maisFrequente = arrayContaEstadoCivil[i];
                    indiceDoMaisFrequente = i;
                }
            }

            if(indiceDoMaisFrequente == 0) {
                return EstadoCivil.SOLTEIRO;
            }
            if(indiceDoMaisFrequente == 1) {
                return EstadoCivil.CASADO;
            }
            if(indiceDoMaisFrequente == 2) {
                return EstadoCivil.VIUVO;
            }
            if(indiceDoMaisFrequente == 3) {
                return EstadoCivil.SEPARADO;
            }
            if(indiceDoMaisFrequente == 4) {
                return EstadoCivil.DIVORCIADO;
            }
        }
        return null;
    }

    public float percentEscolaridade(Escolaridade escolaridade) {
        float percentNenhuma = 0;
        float percentFundamental = 0;
        float percentMedio = 0;
        float percentSuperior = 0;
        float percentPosGraduacao = 0;

        for(int i = 0; i < quantidadePessoasCadastradas; i++) {
            if(pessoas[i].getEscolaridade() == escolaridade) {
                percentNenhuma++;
            }
            if(pessoas[i].getEscolaridade() == escolaridade) {
                percentFundamental++;
            }
            if(pessoas[i].getEscolaridade() == escolaridade) {
                percentMedio++;
            }
            if(pessoas[i].getEscolaridade() == escolaridade) {
                percentSuperior++;
            }
            if(pessoas[i].getEscolaridade() == escolaridade) {
                percentPosGraduacao++;
            }
        }
        if(escolaridade == Escolaridade.NENHUMA) {
            return percentNenhuma = (percentNenhuma * 100) / quantidadePessoasCadastradas;
        }
        if(escolaridade == Escolaridade.FUNDAMENTAL) {
            return percentFundamental = (percentFundamental * 100) / quantidadePessoasCadastradas;
        }
        if(escolaridade == Escolaridade.MEDIO) {
            return percentMedio = (percentMedio * 100) / quantidadePessoasCadastradas;
        }
        if(escolaridade == Escolaridade.SUPERIOR) {
            return percentSuperior = (percentSuperior * 100) / quantidadePessoasCadastradas;
        }
        if(escolaridade == Escolaridade.POS_GRADUACAO) {
            return percentPosGraduacao = (percentPosGraduacao * 100) / quantidadePessoasCadastradas;
        }

        return 0;
    }

    public Escolaridade modeEscolaridade() {
        if(quantidadePessoasCadastradas > 0) {
            int numeroNenhuma = 0;
            int numeroFundamental = 0;
            int numeroMedio = 0;
            int numeroSuperior = 0;
            int numeroPosGraduacao = 0;

            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getEscolaridade() == Escolaridade.NENHUMA) {
                    numeroNenhuma++;
                }
                if(pessoas[i].getEscolaridade() == Escolaridade.FUNDAMENTAL) {
                    numeroFundamental++;
                }
                if(pessoas[i].getEscolaridade() == Escolaridade.MEDIO) {
                    numeroMedio++;
                }
                if(pessoas[i].getEscolaridade() == Escolaridade.SUPERIOR) {
                    numeroSuperior++;
                }
                if(pessoas[i].getEscolaridade() == Escolaridade.POS_GRADUACAO) {
                    numeroPosGraduacao++;
                }
            }

            int[] arrayContaEscolaridade = {numeroNenhuma, numeroFundamental, numeroMedio, numeroSuperior, numeroPosGraduacao};
            int maisFrequente = 0;
            int indiceDoMaisFrequente = 0;
            for(int i = 0; i < arrayContaEscolaridade.length; i++) {
                if(arrayContaEscolaridade[i] > maisFrequente) {
                    maisFrequente = arrayContaEscolaridade[i];
                    indiceDoMaisFrequente = i;
                }
            }

            if(indiceDoMaisFrequente == 0) {
                return Escolaridade.NENHUMA;
            }
            if(indiceDoMaisFrequente == 1) {
                return Escolaridade.FUNDAMENTAL;
            }
            if(indiceDoMaisFrequente == 2) {
                return Escolaridade.MEDIO;
            }
            if(indiceDoMaisFrequente == 3) {
                return Escolaridade.SUPERIOR;
            }
            if(indiceDoMaisFrequente == 4) {
                return Escolaridade.POS_GRADUACAO;
            }
        }
        return null;
    }

    public float percentMoradia(Moradia moradia) {
        float percentComFamilia = 0;
        float percentAluguel = 0;
        float percentCasaPropria = 0;


        for(int i = 0; i < quantidadePessoasCadastradas; i++) {
            if(pessoas[i].getMoradia() == moradia) {
                percentComFamilia++;
            }
            if(pessoas[i].getMoradia() == moradia) {
                percentAluguel++;
            }
            if(pessoas[i].getMoradia() == moradia) {
                percentCasaPropria++;
            }
        }
        if(moradia == Moradia.COM_FAMILIA) {
            return percentComFamilia = (percentComFamilia * 100) / quantidadePessoasCadastradas;
        }
        if(moradia == Moradia.ALUGUEL) {
            return percentAluguel = (percentAluguel * 100) / quantidadePessoasCadastradas;
        }
        if(moradia == Moradia.CASA_PROPRIA) {
            return percentCasaPropria = (percentCasaPropria * 100) / quantidadePessoasCadastradas;
        }

        return 0;
    }

    public Moradia modeMoradia() {
        if(quantidadePessoasCadastradas > 0) {
            int numeroComFamilia = 0;
            int numeroAluguel = 0;
            int numeroCasaPropria = 0;

            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getMoradia() == Moradia.COM_FAMILIA) {
                    numeroComFamilia++;
                }
                if(pessoas[i].getMoradia() == Moradia.ALUGUEL) {
                    numeroAluguel++;
                }
                if(pessoas[i].getMoradia() == Moradia.CASA_PROPRIA) {
                    numeroCasaPropria++;
                }
            }

            int[] arrayContaMoradia = {numeroComFamilia, numeroAluguel, numeroCasaPropria};
            int maisFrequente = 0;
            int indiceDoMaisFrequente = 0;
            for(int i = 0; i < arrayContaMoradia.length; i++) {
                if(arrayContaMoradia[i] > maisFrequente) {
                    maisFrequente = arrayContaMoradia[i];
                    indiceDoMaisFrequente = i;
                }
            }

            if(indiceDoMaisFrequente == 0) {
                return Moradia.COM_FAMILIA;
            }
            if(indiceDoMaisFrequente == 1) {
                return Moradia.ALUGUEL;
            }
            if(indiceDoMaisFrequente == 2) {
                return Moradia.CASA_PROPRIA;
            }
        }
        return null;
    }

    public float percentHobby() {
        float temHobby = 0;

        for(int i = 0; i < quantidadePessoasCadastradas; i++) {
            if(pessoas[i].getHobby() != Hobby.NENHUM) {
                temHobby++;
            }
        }

        return temHobby = (temHobby * 100) / quantidadePessoasCadastradas;
    }

    public float percentFeliz() {
        float ehFeliz = 0;

        for(int i = 0; i < quantidadePessoasCadastradas; i++) {
            if(pessoas[i].isFeliz()) {
                ehFeliz++;
            }
        }

        return ehFeliz = (ehFeliz * 100) / quantidadePessoasCadastradas;
    }

    public float minRenda() {
        if(quantidadePessoasCadastradas > 0) {
            float menorRenda = pessoas[0].getRenda();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(menorRenda < pessoas[i].getRenda()) {
                    menorRenda = pessoas[i].getRenda();
                }
            }
            return menorRenda;
        }
        return 0;
    }

    public float maxRenda() {
        if(quantidadePessoasCadastradas > 0) {
            float maiorRenda = pessoas[0].getRenda();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getRenda() > maiorRenda) {
                    maiorRenda = pessoas[i].getRenda();
                }
            }
            return maiorRenda;
        }
        return 0;
    }

    public float minIdade() {
        if(quantidadePessoasCadastradas > 0) {
            float menorIdade = pessoas[0].getIdade();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                float idade = pessoas[i].getIdade();
                if(menorIdade < idade) {
                    menorIdade = idade;
                }
            }
            return menorIdade;
        }
        return 0;
    }

    public float maxIdade() {
        if(quantidadePessoasCadastradas > 0) {
            float maiorIdade = pessoas[0].getIdade();
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                if(pessoas[i].getIdade() > maiorIdade) {
                    maiorIdade = pessoas[i].getIdade();
                }
            }
            return maiorIdade;
        }
        return 0;
    }

    public void normalizeField(String fieldName) {
        if (fieldName.equalsIgnoreCase("Altura")) {
            float maxAltura = maxAltura();
            float minAltura = minAltura();
            if (maxAltura != minAltura) {
                for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                    float alturaNormalizada = (pessoas[i].getAltura() - minAltura) / (maxAltura - minAltura);
                    pessoas[i].setAltura(alturaNormalizada);
                }
            } else {
                for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                    pessoas[i].setAltura(0);
                }
            }
        }

        if (fieldName.equalsIgnoreCase("Peso")) {
            float maxPeso = maxPeso();
            float minPeso = minPeso();
            if (maxPeso != minPeso) {
                for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                    float pesoNormalizado = (pessoas[i].getPeso() - minPeso) / (maxPeso - minPeso);
                    pessoas[i].setPeso(pesoNormalizado);
                }
            } else {
                for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                    pessoas[i].setPeso(0);
                }
            }
        }

        if (fieldName.equalsIgnoreCase("Renda")) {
            float maxRenda = maxRenda();
            float minRenda = minRenda();
            if (maxRenda != minRenda) {
                for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                    float rendaNormalizada = (pessoas[i].getRenda() - minRenda) / (maxRenda - minRenda);
                    pessoas[i].setRenda(rendaNormalizada);
                }
            } else {
                for (int i = 0; i < quantidadePessoasCadastradas; i++) {
                    pessoas[i].setRenda(0);
                }
            }


        }
    }

    public double[] calcDistanceVector(Pessoa pessoa) {
        if (quantidadePessoasCadastradas > 0) {
            double[] distanceVector = new double[quantidadePessoasCadastradas];
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                distanceVector[i] = distanceMeasure.calcDistance(pessoa, pessoas[i]);
            }
            return distanceVector;
        }
        return null;
    }

    public double[][] calcDistanceMatrix() {
        if (quantidadePessoasCadastradas > 0) {
            double[][] distanceMatrix = new double[quantidadePessoasCadastradas][quantidadePessoasCadastradas];
            for(int i = 0; i < quantidadePessoasCadastradas; i++) {
                for(int j = 0; j < quantidadePessoasCadastradas; j++) {
                    distanceMatrix[i][j] = distanceMeasure.calcDistance(pessoas[i], pessoas[j]);
                }
            }
            return distanceMatrix;
        }
        return null;
    }

    public Pessoa[] getSimilar(Pessoa pessoa, int nPessoasSimilares) {
        if (quantidadePessoasCadastradas > 0 && nPessoasSimilares <= quantidadePessoasCadastradas) {
            Pessoa pessoasSimilares[] = new Pessoa[nPessoasSimilares];
            int indice = 0;
            for(int i = 0; i < quantidadePessoasCadastradas ; i++) {
                if (pessoas[i] != pessoa && nPessoasSimilares > 0 && distanceMeasure.calcDistance(pessoas[i], pessoa) <= 0.6) {
                    pessoasSimilares[indice] = pessoas[i];
                    indice++;
                    nPessoasSimilares--;
                }
            }
            return pessoasSimilares;
        }
        return null;
    }

    public void loadDataFromCSV(String filename) throws Exception {

        try (BufferedReader file = new BufferedReader(new FileReader(filename))) {

            // Remove linha de título
            String line = file.readLine();

            line = file.readLine();
            
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            DecimalFormat format = new DecimalFormat("0.#");
            format.setDecimalFormatSymbols(symbols);

            while (line != null && this.quantidadePessoasCadastradas < DataSet.MAX_PESSOAS) {
                String[] fields = line.split(";");
                String nome = fields[0];
                LocalDate dataNascimento = LocalDate.parse(fields[1], DateTimeFormatter.ofPattern("M/d/yyyy"));
                Genero genero = Genero.parseGenero(fields[2]);
                float altura =   format.parse(fields[3]).floatValue();
                float peso = format.parse(fields[4]).floatValue();
                float renda = format.parse(fields[5]).floatValue();
                String naturalidade = fields[6];
                Moradia moradia = Moradia.parseMoradia(fields[7]);
                EstadoCivil estadoCivil = EstadoCivil.parseEstadoCivil(fields[8]);
                Escolaridade escolaridade = Escolaridade.parseEscolaridade(fields[9]);
                Hobby hobby = Hobby.parseHobby(fields[10]);
                boolean feliz = fields[11].equalsIgnoreCase("Sim");

                pessoas[quantidadePessoasCadastradas++] = new Pessoa(nome, dataNascimento, genero, altura, peso, renda,
                naturalidade, hobby, estadoCivil, escolaridade, feliz, moradia) ;
                line = file.readLine();
            }
        } catch (IOException e) {

        }

    }
}


