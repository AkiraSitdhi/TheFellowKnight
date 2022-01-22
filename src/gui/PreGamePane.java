package gui;

import constants.FontHolder;
import constants.ImageHolder;
import constants.SoundHolder;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class PreGamePane extends StackPane {
	
	public PreGamePane() {
		
		this.setWidth(1280);
		this.setHeight(720);
		this.setPrefWidth(1280);
		this.setPrefHeight(720);
		Canvas canvas = new Canvas(1280, 720);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.drawImage(ImageHolder.preGameSprite, 0, 0, 1280, 720);
		
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.setFill(Color.GREY);
		gc.setFont(FontHolder.font25);
		gc.fillText("CLICK ANYWHERE TO START", 640, 680);

		this.getChildren().add(canvas);

		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				SoundHolder.getInstance().clickSfx.play(0.6D);
				SceneManager.getInstance().switchScene(1);
			}
		});
	}

}
