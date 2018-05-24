import java.util.Random;

public class lesserHeals extends Item {
	
	private final int HealBase;
	private final int Duration;
	private final String Description;
	private Random rand = new Random();
	
	public lesserHeals() {
		super("Lesser Heal Tickets", 20, 0);
		HealBase = 10;
		Duration = 1;
		this.setItemDuration(Duration);
		Description = "This treatement heals " + HealBase + " hp points or more depending on the treament's sucess rate in " + this.getItemDuration() + " minute.";
		this.setItemDescription(Description);
	}
	
	public int getHealNum() {
		return HealBase;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.Description;
		return returnString;
	}
	
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			int heroHealthUpdate = hero.getCurrentHealth() +  rand.nextInt(3) + HealBase;
			if (heroHealthUpdate < hero.getMaximumHealth()) {
				hero.setCurrentHealth(heroHealthUpdate);
			} else {
				hero.setCurrentHealth(hero.getMaximumHealth());
			}
			this.setItemStock(this.getItemStock() - 1);
			String out =  "Healing Procedure Has Started";
			out += " \n\nHero: "+hero.getPersonName()+ " has been moved into Healing Ward from Team." + "\n";
			return out;
		} else {
			return "Insufficient amount of "+this.getItemName()+". \nPlease Buy Some from Shop";
		}
	}
	
}
