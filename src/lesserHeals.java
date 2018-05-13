import java.util.Random;

public class lesserHeals extends Item {
	
	private final int HealBase;
	private final int HealNum;
	private final int Duration;
	private final String Description;
	
	public lesserHeals() {
		super("Lesser Heal Tickets", 20, 0);
		Random rand = new Random();
		HealBase = 10;
		HealNum = rand.nextInt(3) + HealBase;
		Duration = 1;
		this.setItemDuration(Duration);
		Description = "This treatement heals " + HealBase + " hp points or more depending on the treament's sucess rate in " + this.getItemDuration() + " minute.";
		this.setItemDescription(Description);
	}
	
	public int getHealNum() {
		return HealNum;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.Description;
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
