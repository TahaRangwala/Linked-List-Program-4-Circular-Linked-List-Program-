/*Name: Taha Rangwala
 * Date: November 21, 2016
 * Purpose: The purpose of this glass is to relay information back to the GUI class. This class is in charge of all of the
 * tasks, and it makes sure everything is getting done while the baseball game is being played.
 */

import java.util.Random;//allows for a random number generator

import javax.swing.JFrame;//allows for message boxes

import javax.swing.JOptionPane;//allows for message boxes

//Game class header
public class Game{

	//Declaring private instance variables
	private Team Home;//the home team
	private Team Away;//the away team
	private final int Innings;//number of innings
	private int currentInning;//the current inning
	private boolean isHomeBatting;//the team batting
	private int Outs;//number of outs
	private Player onFirst;//player on first base
	private Player onSecond;//player on second base
	private Player onThird;//player on third base
	private boolean Playing;//if the game is playing
	
	//Constructor method to initialize private instance variables
	public Game(){
		Innings = 1;
		Home = new Team();
		Away = new Team();
		currentInning = 1;
		isHomeBatting = false;
		Outs = 0;
		onFirst = null;
		onSecond = null;
		onThird = null;
		Player.numPlayersHome = 0;
		Player.numPlayersAway = 0;
		Playing = false;
	}
	
	//Resets Current to First Player Inputted
	public void resetCurrent(){
		Home.resetCurrent();
		Away.resetCurrent();
		startPlaying();
	}
	
	/*Purpose: The purpose of this method is to check if the game is playing
	 * @return This method returns a boolean value of whether or not there is a game going
	 */
	public boolean isPlaying(){
		return Playing;
	}
	
	//Setting the game to start
	public void startPlaying(){
		Playing = true;
	}
	
	/*Purpose: The purpose of this method is to return a String value of the name of the current team playing
	 *@return This returns a string value of the current team playing's name
	 */
	public String getCurrentTeam(){
		if(isHomeBatting)
			return "Home";
		else return "Away";		
	}
	
	/*Purpose: The purpose of this method is to replace the current player with a new player
	 * @param firstName This is the first name of the new player
	 * @param lastName This is the last name of the new player
	 */
	public void replacePlayer(String firstName, String lastName){
		if(isHomeBatting)
			Home.replacePlayer(firstName, lastName);
		else Away.replacePlayer(firstName, lastName);
	}
	
	/*Purpose: The purpose of this method is to return the current player who is batting
	 * @return This returns the current player who is batting
	 */
	public Player getCurrentPlayer(){
		if(isHomeBatting)
			return (Player) Home.getCurrent().getValue();
		else
			return (Player) Away.getCurrent().getValue();
	}
	
	/*Purpose: The purpose of this method is to add a new player to the team selected
	 * @param isHomeTeam This is the team that is selected
	 * @param P This is the player being added to the selected team
	 */
	public void AddPlayer(boolean isHomeTeam, Player P){
		if(isHomeTeam && Player.numPlayersHome < 9){
			Home.Add(P);
			Player.numPlayersHome++;
		}
		else if(!isHomeTeam && Player.numPlayersAway < 9){
			Away.Add(P);
			Player.numPlayersAway++;
		}
		else throw new IllegalArgumentException("There Are 9 Players In This Team!");
	}
	
	/*Purpose: This method is in charge of getting the integer value that will determine the move of the
	 * player up to bat
	 * @return This returns an integer value that will signify the move of the player batting
	 */
	public int Move(){
		Random Generator = new Random();
		return Generator.nextInt(100) + 1;
	}
	
