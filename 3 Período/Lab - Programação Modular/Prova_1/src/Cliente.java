
public class Cliente {
	
	private String nome;
	private Jogo[] historico;
	
	Cliente() {
		this.nome = "Lucas";
		this.historico = new Jogo[100];
	}
	
	Cliente(String nome, Jogo[] historico) {
		this.nome = nome;
		this.historico = historico;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Jogo[] getHistorico() {
		return historico;
	}
	public void setHistorico(Jogo[] historico) {
		this.historico = historico;
	}
	
	public void incluirJogo(Jogo novo) {

		int cont = 0;
		while(getHistorico()[cont] != null) {
			cont++;
		}
		System.out.println(cont);
		if(cont < 100) {
			getHistorico()[cont] = novo;
		}
	}
	
}
