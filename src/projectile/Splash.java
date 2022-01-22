package projectile;

import constants.GameUnit;
import constants.ImageHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import render.IRenderable;

public class Splash extends Impact implements IRenderable{
	
	public Splash(Coordinate coordinate) {
		super(coordinate);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 26;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ImageHolder.splashSprite, coordinate.getX()-GameUnit.UNIT_SIZE, coordinate.getY()-GameUnit.UNIT_SIZE);
		setVisible(false);
		setRemove(true);
	}
}
