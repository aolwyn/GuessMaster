//19ahb 20176309

//class for handling the incorrect dates, displays that whatever thing it was sent was incorrect form various reasons (not in bounds, etc.)
public class IncorrectDateException extends Exception {

	public IncorrectDateException(String dateString)
{
	super("The date you have entered, "+dateString+" is not a valid input");
}

}
