package logic;

import character.enemy.*;
import constants.GameUnit;

public class WaveSystem {
	
	private int waveCount;
	private int enemyCount;
	
	private static final Coordinate centerMiddle = new Coordinate(GameUnit.MAP_WIDTH/2,GameUnit.MAP_HEIGHT/2);
	private static final Coordinate centerBottom = new Coordinate(GameUnit.MAP_WIDTH/2,GameUnit.MAP_HEIGHT-GameUnit.UNIT_SIZE);
	private static final Coordinate centerTop = new Coordinate(GameUnit.MAP_WIDTH/2,0);
	private static final Coordinate leftMiddle = new Coordinate(0,GameUnit.MAP_HEIGHT/2);
	private static final Coordinate leftBottom = new Coordinate(GameUnit.UNIT_SIZE,GameUnit.MAP_HEIGHT-GameUnit.UNIT_SIZE);
	private static final Coordinate leftTop = new Coordinate(0,0);
	private static final Coordinate rightMiddle = new Coordinate(GameUnit.MAP_WIDTH-GameUnit.UNIT_SIZE,GameUnit.MAP_HEIGHT/2);
	private static final Coordinate rightBottom = new Coordinate(GameUnit.MAP_WIDTH-GameUnit.UNIT_SIZE,GameUnit.MAP_HEIGHT-GameUnit.UNIT_SIZE);
	private static final Coordinate rightTop = new Coordinate(GameUnit.MAP_WIDTH-GameUnit.UNIT_SIZE,0);
	
	
	public WaveSystem() {
		setWaveCount(0);
		setEnemyCount(0);
		GameStat.reset();
	}
	
