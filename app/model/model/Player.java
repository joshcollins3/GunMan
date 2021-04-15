package model;
import javafx.scene.image.*;

/**
 * The Player class is a model containing the attributes of the player.
 * This class includes the functionality to reset, take damage, and control
 * the firing.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class Player {
	int health;
	
	double xPos;
	double yPos;
	int dir;
	
	boolean initFiring;
	boolean firing;
	boolean rapidFiring;

	Weapon currentWeapon;

	/**
	 * The empty argument constructor instantiates the class
	 * and initializes all of the variables to their default state.
	 */
	public Player() {
		this.health = 100;
		this.xPos = 400;
		this.yPos = 400;
		this.dir = 0;
		this.currentWeapon = new Weapon();
	}
	
	/**
	 * This method is a getter for the rapidFiring variable.
	 * 
	 * @return Whether rapid firing is occurring.
	 */
	public boolean isRapidFiring() {
		return rapidFiring;
	}

	/**
	 * This method is a setter for the rapidFiring variable.
	 * 
	 * @param rapidFiring Whether rapid firing is occurring.
	 * @return nothing
	 */
	public void setRapidFiring(boolean rapidFiring) {
		this.rapidFiring = rapidFiring;
	}
	
	/**
	 * This method resets the player when restarting the game.
	 * 
	 * @return nothing
	 */
	public void reset() {
		this.health = 100;
		this.xPos = 400;
		this.yPos = 0;
		this.dir = 0;
		this.currentWeapon = new Weapon();
	}
	
	/**
	 * This method adjusts the player's health when taking damage.
	 * 
	 * @return nothing
	 */
	public void damage() {
		if (this.health != 0) {
			this.health -= 1;
		}
	}
	
	/**
	 * This method begins the process of firing the player's weapon.
	 */
	public void shoot() {
		this.initFiring = true;
		this.firing = true;
	}
	
	/**
	 * This method is a getter for the initFiring variable.
	 * 
	 * @return Whether firing is being initialized.
	 */
	public boolean isInitFiring() {
		return this.initFiring;
	}
	
	/**
	 * This method ends the initialization of firing.
	 * 
	 * @return nothing
	 */
	public void endInitFiring() {
		this.initFiring = false;
	}
	
	
	/**
	 * This method is a getter for the firing variable
	 * 
	 * @return Whether the player is firing.
	 */
	public boolean isFiring() {
		return this.firing;
	}
	
	/**
	 * This method ends the process of firing.
	 * 
	 * @return nothing
	 */
	public void endFiring() {
		this.firing = false;
	}

	
	/**
	 * This method is a getter for the health variable.
	 * 
	 * @return The player's health level.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * This method is a setter for the health variable.
	 * 
	 * @param health The player's current health level.
	 * @return nothing
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * This method is a getter for the xPos variable.
	 * 
	 * @return The x coordinate.
	 */
	public double getxPos() {
		return xPos;
	}

	/**
	 * This method is a setter for the xPos variable.
	 * 
	 * @param xPos The x coordinate.
	 * @return nothing
	 */
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	/**
	 * This method is a getter for the yPos variable.
	 * 
	 * @return The y coordinate.
	 */
	public double getyPos() {
		return yPos;
	}

	/**
	 * This method is a setter for the yPos variable.
	 * 
	 * @param yPos The y coordinate.
	 * @return nothing
	 */
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * This method is a getter for the dir variable.
	 * 
	 * @return The direction the player is facing.
	 */
	public int getDir() {
		return this.dir;
	}
	
	/**
	 * This method is a setter for the dir variable.
	 * 
	 * @param dir The direction the player is facing.
	 * @return nothing
	 */
	public void setDir(int dir) {
		this.dir = dir;
	}

	/**
	 * This method is a getter for the currentWeapon variable.
	 * 
	 * @return The player's current weapon.
	 */
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	/**
	 * This method is a setter for the currentWeapon variable.
	 * 
	 * @param currentWeapon The player's current weapon.
	 * @return nothing
	 */
	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}
	
	/**
	 * This method gets the appropriate image according to the player's weapon and direction.
	 * 
	 * @return The player image.
	 */
	public Image getImg() {
		Image playerImg = new Image("/player-1911-up.png");
		if (this.dir == 0) {
			if (this.currentWeapon.getType() == "Colt") {
				playerImg = new Image("/player-1911-up.png");
			}
			else if (this.currentWeapon.getType() == "Shotgun") {
				playerImg = new Image("/player-shotgun-up.png");
			}
			else if (this.currentWeapon.getType() == "M16") {
				playerImg = new Image("/player-m16-up.png");
			}
		}
		
		else if (this.dir == 1) {
			if (this.currentWeapon.getType() == "Colt") {
				playerImg = new Image("/player-1911-right.png");
			}
			else if (this.currentWeapon.getType() == "Shotgun") {
				playerImg = new Image("/player-shotgun-right.png");
			}
			else if (this.currentWeapon.getType() == "M16") {
				playerImg = new Image("/player-m16-right.png");
			}
		}
		
		else if (this.dir == 2) {
			if (this.currentWeapon.getType() == "Colt") {
				playerImg = new Image("/player-1911-down.png");
			}
			else if (this.currentWeapon.getType() == "Shotgun") {
				playerImg = new Image("/player-shotgun-down.png");
			}
			else if (this.currentWeapon.getType() == "M16") {
				playerImg = new Image("/player-m16-down.png");
			}
		}
		
		else if (this.dir == 3) {
			if (this.currentWeapon.getType() == "Colt") {
				playerImg = new Image("/player-1911-left.png");
			}
			else if (this.currentWeapon.getType() == "Shotgun") {
				playerImg = new Image("/player-shotgun-left.png");
			}
			else if (this.currentWeapon.getType() == "M16") {
				playerImg = new Image("/player-m16-left.png");
			}
		}
		return playerImg;
	}
}
