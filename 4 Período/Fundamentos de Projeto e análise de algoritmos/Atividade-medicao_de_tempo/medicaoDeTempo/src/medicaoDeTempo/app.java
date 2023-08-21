package medicaoDeTempo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.math.BigInteger;

public class app {

    /**
     * Troca dois elementos de posição em um vetor.
     * @param dados O vetor com os dados.
     * @pos1 Primeira posição para trocar.
     * @pos2 Posição a ser trocada com a primeira.
     */
    static void trocar(int[] dados, int pos1, int pos2){
        int aux = dados[pos1];
        dados[pos1] = dados[pos2];
        dados[pos2] = aux;
    }

    /**
     * Gerador de vetores aleatórios: recebe como parâmetros o tamanho do vetor e se ele deve ser gerado em ordem crescente ou não.
     * @param tamanho Tamanho do vetor a gerar (número positivo).
     * @param ordenado TRUE para receber um vetor ordenado; FALSE caso contrário.
     * @return Um vetor de inteiros nas condições especificadas pelos parâmetros.
     */
    static public int[] geraVetor(int tamanho, boolean ordenado){
        Random sorteio = new Random(42);
        int[] dados = new int[tamanho];
        for (int i = 0; i < dados.length; i++) {
            dados[i] = i+1;
        }
        if(!ordenado){
            for (int i = 0; i < dados.length*3; i++) {
                int pos1 = sorteio.nextInt(dados.length);
                int pos2 = sorteio.nextInt(dados.length);
                trocar(dados, pos1, pos2);
            }
        }
        return dados;
    }

    /**
     * Ordenação por bolha. Pára a ordenação se percebe o vetor já ordenado.
     * @param dados O vetor a ser ordenado.
     */
    static public void bolha(int[] dados){
        for (int i = dados.length-1; i > 0; i--) {
            int trocas = 0;
            for (int j = 0; j < i; j++) {
                if(dados[j] > dados[j+1]){
                    trocar(dados, j, j+1);
                    trocas++;
                }
            }
            if(trocas==0) return;
        }
    }

    /**
     * Particionamento do vetor para a ordenação quicksort. Usa como pivô a última posição do vetor.
     * @param dados Vetor a ser particionado.
     * @param inicio Posição inicial do particionamento.
     * @param fim Posição final do particionamento (inclusivo, ou seja: este valor é a posição do vetor que será usada como pivô).
     * @return A posição entre 'inicio' e 'fim' onde ocorreu o particionamento.
     */
    static public int particao(int[] dados, int inicio, int fim){
        int posicao = inicio-1;
        int pivot = dados[fim];
        for (int i = inicio; i < fim; i++) {
            if(dados[i]<pivot){
                posicao++;
                trocar(dados, posicao, i);
            }
        }
        posicao++;
        trocar(dados, posicao, fim);
        return posicao;
    }

    /**
     * Método quicksort recursivo para ordenar um vetor de inteiros.
     * @param dados O vetor com os dados.
     * @param inicio O limite inicial para a ordenação recursiva.
     * @param fim O limite final (inclusivo) para a ordenação recursiva.
     */
    static public void quicksort(int[] dados, int inicio, int fim){
        if(inicio>=fim)
            return;
        else{
            System.out.println("--------");
            System.out.println("Início: " + inicio);
            System.out.println("Fim: " + fim);
            int particao = particao(dados, inicio, fim);
            System.out.println("Partição: " + particao);
            quicksort(dados, inicio, particao-1);
            quicksort(dados, particao+1, fim);
        }
    }

    /**
     * Escreva aqui no método principal sua automação do teste, de acordo com as especificações do exercício.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] tamList = { 375_000 };
        for(int tam : tamList){
            List<BigInteger> tempoDeExecucao = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                int[] vet = geraVetor(tam, false);
                BigInteger inicio = new BigInteger(String.valueOf(System.currentTimeMillis()));
                quicksort(vet, 0, vet.length-1);
                BigInteger fim = new BigInteger(String.valueOf(System.currentTimeMillis()));
                BigInteger diferencaTempo = new BigInteger(fim.subtract(inicio).toByteArray());
                tempoDeExecucao.add(diferencaTempo);
            }
            try (BufferedWriter saida = new BufferedWriter(new FileWriter("Quicksort" + tam + "_desordenado_10_" + ".txt"))) {
                BigInteger media = BigInteger.ZERO;
                int j = 0;
                for (BigInteger x : tempoDeExecucao) {
                    media = media.add(x);
                    saida.write(j + 1 + ") " + x);
                    saida.newLine();
                    j++;
                }
                saida.newLine();
                saida.newLine();
                saida.write("Media: " + media.divide(BigInteger.valueOf(tempoDeExecucao.size())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
