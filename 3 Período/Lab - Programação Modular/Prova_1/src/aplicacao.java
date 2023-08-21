
public class aplicacao {

	public static void main(String[] args) {
		
		Jogo fifa = new Jogo();
		Cliente lucas = new Cliente();
		lucas.incluirJogo(fifa);
		System.out.println("produto vendido(2022) por: " + lucas.getHistorico()[0].precoVenda());
		lucas.getHistorico()[0].setAnoLancamento(2019);
		System.out.println("produto vendido(2019) por: " + lucas.getHistorico()[0].precoVenda());
	}
}
