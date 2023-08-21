import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurmaCursoLivreTest {

	TurmaCursoLivre turma1;
	TurmaCursoLivre turma2;
	
	@BeforeEach
	void init() {
		turma1 = new TurmaCursoLivre();
		turma2 = new TurmaCursoLivre(2, "terca-feira", "noite");
	}
	
	@Test
	void objetoInicializadoPadrao() {
		assertNotEquals(null, turma1);
		assertEquals(1, turma1.getNivel());
		assertEquals("quarta-feira", turma1.getDiaDaAula());
		assertEquals("tarde", turma1.getTurno());
		assertEquals("142L", turma1.getCodTurma());
		assertNotEquals(null, turma1.getAlunosDaTurma());
	}
	
	@Test
	void objetoInicializadoParametros() {
		assertNotEquals(null, turma2);
		assertEquals(2, turma2.getNivel());
		assertEquals("terca-feira", turma2.getDiaDaAula());
		assertEquals("noite", turma2.getTurno());
		assertEquals("233L", turma2.getCodTurma());
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
		turma1.fecharResultado(turma1.getAlunosDaTurma().get(0));
		assertEquals(true, turma1.getAlunosDaTurma().get(0).isAprovado());
		
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
		
		turma1.darFalta(turma1.getAlunosDaTurma().get(0));
		turma1.darFalta(turma1.getAlunosDaTurma().get(2));
		
		turma1.fecharResultado(aluno1);
		turma1.fecharResultado(aluno2);
		turma1.fecharResultado(aluno3);
		turma1.fecharResultado(aluno4);
		assertEquals("Matrícula  | Nome            | Aprovado |\n"
				   + "5          | João            | false    |\n"
				   + "8          | Junia           | true     |\n"
				   + "6          | Júlia           | false    |\n"
				   + "7          | Maria           | true     |\n"
				   + "", turma1.relatorioTurma());
	}

}
