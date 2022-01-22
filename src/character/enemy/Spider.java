package character.enemy;



import character.base.Enemy;
import javafx.scene.image.Image;
import logic.Coordinate;
import projectile.Projectile;
import projectile.Web;

public class Spider extends Enemy{
	
	public static final Image imgLeft = new Image(ClassLoader.getSystemResource("spider1.png").toString());
	public static final Image imgRight = new Image(ClassLoader.getSystemResource("spider2.png").toString());

	public  Spider(int maxHp, int maxCd) {
		super("Spider", maxHp, maxCd);
		setRange(7);
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
		return (Projectile)(new Web(8, (int)(2*range/Web.getBaseVelocity()), coordinate, destination));
	}

}
