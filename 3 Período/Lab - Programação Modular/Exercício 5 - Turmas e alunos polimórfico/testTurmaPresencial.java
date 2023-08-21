import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testTurmaPresencial {

	
	TurmaPresencial turma1;
	TurmaPresencial turma2;
	
	@BeforeEach
	void init() {
		turma1 = new TurmaPresencial();
		turma2 = new TurmaPresencial(2, "terca-feira", "noite");
	}
	
	@Test
	void objetoInicializadoPadrao() {
		assertNotEquals(null, turma1);
		assertEquals(1, turma1.getNivel());
		assertEquals("quarta-feira", turma1.getDiaDaAula());
		assertEquals("tarde", turma1.getTurno());
		assertEquals("142", turma1.getCodTurma());
		assertNotEquals(null, turma1.getAlunosDaTurma());
	}
	
	@Test
	void objetoInicializadoParametros() {
		assertNotEquals(null, turma2);
		assertEquals(2, turma2.getNivel());
		assertEquals("terca-feira", turma2.getDiaDaAula());
		assertEquals("noite", turma2.getTurno());
		assertEquals("233", turma2.getCodTurma());
		assertNotEquals(null, turma2.getAlunosDaTurma());
	}
	
	@Test
	void adicionarAlunoATurma() {
		assertEquals(0, turma1.getAlunosDaTurma().size());
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		assertEquals(1, turma1.getAlunosDaTurma().size());
		assertEquals("Lucas", turma1.getAlunosDaTurma().get(0).getNome());
	}
	
	@Test
	void adicionarAlunoATurmaCheia() {
		assertEquals(0, turma1.getAlunosDaTurma().size());
		for(int i = 0; i < 20; i++) {
			Alunos aluno = new Alunos();
			turma1.adicionarAlunos(aluno);
		}
		assertEquals(20, turma1.getAlunosDaTurma().size());
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		assertEquals(20, turma1.getAlunosDaTurma().size());
	}
	
	@Test
	void adicionarAlunoQueJaTemTurma() {
		assertEquals(0, turma1.getAlunosDaTurma().size());
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		Alunos aluno2 = new Alunos();
		aluno2.setCodTurma("teste");
		turma1.adicionarAlunos(aluno);
		assertEquals(1, turma1.getAlunosDaTurma().size());
	}
	
	@Test
	void adicionarFaltaAALuno() {
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		turma1.darFalta(turma1.getAlunosDaTurma().get(0));
		assertEquals(1, turma1.getAlunosDaTurma().get(0).getFaltas());
	}
	
	@Test
	void aprovarAluno() {
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		for(int i = 1;i<5;i++) {
			aluno.alterarNotas(17, i);
			turma1.darFalta(turma1.getAlunosDaTurma().get(0));
		}
		turma1.fecharResultado(turma1.getAlunosDaTurma().get(0));
		assertEquals(true, turma1.getAlunosDaTurma().get(0).isAprovado());
		
	}
	
	@Test
	void reprovarAlunoNota() {
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		for(int i = 1;i<5;i++) {
			aluno.alterarNotas(14, i);
			turma1.darFalta(turma1.getAlunosDaTurma().get(0));
		}
		turma1.fecharResultado(turma1.getAlunosDaTurma().get(0));
		assertEquals(false, turma1.getAlunosDaTurma().get(0).isAprovado());
		
	}
	
	@Test
	void reprovarAlunoPresenca() {
		Alunos aluno = new Alunos();
		turma1.adicionarAlunos(aluno);
		for(int j = 0;j<20;j++) {
			turma1.darFalta(turma1.getAlunosDaTurma().get(0));
		}
		for(int i = 1;i<5;i++) {
			aluno.alterarNotas(17, i);
		}
		turma1.fecharResultado(turma1.getAlunosDaTurma().get(0));
		assertEquals(false, turma1.getAlunosDaTurma().get(0).isAprovado());
		
	}
 	
	@Test
	void mediaDasNotas() {
		Alunos aluno1 = new Alunos();
		Alunos aluno2= new Alunos();
		Alunos aluno3 = new Alunos();
		Alunos aluno4 = new Alunos();
		turma1.adicionarAlunos(aluno1);
		turma1.adicionarAlunos(aluno2);
		turma1.adicionarAlunos(aluno3);
		turma1.adicionarAlunos(aluno4);
		for(int i = 1;i<5;i++) {
			aluno1.alterarNotas(14, i);
			aluno2.alterarNotas(16, i);
			aluno3.alterarNotas(15, i);
			aluno4.alterarNotas(15, i);
		}
		assertEquals(60, turma1.mediaDeNotasDaTurma());
	}
	
	@Test
	void mediaDasFrequencias() {
		Alunos aluno1 = new Alunos();
		Alunos aluno2= new Alunos();

		turma1.adicionarAlunos(aluno1);
		turma1.adicionarAlunos(aluno2);
		
		for(int i = 0;i < 8;i++) {
			turma1.darFalta(aluno1);
			turma1.darFalta(aluno2);

		}
		assertEquals(12, turma1.mediaDeFrequenciaDaTurma());
	}
	
	@Test
	void melhorAluno() {
		Alunos aluno1 = new Alunos();
		Alunos aluno2 = new Alunos();
		Alunos aluno3 = new Alunos();
		Alunos aluno4 = new Alunos();

		turma1.adicionarAlunos(aluno1);
		turma1.adicionarAlunos(aluno2);
		turma1.adicionarAlunos(aluno3);
		turma1.adicionarAlunos(aluno4);

		for(int j = 1; j < 5; j++) {
			aluno1.alterarNotas(10,j);
			aluno2.alterarNotas(15,j);
			aluno3.alterarNotas(16,j);
			aluno4.alterarNotas(20,j);
		}
		assertEquals(aluno4.getMatricula(), turma1.melhorAluno().getMatricula());
	}
	
	@Test
	void relatorioDaTurma() {
		Alunos aluno1 = new Alunos();
		aluno1.setNome("João");
		Alunos aluno2 = new Alunos();
		aluno2.setNome("Júlia");
		Alunos aluno3 = new Alunos();
		aluno3.setNome("Maria");
		Alunos aluno4 = new Alunos();
		aluno4.setNome("Junia");

		turma1.adicionarAlunos(aluno1);
		turma1.adicionarAlunos(aluno2);
		turma1.adicionarAlunos(aluno3);
		turma1.adicionarAlunos(aluno4);

		for(int j = 1; j < 5; j++) {
			aluno1.alterarNotas(10,j);
			aluno2.alterarNotas(15,j);
			aluno3.alterarNotas(16,j);
			aluno4.alterarNotas(20,j);
		}
		turma1.fecharResultado(aluno1);
		turma1.fecharResultado(aluno2);
		turma1.fecharResultado(aluno3);
		turma1.fecharResultado(aluno4);
		System.out.print("Ola");
		System.out.print(turma1.relatorioTurma());
		assertEquals("Matrícula  | Nome            | Nota   | Aprovado |\n"
				   + "32         | João            | 40     | false    |\n"
				   + "35         | Junia           | 80     | true     |\n"
				   + "33         | Júlia           | 60     | true     |\n"
				   + "34         | Maria           | 64     | true     |\n"
				   + "", turma1.relatorioTurma());
	}
	
}
