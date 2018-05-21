
public class PowerUpDen extends Locations{
	
	public PowerUpDen() {
		super("Power Up Den");
	}
	
	public void travel(GameEnvironment game) {
		travelledto();
		game.launchPowerUpSCREEN(game.getHomeBase());
	}


}
