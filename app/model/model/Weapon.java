package model;

/**
 * The weapon class is a model containing the attributes of the player's weapon, including
 * The weapon type and rate of fire. It is instantiated in the Player class.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class Weapon {
	String type;
	
	int rateOfFire;
	
	/**
	 * The empty argument constructor instantiates the class
	 * and initializes all of the variables to their default state.
	 */
	Weapon() {
		this.type = "Colt";
		this.rateOfFire = getRateOfFire(this.type);
	}
	
	/**
	 * The custom constructor supports instantiating the Weapon class
	 * with a given weapon type.
	 * 
	 * @param type The weapon type.
	 */
	public Weapon(String type) {
		this.type = type;
		this.rateOfFire = getRateOfFire(this.type);
	}

	
	/**
	 * This method is a getter for the rateOfFire variable which takes the weapon type as a parameter.
	 * 
	 * @param type The weapon type.
	 * @return The weapon's rate of fire.
	 */
	int getRateOfFire(String type) {
		switch (this.type) {
		
		default:
			return 0;
		
		case "Colt":
			return 0;
		case "Shotgun":
			return 10;
		case "M16":
			return 40;
		}
	}

	/**
	 * This method is a getter for the type variable.
	 * 
	 * @return The weapon type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method is a setter for the type variable.
	 * 
	 * @param type The weapon type.
	 * @return nothing
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method is the default getter for the rateOfFire variable.
	 * 
	 * @return The weapon's rate of fire.
	 */
	public int getRateOfFire() {
		return rateOfFire;
	}

	/**
	 * This method is a setter for the rateOfFire variable.
	 * 
	 * @param rateOfFire The weapon's rate of fire.
	 * @return nothing
	 */
	public void setRateOfFire(int rateOfFire) {
		this.rateOfFire = rateOfFire;
	}
}
