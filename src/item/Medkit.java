package item;

import logic.Coordinate;
import logic.CurrentAllies;
import logic.Updatable;

public abstract class Medkit implements Updatable {
	
	protected Coordinate coordinate;
	protected int timer;
	protected boolean isVisible;
	protected boolean isRemove;
	
	public Medkit(Coordinate coordinate) {
		setCoordinate(coordinate);
		setTimer(60);
		setVisible(true);
		setRemove(false);
	}
	
	public abstract void heal(CurrentAllies currentAllies);
	
	public abstract void update();

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer>0 ? timer : 0;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

}
