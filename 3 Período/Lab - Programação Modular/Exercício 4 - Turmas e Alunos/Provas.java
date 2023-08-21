
public class Provas {
	
	private int valor;
	private int resultado;
	
	private void init(int valor, int resultado) {
		this.valor = valor;
		this.resultado = resultado;
	}
	
	Provas(int valor)
	{
		init(valor,0);
	}
	
	Provas(int valor, int resultado)
	{
		init(valor,resultado);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	

}
