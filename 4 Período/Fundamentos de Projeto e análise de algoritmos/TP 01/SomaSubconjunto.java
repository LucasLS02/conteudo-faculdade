import java.util.ArrayList;
import java.util.List;

public class SomaSubconjunto {
    
    public static List<List<Integer>> subconjuntos(List<Integer> conjunto, int soma) {
        List<List<Integer>> resultado = new ArrayList<List<Integer>>();
        List<List<Integer>> possibilidades = Combinacao.gerarCombinacoes(conjunto);
        for (List<Integer> subconjunto : possibilidades) {
            if(subconjunto.stream().mapToInt(p -> p).sum() == soma) {
                resultado.add(subconjunto);
            }
        }
        return resultado;
    }
}
