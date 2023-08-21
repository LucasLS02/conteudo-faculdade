import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Microwavetest {
	
	Microwave microndas;
	
	@BeforeEach
	public void init()
	{
		microndas = new Microwave();
	}
	
	// First Requisit - Start
	
	@Test
	public void testMicrowaveCreation()
	{
		assertNotEquals(null, microndas);
	}
	
	@Test
	public void testMicrowaveTimerCreated()
	{
		assertEquals(0, microndas.getMinutes());
		assertEquals(0, microndas.getSeconds());
	}
	
	// First Requisit - End
	
	// Second Requisit - Start
	
	@Test
	public void testMicrowaveTurnOn()
	{
		microndas.addMinutesAndSeconds(1, 12);
		microndas.turnOn();
		assertEquals(false, microndas.isDoorOpen());
		assertEquals(false, microndas.isPaused());
	}
	
	public void testMicrowaveTurnOnAfterPaused()
	{
		microndas.addMinutesAndSeconds(1, 12);
		microndas.turnOn();
		microndas.pause();
		microndas.turnOn();
		assertEquals(false, microndas.isPaused());
	}
	
	@Test
	public void testMicrowaveTurnOnWithoutSecondsAndMinutes()
	{
		microndas.turnOn();
		assertEquals(true, microndas.isPaused());
	}
	
	@Test
	public void testMicrowaveTurnOff()
	{
		microndas.turnOn();
		microndas.turnOff();
		assertEquals(0, microndas.getMinutes());
		assertEquals(0, microndas.getSeconds());
		assertEquals(true, microndas.isPaused());
	}
	
	@Test
	public void testMicrowavePaused()
	{
		microndas.addMinutesAndSeconds(1, 12);
		microndas.turnOn();
		microndas.pause();
		assertEquals(1, microndas.getMinutes());
		assertEquals(12, microndas.getSeconds());
		assertEquals(true, microndas.isPaused());	
	}
	
	@Test
	public void testMicrowaveTimerReset()
	{
		microndas.addMinutesAndSeconds(20,30);
		microndas.resetTimer();
		assertEquals(0, microndas.getMinutes());
		assertEquals(0, microndas.getSeconds());
	}
	
	// Second Requisit - End
	
	// Third Requisit - Start
	
	@Test
	public void testMicrowaveTurnOnWhileOpen()
	{
		microndas.openDoor();
		microndas.turnOn();
		assertEquals(true, microndas.isPaused());
	}
	
	@Test
	public void testMicrowaveOpenTurnedOn()
	{
		microndas.addMinutesAndSeconds(1, 12);
		microndas.turnOn();
		microndas.openDoor();
		assertEquals(false, microndas.isDoorOpen());
	}
	
	// Third Requisit - End
	
	// Forfh Requisit - Start
	
	@Test
	public void testMicrowaveAddSeconds()
	{
		microndas.addSeconds(30);
		assertNotEquals(0, microndas.getSeconds());
	}
	
	@Test
	public void testMicrowaveAddSecondsNegative()
	{
		microndas.addSeconds(-14);
		assertNotEquals(-14, microndas.getSeconds());
		assert(microndas.getSeconds() >= 0);
	}
	
	@Test
	public void testMicrowaveAddMinutes()
	{
		microndas.addMinutes(20);
		assertNotEquals(0, microndas.getMinutes());
	}
	
	@Test
	public void testMicrowaveAddMinutesNegative()
	{
		microndas.addMinutes(-14);
		assertNotEquals(-14, microndas.getMinutes());
		assert(microndas.getMinutes() >= 0);
	}
	
	@Test
	public void testMicrowaveAddMinutesAndSeconds()
	{
		microndas.addMinutesAndSeconds(20,30);
		assertNotEquals(0, microndas.getMinutes());
		assertNotEquals(0, microndas.getSeconds());
	}
	
	@Test
	public void testMicrowaveTimeIsValid()
	{
		microndas.addSeconds(500);
		assert(microndas.getSeconds() < 60);
	}
	
	@Test
	public void testMicrowavePassASecond()
	{
		microndas.addMinutesAndSeconds(1, 12);
		microndas.turnOn();
		microndas.passASecond();
		assertNotEquals(12, microndas.getSeconds());
	}
	
	@Test
	public void testMicrowavePassASecondWith0Seconds()
	{
		microndas.addMinutesAndSeconds(2, 0);
		microndas.turnOn();
		microndas.passASecond();
		assertNotEquals(2, microndas.getMinutes());
		assertNotEquals(60, microndas.getSeconds());
	}
	
	@Test
	public void testMicrowavePassTimeWithResetTimer()
	{
		microndas.passASecond();
		assertEquals(0, microndas.getMinutes());
		assertEquals(0, microndas.getSeconds());
	}
	
	public void testMicrowaveAddTimeWhilePaused()
	{
		microndas.addMinutesAndSeconds(2, 0);
		microndas.turnOn();
		microndas.pause();
		microndas.addMinutesAndSeconds(1, 12);
		assertEquals(3, microndas.getMinutes());
		assertEquals(12, microndas.getSeconds());
	}
	
	// Forfh Requisit - End
	
}
