public abstract class TurmaAvaliativa extends Turmas {
	
	TurmaAvaliativa() {
		super();
	}
	
	TurmaAvaliativa(int nivel,String diaDaAula, String turno) {
		super(nivel, diaDaAula, turno);
	}
		
	public int mediaDeNotasDaTurma() {
		int somaDasNotas = 0;
		for(int i = 0;i<getAlunosDaTurma().size();i++) {
			somaDasNotas += getAlunosDaTurma().get(i).somatorioDeNotas();
		}
		return somaDasNotas/getAlunosDaTurma().size();
	}
	
	public abstract double resultadoParcial(Alunos aluno);
	
	public Alunos melhorAluno() {
		Alunos melhorAluno = getAlunosDaTurma().get(0);
		for(int i = 1; i < getAlunosDaTurma().size(); i++) {
			if(resultadoParcial(melhorAluno) < resultadoParcial(getAlunosDaTurma().get(i))) {
				melhorAluno = getAlunosDaTurma().get(i);
			}
		}
		return melhorAluno;
	}
	
	public abstract String relatorioTurma();

}
