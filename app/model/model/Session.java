package model;

import java.util.ArrayList;

/**
 * The Session class is a model that contains all of the attributes of the 
 * current game session, such as the current display type and the ArrayList of
 * enemies.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class Session {
	ArrayList<Zombie> zList = new ArrayList<Zombie>();

	int zombieIndex = 0;
	
	int killed = 0;
	
	boolean startMenu = true;
	boolean restartMenu = false;
	boolean paused = false;
	boolean quitting = false;
	
	int round = 1;
	
	/**
	 * This method is a getter for the paused variable.
	 * 
	 * @return Whether the game is paused.
	 */
	public boolean isPaused() {
		return paused;
	}

	/**
	 * This method pauses the game.
	 * 
	 * @return nothing
	 */
	public void pause() {
		this.paused = true;;
	}
	
	/**
	 * This method resumes the game.
	 * 
	 * @return nothing
	 */
	public void resume() {
		this.paused = false;
	}


	/**
	 * This method is a getter for the round variable.
	 * 
	 * @return The current round.
	 */
	public int getRound() {
		return round;
	}

	/**
	 * This method is a setter for the round variable.
	 * 
	 * @param round The current round.
	 * @return nothing
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * This method is a getter for the quitting variable.
	 * 
	 * @return Whether the player is quitting.
	 */
	public boolean isQuitting() {
		return quitting;
	}

	/**
	 * This method is a setter for the quitting variable.
	 * 
	 * @param quitting Whether the player is quitting.
	 * @return nothing
	 */
	public void setQuitting(boolean quitting) {
		this.quitting = quitting;
	}
	
	/**
	 * This method restarts the game by resetting the instance variables to the default values.
	 * 
	 * @return nothing
	 */
	public void restart() {
		zList = new ArrayList<Zombie>();
		zombieIndex = 0;
		killed = 0;
		round = 1;
		restartMenu = false;
	}

	/**
	 * This method is a setter for the quitting variable.
	 * 
	 * @return nothing
	 */
	public void quit() {
		quitting = true;
	}
	
	/**
	 * This method is a setter for the startMenu variable.
	 * 
	 * @return Whether the start menu is being displayed.
	 */
	public boolean isStartMenu() {
		return startMenu;
	}

	/**
	 * This method is a setter for the startMenu variable.
	 * 
	 * @param startMenu Whether the start menu is being displayed.
	 * @return nothing
	 */
	public void setStartMenu(boolean startMenu) {
		this.startMenu = startMenu;
	}

	/**
	 * This method is a getter for the restartMenu variable.
	 * 
	 * @return Whether the restart menu is being displayed.
	 */
	public boolean isRestartMenu() {
		return restartMenu;
	}

	/**
	 * This method is a setter for the 
	 * @param restartMenu Whether the restart menu is being displayed.
	 * @return nothing
	 */
	public void setRestartMenu(boolean restartMenu) {
		this.restartMenu = restartMenu;
	}

	/**
	 * This method is a getter for the zList variable.
	 * 
	 * @return The ArrayList of zombie entities.
	 */
	public ArrayList<Zombie> getzList() {
		return zList;
	}

	/**
	 * This method is a setter for the zList variable.
	 * 
	 * @param zList The ArrayList of zombie entities.
	 * @return nothing
	 */
	public void setzList(ArrayList<Zombie> zList) {
		this.zList = zList;
	}

	/**
	 * This method is a getter for the zombieIndex variable.
	 * 
	 * @return The length of the zList variable.
	 */
	public int getZombieIndex() {
		return zombieIndex;
	}

	/**
	 * This method is a setter for the zombieIndex variable.
	 * 
	 * @param zombieIndex The length of the zList variable.
	 * @return nothing
	 */
	public void setZombieIndex(int zombieIndex) {
		this.zombieIndex = zombieIndex;
	}

	/**
	 * This method is a getter for the killed variable.
	 * 
	 * @return The number of zombies the player has killed.
	 */
	public int getKilled() {
		return killed;
	}

	/**
	 * This method is a setter for the killed variable.
	 * 
	 * @param killed The number of zombies the player has killed.
	 */
	public void setKilled(int killed) {
		this.killed = killed;
	}
}
