package gui;

import constants.FontHolder;
import constants.ImageHolder;
import constants.SoundHolder;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainMenuPane extends VBox {

	private Button startButton;
	private Button tutorialButton;
	private Button creditButton;
	private Button exitButton;
	public static MediaPlayer menuTheme;

	public MainMenuPane() {
		// set size
		this.setWidth(1280);
		this.setPrefWidth(1280);
		this.setHeight(720);
		this.setPrefHeight(720);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(40);
		// set background
		BackgroundSize bgSize = new BackgroundSize(1280, 720, false, false, false, false);
		this.setBackground(new Background(new BackgroundImage(ImageHolder.menuBg2Sprite, null, null, null, bgSize)));
		// set component
		
		DropShadow ds = new DropShadow();
		ds.setOffsetY(4.0f);
		ds.setColor(Color.color(1f, 1f, 1f));
		Text text = new Text("The Fellow Knight");
		text.setFont(FontHolder.font100);
		text.setFill(Color.WHITE);
		text.setEffect(ds);
		initStartButton();
		initTutorialButton();
		initCreditButton();
		initExitButton();
		this.getChildren().addAll(text, startButton, tutorialButton, creditButton, exitButton);
		// play song
		menuTheme = new MediaPlayer(SoundHolder.getInstance().mainMenuTheme);
	    menuTheme.setVolume(0.5D);
	    menuTheme.setCycleCount(-1);
	    menuTheme.play();
	}

	private void initStartButton() {
		Button btn = new Button("Start");
		btn.setFont(FontHolder.font40);
		DropShadow ds = new DropShadow();
		ds.setOffsetY(4.0f);
		ds.setColor(Color.color(1f, 1f, 1f));
		btn.setEffect(ds);
		btn.setMaxWidth(300);
		btn.setMaxHeight(40);
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				SoundHolder.getInstance().clickSfx.play(0.6D);
				SceneManager.getInstance().switchScene(4);
			}
		});
		this.startButton = btn;
	}

	private void initTutorialButton() {
		Button btn = new Button("How to play");
		DropShadow ds = new DropShadow();
		ds.setOffsetY(4.0f);
		ds.setColor(Color.color(1f, 1f, 1f));
		btn.setEffect(ds);
		btn.setFont(FontHolder.font40);
		btn.setMaxWidth(300);
		btn.setMaxHeight(40);
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				SoundHolder.getInstance().clickSfx.play(0.6D);
				SceneManager.getInstance().switchScene(2);
			}
		});
		this.tutorialButton = btn;
	}

	private void initCreditButton() {
		Button btn = new Button("Credit");
		DropShadow ds = new DropShadow();
		ds.setOffsetY(4.0f);
		ds.setColor(Color.color(1f, 1f, 1f));
		btn.setEffect(ds);
		btn.setFont(FontHolder.font40);
		btn.setMaxWidth(300);
		btn.setMaxHeight(40);
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				SoundHolder.getInstance().clickSfx.play(0.6D);
				SceneManager.getInstance().switchScene(3);
			}
		});
		this.creditButton = btn;
	}

	private void initExitButton() {
		Button btn = new Button("Exit");
		DropShadow ds = new DropShadow();
		ds.setOffsetY(4.0f);
		ds.setColor(Color.color(1f, 1f, 1f));
		btn.setEffect(ds);
		btn.setFont(FontHolder.font40);
		btn.setMaxWidth(300);
		btn.setMaxHeight(40);
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				System.exit(0);
			}
		});
		this.exitButton = btn;
	}

}
