/**
 * Date: April 29th 2018
 * 
 * Person class is parent class to all types of living beings in the game, which are Heroes and Villains.
 * 
 * The class provides Object Person attributes such as a name, and whether the person is dead or alive. 
 * Includes getter and setter method for boolean living and a getter method for person name.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */
public class Person {
	
	/**
	 * Local String Variable representing Name of Person.
	 */
	private String personName;
	
	/**
	 * Local Boolean variable which indicates whether the Person is living or not.
	 */
	private boolean living;
	
	
	/**
	 * Constructor method for Person class using Name, and boolean Living set to True by default. 
	 * @param name String variable referencing Person name.
	 */
	public Person(String name) {
		personName = name;
		living = true;
	}
	
	/**
	 * This method returns a String variable referencing the Name of the Person.
	 * @return Returns String variable Name of Person.
	 */
	public String getPersonName() {
		return personName;
	}
	
	/**
	 * This method changes the Boolean variable Living using the Boolean input 'is'.
	 * @param is Boolean variable indicating whether Person is Living or not.
	 */
	public void setLiving(boolean is) {
		living = is;
	}
	
	/**
	 * This method returns a Boolean variable referencing whether the Person is Living or not.
	 * @return Returns Boolean variable living.
	 */
	public boolean getLiving() {
		return living;
	}
	
	
}
