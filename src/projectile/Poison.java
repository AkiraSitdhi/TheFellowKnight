package projectile;

import java.util.List;

import character.base.Character;
import constants.GameUnit;
import constants.ImageHolder;
import constants.SoundHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import logic.CurrentAllies;
import logic.GameSystem;
import render.IRenderable;

public class Poison extends Projectile implements IRenderable {

	public Poison(int damage, int timer, Coordinate coordinate, Coordinate destination) {
		super(damage, timer, coordinate, destination);
		setAngle(calculateAngle(coordinate,destination));
		setBaseVelocity(0.8);
		setVelocity(coordinate, destination);
	}


	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		//gc.draw(RenderableHolder.axeSprite ,getCoordinate().getX(), getCoordinate().getY()); // if keep picture in renderable holder
		gc.drawImage(rotateImage(ImageHolder.poisonSprite, angle), getCoordinate().getX(), getCoordinate().getY());
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
			if (entity.get(e) instanceof CurrentAllies) {
				CurrentAllies target = (CurrentAllies) entity.get(e);
				for (int i = 0; i < target.getAlliesList().size(); i++) {
					if (Math.hypot(coordinate.getX()-target.getAlliesCoordinateList().get(i).getX(),
							coordinate.getY()-target.getAlliesCoordinateList().get(i).getY()) <= GameUnit.UNIT_SIZE/2*3) {
						SoundHolder.getInstance().splashSfx.play(0.2D);
						trigger(target.getAlliesList().get(i));
						GameSystem.getInstance().gameScreen.initObject(new Impact(target.getAlliesCoordinateList().get(i)));
						GameSystem.getInstance().gameScreen.initObject(new Splash(target.getAlliesCoordinateList().get(i)));
						for (int j=0;j<target.getAlliesList().size();j++) {
							if (j!=i && Math.abs(target.getAlliesCoordinateList().get(j).getX()-target.getAlliesCoordinateList().get(i).getX())<=GameUnit.UNIT_SIZE
									&& Math.abs(target.getAlliesCoordinateList().get(j).getY()-target.getAlliesCoordinateList().get(i).getY())<=GameUnit.UNIT_SIZE) {
								trigger(target.getAlliesList().get(j));
								GameSystem.getInstance().gameScreen.initObject(new Impact(target.getAlliesCoordinateList().get(j)));
								//RenderableHolder.getInstance().add(new Impact(target.getAlliesCoordinateList().get(j)));
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
