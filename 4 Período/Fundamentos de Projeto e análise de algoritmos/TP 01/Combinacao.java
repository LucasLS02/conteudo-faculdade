import java.util.ArrayList;
import java.util.List;

public class Combinacao {

    private static void gerarCombinacoesInterno(List<Integer> set, List<List<Integer>> resultado, List<Integer> acumulador, int index) {
        if (index == set.size()) {
            resultado.add(new ArrayList<Integer>(acumulador));
        } else {
            acumulador.add(set.get(index));
            gerarCombinacoesInterno(set, resultado, acumulador, index + 1);
            acumulador.remove(acumulador.size() - 1);
            gerarCombinacoesInterno(set, resultado, acumulador, index + 1);
        }
    }

    public static List<List<Integer>> gerarCombinacoes(List<Integer> sequence) {
        List<List<Integer>> resultado = new ArrayList<>();
        gerarCombinacoesInterno(sequence, resultado, new ArrayList<>(), 0);
        return resultado;
    }

}
