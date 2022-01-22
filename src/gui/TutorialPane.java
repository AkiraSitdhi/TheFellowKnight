package gui;

import constants.FontHolder;
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

public class TutorialPane extends StackPane {
	
	private static final String knightIcon = ClassLoader.getSystemResource("knight_icon.png").toString();
	private static final String bomberIcon = ClassLoader.getSystemResource("bomber_icon.png").toString();
	private static final String archerIcon = ClassLoader.getSystemResource("archer_icon.png").toString();
	private static final String wizardIcon = ClassLoader.getSystemResource("wizard_icon.png").toString();
	private static final String executionerIcon = ClassLoader.getSystemResource("executioner_icon.png").toString();
	private static final String bossIcon = ClassLoader.getSystemResource("boss_icon.png").toString();
	private static final String batIcon = ClassLoader.getSystemResource("bat_icon.png").toString();
	private static final String sorcererIcon = ClassLoader.getSystemResource("sorcerer_icon.png").toString();
	private static final String spiderIcon = ClassLoader.getSystemResource("spider_icon.png").toString();
	private static final String normalheartIcon = ClassLoader.getSystemResource("normalheart_icon.png").toString();
	private static final String specialheartIcon = ClassLoader.getSystemResource("specialheart_icon.png").toString();
	
	public TutorialPane() {
		
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
		gc.fillText("HOW TO PLAY", 640, 80);
		
		gc.setFill(Color.WHITE);
		gc.setTextAlign(TextAlignment.LEFT);
		gc.setFont(FontHolder.font25);
		gc.fillText("1. Your objective is to overcome all the enemies waves and defeat the boss.", 200, 160);
		gc.fillText("2. You have to control your allies move direction", 200, 200);
		gc.fillText("    Press 'W' to move Up, 'A' to move Left, 'S' to move Down, 'D' to move Right.", 200, 240);
		gc.fillText("3. You allies will attack enemies automatically.", 200, 280);
		gc.fillText("4. Defeating enemy may drop a heart, which can heal your all of your allies.", 200, 320);
		gc.fillText("5. The game will be over if all of your allies are dead,", 200, 360);
		gc.fillText("    or you run into yourself, enemy or map boundaries.", 200, 400);
		
		gc.setFont(FontHolder.font30);
		gc.fillText("Allies", 240, 480);
		gc.fillText("Boss", 570, 480);
		gc.fillText("Enemy", 755, 480);
		gc.fillText("Heart", 1075, 480);
		
		gc.drawImage(new Image(knightIcon), 100, 520, 60, 60);
		gc.drawImage(new Image(archerIcon), 170, 520, 60, 60);
		gc.drawImage(new Image(wizardIcon), 240, 520, 60, 60);
		gc.drawImage(new Image(bomberIcon), 310, 520, 60, 60);
		gc.drawImage(new Image(executionerIcon), 380, 520, 60, 60);
		gc.drawImage(new Image(bossIcon), 570, 520, 60, 60);
		gc.drawImage(new Image(batIcon), 700, 520, 60, 60);
		gc.drawImage(new Image(sorcererIcon), 770, 520, 60, 60);
		gc.drawImage(new Image(spiderIcon), 840, 520, 60, 60);
		gc.drawImage(new Image(normalheartIcon), 1050, 520, 60, 60);
		gc.drawImage(new Image(specialheartIcon), 1120, 520, 60, 60);
		
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFill(Color.GREY);
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
