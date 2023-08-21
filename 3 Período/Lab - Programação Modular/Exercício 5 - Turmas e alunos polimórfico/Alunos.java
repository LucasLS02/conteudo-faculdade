
public class Alunos {
	
	private String nome;
	private int matricula;
	private Provas[] avaliacoes;
	private String codTurma;
	private int faltas;
	private boolean aprovado;
	private static int contador = 1;
	
	private void init(String nome, int quantidadeProvas, int faltas) {
		this.nome = nome;
		this.avaliacoes = iniciarProvas(quantidadeProvas);
		this.codTurma = "";
		this.faltas = faltas;
		aprovado = false;
		this.matricula = criarMatricula();
	}
	
	Alunos() {
		init("Lucas", 4, 0);
	}

	Alunos(String nome, int quantidadeProvas, int faltas) {
		init(nome, quantidadeProvas, faltas);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public Provas[] getAvaliacoes() {
		return avaliacoes;
	}

	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public int getFaltas() {
		return faltas;
	}

	private void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	
	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	private static int getNumMatriculaAtual()
	{
		return contador;
	}
	
	private static void setNumMatriculaAtual()

	{
		contador++;
	}
	
	private int criarMatricula() {
		int matricula = Alunos.getNumMatriculaAtual();
		Alunos.setNumMatriculaAtual();
		return matricula;
	}
	
	private Provas[] iniciarProvas(int quantidadeProvas)
	{
		Provas[] provas = new Provas[quantidadeProvas];
		int valorProva = 100/quantidadeProvas;
		for(int i = 0;i<quantidadeProvas;i++) {
			Provas prova = new Provas(valorProva);
			provas[i] = prova;
		}
		return provas;
	}
	
	public void adicionarFalta()
	{
		setFaltas(faltas + 1);
	}
	
	public void retirarFalta()
	{
		if(faltas > 0)
		{
			setFaltas(faltas - 1);
		}
	}
	
	public int somatorioDeNotas() {
		int somatorioProvas = 0;
		for(int i = 0;i<4;i++)
		{
			somatorioProvas += avaliacoes[i].getResultado();
		}
		return somatorioProvas;
	}
	
	public void alterarNotas(int nota, int numProva) {
		numProva--;
		if(nota <= avaliacoes[0].getValor() && nota >= 0 && numProva >= 0 && numProva <= avaliacoes.length) { 
			avaliacoes[numProva].setResultado(nota);
		}
	}
	
}
