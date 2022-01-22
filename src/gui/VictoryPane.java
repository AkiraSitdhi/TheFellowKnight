package gui;

import constants.FontHolder;
import constants.ImageHolder;
import constants.SoundHolder;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import logic.GameStat;

public class VictoryPane extends StackPane {
	
	
	public VictoryPane() {
		this.setWidth(1280);
		this.setHeight(720);
		this.setPrefWidth(1280);
		this.setPrefHeight(720);
		Canvas canvas = new Canvas(1280, 720);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		// Set line width
		gc.setLineWidth(2);
		// Set fill color
		gc.setFill(Color.LIGHTGREEN);
		gc.setFont(FontHolder.font150);

		gc.fillText("VICTORY", 640, 170);
		
		gc.setFill(Color.WHITE);
		gc.setFont(FontHolder.font40);
		gc.fillText("Congratulation! You have defeated the boss.", 640, 290);
		
		gc.setFont(FontHolder.font30);
		gc.fillText("Enemy Killed : " + GameStat.enemyKilled, 640, 350);
		
		gc.drawImage(ImageHolder.victorySprite, 320, 420, 640, 180);
		
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFill(Color.GREY);
		gc.fillText("CLICK ANYWHERE TO CONTINUE", 640, 670);
		
		SoundHolder.getInstance().victoryTheme.play(0.5);
		
		this.getChildren().add(canvas);
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				SoundHolder.getInstance().clickSfx.play(0.6D);
				MainMenuPane.menuTheme.play();
				SceneManager.getInstance().switchScene(0);
			}
		});
	}

}
