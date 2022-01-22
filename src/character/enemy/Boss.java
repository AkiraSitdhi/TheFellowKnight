package character.enemy;

import character.base.Enemy;
import javafx.scene.image.Image;
import logic.Coordinate;
import projectile.Poison;
import projectile.Projectile;

public class Boss extends Enemy {
	
	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("boss1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("boss2.png").toString());

	public Boss(int maxHp, int maxCd) {
		super("Boss", maxHp, maxCd);
		setRange(6);
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
		return (Projectile)(new Poison(12, (int)(2*range/Poison.getBaseVelocity()), coordinate, destination));
	}

}
