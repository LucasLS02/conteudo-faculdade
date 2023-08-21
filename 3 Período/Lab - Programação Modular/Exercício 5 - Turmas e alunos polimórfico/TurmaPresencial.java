
public class TurmaPresencial extends TurmaAvaliativa {
	
	private final int aulas = 20;
	
	TurmaPresencial() {
		super();
	}
	
	TurmaPresencial(int nivel,String diaDaAula, String turno) {
		super(nivel, diaDaAula,turno);
	}
	
	public int getAulas() {
		return aulas;
	}

	@Override
	public String gerarCodTurma() {
		return String.valueOf(100*super.getNivel() + 10*codDiaDaSemana() + codTurno());
	}
	
	@Override
	public void adicionarAlunos(Alunos aluno) {
		if(getAlunosDaTurma().size() < 20 && aluno.getCodTurma() == "") {
			getAlunosDaTurma().add(aluno);
			ordenarListaAlunos();
			aluno.setCodTurma(getCodTurma());
		}
	}
	
	@Override
	public void fecharResultado(Alunos aluno) {
		if(aluno.somatorioDeNotas() >= 60 && aluno.getFaltas() <= (getAulas()*0.25)) {
			aluno.setAprovado(true);
		}
	}
	
	public void darFalta(Alunos aluno) {
		aluno.adicionarFalta();
	}
	
	public int mediaDeFrequenciaDaTurma() {
		int somaDasFrequencias = 0;
		for(int i = 0;i<getAlunosDaTurma().size();i++) {
			somaDasFrequencias += (getAulas() - getAlunosDaTurma().get(i).getFaltas());
		}
		return (somaDasFrequencias/getAlunosDaTurma().size());
	}
	
	@Override
	public double resultadoParcial(Alunos aluno) {
		return ((0.8*aluno.somatorioDeNotas()) + (0.2 * (getAulas() - aluno.getFaltas()))); 
	}
	
	@Override
	public String relatorioTurma() {
		String relatorioTurma = String.format("%-10s | %-15s | %-6s | %-8s |\n", "Matrícula", "Nome", "Nota", "Aprovado");
		for(int i = 0; i < getAlunosDaTurma().size(); i++) {
			relatorioTurma += String.format("%-10d | %-15s | %-6d | %-8s |\n", getAlunosDaTurma().get(i).getMatricula(), getAlunosDaTurma().get(i).getNome(), getAlunosDaTurma().get(i).somatorioDeNotas(), getAlunosDaTurma().get(i).isAprovado());
		}
		return relatorioTurma;
	}
	
}
