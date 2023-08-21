import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProvasTest {
	
	Provas test;
	Provas test_2;
	
	@BeforeEach
	void init()
	{
		test = new Provas(20);
		test_2 = new Provas(20,15);
	}

	@Test
	void createTest() {
		assertNotEquals(null, test);
	}
	
	@Test
	void inicializeTestValue() {
		assertEquals(20, test.getValor());
	}
	
	@Test
	void inicializeTestValueAndResults() {
		assertEquals(20, test_2.getValor());
		assertEquals(15, test_2.getResultado());
	}

}
