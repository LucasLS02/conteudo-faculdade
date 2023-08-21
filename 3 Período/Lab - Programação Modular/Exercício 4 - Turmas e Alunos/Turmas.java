import java.util.ArrayList;
import java.util.Comparator;

public class Turmas {
	
	private String codTurma;
	private int nivel;
	private String diaDaAula;
	private String turno;
	private ArrayList<Alunos> alunosDaTurma;
	private int aulasRealizadas;
	
	Turmas() {
		init(1,"quarta-feira","tarde",0);
	}
	
	Turmas(int nivel,String diaDaAula, String turno, int aulasRealizadas) {
		init(nivel, diaDaAula,turno,aulasRealizadas);
	}
	
	private void init(int nivel,String diaDaAula, String turno, int aulasRealizadas) {
		this.nivel = nivel;
		this.diaDaAula = diaDaAula;
		this.turno = turno;
		this.codTurma = gerarCodTurma();
		this.alunosDaTurma = new ArrayList<Alunos>();
		this.aulasRealizadas = aulasRealizadas;
	}
	
	public String getCodTurma() {
		return codTurma;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
		this.codTurma = gerarCodTurma();
	}

	public String getDiaDaAula() {
		return diaDaAula;
	}

	public void setDiaDaAula(String diaDaAula) {
		this.diaDaAula = diaDaAula;
		this.codTurma = gerarCodTurma();
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
		this.codTurma = gerarCodTurma();
	}

	public ArrayList<Alunos> getAlunosDaTurma() {
		return alunosDaTurma;
	}

	public int getAulasRealizadas() {
		return aulasRealizadas;
	}

	public void setAulasRealizadas(int aulasRealizadas) {
		this.aulasRealizadas = aulasRealizadas;
	}
	
	private int codDiaDaSemana() {
		int codDiaSemana = 0;
		switch (diaDaAula) {
		case "domingo":
			codDiaSemana = 1;
			break;
		case "segunda-feira":
			codDiaSemana = 2;
			break;
		case "terca-feira":
			codDiaSemana = 3;
			break;
		case "quarta-feira":
			codDiaSemana = 4;
			break;
		case "quinta-feira":
			codDiaSemana = 5;
			break;
		case "sexta-feira":
			codDiaSemana = 6;
			break;
		case "sabado":
			codDiaSemana = 7;
			break;
		default:
			break;
		}
		return codDiaSemana;
	}
	
	private int codTurno() {
		int codigo = 0;
		switch (turno) {
		case "manha":
			codigo = 1;
			break;
		case "tarde":
			codigo = 2;
			break;
		case "noite":
			codigo = 3;
			break;
		default:
			break;
		}
		return codigo;
	}
	
	private String gerarCodTurma() {
		return String.valueOf(100*this.nivel + 10*codDiaDaSemana() + codTurno());
	}
	
	
	public void adicionarAlunos(Alunos aluno) {
		if(alunosDaTurma.size() < 20 && aluno.getCodTurma() == "") {
			alunosDaTurma.add(aluno);
			ordenarListaAlunos();
			aluno.setCodTurma(codTurma);
		}
	}
	
	public void realizarAula() {
		if(aulasRealizadas < 20) {
			setAulasRealizadas(aulasRealizadas + 1);	
		}
	}
	
	public void darFalta(Alunos aluno) {
		aluno.adicionarFalta();
	}
	
	public void fecharResultado(Alunos aluno) {
	if(aluno.somatorioDeNotas() >= 60 && aluno.getFaltas() <= (aulasRealizadas*0.25)) {
		aluno.setAprovado(true);
	}
 }
	
	public int mediaDeNotasDaTurma() {
		int somaDasNotas = 0;
		for(int i = 0;i<alunosDaTurma.size();i++) {
			somaDasNotas += alunosDaTurma.get(i).somatorioDeNotas();
		}
		return somaDasNotas/alunosDaTurma.size();
	}
	
	public int mediaDeFrequenciaDaTurma() {
		int somaDasFrequencias = 0;
		for(int i = 0;i<alunosDaTurma.size();i++) {
			somaDasFrequencias += (aulasRealizadas - alunosDaTurma.get(i).getFaltas());
		}
		return (somaDasFrequencias/alunosDaTurma.size());
	}
	
	private double resultadoParcial(Alunos aluno) {
		return ((0.8*aluno.somatorioDeNotas()) + (0.2 * (aulasRealizadas - aluno.getFaltas()))); 
	}
	
	public Alunos melhorAluno() {
		Alunos melhorAluno = alunosDaTurma.get(0);
		for(int i = 1; i < alunosDaTurma.size(); i++) {
			if(resultadoParcial(melhorAluno) < resultadoParcial(alunosDaTurma.get(i))) {
				melhorAluno = alunosDaTurma.get(i);
			}
		}
		return melhorAluno;
	}
	
	private void ordenarListaAlunos() {
		alunosDaTurma.sort(new Comparator<Alunos>() {
			@Override
			public int compare(Alunos arg0, Alunos arg1) {
				
				return arg0.getNome().compareTo(arg1.getNome());
			}
		});
	}
	
	public String relatorioTurma() {
		String relatorioTurma = String.format("%-10s | %-15s | %-6s | %-8s |\n", "Matrícula", "Nome", "Nota", "Aprovado");
		for(int i = 0; i < alunosDaTurma.size(); i++) {
			relatorioTurma += String.format("%-10d | %-15s | %-6d | %-8s |\n", alunosDaTurma.get(i).getMatricula(), alunosDaTurma.get(i).getNome(), alunosDaTurma.get(i).somatorioDeNotas(), alunosDaTurma.get(i).isAprovado());
		}
		return relatorioTurma;
	}
	
}
