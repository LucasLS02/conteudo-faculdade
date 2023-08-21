import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class ContaTest {
	
	Conta contaBancaria;
	Conta contaBancaria2;
	
	@BeforeEach
	void init()
	{
		contaBancaria = new Conta();
		contaBancaria2 = new Conta(150);
	}

	@Test
	@Order(1)
	void contaCriada() {
		assertNotEquals(null, contaBancaria);
	}
	
	@Test
	@Order(2)
	void contaInicializadaPadrao() {
		assertEquals(3, contaBancaria.getNumConta());
		assertEquals(0, contaBancaria.getSaldo());
	}
	
	@Test
	@Order(3)
	void contaInicializadaParametros() {
		assertEquals(6, contaBancaria2.getNumConta());
		assertEquals(150, contaBancaria2.getSaldo());
	} 
	
	@Test
	@Order(4)
	void tranfereValor()
	{
		contaBancaria.tranferencia(contaBancaria2, 10);
		assertEquals(-10, contaBancaria.getSaldo());
		assertEquals(160, contaBancaria2.getSaldo());
	}
	
	@Test
	@Order(5)
	void tranfereValorNegativo()
	{
		contaBancaria.tranferencia(contaBancaria2, -100);
		assertEquals(0, contaBancaria.getSaldo());
		assertEquals(150, contaBancaria2.getSaldo());
	}
	
	@Test
	@Order(6)
	void extrato()
	{
		assertEquals("Extrato da conta: R$ 0,00", contaBancaria.extrato());
		assertEquals("Extrato da conta: R$ 150,00", contaBancaria2.extrato());
	}
	
	@Test
	@Order(7)
	void extratoModificado()
	{
		assertEquals("Extrato da conta: R$ 0,00", contaBancaria.extrato());
		contaBancaria.tranferencia(contaBancaria2, 10);
		assertEquals("Extrato da conta: R$ -10,00", contaBancaria.extrato());
	}
	

}
