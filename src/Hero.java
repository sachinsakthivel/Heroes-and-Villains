enum Heroability {
	WIZARD, TANK, MEDIC, ROGUE, EVASIVE, CLAIRVOYANT, NECROMANCER
}


public class Hero extends Person{
	private Heroability ability;

	public Hero(String name, Heroability type) {
		super(name);
		ability = type;
		
	}
	
	public void useability( Hero Chosenhero) {
		
	}
	
	

}
