
public class Person {
	
	private String personName;
	private boolean living;
	
	public Person(String name) {
		personName = name;
		living = true;
		
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setLiving(boolean is) {
		living = is;
	}
	
	public boolean getLiving() {
		return living;
	}
	
	
}
