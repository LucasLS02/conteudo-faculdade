import java.util.ArrayList;
import java.util.Comparator;

public abstract class Turmas {
	
	private String codTurma;
	private int nivel;
	private String diaDaAula;
	private String turno;
	private ArrayList<Alunos> alunosDaTurma;
	
	Turmas() {
		init(1,"quarta-feira","tarde");
	}
	
	Turmas(int nivel,String diaDaAula, String turno) {
		init(nivel, diaDaAula,turno);
	}
	
	private void init(int nivel,String diaDaAula, String turno) {
		this.nivel = nivel;
		this.diaDaAula = diaDaAula;
		this.turno = turno;
		this.codTurma = gerarCodTurma();
		this.alunosDaTurma = new ArrayList<Alunos>();
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


	public int codDiaDaSemana() {
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
	
	public int codTurno() {
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
	
	public abstract String gerarCodTurma();
	
	
	public void adicionarAlunos(Alunos aluno) {
		if(aluno.getCodTurma() == "") {
			getAlunosDaTurma().add(aluno);
			ordenarListaAlunos();
			aluno.setCodTurma(getCodTurma());
		}
	}
	
	public abstract void fecharResultado(Alunos aluno);
	
	public void ordenarListaAlunos() {
		alunosDaTurma.sort(new Comparator<Alunos>() {
			@Override
			public int compare(Alunos arg0, Alunos arg1) {
				
				return arg0.getNome().compareTo(arg1.getNome());
			}
		});
	}
	
	public abstract String relatorioTurma();
	
}
