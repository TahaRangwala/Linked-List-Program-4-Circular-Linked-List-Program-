import BreezySwing.*;
import javax.swing.*;
import java.awt.Color;

public class GUI extends GBFrame{
	
	public static LinkedList List;
	private JLabel firstLabel, secondLabel, thirdLabel, homeLabel, currentLabel;
	private JTextField firstBase, secondBase, thirdBase, homePlate, currentPlayer;
	private JTextArea infoArea;
	private JButton Move, Replace, Exit;
	
	public GUI(){
		
		List = new LinkedList();
		firstLabel = addLabel("First Base",6,3,1,1);
		firstBase = addTextField("",7,3,1,1);
		secondLabel = addLabel("Second Base",3,2,1,1);
		secondBase = addTextField("",4,2,1,1);
		thirdLabel = addLabel("Third Base",6,1,1,1);
		thirdBase = addTextField("",7,1,1,1);
		homeLabel = addLabel("Home Plate",9,2,1,1);
		homePlate = addTextField("",10,2,1,1);
		Move = addButton("Move",11,1,1,1);
		Replace = addButton("Replace",11,2,1,1);
		Exit = addButton("Exit",11,3,1,1);
		infoArea = addTextArea("",1,1,3,1);
		currentLabel = addLabel("Current Player",2,1,1,1);
		currentPlayer = addTextField("",2,2,1,1);
		infoArea.setEditable(false);
		currentPlayer.setEditable(false);
		firstBase.setEditable(false);
		secondBase.setEditable(false);
		thirdBase.setEditable(false);
		homePlate.setEditable(false);
		AddGUI addGUI = new AddGUI(this);
		addGUI.setVisible(true);
	}
	
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Move){
			
		}
		else if(buttonObj == Replace){
			
		}
		else
			this.dispose();
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
