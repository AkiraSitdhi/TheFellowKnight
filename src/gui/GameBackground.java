package gui;

import constants.GameUnit;
import constants.ImageHolder;
import javafx.scene.canvas.GraphicsContext;
import render.IRenderable;

public class GameBackground implements IRenderable {

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ImageHolder.mapSprite, 0, 0, GameUnit.MAP_WIDTH, GameUnit.MAP_HEIGHT);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isRemove() {
		// TODO Auto-generated method stub
		return false;
	}

}
