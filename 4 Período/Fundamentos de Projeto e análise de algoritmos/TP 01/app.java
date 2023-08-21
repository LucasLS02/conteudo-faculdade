import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class App {
    
    public static List<Integer> generateConjunto(int tam) {
		List<Integer> conjunto = new LinkedList<Integer>();
		Random random = new Random();
		for(int i=0; i<tam; i++) {
			conjunto.add(random.nextInt(8) + 1);
		}
		
		return conjunto;
	}

    public static void main(String[] args) {
        Map<Integer, Long> tempoPorTamanhoVetor = new HashMap<Integer, Long>();
        long tempoMedio = 0;
        for(int i = 2; tempoMedio <= 4000; i++) {
            List<Integer> conjunto = generateConjunto(i);
            long tempo = 0;
            for(int j = 0; j < 150; j++) {
                tempo = System.currentTimeMillis();
                SomaSubconjunto.subconjuntos(conjunto, (int) Math.round(conjunto.stream().mapToInt(p -> p).average().orElse(0)));
                tempo = System.currentTimeMillis() - tempo;
                tempoMedio += tempo;
            }
            tempoMedio /= 150;
            tempoPorTamanhoVetor.put(i, tempoMedio);
        }
        System.out.println(tempoPorTamanhoVetor);
    }
}