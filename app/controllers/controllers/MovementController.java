package controllers;

import javafx.event.*;
import javafx.scene.input.*;
import model.Player;
import model.Session;

/**
 * The MovementController class is a controller used to handle all
 * KeyEvents, such as moving the player, and navigating through the menus.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class MovementController implements EventHandler<KeyEvent>{
	Player p;
	Session gs;
	
	/**
	 * This constructor initializes the player and game session variables.
	 * 
	 * @param p The player.
	 * @param gs The game session.
	 */
	public MovementController(Player p, Session gs) {
		this.p = p;
		this.gs = gs;
	}
	
	/**
	 * This handle method is included in the EventHandler interface. It handles each KeyPress
	 * in order to navigate the menus, move the player, and fire the weapon.
	 * 
	 * @param event The KeyEvent.
	 */
	public void handle(KeyEvent event) {
		if (p.getCurrentWeapon().getType() == "M16" && event.getCode() == KeyCode.SPACE) {
			p.setRapidFiring(true);
		}
		if (event.getCode() == KeyCode.ENTER) {
			if (gs.isStartMenu()) {
				gs.setStartMenu(false);
			}
			else if (gs.isRestartMenu()) {
				gs.restart();
			}
		}
		else if (event.getCode() == KeyCode.LEFT) {
			if (p.getxPos() >= 100) {
				if (p.getDir() == 3) {
					p.setxPos(p.getxPos() - 100);
				}
				
				p.setDir(3);
			}
		}
		else if (event.getCode() == KeyCode.RIGHT) {
			if (p.getxPos() <= 600) {
				if (p.getDir() == 1) {
					p.setxPos(p.getxPos() + 100);
				}
				
				p.setDir(1);
			}
		}
		else if (event.getCode() == KeyCode.UP) {
			if (p.getyPos() >= 100) {
				if (p.getDir() == 0) {
					p.setyPos(p.getyPos() - 100);
				}
				
				p.setDir(0);
			}
		}
		else if (event.getCode() == KeyCode.DOWN) {
			if (p.getyPos() <= 600) {
				if (p.getDir() == 2) {
					p.setyPos(p.getyPos() + 100);
				}
				
				p.setDir(2);
			}
		}
		else if (event.getCode() == KeyCode.SPACE) {
			if (!p.isFiring() && p.getHealth() > 0) {
				p.shoot();
			}
			
		}
		else if (event.getCode() == KeyCode.ESCAPE) {
			if (gs.isRestartMenu()) {
				gs.quit();
			}
			else if (!gs.isStartMenu() && !gs.isPaused()) {
				gs.pause();
			}
			else if (gs.isPaused()) {
				gs.resume();
			}
		}
		System.out.println(p.getxPos() + ", " + p.getyPos());
	}
	


}
