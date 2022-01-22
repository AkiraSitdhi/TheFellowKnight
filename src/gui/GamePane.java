package gui;

import constants.SoundHolder;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import logic.GameSystem;

public class GamePane extends HBox {
	
	private MediaPlayer mediaPlayer;

	public GamePane() {
		GameSystem.getInstance().gamePane=this;
		this.setWidth(1280);
		this.setHeight(720);
		this.setPrefWidth(1280);
		this.setPrefHeight(720);
		StatPane statPane = new StatPane();
		GameScreen gameScreen = new GameScreen();
		this.getChildren().addAll(statPane, gameScreen);
		gameScreen.setFocusTraversable(true);
		this.mediaPlayer = new MediaPlayer(SoundHolder.getInstance().gameTheme);
	    mediaPlayer.setAutoPlay(true);
	    mediaPlayer.setVolume(0.5D);
	    mediaPlayer.setCycleCount(-1);
	}
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
}
