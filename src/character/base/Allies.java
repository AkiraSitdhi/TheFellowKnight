package character.base;

public abstract class Allies extends Character {

	public Allies(String name, int maxHp, int maxCd) {
		super(name, maxHp, maxCd);
	}

	public abstract void updateGameStat();

}
