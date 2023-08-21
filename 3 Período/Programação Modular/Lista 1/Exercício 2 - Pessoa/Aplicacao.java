
public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa fulano = new Pessoa();
		Pessoa julia = new Pessoa("Júlia", "15681928608", 19, "feminino");
		
		System.out.println("Pessoa com inicializador padrão");
		System.out.println("-------------------------------------------");
		System.out.println("Nome da pessoa 1: " +  fulano.getNome());
		System.out.println("CPF da pessoa 1: " +  fulano.getCPF());
		System.out.println("Idade da pessoa 1: " +  fulano.getIdade());
		System.out.println("Sexo da pessoa 1: " +  fulano.getSexo());
		System.out.println("Pessoa 1 é maior de idade: " +  fulano.eMaiorDeIdade(fulano.getIdade()));
		System.out.println("-------------------------------------------");
		System.out.println("Pessoa com inicializador com parâmetros");
		System.out.println("-------------------------------------------");
		System.out.println("Nome da pessoa 2: " +  julia.getNome());
		System.out.println("CPF da pessoa 2: " +  julia.getCPF());
		System.out.println("Idade da pessoa 2: " +  julia.getIdade());
		System.out.println("Sexo da pessoa 2: " +  julia.getSexo());
		System.out.println("Pessoa 2 é maior de idade: " +  julia.eMaiorDeIdade(julia.getIdade()));
		System.out.println("-------------------------------------------");
		
	}

}
