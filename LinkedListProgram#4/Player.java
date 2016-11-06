
public class Player {

	private String firstName;
	private String lastName;
	private int Points;
	private int Singles;
	private int Doubles;
	private int Triples;
	private int homeRuns;
	private int Walks;
	private boolean homeTeam;
	
	public Player(String firstName, String lastName, boolean homeTeam){
		this.firstName = firstName;
		this.lastName = lastName;
		Points = 0;
		Singles = 0;
		Doubles = 0;
		Triples = 0;
		homeRuns = 0;
		Walks = 0;
		this.homeTeam = homeTeam;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setPoints(){
		Points++;
	}
	
	public int getPoints(){
		return Points;
	}
	
	public void setSingles(){
		Singles++;
	}
	
	public int getSingles(){
		return Singles;
	}
	
	public void setDoubles(){
		Doubles++;
	}
	
	public int getDoubles(){
		return Doubles;
	}
	
	public void setTriples(){
		Triples++;
	}
	
	public int getTriples(){
		return Triples;
	}
	
	public void setHomeRuns(){
		homeRuns++;
	}
	
	public int getHomeRuns(){
		return homeRuns;
	}
	
	public void setWalks(){
		Walks++;
	}
	
	public int getWalks(){
		return Walks;
	}
	
	public boolean getHomeTeam(){
		return homeTeam;
	}
}
