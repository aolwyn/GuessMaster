//adam bayley 20176309 19ahb

public class Singer extends Person {
	//these two instance variables were required
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	//this constructor was required, and needed to avoid privacy leaks
	
	
	//method updated to remove difficulty and throws the clone exception
	public Singer(String name, Date birthday,  String debutAlbum, Date debutAlbumReleaseDate) throws CloneNotSupportedException {
		super(name, birthday);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}
	
	
    //new clone method with copy thing. updated so it doesn't allow for privacy leaks (on debut album release date)
	public Singer clone() {

		Singer singerCopy = (Singer) super.clone();
		 singerCopy.debutAlbumReleaseDate = (Date) debutAlbumReleaseDate.clone();
		return singerCopy;
	}
	
	//this toString method was required
	public String toString() {
		return super.toString()+". Their debut album was "+this.debutAlbum+", and it was released on "+this.debutAlbumReleaseDate.getDay()+" "+this.debutAlbumReleaseDate.getMonth()+", "+this.debutAlbumReleaseDate.getYear();
	}
	
	//this method was required
	public String personType() {
		return "singer";
	}

}
