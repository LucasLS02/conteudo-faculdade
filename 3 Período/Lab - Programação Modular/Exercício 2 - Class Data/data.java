class Clock {

	private int hour;
	private int min;
	private int seconds;
	private int day;
	private int month;
	private int year;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		formattedDate();
	}

	public int getMin() {
		return min;
	}		

	public void setMin(int min) {
		this.min = min;
		formattedDate();
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
		formattedDate();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
		formattedDate();
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
		formattedDate();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
		formattedDate();
	}

	public Clock()
	{
		resetClock();
	}

	public Clock(int seconds, int min, int hour)
	{
		this.hour = hour;
		this.min = min;
		this.seconds = seconds;
		this.day = 1;
		this.month = 1;
		this.year = 2000;
		formattedDate();
	}
	public Clock(int seconds, int min, int hour, int day, int mounth, int year)
	{
		this.hour = hour;
		this.min = min;
		this.seconds = seconds;
		this.day = day;
		this.month = mounth;
		this.year = year;
		formattedDate();
	}

	public void resetClock () 
	{
		this.hour = 0;
		this.min = 0;
		this.seconds = 1;
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}

	public boolean leapYear(int year)
	{
		boolean response = false;

		if(year%4==0) 
		{    
			if (year%100==0) 
			{   
				if (year%400==0)
				{
					response = true;
				}
			}
			else
			{
				response = true;
			}
		}

		return response;
	}

	public int daysInMounth(int mounth)
	{
		int days = 0;
		if(mounth > 8)
		{
			if(mounth % 2 == 0)
			{
				days = 31;
			}
			else
			{
				days = 30;
			}
		}
		else 
		{
			if(mounth % 2 == 0)
			{
				if(mounth == 2)
				{
					if(leapYear(this.year) == true)
					{
						days = 29;
					}
					else
					{
						days = 28;
					}
				}
				days = 30;
			}
			else
			{
				days = 31;
			}
		}
		return days;
	}

	public void formattedDate()
	{
		while(seconds >= 60)
		{
			seconds -= 60;
			min++;
		}

		while(min >= 60)
		{
			min -= 60;
			hour++;
		}

		while(hour >= 24)
		{
			hour -= 24;
			day++;
		}

		while(day >= daysInMounth(this.month))
		{
			day -= daysInMounth(this.month);
			month++;
		}

		while(month >= 12)
		{
			month -= 12;
			year++;
		}
	}

	public Clock addSeconds(int seconds)
	{
		seconds += this.seconds;
		Clock new_date = new Clock(this.hour,this.min, seconds, this.day, this.month, this.year);
		return new_date;
	}

	public Clock addMinutes(int minutes)
	{
		minutes += this.min;
		Clock new_date = new Clock(this.hour,minutes, this.seconds, this.day, this.month, this.year);
		return new_date;
	}

	public Clock addHour(int hour)
	{
		hour += this.hour;
		Clock new_date = new Clock(hour,this.min, this.seconds, this.day, this.month, this.year);
		return new_date;
	}

	public Clock addDays(int day)
	{
		day += this.day;
		Clock new_date = new Clock(this.hour,this.min, this.seconds, day, this.month, this.year);
		return new_date;
	}

	public Clock addMonth(int month)
	{
		month += this.month;
		Clock new_date = new Clock(this.hour,this.min, this.seconds, this.day, month, this.year);
		return new_date;
	}

	public Clock addYear(int year)
	{
		year += this.year;
		Clock new_date = new Clock(this.hour,this.min, this.seconds, this.day, this.month, year);
		return new_date;
	}

	public int formateToCompare()
	{
		int daysInMonths = 0;

		for (int i = 1; i < month;i++)
		{
			daysInMonths += daysInMounth(i);
		}

		return seconds + (min*60) + (hour*3600) + (day*86400) + (daysInMonths*86400);

	}

	public static Clock latestDate(Clock clock_1, Clock clock_2)
	{
		Clock latest = null;

		if(clock_1.year == clock_2.year)
		{
			int date_in_seconds_clock_1 = clock_1.formateToCompare();
			int date_in_seconds_clock_2 = clock_2.formateToCompare();

			if(date_in_seconds_clock_1 > date_in_seconds_clock_2)
			{
				latest = clock_1;
			}
			else
			{
				latest = clock_2;
			}
		}
		else
		{
			if(clock_1.year > clock_2.year)
			{
				latest = clock_1;
			}
			else
			{
				latest = clock_2;
			}
		}
		return latest;
	}

	public String printDate()
	{
		return hour + ":" + min + ":" + seconds + "  " + day + "/" + month + "/" + year;
	}

}
