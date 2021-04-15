package model;

/**
 * The Zombie class is a model containing the attributes of the zombie,
 * which acts as the enemy in this game. This class supports entity movement.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class Zombie {
	
	double xPos;
	double yPos;
	
	int lastMove;
	
	int index;
	
	/**
	 * This constructor initializes the zombie entity using a random number generator
	 * to place it at a random position at any side of the map.
	 * 
	 * @param num The randomly generated coordinate.
	 * @param index The index of the zombie in the ArrayList.
	 */
	public Zombie(double num, int index) {
		this.index = index;
		
		int side = (int) (Math.random() * 4);
		
		if (side == 0) {
			this.yPos = 0;
			this.xPos = num;
			System.out.println(0);
		}
		
		else if (side == 1) {
			this.xPos = 700;
			this.yPos = num;
			System.out.println(1);
		}
		
		else if (side == 2) {
			this.yPos = 700;
			this.xPos = num;
			System.out.println(2);
		}
		else if (side == 3) {
			this.xPos = 0;
			this.yPos = num;
			System.out.println(3);
		}
		
		this.lastMove = 0;
		System.out.println("generated");
	}
	
	/**
	 * This method moves the zombie towards the player.
	 * 
	 * @param p The player.
	 */
	public void move(Player p) {
		if (this.lastMove == 1) {
			if (this.xPos > p.getxPos()) {
				this.xPos -= 100;
			}
			else if (this.xPos < p.getxPos()) {
				this.xPos += 100;
			}
		}
		
		else if (this.lastMove == 0) {
			if (this.yPos > p.getyPos()) {
				this.yPos -= 100;
			}
			else if (this.yPos < p.getyPos()) {
				this.yPos += 100;
			}
		}

		if (this.xPos == p.getxPos() && this.yPos == p.getyPos()) {
			p.damage();
		}
		
		if (this.lastMove == 0) {
			this.lastMove = 1;
		}
		else {
			this.lastMove = 0;
		}
	}

	/**
	 * This method is a getter for the index variable.
	 * 
	 * @return The index.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * This method is a setter for the index variable.
	 * 
	 * @param i The index.
	 * @return nothing
	 */
	public void setIndex(int i) {
		this.index = i;
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
