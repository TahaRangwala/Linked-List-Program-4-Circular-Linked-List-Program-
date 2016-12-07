/*Name: Taha Rangwala
 * Date: November 21, 2016
 * Purpose: The purpose of this class is to hold all of the information for each team
 */

import BreezySwing.Format;//allows for more formatting options

//Team class header
public class Team {
	
	//Declaring private instance variables
	private CircularLinkedList <Player> Players;//All players on team
	private LinkedList <Player> playersTakenOut;//Alls players that were replaced
	private int Score;//score of the team
	
	//Constructor method to intialize private instance variables
	public Team(){
		Players = new CircularLinkedList<Player>();
		playersTakenOut = new LinkedList<Player>();
		Score = 0;
	}
	
	public void resetPlayers(){
		Players.resetPlayers();
		playersTakenOut.resetValues();
	}
	
	/*Purpose: This replaces the current player with a new player
	 * @param firstName first name of the new player
	 * @param lastName of the new player
	 */
	public void replacePlayer(String firstName, String lastName){
		Players.replaceCurrent(new Player(firstName, lastName));
		playersTakenOut.Add(Players.getCurrent());
	}
	
	/*Purpose: This adds a new player to the team
	 * @param P This is the new player
	 */
	public void Add(Player P){
		Players.Add(P);
	}
	
	//This method resets the score to 0
	public void resetScore(){
		Score = 0;
	}
	
	//This method adds to the score
	public void setScore(){
		Score++;
	}
	
	/*Purpose: This method returns the score
	 * @return This returns an integer value of the score
	 */
	public int getScore(){
		return Score;
	}
	
	/*Purpose: This method returns all of the player information in this team
	 * @return This returns a string value of all the player information
	 */
	public String getAllPlayers(){
		return getAllCurrentPlayers() + getReplacedPlayers();
	}
	
	/*Purpose: This method returns all of the current player information in this team
	 * @return This returns a string value of all the current player information
	 */
	private String getAllCurrentPlayers(){
		String Output = "All Players In Game\n";
		Output += Format.justify('l', "Name", 15) + Format.justify('l', "Points", 15) + Format.justify('l', "Singles", 15)
				+ Format.justify('l', "Doubles", 15) + Format.justify('l', "Triples", 15) + Format.justify('l', "Home Runs", 15)
				+ Format.justify('l', "Walks", 15) + Format.justify('l', "Outs", 15) + "\n";
		Output += Players.toString();
		return Output;
	}
	
	/*Purpose: This method returns all of the replaced players information in this team
	 * @return This returns a string value of all the replaced player information
	 */
	private String getReplacedPlayers(){
		if(playersTakenOut.getHead() == null)
			return "No Players Were Replaced!\n\n";
		String Output = "All Replaced Players\n";
		Output += Format.justify('l', "Name", 15) + Format.justify('l', "Points", 15) + Format.justify('l', "Singles", 15)
				+ Format.justify('l', "Doubles", 15) + Format.justify('l', "Triples", 15) + Format.justify('l', "Home Runs", 15)
				+ Format.justify('l', "Walks", 15) + Format.justify('l', "Outs", 15) + "\n";
		Output += playersTakenOut.toString();
		return Output;
	}
	
	//This method resets the current value in the team to the first player inputted
	public void resetCurrent(){
		Players.resetCurrent();
	}
	
	/*Purpose: This returns the current player in the team batting
	 * @return This is the list node of the current player
	 */
	public ListNode getCurrent(){
		return Players.getCurrent();
	}
	
	//This method sets the current player to the next player in the line
	public void setNewCurrent(){
		Players.setNewCurrent();
	}
	
}
