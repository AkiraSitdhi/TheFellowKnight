package projectile;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import logic.CurrentEnemy;
import logic.GameSystem;
import render.IRenderable;
import character.base.Character;
import constants.GameUnit;
import constants.ImageHolder;
import constants.SoundHolder;

public class Axe extends Projectile implements IRenderable {


	public Axe(int damage, int timer, Coordinate coordinate, Coordinate destination) {
		super(damage, timer, coordinate, destination);
		setAngle(0);
		setBaseVelocity(0.8);
		setVelocity(coordinate, destination);
	}

	

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 18;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(rotateImage(ImageHolder.axeSprite, angle), getCoordinate().getX(), getCoordinate().getY());
		setAngle((angle+15)%360);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

	@Override
	public boolean isRemove() {
		// TODO Auto-generated method stub
		return isRemove;
	}

	@Override
	public boolean isTriggerable(List<IRenderable> entity) {
		// TODO Auto-generated method stub
		for (int e = 0; e < entity.size(); e++) {
			if (entity.get(e) instanceof CurrentEnemy) {
				CurrentEnemy target = (CurrentEnemy) entity.get(e);
				for (int i = 0; i < target.getEnemyList().size(); i++) {
					if (Math.hypot(coordinate.getX()-target.getEnemyCoordinateList().get(i).getX(),
							coordinate.getY()-target.getEnemyCoordinateList().get(i).getY()) <= GameUnit.UNIT_SIZE/2) {
						//SoundHolder.getInstance().hitSfx.play(0.35D);
						trigger(target.getEnemyList().get(i));
						GameSystem.getInstance().gameScreen.initObject(new Impact(target.getEnemyCoordinateList().get(i)));
						//RenderableHolder.getInstance().add(new Impact(target.getEnemyCoordinateList().get(i)));
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public void trigger(Character target) {
		// TODO Auto-generated method stub
		target.setCurHp(target.getCurHp()-damage);
	}

}
