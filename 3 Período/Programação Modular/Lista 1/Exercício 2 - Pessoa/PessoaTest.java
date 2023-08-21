import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PessoaTest {
	
	Pessoa pessoa;
	Pessoa pessoa_2;
	
	@BeforeEach
	void init() {
		pessoa = new Pessoa();
		pessoa_2 = new Pessoa("Lucas", "22222222222", 17, "Homem");
	}

	@Test
	void pessoaCriada() {
		assertNotEquals(null, pessoa);
	}
	
	@Test
	void pessoaInicializadaPadrao() {
		assertEquals("Fulano De Tal", pessoa.getNome());
		assertEquals("11111111111", pessoa.getCPF());
		assertEquals(18, pessoa.getIdade());
		assertEquals("Não Declarado", pessoa.getSexo());
	}
	
	@Test
	void pessoaInicializadaParametros() {
		assertEquals("Lucas", pessoa_2.getNome());
		assertEquals("22222222222", pessoa_2.getCPF());
		assertEquals(17, pessoa_2.getIdade());
		assertEquals("Homem", pessoa_2.getSexo());
	}
	
	@Test
	void maiorDeIdade() {
		assertEquals(true, pessoa.eMaiorDeIdade(pessoa.getIdade()));
	}
	
	@Test
	void menorDeIdade() {
		assertEquals(false, pessoa_2.eMaiorDeIdade(pessoa_2.getIdade()));
	}

}
