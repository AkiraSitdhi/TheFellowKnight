package projectile;

import java.util.List;

import character.base.Character;
import constants.GameUnit;
import constants.ImageHolder;
import constants.SoundHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import logic.CurrentEnemy;
import logic.GameSystem;
import render.IRenderable;

public class Bomb extends Projectile implements IRenderable{

	public Bomb(int damage, int timer, Coordinate coordinate, Coordinate destination) {
		super(damage, timer, coordinate, destination);
		setAngle(calculateAngle(coordinate,destination));
		setBaseVelocity(0.6);
		setVelocity(coordinate, destination);
	}

	

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 17;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		//gc.draw(RenderableHolder.axeSprite ,getCoordinate().getX(), getCoordinate().getY()); // if keep picture in renderable holder
		gc.drawImage(rotateImage(ImageHolder.bombSprite, angle), getCoordinate().getX(), getCoordinate().getY());
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
							coordinate.getY()-target.getEnemyCoordinateList().get(i).getY()) <= GameUnit.UNIT_SIZE/2*3) {
						SoundHolder.getInstance().explodeSfx.play(0.1D);
						trigger(target.getEnemyList().get(i));
						GameSystem.getInstance().gameScreen.initObject(new Impact(target.getEnemyCoordinateList().get(i)));
						GameSystem.getInstance().gameScreen.initObject(new Explode(target.getEnemyCoordinateList().get(i)));
						//RenderableHolder.getInstance().add(new Impact(target.getEnemyCoordinateList().get(i)));
						//RenderableHolder.getInstance().add(new Explode(target.getEnemyCoordinateList().get(i)));
						for (int j=0;j<target.getEnemyList().size();j++) {
							if (j!=i && Math.abs(target.getEnemyCoordinateList().get(j).getX()-target.getEnemyCoordinateList().get(i).getX())<=GameUnit.UNIT_SIZE
									&& Math.abs(target.getEnemyCoordinateList().get(j).getY()-target.getEnemyCoordinateList().get(i).getY())<=GameUnit.UNIT_SIZE) {
								trigger(target.getEnemyList().get(j));
								GameSystem.getInstance().gameScreen.initObject(new Impact(target.getEnemyCoordinateList().get(j)));
								//RenderableHolder.getInstance().add(new Impact(target.getEnemyCoordinateList().get(j)));
							}
						}
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
