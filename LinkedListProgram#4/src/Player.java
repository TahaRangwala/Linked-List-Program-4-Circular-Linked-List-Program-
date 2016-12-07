/*Name: Taha Rangwala
 *Date: November 21, 2016
 *Purpose: The purpose of this class is to hold all of the information for the players
 */

import BreezySwing.Format;//allows for more formatting options

//Player class heading
public class Player{

	//Declaring static variables
	public static int numPlayersHome = 0;//number of players in home team
	public static int numPlayersAway = 0;//number of players in away team
	
	//Declaring private instance variables
	private String firstName;//player first name
	private String lastName;//player last name
	private int Points;//points scored
	private int Singles;//number of singles
	private int Doubles;//number of doubles
	private int Triples;//number of triples
	private int homeRuns;//number of home runs
	private int Walks;//number of walks
	private int Outs;//number of outs
	
	/*Purpose: The constructor method of the player initializing private instance variables
	 * @param firstName This is the first name of the player
	 * @param lastName This is the last name of the player
	 */
	public Player(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		Points = 0;
		Singles = 0;
		Doubles = 0;
		Triples = 0;
		homeRuns = 0;
		Walks = 0;
	}
	
	public void resetPlayers(){
		Points = 0;
		Singles = 0;
		Doubles = 0;
		Triples = 0;
		homeRuns = 0;
		Walks = 0;
	}
	
	/*Purpose: This returns the first name of the player
	 * @return This is the string value of the player's first name
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/*Purpose: This returns the last name of the player
	 * @return This is the string value of the player's last name
	 */
	public String getLastName(){
		return lastName;
	}
	
	//This method adds to the player's points
	public void setPoints(){
		Points++;
	}
	
	//This method adds to the player's singles
	public void setSingles(){
		Singles++;
	}
	
	//This method adds to the player's doubles
	public void setDoubles(){
		Doubles++;
	}
	
	//This method adds to the player's number of triples
	public void setTriples(){
		Triples++;
	}
	
	//This method adds to the player's number of home runs
	public void setHomeRuns(){
		homeRuns++;
	}
	
	//This method adds to the player's number of walks
	public void setWalks(){
		Walks++;
	}
	
	//This method adds to the player's number of outs
	public void setOuts(){
		Outs++;
	}
	
	/*Purpose: This returns the all of the information of the player
	 * @return This is the string value of the player's data
	 */
	public String toString(){
		return Format.justify('l', firstName + " " + lastName, 15) + Format.justify('l', Points, 15) + Format.justify('l', Singles, 15)
		+ Format.justify('l', Doubles, 15) + Format.justify('l', Triples, 15) + Format.justify('l',homeRuns, 15)
		+ Format.justify('l', Walks, 15) + Format.justify('l',Outs, 15) + "\n";
	}
	
	/*Purpose: This returns the player's full name
	 * @return This is the string value of the player's full name
	 */
	public String getName(){
		return firstName + " " + lastName;
	}
	
	/*Purpose: This method error checks the player's first and last name
	 * @param firstName This is the player's first name
	 * @param lastName This is the player's last name
	 */
	public static void errorCheckPlayers(String firstName, String lastName){
		if(firstName.equals(""))
			throw new IllegalArgumentException("Please Input A First Name!");
		else if(lastName.equals(""))
			throw new IllegalArgumentException("Plase Input A Last Name!");
	}
	
	/*Purpose: This method error checks each team's count
	 * @param isHome This determines which team is being checked
	 */
	public static void errorCheckPlayerCount(boolean isHome){
		if(isHome && numPlayersHome != 9)
			throw new IllegalArgumentException("Please Add " + (9-numPlayersHome) + " Players To The Home Team!" );
		else if(!isHome && numPlayersAway != 9){
			throw new IllegalArgumentException("Please Add " + (9-numPlayersAway) + " Players To The Away Team!" );
		}
	}
	
}
