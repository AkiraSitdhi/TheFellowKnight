package character.allies;

import character.base.Allies;
import javafx.scene.image.Image;
import logic.Coordinate;
import logic.GameStat;
import projectile.Projectile;
import projectile.SwordSwing;

public class Knight extends Allies {
	
	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("knight1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("knight2.png").toString());

	public Knight() {
		super("Knight", 100 , 4);
		setRange(2);
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

	@Override
	public Projectile attack(Coordinate coordinate, Coordinate destination) {
		// TODO Auto-generated method stub
		return (Projectile)(new SwordSwing(75, 2, coordinate, destination));
	}

	@Override
	public void updateGameStat() {
		// TODO Auto-generated method stub
		GameStat.knightHp = 1.0*this.curHp/this.maxHp;
	}

}
