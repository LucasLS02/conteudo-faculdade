
public class Humano {
	
	public String nome;
	
	Humano(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return("Nome: " + this.nome);
	}

}
