package gui;

import constants.FontHolder;
import constants.ImageHolder;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import logic.GameStat;
import logic.GameSystem;

public class StatPane extends Canvas {

	public StatPane() {
		GameSystem.getInstance().statPane = this;
		this.setWidth(320);
		this.setHeight(720);
		this.setVisible(true);
		update();
	}

	public void nextWave() {
		// set wave count + 1
		GameSystem.getInstance().gameScreen.getWaveSystem()
				.setWaveCount(GameSystem.getInstance().gameScreen.getWaveSystem().getWaveCount() + 1);
		// call next wave after 3 seconds
		Thread wait = new Thread(() -> {
			try {
				Thread.sleep(3000);
				GameSystem.getInstance().gameScreen.getWaveSystem().nextWave();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		wait.start();
	}

	public void update() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.drawImage(ImageHolder.stat2Sprite, 0, 0, this.getWidth(), this.getHeight());
	
		gc.setStroke(Color.WHITE);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(5.0);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.setFont(FontHolder.font50);
		
		DropShadow ds = new DropShadow();
		ds.setOffsetY(4.0f);
		ds.setColor(Color.color(1f, 1f, 1f));
		gc.setFill(Color.WHITE);
		gc.setEffect(ds);
		gc.fillText("The Fellow", 160, 50);
		gc.fillText("Knight", 160, 100);
		
		gc.setFont(FontHolder.font40);
		gc.fillText("Wave " + GameStat.waveCount, 160, 200);
		gc.fillText("Killed " + GameStat.enemyKilled, 160, 250);
		
		gc.setEffect(null);
		gc.setFont(FontHolder.font30);

		for (int k = 0; k < 5; k++) {
			gc.setFill(Color.WHITE);
			gc.fillRect(120, 360 + 70 * k, 160, 40);
			gc.setFill(Color.GREEN);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setTextBaseline(VPos.CENTER);

			switch (k) {
			case 0:
				gc.fillRect(120, 360 + 70 * k, 160 * GameStat.knightHp, 40);
				if (GameStat.knightHp == 0) {
					gc.setFill(Color.RED);
					gc.fillText("Dead", 200, 382 + 70 * k);
					gc.drawImage(ImageHolder.knightDeadSprite, 30, 350, 60, 60);
				} else {
					gc.drawImage(ImageHolder.knightSprite, 30, 350, 60, 60);
				}
				break;
			case 1:
				gc.fillRect(120, 360 + 70 * k, 160 * GameStat.archerHp, 40);
				if (GameStat.archerHp == 0) {
					gc.setFill(Color.RED);
					gc.fillText("Dead", 200, 382 + 70 * k);
					gc.drawImage(ImageHolder.archerDeadSprite, 30, 420, 60, 60);
				} else {
					gc.drawImage(ImageHolder.archerSprite, 30, 420, 60, 60);
				}
				break;
			case 2:
				gc.fillRect(120, 360 + 70 * k, 160 * GameStat.wizardHp, 40);
				if (GameStat.wizardHp == 0) {
					gc.setFill(Color.RED);
					gc.fillText("Dead", 200, 382 + 70 * k);
					gc.drawImage(ImageHolder.wizardDeadSprite, 30, 490, 60, 60);
				} else {
					gc.drawImage(ImageHolder.wizardSprite, 30, 490, 60, 60);
				}
				break;
			case 3:
				gc.fillRect(120, 360 + 70 * k, 160 * GameStat.bomberHp, 40);
				if (GameStat.bomberHp == 0) {
					gc.setFill(Color.RED);
					gc.fillText("Dead", 200, 382 + 70 * k);
					gc.drawImage(ImageHolder.bomberDeadSprite, 30, 560, 60, 60);
				} else {
					gc.drawImage(ImageHolder.bomberSprite, 30, 560, 60, 60);
				}
				break;
			case 4:
				gc.fillRect(120, 360 + 70 * k, 160 * GameStat.executionerHp, 40);
				if (GameStat.executionerHp == 0) {
					gc.setFill(Color.RED);
					gc.fillText("Dead", 200, 382 + 70 * k);
					gc.drawImage(ImageHolder.executionerDeadSprite, 30, 630, 60, 60);
				} else {
					gc.drawImage(ImageHolder.executionerSprite, 30, 630, 60, 60);
				}
				break;
			}
			gc.strokeRect(120, 360 + 70 * k, 160, 40);
		}
	}
}
