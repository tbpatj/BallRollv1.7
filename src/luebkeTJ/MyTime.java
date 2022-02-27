package luebkeTJ;

public class MyTime {
	int Second = 0;
	int Minute = 0;
	int Hour = 0;
	public MyTime futureTime(int sec, int min, int hour)
	{
		MyTime future = new MyTime();
		future.Second = this.Second + sec;
		future.Minute = this.Minute + min;
		while(future.Second >= 60)
		{
			future.Minute ++;
			future.Second = future.Second - 60;
		}
		future.Hour = this.Hour + hour;
		while(future.Minute >= 60)
		{
			future.Hour ++;
			future.Minute = future.Minute - 60;
		}
		return future;
	}
	public MyTime getTimeSubtractTime(MyTime time)
	{
		MyTime outComeTime = new MyTime();
		outComeTime.Second = time.Second - this.Second;
		
		outComeTime.Minute = time.Minute - this.Minute;
		if(outComeTime.Second < 0)
		{
			outComeTime.Second = outComeTime.Second + 60;
			outComeTime.Minute = outComeTime.Minute - 1;
		}
		outComeTime.Hour = time.Hour - this.Hour;
		if(outComeTime.Minute < 0)
		{
			outComeTime.Minute = outComeTime.Minute + 60;
			outComeTime.Hour = outComeTime.Hour - 1;
		}
		return outComeTime;
	}
	static MyTime subtract(MyTime time, MyTime time2)
	{
		MyTime outComeTime = new MyTime();
		outComeTime.Second = time.Second - time2.Second;
		outComeTime.Minute = time.Minute - time2.Minute;
		outComeTime.Hour = time.Hour - time2.Hour;
		return outComeTime;
	}
	public boolean ifTimeIsGreater(MyTime time)
	{
		if(this.Hour < time.Hour)
		{
			return true;
		}
		else if(this.Minute < time.Minute && this.Hour == time.Hour)
		{
			return true;
		}
		else if(this.Minute == time.Minute && this.Hour == time.Hour && this.Second < time.Second)
		{
			return true;
		}
		
		return false;
	}
}
