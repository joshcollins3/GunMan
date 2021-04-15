package application;

import controllers.MovementController;
import javafx.application.*;
import javafx.animation.AnimationTimer;
import javafx.stage.*;
import model.Bullet;
import model.Player;
import model.Session;
import model.Weapon;
import model.Zombie;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.util.ArrayList;

/**
 * GunMan is a zombie survival shooter game. The game increases in difficulty
 * as the user progresses, and the they are rewarded with new weapons of higher
 * efficiency as they make it through the earlier rounds.
 * 
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-04-15
 */
public class Main extends Application {

	/**
	 * This is the method that generates the UI and contains the main game loop.
	 * 
	 * @param primaryStage The stage
	 * @return nothing
	 */
	public void start(Stage primaryStage) throws Exception {

		//Build the display window and canvas.
		primaryStage.setTitle("GunMan");
		primaryStage.setMinHeight(800);
		primaryStage.setMinWidth(800);
		primaryStage.setMaxHeight(800);
		primaryStage.setMaxWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setWidth(800);

		Group root = new Group();
		Scene scene = new Scene(root, 600, 400);

		primaryStage.setScene(scene);

		Canvas canvas = new Canvas(800, 800);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		Player p = new Player();

		//Instantiates a game session and binds the MovementController to handle KeyEvents.
		Session gameSession = new Session();
		MovementController mc = new MovementController(p, gameSession);

		scene.setOnKeyPressed(mc);
		
		scene.setOnKeyReleased((KeyEvent -> {
			if (KeyEvent.getCode() == KeyCode.SPACE) {
				p.setRapidFiring(false);
			}
		}));

		//This object contains the handle method which contains the game loop.
		new AnimationTimer() {
			
			int frameCounter = 0;
			Bullet bullet;


			//Executes every frame.
			public void handle(long currentTime) {
				
				//Displays start menu.
				if (gameSession.isStartMenu()) {
					gc.setFill(Color.BLACK);
					gc.setFont(Font.font(Font.getDefault().getName(), 40));
					gc.fillText("Press 'Enter' to Start", 225, 350);
				}
				
				//Contains the gameplay.
				if (!gameSession.isStartMenu() && !gameSession.isRestartMenu() && !gameSession.isPaused()) {
					
					//Generate zombie and add to ArrayList
					int generationSpeed = gameSession.getRound() * 5;
					if (generationSpeed >= 95) {
						generationSpeed = 95;
					}
					
					if (frameCounter % (100 - generationSpeed + 5) == 0 && frameCounter != 0 && generationSpeed <= 95) {
						double rand = (int) (Math.random() * 8);
						double num = rand * 100;
						System.out.println(num);
						
						ArrayList<Zombie> zList = gameSession.getzList();
						zList.add(new Zombie(num, gameSession.getZombieIndex()));

						gameSession.setzList(zList);
						gameSession.setZombieIndex(gameSession.getZombieIndex() + 1);

						for (Zombie zombie : zList) {
							zombie.move(p);
						}
					}

					//Clear canvas to draw player and zombies
					frameCounter++;
					gc.drawImage(new Image("/background.png"), 0, 0);
					
					if (p.getHealth() != 0) {
						gc.drawImage(p.getImg(), p.getxPos(), p.getyPos());
					}
					
					


					for (Zombie zombie : gameSession.getzList()) {
						gc.drawImage(new Image("/zombie-left.png"), zombie.getxPos(), zombie.getyPos());
					}

					//Executes when bullet is traveling
					if (p.isFiring()) {
						if (p.isInitFiring()) {
							bullet = new Bullet(p);
							bullet.setDir(p.getDir());
							p.endInitFiring();
						}
						if (bullet.getxPos() >= 800 || bullet.getxPos() <= 0 || bullet.getyPos() >= 800
								|| bullet.getyPos() <= 0) {
							p.endFiring();
							if (p.isRapidFiring()) {
								p.shoot();
							}
						}

						//Draws bullet and moves in direction player is facing at fire time
						gc.drawImage(new Image("/bullet.png"), bullet.getxPos(), bullet.getyPos());
						if (bullet.getDir() == 0) {
							bullet.setyPos(bullet.getyPos() - (10 + p.getCurrentWeapon().getRateOfFire()));
						} else if (bullet.getDir() == 1) {
							bullet.setxPos(bullet.getxPos() + (10 + p.getCurrentWeapon().getRateOfFire()));
						} else if (bullet.getDir() == 2) {
							bullet.setyPos(bullet.getyPos() + (10 + p.getCurrentWeapon().getRateOfFire()));
						} else if (bullet.getDir() == 3) {
							bullet.setxPos(bullet.getxPos() - (10 + p.getCurrentWeapon().getRateOfFire()));
						}

						//Removes zombie from ArrayList if hit
						int ind = 0;
						boolean removing = false;
						for (Zombie zombie : gameSession.getzList()) {
							if (bullet.getxPos() == zombie.getxPos() + bullet.getxOffset()
									&& bullet.getyPos() == zombie.getyPos() + bullet.getyOffset()) {
								System.out.println("Hit!");
								ind = zombie.getIndex();
								removing = true;
								gameSession.setKilled(gameSession.getKilled() + 1);
								
								if (gameSession.getKilled() % 2 == 0 && gameSession.getKilled() != 0) {
									gameSession.setRound(gameSession.getRound() + 1);
									System.out.println(gameSession.getRound());
								}
								
							}

						}
						if (removing) {
							gameSession.getzList().remove(ind);
							for (Zombie zombie : gameSession.getzList()) {
								if (zombie.getIndex() > ind) {
									zombie.setIndex(zombie.getIndex() - 1);
								}
							}
							gameSession.setZombieIndex(gameSession.getZombieIndex() - 1);
							p.endFiring();
							if (p.isRapidFiring()) {
								p.shoot();
							}
						}
						ind = 0;

					}
					
					//Damages the player on contact with zombie entity
					for (Zombie zombie: gameSession.getzList()) {
						if (p.getxPos() == zombie.getxPos() && p.getyPos() == zombie.getyPos()) {
							p.damage();
						}
					}
					
					//Rewards player with new weapons.
					if (gameSession.getRound() == 5) {
						p.setCurrentWeapon(new Weapon("Shotgun"));
					}
					else if (gameSession.getRound() == 10) {
						p.setCurrentWeapon(new Weapon("M16"));
					}
					
					if (p.getHealth() == 0) {
						gameSession.setRestartMenu(true);
					}

					//Displays stats
					gc.setFill(Color.RED);
					gc.setFont(Font.font(Font.getDefault().getName(), 20));
					gc.setTextAlign(TextAlignment.LEFT);
					gc.fillText("Round: " + String.valueOf(gameSession.getRound()), 10, 28);
					gc.fillText("Health: " + p.getHealth() + "%", 10, 68);
					gc.fillText("Kills: " + gameSession.getKilled(), 10, 48);
					
				}
				
				//Displays pause menu
				if (gameSession.isPaused()) {
					gc.setFill(new Color(1, 1, 1, 1));
					gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
					gc.setFill(Color.BLACK);
					gc.setFont(Font.font(Font.getDefault().getName(), 40));
					gc.fillText("Paused", 330, 350);
				}
				
				//Displays restart menu
				if (gameSession.isRestartMenu()) {
					p.reset();
					
					gc.setFill(new Color(1, 1, 1, 1));
					gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
					gc.setFill(Color.BLACK);
					gc.setFont(Font.font(Font.getDefault().getName(), 40));
					gc.fillText("You Died! You reached round " + gameSession.getRound() + ".\nPress 'Enter' to play again, or 'Esc' to quit.", 20, 350);
				}
				
				//Exits the game
				if (gameSession.isQuitting()) {
					Platform.exit();
				}
				
				

			}
		}.start();

		primaryStage.show();

	}

	/**
	 * This is the main method which launches the application to call the start method.
	 * 
	 * @param args unused
	 * @return nothing
	 */
	public static void main(String[] args) {
		launch(args);
	}

}