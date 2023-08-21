
public class TurmaCursoLivre  extends Turmas{
	
	private int materiais;
	
	TurmaCursoLivre() {
		super();
		this.materiais = 30;
	}
	
	TurmaCursoLivre(int nivel,String diaDaAula, String turno) {
		super(nivel, diaDaAula,turno);
	}

	public int getMateriais() {
		return materiais;
	}

	public void setMateriais(int materiais) {
		this.materiais = materiais;
	}
	
	public void darFalta(Alunos aluno) {
		aluno.adicionarFalta();
	}

	@Override
	public String gerarCodTurma() {
		return String.valueOf(100*super.getNivel() + 10*codDiaDaSemana() + codTurno()) + 'L';
	}
	
	@Override
	public void fecharResultado(Alunos aluno) {
		if(aluno.getFaltas() == 0) {
			aluno.setAprovado(true);
		}
	}
	
	@Override
	public String relatorioTurma() {
		String relatorioTurma = String.format("%-10s | %-15s | %-8s |\n", "Matrícula", "Nome", "Aprovado");
		for(int i = 0; i < getAlunosDaTurma().size(); i++) {
			relatorioTurma += String.format("%-10d | %-15s | %-8s |\n", getAlunosDaTurma().get(i).getMatricula(), getAlunosDaTurma().get(i).getNome(), getAlunosDaTurma().get(i).isAprovado());
		}
		return relatorioTurma;
	}
	
}
