//adam bayley 20176309 19ahb

public class Date implements Comparable<Date> , Cloneable {
	
	private static class Months{
		
		private static int getDays(int month)
		{
			
		 
			switch (month)
			{
			
			case 2: //case of february
			return 28; 
			
			
			//idk if you can do case (1,3,5,7,9,11): if it's a violation in java, I know it is in C++ to do case 1,3,5,6,7...
			
			//cases of anything that has 31 days
			case 1:
			case 3:
			case 5:
			case 7:
			case 9:
			case 11:
			return 31;
			//anything else will have 30 days
			default:
			return 30;
				
			}		
		}//close nested class getDays
		
	}//close months
	
//these 3 instance variables are required
private int day;
private int month;
private int year;
 

//assign values
public Date(int day, int month, int year) {
	this.day = day;
	this.month = month;
	this.year = year;
}


//this is for settign up whether or not a date has been setup correctly.
//if the inputtede date is too long, throw the exception. if it isn't, setup accordingly.
//however, if it has correct length, but outside bounds, again, throw the exception.
public Date (String sDate) throws IncorrectDateException 
{
	if(sDate.length() != 10)
	{
		throw new IncorrectDateException(sDate);
	//said to remove this.year / month / day = 1 here, not sure why so i've left it out
	}
	else
	{
	//if its setup correctly, putt it all in
    day = Integer.parseInt(sDate.substring(0, 2));
    month = Integer.parseInt(sDate.substring(3, 5));
    year = Integer.parseInt(sDate.substring(6));
	}
	if(day < 1 || month < 1 || month > 12 || year < 1 || day > Months.getDays(month)) //checks bounds based on above 3 lines (64-67)
	{
	throw new IncorrectDateException(sDate);	
	}
	
}

public Date clone()  //implements better copy / clone method 

{
try 
{
	Date copy = (Date) super.clone();
	return copy; 

}
catch (CloneNotSupportedException e)
{
	return null;
}
	
}


public int compareTo(Date otherDate) //if parameter is earlier than thing passed in, return -1. if greater than, return 1.
									// if the date is equaL (THIS.X = OTHERDATE.X, return 0.
{
	if(this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year)
	{
		return 0;
	}
	
	else if (this.year < otherDate.year)
	{
		return -1;
	}
	else if (this.year > otherDate.year)
	{	
		 return 1;
	}
	
	else if (this.month < otherDate.month)
		{
			return -1;
		}
	else if(this.month > otherDate.month)
		{
			return 1;
		}
	
	else if (this.day < otherDate.day)
		{
			return -1;
		}
		else
		{
			return 1;
		}
		

	
}//end comparTo



public int getDay() {
	return this.day;
}

public int getMonth() {
	return this.month;
}

public int getYear() {
	return this.year;
}

public void setDay(int day) {
	this.day = day;
}

public void setMonth(int month) {
	this.month = month;
}

public void setYear(int year) {
	this.year = year;
}

public boolean equals(Date date) {
	if(this.day==date.day && this.month==date.month && this.year==date.year)
		return true;
	else
		return false;
}

public String toString() {
	return day+", "+month+", "+year;
}



}
