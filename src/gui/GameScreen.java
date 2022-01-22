package gui;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import logic.*;
import projectile.*;
import render.*;
import constants.GameUnit;
import java.util.Queue;
import java.util.LinkedList;

import input.InputUtility;
import item.*;

public class GameScreen extends Canvas {

	private GraphicsContext gc;
	
	private WaveSystem waveSystem;
	private Thread gameLoop;
	private Queue<IRenderable> initializeList;
	
	public GameScreen() {
		setUp();
		initGame();
		initGameLoop();
		initWaveSystem();
	}
	
	public void setUp() {
		this.setWidth(GameUnit.MAP_WIDTH);
		this.setHeight(GameUnit.MAP_HEIGHT);
		this.setVisible(true);
		this.setFocusTraversable(true);
		addListener();
		this.gc = getGraphicsContext2D();
		GameSystem.getInstance().gameScreen = this;
		this.initializeList = new LinkedList<IRenderable>();
		this.waveSystem = new WaveSystem();
	}
	
	public void initGame() {
		GameScreen.this.initObject(new CurrentAllies());
		GameScreen.this.initObject(new GameBackground());
	}
	
	public void initGameLoop() {      
		this.gameLoop = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(75);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							if (GameStat.isGameOver) {
								GameScreen.this.exitGame();
							}
							GameScreen.this.clearScreen();
							GameScreen.this.rearrange();
							GameScreen.this.updateObject();
							GameScreen.this.paintComponent();
							GameSystem.getInstance().statPane.update();
							RenderableHolder.getInstance().update();
						}
					});
					Thread.sleep(75);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							GameScreen.this.clearScreen();
							GameScreen.this.projectileUpdate();
							GameScreen.this.paintComponent();
							RenderableHolder.getInstance().update();
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); 
		this.gameLoop.start();
	}
	public void exitGame() {
		GameSystem.getInstance().gamePane.getMediaPlayer().stop();
		GameSystem.getInstance().gameScreen.stopLoop();
		RenderableHolder.getInstance().getEntities().clear();
		GameScreen.this.initializeList.clear();
		InputUtility.reset();
		if (GameStat.isVictory) {
			SceneManager.getInstance().switchScene(6);
		} else {
			SceneManager.getInstance().switchScene(5);
		}
	}
	
	public void initWaveSystem() {
		GameSystem.getInstance().statPane.nextWave();
	}

	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode());
		});
	}
	
	public void clearScreen() {
		gc.clearRect(0, 0, GameUnit.MAP_WIDTH, GameUnit.MAP_HEIGHT);
	}
	
	public void rearrange() {
		RenderableHolder.getInstance().update();
		while (!initializeList.isEmpty()) {
			RenderableHolder.getInstance().add(initializeList.poll());
		}
	}
	
	public void initObject(IRenderable object) {
		this.initializeList.add(object);
	}
	
	@SuppressWarnings("deprecation")
	void stopLoop() {
		this.gameLoop.stop();
	}

	public void paintComponent() {
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible()) {
				entity.draw(gc);
			}
		}
	}
	
	public void updateObject() {
		for (int i=0 ; i<RenderableHolder.getInstance().getEntities().size(); i++) {
			if (RenderableHolder.getInstance().getEntities().get(i) instanceof Updatable) {
				Updatable object = (Updatable) RenderableHolder.getInstance().getEntities().get(i);
				object.update();
			}
		}
	}
	
	public void projectileUpdate() {
		for (int i=0; i<RenderableHolder.getInstance().getEntities().size(); i++) {
			if (RenderableHolder.getInstance().getEntities().get(i) instanceof Projectile) {
				Projectile projectile = (Projectile) RenderableHolder.getInstance().getEntities().get(i);
				projectile.update();
				if (projectile.isTriggerable(RenderableHolder.getInstance().getEntities())) {
					projectile.setVisible(false);
					projectile.setRemove(true);
				}
			}
		}
	}

	public WaveSystem getWaveSystem() {
		return waveSystem;
	}

	public void setWaveSystem(WaveSystem waveSystem) {
		this.waveSystem = waveSystem;
	}

}
