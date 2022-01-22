package projectile;

import java.util.List;
import character.base.Character;
import constants.GameUnit;
import constants.ImageHolder;
import constants.SoundHolder;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import logic.CurrentEnemy;
import logic.GameSystem;
import render.IRenderable;

public class SwordSwing extends Projectile implements IRenderable{
	
	public SwordSwing(int damage, int timer, Coordinate coordinate, Coordinate destination) {
		super(damage, timer, coordinate, destination);
		if (InputUtility.isLeft()) {
			setAngle(270);
		}
		else if (InputUtility.isRight()) {
			setAngle(90);
		}
		else if (InputUtility.isDown()) {
			setAngle(180);
		}
		else {
			setAngle(0);
		}
		setBaseVelocity(0);
		setVelocity(coordinate, destination);
	}

	

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		//gc.draw(RenderableHolder.axeSprite ,getCoordinate().getX(), getCoordinate().getY()); // if keep picture in renderable holder
		gc.drawImage(rotateImage(ImageHolder.swordSprite, angle), getCoordinate().getX()-2*GameUnit.UNIT_SIZE, getCoordinate().getY()-2*GameUnit.UNIT_SIZE);
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
							coordinate.getY()-target.getEnemyCoordinateList().get(i).getY()) <= GameUnit.UNIT_SIZE/2*5 && 
							((InputUtility.isLeft() && target.getEnemyCoordinateList().get(i).getX()<=coordinate.getX()) || 
							(InputUtility.isRight() && target.getEnemyCoordinateList().get(i).getX()>=coordinate.getX()) ||
							(InputUtility.isUp() && target.getEnemyCoordinateList().get(i).getY()<=coordinate.getY()) || 
							(InputUtility.isDown() && target.getEnemyCoordinateList().get(i).getY()>=coordinate.getY()))) {
						SoundHolder.getInstance().swordSfx.play(0.1D);
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
