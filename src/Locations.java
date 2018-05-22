
public class Locations {
	
	private String name;
	boolean discovered;

	public Locations(String buildingname) {
		name = buildingname;
		discovered = false;
	}
	
	public void travelledto() {
		discovered = true;
	}
	
	public String getName() {
		if (discovered) {
			return name;
		} else {
			return "Destination: Unknown";
		}
	}
	
	public boolean goneTo() {
		return discovered;
	}
	
	public void travel(GameEnvironment game) {
		
	}

}
