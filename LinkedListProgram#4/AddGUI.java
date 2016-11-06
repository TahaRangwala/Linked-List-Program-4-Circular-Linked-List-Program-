/*Name: Taha Rangwala
 * Date: November 17, 2016
 * Purpose: The purpose of this dialog box class is to allow the user to add values to the program
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//AddGUI class header
public class AddGUI extends GBDialog{

	//Declaring window objects
	private JLabel firstNameLabel, lastNameLabel;
	private JTextField firstNameField, lastNameField;
	private JRadioButton Home, Away;
	private JButton Add;
	
	/*Purpose: This is the constructor method of the dialog box class
	 * param F This is the JFrame settings needed for the super class
	 */
	public AddGUI(JFrame F){
		super(F);
		setSize(500,200);
		setTitle("Add All Players");
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
		firstNameLabel = addLabel("First Name",1,1,1,1);
		firstNameField = addTextField("",1,2,1,1);
		lastNameLabel = addLabel("Last Name",1,3,1,1);
		lastNameField = addTextField("",1,4,1,1);
		Home = addRadioButton("Home",2,2,1,1);
		Away = addRadioButton("Away",2,4,1,1);
		Add = addButton("Add Player",3,3,1,1);
		ButtonGroup BG = new ButtonGroup();
		BG.add(Home);
		BG.add(Away);
		Home.setSelected(true);
	}
	
	/*Purpose: The purpose of this method is to perform certain tasks according to which button the user clicks
	 * @param buttonObj This is the button object which allows the program to tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		
		if(buttonObj == Add){
			try{
				
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
