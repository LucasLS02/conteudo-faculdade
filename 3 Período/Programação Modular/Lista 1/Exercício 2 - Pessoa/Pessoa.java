
public class Pessoa {
	
	private String nome;
	private String CPF;
	private int idade;
	private String sexo;
	
	Pessoa() {
		this.nome = "Fulano De Tal";
		this.CPF = "11111111111";
		this.idade = 18;
		this.sexo = "Não Declarado";
	}
	
	Pessoa(String nome, String CPF, int idade, String sexo) {
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public boolean eMaiorDeIdade(int idade) {
		boolean maiorDeIdade = false;
		
		if(idade >= 18)
		{
			maiorDeIdade = true;
		}
		
		return maiorDeIdade;
	}
	

}
