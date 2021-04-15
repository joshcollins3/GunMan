package model;

/**
 * The Bullet class is a model containing the attributes of the bullet.
 * It calculates the position offset necessary for each weapon and direction.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class Bullet {
	double xPos;
	double yPos;
	
	double xOffset;
	double yOffset;
	
	int dir;

	/**
	 * This constructor initializes the bullet with the appropriate offset for the
	 * weapon equipped and the player direction.
	 * 
	 * @param p The player object.
	 */
	public Bullet(Player p) {
		if (p.getDir() == 0) {
			this.xOffset = 60;
			this.xPos = p.getxPos() + this.xOffset;
			this.yPos = p.getyPos();
		}
		else if (p.getDir() == 1) {
			this.xOffset = 100;
			this.yOffset = 60;
			this.xPos = p.getxPos() + this.xOffset;
			this.yPos = p.getyPos() + this.yOffset;
		}
		else if (p.getDir() == 2) {
			this.xOffset = 20;
			this.yOffset = 100;
			this.xPos = p.getxPos() + this.xOffset;
			this.yPos = p.getyPos() + this.yOffset;
		}
		else if (p.getDir() == 3) {
			this.xOffset = 0;
			this.yOffset = 20;
			this.xPos = p.getxPos();
			this.yPos = p.getyPos() + this.yOffset;
		}
		
	}
	
	/**
	 * This method is a getter for the dir variable.
	 * 
	 * @return The direction the player is facing.
	 */
	public int getDir() {
		return dir;
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
	 * This method is a getter for the xOffset variable.
	 * 
	 * @return The x offset.
	 */
	public double getxOffset() {
		return xOffset;
	}

	/**
	 * This method is a setter for the xOffset variable.
	 * 
	 * @param xOffset The x offset.
	 * @return nothing
	 */
	public void setxOffset(double xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * This method is a getter for the yOffset variable.
	 * 
	 * @return The y offset.
	 */
	public double getyOffset() {
		return yOffset;
	}

	/**
	 * This method is a setter for the yOffset variable.
	 * 
	 * @param xOffset The y offset.
	 * @return nothing
	 */
	public void setyOffset(double yOffset) {
		this.yOffset = yOffset;
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
}
