
public class lesserHeals extends Item {
	private int HealNum;
	private int ItemDuration;
	
	public lesserHeals() {
		super("Lesser Heal Tickets", 20, 0);
		ItemDuration = 1;
		HealNum = 10;
	}
	
	public int getHealNum() {
		return HealNum;
	}
	
	public int getItemDuration() {
		return ItemDuration;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item heals " + HealNum + " hp points in " + ItemDuration + " minute.";
		return returnString;
	}
	
	public void use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			int heroHealthUpdate = hero.getCurrentHealth() + HealNum;
			if (heroHealthUpdate < hero.getMaximumHealth()) {
				hero.setCurrentHealth(heroHealthUpdate);
			} else {
				hero.setCurrentHealth(hero.getMaximumHealth());
			}
			this.setItemStock(this.getItemStock() - 1);
			System.out.println("Healing Procedure Has Started");
		} else {
			System.out.println("Insufficient amount of "+this.getItemName()+", Please Buy Some from Shop");
		}
	}
	
}
