package character.enemy;


import character.base.Enemy;
import javafx.scene.image.Image;
import logic.Coordinate;
import projectile.Fireball;
import projectile.Projectile;


public class Sorcerer extends Enemy {
	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("sorcerer1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("sorcerer2.png").toString());

	public  Sorcerer(int maxHp, int maxCd) {
		super("Sorcerer", maxHp, maxCd);
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
		return (Projectile)(new Fireball(12, (int)(2*range/Fireball.getBaseVelocity()), coordinate, destination));
	}
}
