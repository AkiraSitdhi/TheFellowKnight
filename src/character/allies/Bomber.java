package character.allies;

import character.base.Allies;
import javafx.scene.image.Image;
import logic.Coordinate;
import logic.GameStat;
import projectile.Bomb;
import projectile.Projectile;

public class Bomber extends Allies {

	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("bomber1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("bomber2.png").toString());

	public Bomber() {
		super("Bomber", 70, 12);
		setRange(4);
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
		return (Projectile) (new Bomb(75, (int) (2 * range / Bomb.getBaseVelocity()), coordinate, destination));
	}

	@Override
	public void updateGameStat() {
		// TODO Auto-generated method stub
		GameStat.bomberHp = 1.0 * this.curHp / this.maxHp;
	}
}
