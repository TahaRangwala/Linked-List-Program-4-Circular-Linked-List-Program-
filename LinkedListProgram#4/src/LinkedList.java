/*Name: Taha Rangwala
 * Date: November 21, 2016
 * Purpose: The purpose of this class is to take all the information from all the other classes
 * and do some calculations and relay them back to the gui class for the user to see. This class essentially
 * holds all the information that the user wants to see and does necessary calculations as well.
 */

import java.io.Serializable;//allows for files to be saved

import java.util.*;

import BreezySwing.Format;

//LinkedList class header
public class LinkedList<T>{
	
	//Declaring private instance variables
	private ListNode <T> Head;//ListNode head containing data
	
	/*Purpose: The purpose of the constructor method is to initialize the instance variables
	 */
	public LinkedList(){
		Head = null;
	}
	
	/*Purpose: This method returns the head
	 *@return This is the list node of the head
	 */
	public ListNode getHead(){
		return Head;
	}
	
	public void resetValues(){
		ListNode Temp = Head;
		while(Temp != null){
			((Player) Temp.getValue()).resetPlayers();
			Temp = Temp.getNext();
		}
	}
	
	/*Purpose: The purpose of this method is to add the value of the first node of the list node
	 * @param newValue This is the value added to the first node of the list node
	 */
	public void addFirst(T newValue){
		ListNode Temp = Head;
		Head = new ListNode(newValue, Temp);
	}
	
	/*Purpose: The purpose of this method is to add the value of the last node of the list node
	 * @param newValue This is the value added to the last node of the list node
	 */
	public void addLast(T newValue){
		if(Head != null){
			ListNode Temp = Head;
			while(Temp.getNext() != null){
				Temp = Temp.getNext();
			}
			Temp.setNext(new ListNode(newValue, null));
		}
		else addFirst(newValue);
	}
	
	/*Purpose: This method prints all of the information from the list node
	 * @return This returns a string value of all of the information in the list node
	 */
	public String printAll(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		String Output = "";
		Output += Head.getValue().toString();
		ListNode Temp = Head;
		while(Temp.getNext() != null){
			Temp = Temp.getNext();
			Output += Temp.getValue().toString();
		}
		return Output;
	}
	
	/*Purpose: This method prints all of the information of the first node
	 * @return This returns a string value of all of the information of the first node
	 */
	public String printFirst(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		String Output = "";
		return Output + Head.getValue();
	}
	
	/*Purpose: This method prints all of the information of the last node
	 * @return This returns a string value of all of the information of the last node
	 */
	public String printLast(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		String Output = "";
		ListNode Temp = Head;
		while(Temp.getNext() != null){
			Temp = Temp.getNext();
		}
		return Output + Temp.getValue();
	}
	
	/*Purpose: This method removes the first node in the list node
	 */
	public void removeFirst(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		if(Head.getNext() != null)
			Head = Head.getNext();
		else Head = null;
	}
	
	/*Purpose: This method removes the last node in the list node
	 */
	public void removeLast(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		else if(Head.getNext() != null){
			ListNode Temp = Head;
			while(Temp.getNext() != null && Temp.getNext().getNext() != null){
				Temp = Temp.getNext();
			}
			Temp.setNext(null);
		}
		else 
			Head = null;
	}
	
	/*Purpose: The purpose of this method is to add values to the list node
	 * @param Value This is the value being added to the list node
	 */
	public void Add(ListNode<T> Value){
		if(Head == null)
			Head = new ListNode(Value.getValue(),null);
		else{
			ListNode Temp = Head;
			while(Temp.getNext() != null){
				Temp = Temp.getNext();
			}
			Temp.setNext(new ListNode(Value.getValue(),null));
		}
	}
	
	/*Purpose: The purpose of this method is to print all of the data in the program 
	 * @return This returns a string value of all of the data in the program
	 */
	public String toString(){
		checkHead();
		String Output = "";
		ListNode Temp = Head;
		while(Temp != null){
			Output += Temp.getValue().toString();
			Temp = Temp.getNext();
		}
		return Output;
	}
	
	/*Purpose: This checks to make sure the head has a value or it throws an exception
	 */
	public void checkHead(){
		if(Head == null)
			throw new IllegalArgumentException("There Are No Students!");
	}

}