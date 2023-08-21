import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataTest {
	
	Data date;
	
	@BeforeEach
	void init() { 
		date = new Data();
	}

	@Test
	void dataCriada() {
		assertNotEquals(null, date);
	}
	
	@Test
	void dataInicializada() {
		assertEquals(1, date.getDia());
		assertEquals(1, date.getMes());
		assertEquals(2022, date.getAno());
	}
	
	@Test
	void avancarData() {
		date.adicionarDias(10);
		assertEquals(11, date.getDia());
	}
	
	@Test
	void diasNoMes() {
		assertEquals(31, date.diasNoMes(date.getMes()));
	}
	
	@Test
	void diaDaSemana() {
		date.adicionarDias(17);
		assertEquals("Terca-Feira", date.diaDaSemana(date.getDia()));
	}
	
	@Test
	void anoBissexto() {
		assertEquals(false, date.eAnoBissexto(date.getAno()));
	}
	
	@Test
	void proximoDia() {
		date.proximoDia();
		assertEquals(2, date.getDia());
	}
	
	@Test
	void dataPorExtenso()
	{
		date.proximoDia();
		assertEquals("Domingo 2 de Janeiro de 2022", date.dataPorExtenso());
	}
	
}
