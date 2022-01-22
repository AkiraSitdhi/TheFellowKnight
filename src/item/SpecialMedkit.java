package item;

import character.base.Allies;
import constants.ImageHolder;
import javafx.scene.canvas.GraphicsContext;
import logic.Coordinate;
import logic.CurrentAllies;
import render.IRenderable;
import render.RenderableHolder;

public class SpecialMedkit extends Medkit implements IRenderable {

	public SpecialMedkit(Coordinate coordinate) {
		super(coordinate);
	}
	
	public void heal(CurrentAllies currentAllies) {
		for (Allies allies : currentAllies.getAlliesList()) {
			allies.setMaxHp((int)(allies.getMaxHp()*1.15));
			allies.setCurHp(allies.getCurHp()+(int)(allies.getMaxHp()*0.5));
		}
		setVisible(false);
		setRemove(true);
	}

	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ImageHolder.specialMedkitSprite, coordinate.getX(), coordinate.getY());
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 40;
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

	public void update() {
		// TODO Auto-generated method stub
		timer--;
		if (timer==0) {
			setVisible(false);
			setRemove(true);
		}
		for (IRenderable obj : RenderableHolder.getInstance().getEntities()) {
			if (obj instanceof CurrentAllies) {
				CurrentAllies currentAllies = (CurrentAllies) obj;
				for (int i=0;i<currentAllies.getAlliesList().size();i++) {
					if (coordinate.getX()==currentAllies.getAlliesCoordinateList().get(i).getX() &&
							coordinate.getY()==currentAllies.getAlliesCoordinateList().get(i).getY()) {
						heal(currentAllies);
						return;
					}
				}
			}
		}
	}
}
