
public class Game {
	
	private String gameName = "";
	private String gameRules = "";
	
	public Game(String name, String rules) {
		setGameName(name);
		setGameRules(rules);
		
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameRules() {
		return gameRules;
	}

	public void setGameRules(String gameRules) {
		this.gameRules = gameRules;
	}
	
	public String toString() {
		String output = new String("Chosen Game: "+ this.getGameName());
		output += "\n" + this.getGameRules();
		return output;
	}
	

}
