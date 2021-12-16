//adam bayley 20176309 19ahb

public class Politician extends Person{
	//this one instance variable was required
	private String party;
	
	//this constructor was required, and needed to avoid privacy leaks
	
	//updated for clon not supported
		public Politician(String name, Date birthday, String party) throws CloneNotSupportedException{
			super(name, birthday);
			this.party = party;
			
		}
		
	
		//this clone method was required
		
		//updated for better clone method, strings aren't mutable so ez pz
		public Politician clone() {
		
			Politician politicianClone = (Politician) super.clone();
			return politicianClone;
		}
		
		//this toString method was required
		public String toString() {
			return super.toString()+". They are a member of the "+this.party+" party.";
		}
		
		//this method was required
		public String personType() {
			return "politician";
		}
}
