package projectile;

import constants.ImageHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import render.IRenderable;

public class Impact implements IRenderable {
	
	protected Coordinate coordinate;
	protected boolean isRemove;
	protected boolean isVisible;
	
	

	public Impact(Coordinate coordinate) {
		setCoordinate(coordinate);
		setRemove(false);
		setVisible(true);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ImageHolder.hitmarkSprite, coordinate.getX(), coordinate.getY());
		setVisible(false);
		setRemove(true);
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	@Override
	public boolean isRemove() {
		// TODO Auto-generated method stub
		return isRemove;
	}

}
