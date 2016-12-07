/*Name: Taha Rangwala
 * Date: November 21, 2016
 * Purpose: The purpose of this method is to hold the head and current value of the circular linked list which is supposed to simulate
 * a circle like linked list since baseball is rotating players in and out
 */

//CircularLinkedList class header
public class CircularLinkedList <T>{

	//Declaring private instance variable
	private ListNode <T> Head;//ListNode Head which is the first value inputted
	private ListNode <T> Current;//ListNode Current which is the batter
	
	//Constructor method to initialize private instance variables
	public CircularLinkedList(){
		Head = null;
		Current = null;
	}
	
	/*Purpose: This adds a value to the circular linked list
	 * @param Value This is the value being added
	 */
	public void Add(T Value){
		if(Head == null){
			Head = new ListNode(Value,null);
		}
		else{
			ListNode Temp = Head;
			while(Temp.getNext() != null && Temp.getNext() != Head){
				Temp = Temp.getNext();
			}
			Temp.setNext(new ListNode(Value,Head));
		}
	}
	
	/*Purpose: This replaces the current value in the circular linked list
	 * @param Replacement This is the replacement value replacing the current value
	 */
	public void replaceCurrent(T Replacement){
		Current.setValue(Replacement);
	}
	
	//This sets the current to the next list node
	public void setNewCurrent(){
		Current = Current.getNext();
	}
	
	//This resets the current to the head
	public void resetCurrent(){
		Current = Head;
	}
	
	/*Purpose: This returns the current value
	 * @return This returns a listnode of the current value
	 */
	public ListNode getCurrent(){
		return Current;
	}
	
	public void resetPlayers(){
		ListNode Temp = Head;
		((Player) Head.getValue()).resetPlayers();
		while(Temp.getNext() != null && Temp.getNext() != Head){
			((Player) Temp.getValue()).resetPlayers();
			Temp = Temp.getNext();
		}
		((Player) Temp.getValue()).resetPlayers();
	}
	
	/*Purpose: This returns all of the values in the circular linked list
	 *@return This is a string value of all of the values in the circular linked list
	 */
	public String toString(){
		String Output = "";
		ListNode Temp = Head;
		while(Temp.getNext() != null && Temp.getNext() != Head){
			Output += Temp.getValue().toString();
			Temp = Temp.getNext();
		}
		return Output += Temp.getValue().toString();
	}
	
}