	//This method is in charge of determing the move of the player batting
	public void determineMove(){
		Team currentTeam;
		if(isHomeBatting)
			currentTeam = Home;
		else currentTeam = Away;
		int Outcome = Move();
		if(Outcome <= 50)
			Out((Player) currentTeam.getCurrent().getValue());
		else if(Outcome <= 58){
			Walk((Player) currentTeam.getCurrent().getValue());
			JOptionPane.showMessageDialog(new JFrame(),"This Player Took A Walk!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(Outcome <= 78){
			Single((Player) currentTeam.getCurrent().getValue());
			JOptionPane.showMessageDialog(new JFrame(),"This Player Hit A Single!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(Outcome <= 90){
			Double((Player) currentTeam.getCurrent().getValue());
			JOptionPane.showMessageDialog(new JFrame(),"This Player Hit A Double!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(Outcome <= 93){
			Triple((Player) currentTeam.getCurrent().getValue());
			JOptionPane.showMessageDialog(new JFrame(),"This Player Hit A Triple!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(Outcome <= 100){
			homeRun((Player) currentTeam.getCurrent().getValue());
			JOptionPane.showMessageDialog(new JFrame(),"This Player Hit A Homerun!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//This method sets a new player up to bat
	public void setNextCurrent(){
		if(isHomeBatting)
			Home.setNewCurrent();
		else 
			Away.setNewCurrent();
	}
	
	//This method resets everything when the game is ended
	public void endGame(){
		Reset();
		currentInning = 1;
		isHomeBatting = false;
		Home.resetScore();
		Away.resetScore();
		Home.resetPlayers();
		Away.resetPlayers();
	}
	
	//This method resets the players on base and the outs when there is a new inning
	public void Reset(){
		Outs = 0;
		onFirst = null;
		onSecond = null;
		onThird = null;
	}
	
	/*Purpose: This methods moves the players accordingly when a batter gets out
	 * @param Current This is the current batter
	 */
	public void Out(Player Current){
		Outs++;
		Current.setOuts();
		if(Outs == 3){
			currentInning++;
			if(currentInning > Innings){
				JOptionPane.showMessageDialog(new JFrame(),"The Game Has Ended!", 
				"Information", JOptionPane.INFORMATION_MESSAGE);
				Playing = false;
			}
			else{
				setNextCurrent();
				isHomeBatting = !isHomeBatting;
				JOptionPane.showMessageDialog(new JFrame(),"There Are 3 Outs. We Are Changing Innings and Which Team Is Batting!", 
				"Information", JOptionPane.INFORMATION_MESSAGE);
				Reset();
			}
		}
		else{
			JOptionPane.showMessageDialog(new JFrame(),"This Player Is Out!", "Information", JOptionPane.INFORMATION_MESSAGE);
			setNextCurrent();
		}
	}
	
	/*Purpose: This methods moves the players accordingly when a batter walks
	 * @param Current This is the current batter
	 */
	public void Walk(Player Current){
		Current.setWalks();
		if(onFirst != null){
			if(onSecond != null){
				if(onThird != null){
					onThird.setPoints();
					setTeamScore();
				}
				onThird = onSecond;
			}
			onSecond = onFirst;
			onFirst = Current;
		}
		else
			onFirst = Current;
		setNextCurrent();
	}
	
	/*Purpose: This methods moves the players accordingly when a batter hits a single
	 * @param Current This is the current batter
	 */
	public void Single(Player Current){
		Current.setSingles();
		if(onThird != null){
			onThird.setPoints();
			setTeamScore();
		}
		onThird = onSecond;
		onSecond = onFirst;
		onFirst = Current;
		setNextCurrent();
	}
	
	/*Purpose: This methods moves the players accordingly when a batter hits a double
	 * @param Current This is the current batter
	 */
	public void Double(Player Current){
		Current.setDoubles();
		if(onThird != null){
			onThird.setPoints();
			setTeamScore();
		}
		if(onSecond != null){
			onSecond.setPoints();
			setTeamScore();
		}
		onThird = onFirst;
		onFirst = null;
		onSecond = Current;
		setNextCurrent();
	}
	
	/*Purpose: This methods moves the players accordingly when a batter hits a triple
	 * @param Current This is the current batter
	 */
	public void Triple(Player Current){
		Current.setTriples();
		if(onThird != null){
			onThird.setPoints();
			setTeamScore();
		}
		if(onSecond != null){
			onSecond.setPoints();
			setTeamScore();
		}
		if(onFirst != null){
			onFirst.setPoints();
			setTeamScore();
		}
		onThird = Current;
		onSecond = null;
		onFirst = null;
		setNextCurrent();
	}
	
	/*Purpose: This methods moves the players accordingly when a batter gets a home run
	 * @param Current This is the current batter
	 */
	public void homeRun(Player Current){
		Current.setHomeRuns();
		Current.setPoints();
		setTeamScore();
		if(onThird != null){
			onThird.setPoints();
			setTeamScore();
		}
		if(onSecond != null){
			onSecond.setPoints();
			setTeamScore();
		}
		if(onFirst != null){
			onFirst.setPoints();
			setTeamScore();
		}
		onFirst = null;
		onSecond = null;
		onThird = null;
		setNextCurrent();
	}
	
	//This method adds a point to the team batting
	public void setTeamScore(){
		if(isHomeBatting)
			Home.setScore();
		else Away.setScore();
	}
	
	/*Purpose: This method returns all of the home team information
	 * @return This is a string value of the home team information
	 */
	private String allHomeTeamInformation(){
		return "Home Team Information\n" + "Score: " + Home.getScore() + "\n" + Home.getAllPlayers();
	}
	
	/*Purpose: This method returns all of the away team information
	 * @return This is a string value of the away team information
	 */
	private String allAwayTeamInformation(){
		return "Away Team Information\n" + "Score: " + Away.getScore() + "\n" + Away.getAllPlayers();
	}
	
	/*Purpose: This method returns all of the game information
	 * @return This is a string value of the game information
	 */
	public String getAllInformation(){
		if(currentInning <= Innings)
			return "Away: " + Away.getScore() + "\nHome: " + Home.getScore() + 
					"\nOuts: " + Outs +  "\nInning: " + currentInning;
		else{
			String Output = "THE GAME HAS ENDED! THESE ARE THE RESULTS!\n\n" + allHomeTeamInformation() + allAwayTeamInformation();
			endGame();
			return Output;
		}
	}
	
	/*Purpose: This returns a string value of the first baseman's name
	 * @return This is the String value of the first baseman's name
	 */
	public String getFirstBase(){
		if(onFirst != null)
			return onFirst.getName();
		else return "Empty";
	}
	
	/*Purpose: This returns a string value of the second baseman's name
	 * @return This is the String value of the second baseman's name
	 */
	public String getSecondBase(){
		if(onSecond != null)
			return onSecond.getName();
		else return "Empty";
	}
	
	/*Purpose: This returns a string value of the third baseman's name
	 * @return This is the String value of the third baseman's name
	 */
	public String getThirdBase(){
		if(onThird != null)
			return onThird.getName();
		else return "Empty";
	}
	
	
}
