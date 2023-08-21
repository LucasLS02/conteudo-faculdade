
public class Conta {
	
	private static int contador = 1;
	private int numConta;
	private float saldo;
	
	Conta() {
		this.numConta = Conta.getNumContaAtual();
		this.saldo = 0;
		Conta.setNumContaAtual();
	}
	
	Conta(float saldo) {
		this.numConta = contador;
		this.saldo = saldo;
		Conta.setNumContaAtual();
	}
	
	private static int getNumContaAtual()
	{
		return contador;
	}
	
	private static void setNumContaAtual()

	{
		contador++;
	}

	public int getNumConta() {
		return numConta;
	}

	private void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	private void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	public void tranferencia(Conta contaExterna, float valor) {
		if(valor > 0)
		{
			setSaldo(saldo - valor);
			contaExterna.setSaldo(contaExterna.getSaldo() + valor);
		}
	}
	
	public String extrato()
	{	
		return String.format("Extrato da conta: R$ %.2f", saldo);
	}

}
