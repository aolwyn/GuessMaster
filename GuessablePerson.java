//adam bayley 20176309 19ahb

public class GuessablePerson<T extends Person> implements Guessable, Cloneable{ //can only take in parameters of type Person
//create instance variables
	private T person;
	private double difficulty;
	
	
	//constructor
	public GuessablePerson (T person, double difficulty)
	{
		this.person = person;
		this.difficulty = difficulty;
	}
	
	
	//compares 2 birthdays, returns a number which corresponds which birthday comes before the other. if they share a birthday,
	//we go based on alphabetical order. 
	
	public int compareTo(Person otherPerson)
	{
		if(person.getBirthday().compareTo(otherPerson.getBirthday()) == -1)
		{
			return -1;
		}
		else if (person.getBirthday().compareTo(otherPerson.getBirthday()) == 1)
		{
			return 1;
		}
		else {
			return (person.getName().compareTo(otherPerson.getName())); //returns pos / neg value based on the alpha ordering
		}
	}
	
	
	//better clone for GuessablePerson, can't avoid privcacy leaks
	public GuessablePerson<T> clone()
	{
		try 
		{
			GuessablePerson<T> copyGuessablePerson = (GuessablePerson<T>) super.clone();
		return copyGuessablePerson;
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
		
	}

	
	//accessor for getitng the person
	public T getPerson()
	{
		return person;
	}
	
	
	
	//given 3 methods for points and messages
	public String startMessage()
	{
		return "Guess the birthday of the "+person.personType()+" "+person.getName();	
		}
	
public String closingMessage()
{
	return "Congratulations! You were correct, "+person.toString();
}
	
public int getAwardedPointNumber()
{
	double points = this.difficulty*100;
	return (int) points;
}
	




	
}
