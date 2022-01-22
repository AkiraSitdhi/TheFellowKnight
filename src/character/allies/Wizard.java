package character.allies;

import character.base.Allies;
import javafx.scene.image.Image;
import logic.Coordinate;
import logic.GameStat;
import projectile.Iceball;
import projectile.Projectile;

public class Wizard extends Allies {
	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("wizard1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("wizard2.png").toString());
	
	public Wizard(){
		super("Wizard", 60, 9);
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
	
	@Override
	public Projectile attack(Coordinate coordinate, Coordinate destination) {
		// TODO Auto-generated method stub
		return (Projectile)(new Iceball(40, (int)(2*range/Iceball.getBaseVelocity()), coordinate, destination));
	}
	@Override
	public void updateGameStat() {
		// TODO Auto-generated method stub
		GameStat.wizardHp = 1.0*this.curHp/this.maxHp;
	}

}
