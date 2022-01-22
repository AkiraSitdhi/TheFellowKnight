package projectile;

import constants.GameUnit;
import constants.ImageHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import render.IRenderable;

public class Explode extends Impact implements IRenderable{
	
	public Explode(Coordinate coordinate) {
		super(coordinate);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ImageHolder.explodeSprite, coordinate.getX()-GameUnit.UNIT_SIZE, coordinate.getY()-GameUnit.UNIT_SIZE);
		setVisible(false);
		setRemove(true);
	}
}
