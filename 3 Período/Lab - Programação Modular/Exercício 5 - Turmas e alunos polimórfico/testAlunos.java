import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class testAlunos {
	
	Alunos aluno;
	Alunos aluno2;
	
	@BeforeEach
	void init() {
		aluno = new Alunos();
		aluno2 = new Alunos("Júlia", 10, 1);
	}
	
	@Order(1)
	@Test
	void alunoCriado() {
		assertNotEquals(null, aluno);
	}
	
	@Order(2)
	@Test
	void alunoCriadoPadrao() {
		assertEquals("Lucas", aluno.getNome());
		assertEquals(3, aluno.getMatricula());
		for(int i = 0; i < aluno.getAvaliacoes().length; i++) {
			assertNotEquals(null, aluno.getAvaliacoes()[i]);
		}
		assertEquals("", aluno.getCodTurma());
		assertEquals(0, aluno.getFaltas());
		assertEquals(false, aluno.isAprovado());
	}
	
	@Order(3)
	@Test
	void alunoCriadoParametros() {
		assertEquals("Júlia", aluno2.getNome());
		assertEquals(6, aluno2.getMatricula());
		for(int i = 0; i < aluno2.getAvaliacoes().length; i++) {
			assertNotEquals(null, aluno2.getAvaliacoes()[i]);
		}
		assertEquals("", aluno2.getCodTurma());
		assertEquals(1, aluno2.getFaltas());
		assertEquals(false, aluno2.isAprovado());
	}
	
	@Order(4)
	@Test
	void adicionarfalta() {
		assertEquals(0, aluno.getFaltas());
		aluno.adicionarFalta();
		assertEquals(1, aluno.getFaltas());
	}
	
	@Order(5)
	@Test
	void retirarFalta() {
		assertEquals(1, aluno2.getFaltas());
		aluno2.retirarFalta();
		assertEquals(0, aluno2.getFaltas());
	}
	
	@Order(6)
	@Test
	void valorDasProvasEIgual() {
		for(int i = 0; i < 3; i++) {
			assertEquals(aluno.getAvaliacoes()[i].getValor(), aluno.getAvaliacoes()[i+1].getValor());
		}
		for(int i = 0; i < 3; i++) {
			assertEquals(aluno2.getAvaliacoes()[i].getValor(), aluno2.getAvaliacoes()[i+1].getValor());
		}
	}
	
	@Order(7)
	@Test
	void valorProvasSoma100() {
		int somaProvas = 0;
		for(int i = 0; i < 4; i++) {
			somaProvas += aluno.getAvaliacoes()[i].getValor();
		}
		assertEquals(100, somaProvas);
	}
	
	@Order(8)
	@Test
	void somatorioNotas() {
		assertEquals(0, aluno.somatorioDeNotas());
	}
	
	@Order(9)
	@Test
	void atribuirNotas() {
		aluno.alterarNotas(15, 1);
		assertEquals(15, aluno.getAvaliacoes()[0].getResultado());
	}


}
