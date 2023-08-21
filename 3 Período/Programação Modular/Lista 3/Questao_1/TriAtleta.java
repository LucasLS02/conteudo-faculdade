
public class TriAtleta extends Humano implements Corredor, Nadador, Ciclista {

	TriAtleta(String nome) {
		super(nome);

	}
	
	public void correr() {
		System.out.print("Correr!");
	}

	@Override
	public void pedalar() {
		System.out.print("Pedalar!!");
	}

	@Override
	public void nadar() {
		System.out.print("Nadar!");
	}

}
