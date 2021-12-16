//adam bayley 20176309 19ahb

//import the stuff that's required for using scanner and hash sets and iterators

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.Arrays; no longer being used

public class GuessMaster3
{
	//setup the instance variables and hash set
	private HashSet<GuessablePerson<?>>people;
	private int numPoints;
	private int numPeople; //idk if we actually need this anymore but I left it in anyway
	
	/*
	
	NOTE TO SELF FOR FRIDAY:
	CHECK THE OTHER BLOODY CLASSES AND MAKE SURE THEY THROW CLONE NOT SUPPORTED
	FOR THE LOVE OF GOD PLEASE
	I PRAY IT WORKS AFTER I DO THIS
	
	UPDATE: IT WORKED THANK GOD
	
	
	*/
	
	
	
	//initializing the values to 0
	public GuessMaster3()
	{
		people = new HashSet<GuessablePerson<?>>(0);
		numPoints = 0;
	}//end initialization
	
	
	public <M extends Person> void addPerson (M newPerson, double difficulty) throws CloneNotSupportedException
	{
		GuessablePerson<Person> newGuessablePerson = new GuessablePerson<>(newPerson.clone(), difficulty); //sets up new person with difficulty and clone method
		people.add(newGuessablePerson); //adds a new guesable person
	}//end addperson
	
	
	
	//allows anything that extends Person to be a parameter, method for getting the people
	public HashSet<GuessablePerson<? extends Person>> getPeople()
	{
		return people; 
	}//end getpeople
	
	//method for starting the game
	public void startGame()
	{
		//setup the input scanner variables and set the correct answer being guessed to: False
		File test;
		Scanner scanner;
		boolean guessed = false;
		
		try //try catch for taking in the text file from the source
		{
			test = new File("C: \\Users\\adumb\\generalworkspace\\Assignment3\\src\\test.txt"); //retrieves the text file
		
			scanner = new Scanner (new FileInputStream(test)); //takes in the stuff
		}//end try
		catch (FileNotFoundException e)	//failsafe to check if the file exists / not. this could've been done with an 
										//if statement (if(___.exists() == false) ) and then exitign but i decided to use a catch.
		{
			System.out.println("File not found.");
			scanner = null;
			System.exit(0);
		}//end catch
		
		
		System.out.println("Welcome! Let's start the game.");
		Iterator <GuessablePerson<? extends Person>>personIterator = people.iterator(); //creates the thing that lets you iterate between ppl
		GuessablePerson<?extends Person> currPerson = personIterator.next();
		
		//basically this is the loop that keeps people guessing. as long as there are things still to iterate, there is still something in the input, and the person hasn't been guessed,
		//the loop should continue. 
		while(personIterator.hasNext() && scanner.hasNextLine() && !guessed)
			
		{
			
			System.out.println(currPerson.startMessage()); //prints the start message from other class
			String scannerInput = scanner.next();
			
			//so if the user wants to quit, they type in 'quit' in any form. other iterations just said quit but i figure people generally capitalize first letter so ignoring case is prob a good idea
			if(scannerInput.equalsIgnoreCase("QUIT"))
					{
				System.out.println("GAME OVER. THE USER HAS SUCCESSFULLY QUIT"); 
		            }
			else
			{
			
				try
				{
					Date guessedDate = new Date(scannerInput); //preserve privacy and take in new inputs
					
			
					//this will use the compareTo method that returns 0, 1 ,-1 based on the person's guess and whether they're higher, lower, or on point
					int guessResult = guessedDate.compareTo(currPerson.getPerson().getBirthday());
					
					if(guessResult ==1)
					{
						System.out.println("try a later date.");
					}//end if 
					
					else if(guessResult == -1)
					{
						System.out.println("Try an earlier date.");
					}//end else if
					
					else //this part is copy pasted from asignment 2 solution
					{
						System.out.println(currPerson.closingMessage());
						numPoints = numPoints + currPerson.getAwardedPointNumber();
						System.out.println("You won "+currPerson.getAwardedPointNumber()+" points in this round. Your total number of points is "+numPoints);
						guessed = true; //ends the loop bc person guessed correctly
						
					}//end inner else
					
				}//end try
				catch (IncorrectDateException e)
				{
				//System.out.println("Incorrect date");
					//System.out.println(" please input a new date.");
				}
				finally //this probably isnt required, but i have it set to always show how to end the game
				{
					System.out.println("to stop playing the game, type 'quit' to stop. ");
				}//end finally
				
			}//end else (outer)
		
		}//end while
		
	}//end startgame
	
			
	//test code
	
	public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
		Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), "Liberal"); 
		Singer dion = new Singer("Celine Dion", new Date(30, 3, 1961), "La voix du bon Dieu", new Date(6, 11, 1981));
		Singer robertson = new Singer("Ed Robertson", new Date(25, 10, 1970), " Gordon", new Date(7, 28, 1992));
		GuessMaster3 gm = new GuessMaster3();
		gm.addPerson(trudeau, 0.25);
		gm.addPerson(dion, 0.5);
		gm.addPerson(robertson,0.75);
		System.out.println("There are "+gm.getPeople().size()+" people to guess in the game");
		GuessablePerson<Politician>guessTrudeau = new GuessablePerson<>(trudeau,0.25);
		System.out.println("The next output should be -1");
		System.out.println(guessTrudeau.compareTo(dion));
		gm.startGame();
	}
	
} //end class


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

