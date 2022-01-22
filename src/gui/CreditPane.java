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

public class CreditPane extends StackPane {

	public CreditPane() {
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
		gc.setFill(Color.GOLD);
		gc.setFont(FontHolder.font75);

		gc.fillText("Thanks for Playing", 640, 80);

		gc.drawImage(ImageHolder.nimbleQuestSprite, 503, 160);
		gc.setFill(Color.WHITE);
		gc.setFont(FontHolder.font30);

		gc.fillText("Inspired by Nimble Quest", 640, 300);
		gc.fillText("Developed by", 640, 390);

		gc.setFont(FontHolder.font25);
		gc.fillText("Teeradon Riratanapong 6330250021", 640, 440);
		gc.fillText("Akira Sitdhikariyawat 6330563421", 640, 480);

		gc.setFont(FontHolder.font25);
		gc.fillText("Part of Programming Methodology Course 2110215", 640, 570);
		gc.fillText("Department of Computer Engineering, Chulalongkorn University", 640, 610);

		gc.setFill(Color.GREY);
		gc.setFont(FontHolder.font30);
		gc.fillText("CLICK ANYWHERE TO CONTINUE", 640, 670);

		this.getChildren().add(canvas);

		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				SoundHolder.getInstance().clickSfx.play(0.6D);
				SceneManager.getInstance().switchScene(0);
			}
		});
	}
}
