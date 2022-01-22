package character.allies;

import character.base.Allies;
import javafx.scene.image.Image;
import logic.Coordinate;
import logic.GameStat;
import projectile.Axe;
import projectile.Projectile;

public class Executioner extends Allies {
	
	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("executioner1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("executioner2.png").toString());

	public Executioner() {
		super("Executioner", 100, 12);
		setRange(5);
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
		return (Projectile)(new Axe(50, (int)(2*range/Axe.getBaseVelocity()), coordinate, destination));
	}
	@Override
	public void updateGameStat() {
		// TODO Auto-generated method stub
		GameStat.executionerHp = 1.0*this.curHp/this.maxHp;
	}

}
