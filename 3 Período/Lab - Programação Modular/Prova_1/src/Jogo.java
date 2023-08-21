
public class Jogo {
	
	 private final int TEMPO_DESC = 2;
	 private final double PCT_DESCONTO = 0.2;
	 private final double MARGEM_LUCRO = 0.35;
	 private String nome;
	 private int anoLancamento;
	 private double precoBase;
	 private int[] avaliacoes;
	 
	 Jogo() {
		 this.nome = "Fifa22";
		 this.anoLancamento = 2022;
		 this.precoBase = 300;
		 this.avaliacoes = new int[100];
		 setarAvaliacoes();
	 }
	 
	 Jogo(String nome, int anoLancamento, double precoBase, int[] avaliacoes) {
		 this.nome = nome;
		 this.anoLancamento = anoLancamento;
		 this.precoBase = precoBase;
		 this.avaliacoes = avaliacoes;
		 setarAvaliacoes();
	 }
	 
	 public int getTEMPO_DESC() {
		return TEMPO_DESC;
	}

	public double getPCT_DESCONTO() {
		return PCT_DESCONTO;
	}

	public double getMARGEM_LUCRO() {
		return MARGEM_LUCRO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}

	public int[] getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(int[] avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	private void setarAvaliacoes() {
		for(int i = 0; i < 100; i++) {
			getAvaliacoes()[i] = -1;
		}
	}
 	
	public double precoVenda() {
		return ((1 + MARGEM_LUCRO) * precoBase());
	}
	
	private double precoBase() {
		return descontoTempo();
	}
	
	private double descontoTempo() {
		double novoPrecoBase = (getPrecoBase() - (((2022 - getAnoLancamento())/getTEMPO_DESC()) * (getPrecoBase() * getPCT_DESCONTO())));
		setPrecoBase(novoPrecoBase);
		return novoPrecoBase;
	}
	
	public double avaliacaoMedia() {
		double somaAvaliacoes = 0;
		int cont = 0;
		while(getAvaliacoes()[0] != -1) {
			somaAvaliacoes += getAvaliacoes()[cont];
		}
		return somaAvaliacoes / getAvaliacoes().length;
	}
	
	public void novaAvaliacao(int nota) {
		
		int cont = 0;
		while(getAvaliacoes()[cont] != -1) {
			cont++;
		}
		if(cont < 100) {
			getAvaliacoes()[cont] = nota;
		}
		
		
		if(nota >= 1 && nota <= 5) {
			if(getAvaliacoes().length == 0) {
				getAvaliacoes()[0] = nota;
			}
			else {
				getAvaliacoes()[getAvaliacoes().length + 1] = nota;
			}
		}
	}
	
}
