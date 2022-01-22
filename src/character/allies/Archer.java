package character.allies;

import character.base.Allies;
import javafx.scene.image.Image;
import logic.Coordinate;
import logic.GameStat;
import projectile.Arrow;
import projectile.Projectile;

public class Archer extends Allies {

	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("archer1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("archer2.png").toString());

	public Archer() {
		super("Archer", 80, 6);
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
		return (Projectile) (new Arrow(20, (int) (2 * range / Arrow.getBaseVelocity()), coordinate, destination));
	}

	@Override
	public void updateGameStat() {
		// TODO Auto-generated method stub
		GameStat.archerHp = 1.0 * this.curHp / this.maxHp;
	}
}
