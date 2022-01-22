package character.enemy;

import character.base.Enemy;
import javafx.scene.image.Image;
import logic.Coordinate;
import projectile.Projectile;

public class Bat extends Enemy {

	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("bat1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("bat2.png").toString());
	
	// Bat can't attack, but can crash into allies
	
	public Bat(int maxHp, int maxCd) {
		super("Bat", maxHp, maxCd);
		setRange(0);
	}

	@Override
	public Image getImageLeft() {
		// TODO Auto-generated method stub
		return imgLeft;
	}

	@Override
	public Image getImageRight() {
		// TODO Auto-generated method stub
		return imgRight;
	}
	
	public Projectile attack(Coordinate coordinate, Coordinate destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
