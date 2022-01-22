package character.base;

import javafx.scene.image.Image;
import logic.Coordinate;
import projectile.Projectile;

public abstract class Character {

	protected String name;
	protected int maxHp;
	protected int curHp;
	protected int maxCd;
	protected int curCd;
	protected double range;

	public Character(String name, int maxHp, int maxCd) {
		setName(name);
		setMaxHp(maxHp);
		setCurHp(maxHp);
		setMaxCd(maxCd);
		setCurCd(0);
	}

	public abstract Image getImageLeft();

	public abstract Image getImageRight();

	// GETTER & SETTER

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public int getMaxCd() {
		return maxCd;
	}

	public void setMaxCd(int maxCd) {
		this.maxCd = maxCd;
	}

	public int getCurCd() {
		return curCd;
	}

	public void setCurCd(int curCd) {
		curCd = curCd > maxCd ? maxCd : curCd;
		this.curCd = curCd < 0 ? 0 : curCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurHp() {
		return curHp;
	}

	public void setCurHp(int curHp) {
		curHp = curHp > maxHp ? maxHp : curHp;
		this.curHp = curHp < 0 ? 0 : curHp;
	}

	public abstract Projectile attack(Coordinate coordinate, Coordinate destination);

}