	public void nextWave() {
		if (waveCount<=1) {
			// 2 bat
			CurrentEnemy bat1 = new CurrentEnemy();
			bat1.addEnemy(new Bat(20,0), leftTop);
			CurrentEnemy bat2 = new CurrentEnemy();
			bat2.addEnemy(new Bat(20,0), rightTop);
			GameSystem.getInstance().gameScreen.initObject(bat1);
			GameSystem.getInstance().gameScreen.initObject(bat2);
			setEnemyCount(2);
		}
		else if (waveCount==2) {
			// 6 bat
			CurrentEnemy bat1 = new CurrentEnemy();
			bat1.addEnemy(new Bat(100,0), leftTop);
			CurrentEnemy bat2 = new CurrentEnemy();
			bat2.addEnemy(new Bat(100,0), rightTop);
			CurrentEnemy bat3 = new CurrentEnemy();
			bat3.addEnemy(new Bat(100,0), leftMiddle);
			CurrentEnemy bat4 = new CurrentEnemy();
			bat4.addEnemy(new Bat(100,0), rightMiddle);
			CurrentEnemy bat5 = new CurrentEnemy();
			bat5.addEnemy(new Bat(100,0), leftBottom);
			CurrentEnemy bat6 = new CurrentEnemy();
			bat6.addEnemy(new Bat(100,0), rightBottom);
			GameSystem.getInstance().gameScreen.initObject(bat1);
			GameSystem.getInstance().gameScreen.initObject(bat2);
			GameSystem.getInstance().gameScreen.initObject(bat3);
			GameSystem.getInstance().gameScreen.initObject(bat4);
			GameSystem.getInstance().gameScreen.initObject(bat5);
			GameSystem.getInstance().gameScreen.initObject(bat6);
			setEnemyCount(6);
		}
		else if (waveCount==3) {
			// 1 List of bat-spider-bat
			CurrentEnemy set1 = new CurrentEnemy();
			set1.addEnemy(new Bat(200,0), leftTop);
			set1.addEnemy(new Bat(200,0), leftTop);
			set1.addEnemy(new Bat(200,0), leftTop);
			GameSystem.getInstance().gameScreen.initObject(set1);
			setEnemyCount(1);
			
		}
		else if (waveCount==4) {
			// 3 spiders
			CurrentEnemy spider1 = new CurrentEnemy();
			spider1.addEnemy(new Spider(100,8), leftTop);
			CurrentEnemy spider2 = new CurrentEnemy();
			spider2.addEnemy(new Spider(100,8), rightTop);
			CurrentEnemy spider3 = new CurrentEnemy();
			spider3.addEnemy(new Spider(100,8), leftMiddle);
			GameSystem.getInstance().gameScreen.initObject(spider1);
			GameSystem.getInstance().gameScreen.initObject(spider2);
			GameSystem.getInstance().gameScreen.initObject(spider3);
			setEnemyCount(3);
			
		}
		else if (waveCount==5) {
			// 2 List of bat-spider-bat
			CurrentEnemy set1 = new CurrentEnemy();
			set1.addEnemy(new Bat(200,0), leftTop);
			set1.addEnemy(new Spider(200,8), leftTop);
			set1.addEnemy(new Bat(200,0), leftTop);
			CurrentEnemy set2 = new CurrentEnemy();
			set2.addEnemy(new Bat(200,0), rightBottom);
			set2.addEnemy(new Spider(200,8), rightBottom);
			set2.addEnemy(new Bat(200,0), rightBottom);
			GameSystem.getInstance().gameScreen.initObject(set1);
			GameSystem.getInstance().gameScreen.initObject(set2);
			setEnemyCount(2);
		}
		else if (waveCount==6) {
			// 2 list of bat-sorcerer
			CurrentEnemy set1 = new CurrentEnemy();
			set1.addEnemy(new Bat(200,8), leftMiddle);
			set1.addEnemy(new Sorcerer(200,6), leftMiddle);
			CurrentEnemy set2 = new CurrentEnemy();;
			set2.addEnemy(new Bat(200,8), rightMiddle);
			set2.addEnemy(new Sorcerer(200,6), rightMiddle);
			CurrentEnemy set3 = new CurrentEnemy();;
			set3.addEnemy(new Bat(200,8), centerTop);
			set3.addEnemy(new Sorcerer(200,6), centerTop);
			GameSystem.getInstance().gameScreen.initObject(set1);
			GameSystem.getInstance().gameScreen.initObject(set2);
			GameSystem.getInstance().gameScreen.initObject(set3);
			setEnemyCount(3);
		}
		else if (waveCount==7) {
			// ???
			CurrentEnemy set1 = new CurrentEnemy();
			set1.addEnemy(new Bat(400,0), centerBottom);
			set1.addEnemy(new Spider(300,8), centerBottom);
			set1.addEnemy(new Sorcerer(300,6), centerBottom);
			set1.addEnemy(new Bat(400,0), centerBottom);
			set1.addEnemy(new Spider(300,8), centerBottom);
			set1.addEnemy(new Sorcerer(300,6), centerBottom);
			GameSystem.getInstance().gameScreen.initObject(set1);
			setEnemyCount(1);
			
		}
		else if (waveCount==8) {
			// ???
			CurrentEnemy bat1 = new CurrentEnemy();
			bat1.addEnemy(new Bat(400,0), leftTop);
			CurrentEnemy bat2 = new CurrentEnemy();
			bat2.addEnemy(new Bat(400,0), rightTop);
			CurrentEnemy spider1 = new CurrentEnemy();
			spider1.addEnemy(new Spider(300,8), centerTop);
			CurrentEnemy spider2 = new CurrentEnemy();
			spider2.addEnemy(new Spider(300,8), rightMiddle);
			CurrentEnemy spider3 = new CurrentEnemy();
			spider3.addEnemy(new Spider(300,8), leftMiddle);
			CurrentEnemy sorcerer1 = new CurrentEnemy();
			sorcerer1.addEnemy(new Sorcerer(300,6), rightBottom);
			CurrentEnemy sorcerer2 = new CurrentEnemy();
			sorcerer2.addEnemy(new Sorcerer(300,6), leftBottom);
			CurrentEnemy sorcerer3 = new CurrentEnemy();
			sorcerer3.addEnemy(new Sorcerer(300,6), leftBottom);
			GameSystem.getInstance().gameScreen.initObject(bat1);
			GameSystem.getInstance().gameScreen.initObject(bat2);
			GameSystem.getInstance().gameScreen.initObject(spider1);
			GameSystem.getInstance().gameScreen.initObject(spider2);
			GameSystem.getInstance().gameScreen.initObject(spider3);
			GameSystem.getInstance().gameScreen.initObject(sorcerer1);
			GameSystem.getInstance().gameScreen.initObject(sorcerer2);
			GameSystem.getInstance().gameScreen.initObject(sorcerer3);
			setEnemyCount(8);
		}
		 else if (waveCount==9) {
			// 3 list of sorcerer-sorcerer-sorcerer
			CurrentEnemy set1 = new CurrentEnemy();
			set1.addEnemy(new Sorcerer(300,6), leftTop);
			set1.addEnemy(new Sorcerer(300,6), leftTop);
			set1.addEnemy(new Sorcerer(300,6), leftTop);
			CurrentEnemy set2 = new CurrentEnemy();;
			set2.addEnemy(new Sorcerer(300,6), rightMiddle);
			set2.addEnemy(new Sorcerer(300,6), rightMiddle);
			set2.addEnemy(new Sorcerer(300,6), rightMiddle);
			CurrentEnemy set3 = new CurrentEnemy();;
			set3.addEnemy(new Sorcerer(300,6), centerBottom);
			set3.addEnemy(new Sorcerer(300,6), centerBottom);
			set3.addEnemy(new Sorcerer(300,6), centerBottom);
			GameSystem.getInstance().gameScreen.initObject(set1);
			GameSystem.getInstance().gameScreen.initObject(set2);
			GameSystem.getInstance().gameScreen.initObject(set3);
			setEnemyCount(3);
		}
		else if (waveCount==10) {
			// boss wave
			CurrentEnemy boss = new CurrentEnemy();
			boss.addEnemy(new Boss(1800,12),centerMiddle);
			CurrentEnemy bat1 = new CurrentEnemy();
			bat1.addEnemy(new Bat(150,0), leftTop);
			CurrentEnemy bat2 = new CurrentEnemy();
			bat2.addEnemy(new Bat(150,0), rightTop);
			CurrentEnemy bat3 = new CurrentEnemy();
			bat3.addEnemy(new Bat(150,0), leftMiddle);
			CurrentEnemy bat4 = new CurrentEnemy();
			bat4.addEnemy(new Bat(150,0), rightMiddle);
			CurrentEnemy bat5 = new CurrentEnemy();
			bat5.addEnemy(new Bat(150,0), leftBottom);
			CurrentEnemy bat6 = new CurrentEnemy();
			bat6.addEnemy(new Bat(150,0), rightBottom);
			CurrentEnemy bat7 = new CurrentEnemy();
			bat7.addEnemy(new Bat(150,0), centerBottom);
			CurrentEnemy bat8 = new CurrentEnemy();
			bat8.addEnemy(new Bat(150,0), centerTop);
			GameSystem.getInstance().gameScreen.initObject(boss);
			GameSystem.getInstance().gameScreen.initObject(bat1);
			GameSystem.getInstance().gameScreen.initObject(bat2);
			GameSystem.getInstance().gameScreen.initObject(bat3);
			GameSystem.getInstance().gameScreen.initObject(bat4);
			GameSystem.getInstance().gameScreen.initObject(bat5);
			GameSystem.getInstance().gameScreen.initObject(bat6);
			GameSystem.getInstance().gameScreen.initObject(bat7);
			GameSystem.getInstance().gameScreen.initObject(bat8);
			setEnemyCount(9);
		}
		else {
			// change to Victory Pane
			GameStat.isVictory = true;
			GameStat.isGameOver = true;
		}
	}

	public int getWaveCount() {
		return waveCount;
	}

	public void setWaveCount(int waveCount) {
		this.waveCount = waveCount;
		GameStat.waveCount = this.waveCount;
	}
	
	public void allEnemyKilled() {
		setEnemyCount(getEnemyCount()-1);
		if (enemyCount==0) {
			GameSystem.getInstance().statPane.nextWave();
		}
	}

	public int getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount>0 ? enemyCount : 0;
	}

}
