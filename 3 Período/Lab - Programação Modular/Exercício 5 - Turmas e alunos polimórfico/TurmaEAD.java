
public class TurmaEAD extends TurmaAvaliativa{ 
	
	TurmaEAD() {
		super();
	}
	
	TurmaEAD(int nivel,String diaDaAula, String turno) {
		super(nivel, diaDaAula,turno);
	}
	
	@Override
	public String gerarCodTurma() {
		return String.valueOf(100*super.getNivel() + 10*codDiaDaSemana() + codTurno()) + 'E';
	}
	
	@Override
	public void fecharResultado(Alunos aluno) {
		if(aluno.somatorioDeNotas() >= 60) {
			aluno.setAprovado(true);
		}
	}
	
	@Override
	public double resultadoParcial(Alunos aluno) {
		return aluno.somatorioDeNotas(); 
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
