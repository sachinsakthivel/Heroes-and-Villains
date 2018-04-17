
public class Villain extends Person {
	
	private int damageAmount;
	private String tauntPhrase;
	private boolean defeated = false;
	private int gamesLost;
	
	public Villain(String name, int damage, String taunt) {
		super(name);
		damageAmount = damage;
		tauntPhrase = taunt;
	}
	
	public int getDamageAmount() {
		return damageAmount;
	}
	
	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}
	
	public String getTauntPhrase() {
		return tauntPhrase;
	}
	
	public void setTauntPhrase(String tauntPhrase) {
		this.tauntPhrase = tauntPhrase;
	}
	
	public String cryTaunt() {
		return getPersonName() + ":" + getTauntPhrase();
	}
	
	public boolean getDefeated() {
		return defeated;
	}
	
	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}
	
	public int getGamesLost() {
		return gamesLost;	
	}
	
	/**
	 * @param setGamesLost is the counter of games the villain has until they are defeated
	 */
	public void setGamesLost() {
		if (getGamesLost() >= 3) {
			setDefeated(true);
		} this.gamesLost +=1;
		
	}
	
	public String toString() {
		String output = new String("This villain is named: " + getPersonName() + " and currently has " + getCurrentHealth() +  " health. Their battle cry is "  + getTauntPhrase());
		return output;
	}
}
