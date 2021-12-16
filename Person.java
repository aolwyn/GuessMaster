//adam bayley 20176309 19ahb

public abstract class Person implements Cloneable {
	//these 3 instance variables are required
	private String name;
	private Date birthday;

	
	//While not "required" students will have needed to make this constructor
	//All methods needed to avoid privacy leaks
	
	
	//updated to not have difficulty and throws clone exception
	public Person(String name, Date birthday) throws CloneNotSupportedException {
		this.name = name;
		this.birthday = (Date) birthday.clone();
	
	}
	

	
	//this method was required, and should return a string in this exact format
	public String toString() {
		return (this.name + ", was born on "+this.birthday.getDay()+" "+this.birthday.getMonth()+", "+this.birthday.getYear());
	}
	

	public abstract String personType();
	

	//better clone method for Person, updated for privacy leaks on birthday
	public  Person clone() {
		
		try
		{
			Person copy = (Person) super.clone();
			copy.birthday = (Date) birthday.clone();
			return copy;
		}
		
		catch(CloneNotSupportedException e)
		{
			return null;
		}

	}
	
	
	//the following accessor methods were not required (though they were likely created and used). 
	//These are the ones that allowed me to complete this example assignment
	public String getName() {
		return this.name;
	}
	
	//note they needed to avoid a privacy leak when doing this
	public Date getBirthday() {
		return birthday.clone();
	}
	

	

	
	
}
