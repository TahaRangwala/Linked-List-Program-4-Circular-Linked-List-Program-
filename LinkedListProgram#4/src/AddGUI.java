/*Name: Taha Rangwala
 * Date: November 21, 2016
 * Purpose: The purpose of this add gui class is to allow the user to use a user friendly interface in order to add
 * new players
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//AddGUI class header
public class AddGUI extends GBDialog {

	// Declaring window objects
	private JLabel firstNameLabel, lastNameLabel, homeTeamLabel, awayTeamLabel;
	private JTextField firstNameField, lastNameField;
	private JRadioButton Home, Away;
	private JButton Add, Start;
	private JList homeTeamList, awayTeamList;
	private DefaultListModel homeTeamModel, awayTeamModel;

	/* Purpose: This is the constructor method of the dialog box class 
	 * param F This is the JFrame settings needed for the super class
	 */
	public AddGUI(JFrame F) {
		super(F);
		setSize(500, 500);
		setTitle("Add All Players");
		setLocationRelativeTo(null);// Location is in center of screen
		getContentPane().setBackground(new Color(169, 229, 255));// background of GUI is lightblue
		firstNameLabel = addLabel("First Name", 1, 1, 1, 1);
		firstNameField = addTextField("", 1, 2, 1, 1);
		lastNameLabel = addLabel("Last Name", 1, 3, 1, 1);
		lastNameField = addTextField("", 1, 4, 1, 1);
		Home = addRadioButton("Home", 2, 2, 1, 1);
		Away = addRadioButton("Away", 2, 4, 1, 1);
		Add = addButton("Add Player", 3, 2, 1, 1);
		Start = addButton("Start Game",3,3,1,1);
		homeTeamLabel = addLabel("Home Team",4,2,1,1);
		awayTeamLabel = addLabel("Away Team",4,3,1,1);
		homeTeamList = addList(5,2,1,1);
		awayTeamList = addList(5,3,1,1);
		ButtonGroup BG = new ButtonGroup();
		BG.add(Home);
		BG.add(Away);
		Home.setSelected(true);
		homeTeamModel = (DefaultListModel)homeTeamList.getModel();
		awayTeamModel = (DefaultListModel)awayTeamList.getModel();
	}

	/* Purpose: The purpose of this method is to perform certain tasks according
	 * to which button the user clicks
	 * @param buttonObj This is the button object which allows the program to
	 * tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Add){
			try{
				Player.errorCheckPlayers(firstNameField.getText(), lastNameField.getText());
				GUI.mainGame.AddPlayer(Home.isSelected(), new Player(firstNameField.getText(), lastNameField.getText()));
				if(Home.isSelected())
					homeTeamModel.addElement(Player.numPlayersHome + ": " + firstNameField.getText() + " " + lastNameField.getText());
				else
					awayTeamModel.addElement(Player.numPlayersAway + ": " + firstNameField.getText() + " " + lastNameField.getText());
				firstNameField.setText("");
				lastNameField.setText("");
				firstNameField.grabFocus();
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			try{
				Player.errorCheckPlayerCount(true);
				Player.errorCheckPlayerCount(false);
				GUI.mainGame.startPlaying();
				GUI.mainGame.resetCurrent();
				setVisible(false);
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
