package item;

import character.base.Allies;
import constants.ImageHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import logic.CurrentAllies;
import render.IRenderable;
import render.RenderableHolder;

public class NormalMedkit extends Medkit implements IRenderable {

	public NormalMedkit(Coordinate coordinate) {
		super(coordinate);
		setVisible(true);
		setRemove(false);
	}

	public void heal(CurrentAllies currentAllies) {
		for (Allies allies : currentAllies.getAlliesList()) {
			// allies.setMaxHp((int)(allies.getMaxHp()*1.1));
			allies.setCurHp(allies.getCurHp() + (int) (allies.getMaxHp() * 0.25));
		}
		setVisible(false);
		setRemove(true);
	}

	public void update() {
		// TODO Auto-generated method stub
		timer--;
		if (timer == 0) {
			setVisible(false);
			setRemove(true);
		}
		for (IRenderable obj : RenderableHolder.getInstance().getEntities()) {
			if (obj instanceof CurrentAllies) {
				CurrentAllies currentAllies = (CurrentAllies) obj;
				for (int i = 0; i < currentAllies.getAlliesList().size(); i++) {
					if (coordinate.getX() == currentAllies.getAlliesCoordinateList().get(i).getX()
							&& coordinate.getY() == currentAllies.getAlliesCoordinateList().get(i).getY()) {
						heal(currentAllies);
						return;
					}
				}
			}
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ImageHolder.normalMedkitSprite, coordinate.getX(), coordinate.getY());

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

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer > 0 ? timer : 0;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

}
