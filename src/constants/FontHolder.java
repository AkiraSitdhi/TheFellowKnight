package constants;

import javafx.scene.text.Font;

public class FontHolder {

	private static final FontHolder instance = new FontHolder();

	public static Font font25;
	public static Font font30;
	public static Font font40;
	public static Font font45;
	public static Font font50;
	public static Font font75;
	public static Font font100;
	public static Font font150;

	public FontHolder() {
		font25 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 25);
		font30 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 30);
		font40 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 40);
		font45 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 45);
		font50 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 50);
		font75 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 75);
		font100 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 100);
		font150 = Font.loadFont(ClassLoader.getSystemResourceAsStream("Pixellari.ttf"), 150);

	}

	public static FontHolder getInstance() {
		return instance;
	}

}
