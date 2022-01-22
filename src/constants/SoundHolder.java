package constants;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class SoundHolder {

	private static final SoundHolder instance = new SoundHolder();

	public Media gameTheme;
	public Media mainMenuTheme;
	public AudioClip gameOverTheme;
	public AudioClip victoryTheme;
	public AudioClip explodeSfx;
	public AudioClip splashSfx;
	public AudioClip clickSfx;
	public AudioClip fireballSfx;
	public AudioClip hitSfx;
	public AudioClip swordSfx;
	
	

	public SoundHolder() {
		gameTheme = new Media(ClassLoader.getSystemResource("gametheme.mp3").toString());
		mainMenuTheme = new Media(ClassLoader.getSystemResource("menutheme.mp3").toString());
		gameOverTheme = new AudioClip(ClassLoader.getSystemResource("gameover.wav").toString());
		victoryTheme = new AudioClip(ClassLoader.getSystemResource("victory.wav").toString());
		explodeSfx = new AudioClip(ClassLoader.getSystemResource("explode.wav").toString());
		splashSfx = new AudioClip(ClassLoader.getSystemResource("potion.wav").toString());
		clickSfx = new AudioClip(ClassLoader.getSystemResource("click.wav").toString());
		fireballSfx = new AudioClip(ClassLoader.getSystemResource("fireball.wav").toString());
		hitSfx = new AudioClip(ClassLoader.getSystemResource("hit.mp3").toString());
		swordSfx = new AudioClip(ClassLoader.getSystemResource("sword.wav").toString());
	}

	public static SoundHolder getInstance() {
		return instance;
	}

}
