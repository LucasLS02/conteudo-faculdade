
public class Microwave {
	
	private int seconds;
	private int minutes;
	private boolean paused;
	private boolean doorOpen;
	
	Microwave()
	{
		resetTimer();
		paused = true;
		doorOpen = false;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	private void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public boolean isPaused() {
		return paused;
	}

	private void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getSeconds() {
		return seconds;
	}

	private void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	private void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public void addSeconds(int seconds)
	{
		if(validTime(seconds) == true)
		{
			setSeconds(this.seconds + seconds);
			adjustTimer();
		}
	}
	
	public void addMinutes(int minutes)
	{
		if(validTime(minutes) == true)
		{
			setMinutes(this.minutes + minutes);
		}
	}
	
	public void addMinutesAndSeconds(int minutes, int seconds)
	{
		addMinutes(minutes);
		addSeconds(seconds);
	}
	
	public void resetTimer()
	{
		this.seconds = 0;
		this.minutes = 0;
	}
	
	public void turnOn()
	{
		if(seconds > 0 || minutes > 0)
		{
			if(doorOpen == false)
			{
				setPaused(false);
			}
		}
	}
	
	public void turnOff()
	{
		pause();
		resetTimer();
	}
	
	public void pause()
	{
		setPaused(true);
	}
	
	public void openDoor()
	{
		if(isPaused() == true)
		{
			setDoorOpen(true);
		}
	}
	
	public void closeDoor()
	{
		setDoorOpen(false);
	}
	
	public void adjustTimer()
	{
		while(seconds > 60)
		{
			seconds -= 60;
			minutes += 1;
		}
	}
	
	public void passASecond()
	{
		if(seconds -1 >= 0)
		{
			setSeconds(seconds-1);
		}
		else
		{
			if(minutes > 0)
			{
				seconds = 60;
				minutes -= 1;
				passASecond();
			}
		}
	}
	
	public boolean validTime(int value)
	{
		boolean isValid = false;
		if(value > 0)
		{
			isValid = true;
		}
		return isValid;
	}
}
