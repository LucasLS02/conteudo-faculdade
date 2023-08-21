
public class Aplicacao {

	public static void main(String[] args) {
		// Classe aplicação para demonstrar funcionamento da classe 'conta'
		
		Conta conta_1 = new Conta();
		Conta conta_2 = new Conta(200);
		
		System.out.println("Conta com inicializador padrão");
		System.out.println("-------------------------------------------");
		System.out.println("Número da conta 1: " +  conta_1.getNumConta());
		System.out.println("Saldo da conta 1: " + conta_1.getSaldo());
		System.out.println("-------------------------------------------");
		System.out.println("Conta com inicializador com parâmetros");
		System.out.println("-------------------------------------------");
		System.out.println("Número da conta 2: " +  conta_2.getNumConta());
		System.out.println("Saldo da conta 2: " + conta_2.getSaldo());
		System.out.println("-------------------------------------------");
		conta_1.tranferencia(conta_2,10);
		System.out.println("Tranferindo R$ 10,00 da conta_1 para conta_2");
		System.out.println("Saldo da conta 1 após tranferência: " + conta_1.getSaldo());
		System.out.println("Saldo da conta 2 após tranferência: " + conta_2.getSaldo());
		System.out.println("-------------------------------------------");
		conta_2.tranferencia(conta_1, 184);
		System.out.println(conta_1.extrato());
		System.out.println(conta_2.extrato());
		System.out.println("-------------------------------------------");
	}
}
