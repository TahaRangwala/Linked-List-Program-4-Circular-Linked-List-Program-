/*Name: Taha Rangwala
 * Date: November 21, 2016
 * Purpose: The purpose of this gui class is to allow the user to use a user friendly interface in order to perform
 * the tasks that they want using this program. This class provides the user with input and output fields, buttons, and
 * more;
 */

import BreezySwing.*;//allows for more window objects

import javax.swing.*;//allows for more window objects

import java.awt.Color;//allows for more colors

//GUI class header
public class GUI extends GBFrame{
	
	//Declaring static variables
	public static Game mainGame;//Game class object
	//Declaring window objects
	private JLabel firstLabel, secondLabel, thirdLabel, homeLabel, currentTeamLabel;
	private JTextField firstBase, secondBase, thirdBase, homePlate, currentTeam;
	private JTextArea infoArea;
	private JButton Move, Replace, Exit;
	
	//Constructor method that initializes private instance variables and window objects
	public GUI(){
		mainGame = new Game();//initializing Game object
		AddGUI addGUI = new AddGUI(this);
		addGUI.setVisible(true);
		firstLabel = addLabel("First Base",6,3,1,1);
		firstBase = addTextField("",7,3,1,1);
		secondLabel = addLabel("Second Base",3,2,1,1);
		secondBase = addTextField("",4,2,1,1);
		thirdLabel = addLabel("Third Base",6,1,1,1);
		thirdBase = addTextField("",7,1,1,1);
		homeLabel = addLabel("Home Plate",9,2,1,1);
		homePlate = addTextField(mainGame.getCurrentPlayer().getName(),10,2,1,1);
		Move = addButton("Move",11,1,1,1);
		Replace = addButton("Replace",11,2,1,1);
		Exit = addButton("Exit",11,3,1,1);
		infoArea = addTextArea(mainGame.getAllInformation(),1,1,3,1);
		currentTeamLabel = addLabel("Current Team",2,1,1,1);
		currentTeam = addTextField(mainGame.getCurrentTeam(),2,2,1,1);
		infoArea.setEditable(false);
		currentTeam.setEditable(false);
		firstBase.setEditable(false);
		secondBase.setEditable(false);
		thirdBase.setEditable(false);
		homePlate.setEditable(false);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Move){//move button
			mainGame.determineMove();
			firstBase.setText(mainGame.getFirstBase());
			secondBase.setText(mainGame.getSecondBase());
			thirdBase.setText(mainGame.getThirdBase());
			homePlate.setText(mainGame.getCurrentPlayer().getName());
			currentTeam.setText(mainGame.getCurrentTeam());
			infoArea.setText(mainGame.getAllInformation());
			checkGame();
		}
		else if(buttonObj == Replace){//replace button
			ReplaceGUI replaceGUI = new ReplaceGUI(this,(Player) mainGame.getCurrentPlayer());
			replaceGUI.setVisible(true);
			homePlate.setText(mainGame.getCurrentPlayer().getName());
		}
		else
			this.dispose();//closes the program
	}
	
	//This method checks to make sure the game is playing, otherwise it resets everything
	private void checkGame(){
		if(!mainGame.isPlaying()){
			mainGame.resetCurrent();
			firstBase.setText("");
			secondBase.setText("");
			thirdBase.setText("");
			homePlate.setText(mainGame.getCurrentPlayer().getName());
			currentTeam.setText(mainGame.getCurrentTeam());
		}
	}
	
	// Main method to set up the GUI
	public static void main (String [] args){
		GUI theMainGUI = new GUI();//GUI object
		theMainGUI.setSize(500,500);//size of the GUI interface
		theMainGUI.setTitle("Taha's Baseball Simulation Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		//theMainGUI.setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
