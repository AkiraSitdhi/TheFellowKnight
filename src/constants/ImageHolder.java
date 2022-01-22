package constants;

import javafx.scene.image.Image;

public class ImageHolder {

	private static final ImageHolder instance = new ImageHolder();

	public static Image mapSprite;
	public static Image nimbleQuestSprite;
	public static Image axeSprite;
	public static Image arrowSprite;
	public static Image bombSprite;
	public static Image fireballSprite;
	public static Image iceballSprite;
	public static Image swordSprite;
	public static Image bossWeaponSprite;
	public static Image webSprite;
	public static Image explodeSprite;
	public static Image hitmarkSprite;
	public static Image poisonSprite;
	public static Image splashSprite;
	public static Image normalMedkitSprite;
	public static Image specialMedkitSprite;
	public static Image knightSprite;
	public static Image knightDeadSprite;
	public static Image archerSprite;
	public static Image archerDeadSprite;
	public static Image wizardSprite;
	public static Image wizardDeadSprite;
	public static Image bomberSprite;
	public static Image bomberDeadSprite;
	public static Image executionerSprite;
	public static Image executionerDeadSprite;
	public static Image victorySprite;
	public static Image defeatSprite;
	public static Image preGameSprite;
	public static Image menuBg2Sprite;
	public static Image stat2Sprite;

	public ImageHolder() {
		mapSprite = new Image(ClassLoader.getSystemResource("mapbg.png").toString());
		nimbleQuestSprite = new Image(ClassLoader.getSystemResource("nimblequest.png").toString());
		axeSprite = new Image(ClassLoader.getSystemResource("axe.png").toString());
		arrowSprite = new Image(ClassLoader.getSystemResource("arrow.png").toString());
		bombSprite = new Image(ClassLoader.getSystemResource("bomb.png").toString());
		fireballSprite = new Image(ClassLoader.getSystemResource("fireball.png").toString());
		iceballSprite = new Image(ClassLoader.getSystemResource("iceball.png").toString());
		swordSprite = new Image(ClassLoader.getSystemResource("swordswing.png").toString());
		webSprite = new Image(ClassLoader.getSystemResource("web.png").toString());
		explodeSprite = new Image(ClassLoader.getSystemResource("explosive.png").toString());
		hitmarkSprite = new Image(ClassLoader.getSystemResource("hitmark.png").toString());
		poisonSprite = new Image(ClassLoader.getSystemResource("poison.png").toString());
		splashSprite = new Image(ClassLoader.getSystemResource("poisonsplash.png").toString());
		normalMedkitSprite = new Image(ClassLoader.getSystemResource("normalheart.png").toString());
		specialMedkitSprite = new Image(ClassLoader.getSystemResource("specialheart.png").toString());
		knightSprite = new Image(ClassLoader.getSystemResource("knight_icon.png").toString());
		knightDeadSprite = new Image(ClassLoader.getSystemResource("knightdead.png").toString());
		archerSprite = new Image(ClassLoader.getSystemResource("archer_icon.png").toString());
		archerDeadSprite = new Image(ClassLoader.getSystemResource("archerdead.png").toString());
		wizardSprite = new Image(ClassLoader.getSystemResource("wizard_icon.png").toString());
		wizardDeadSprite = new Image(ClassLoader.getSystemResource("wizarddead.png").toString());
		bomberSprite = new Image(ClassLoader.getSystemResource("bomber_icon.png").toString());
		bomberDeadSprite = new Image(ClassLoader.getSystemResource("bomberdead.png").toString());
		executionerSprite = new Image(ClassLoader.getSystemResource("executioner_icon.png").toString());
		executionerDeadSprite = new Image(ClassLoader.getSystemResource("executionerdead.png").toString());
		victorySprite = new Image(ClassLoader.getSystemResource("alliesvictory.png").toString());
		defeatSprite = new Image(ClassLoader.getSystemResource("alliesdefeat.png").toString());
		preGameSprite = new Image(ClassLoader.getSystemResource("pregame.png").toString());
		stat2Sprite = new Image(ClassLoader.getSystemResource("statformat2.png").toString());
		menuBg2Sprite = new Image(ClassLoader.getSystemResource("menubg2.png").toString());
	}

	public static ImageHolder getInstance() {
		return instance;
	}
}
