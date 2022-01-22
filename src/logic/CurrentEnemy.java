package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import character.base.Enemy;
import character.enemy.*;
import constants.GameUnit;
import item.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import projectile.Projectile;
import render.IRenderable;
import render.RenderableHolder;

public class CurrentEnemy implements IRenderable, Updatable {

	private LinkedList<Coordinate> enemyCoordinateList;
	private ArrayList<Enemy> enemyList;
	private boolean isLeft;
	private int counter;
	private boolean isVisible = true;
	private boolean isRemove = false;

	public CurrentEnemy() {
		this.counter = 0;
		this.enemyList = new ArrayList<Enemy>();
		this.enemyCoordinateList = new LinkedList<Coordinate>();
		setLeft(true);
	}

	public void addEnemy(Enemy enemy, Coordinate coordinate) {
		enemyList.add(enemy);
		enemyCoordinateList.add(coordinate);
	}

	public Coordinate getAlliesDistance(Coordinate alliesPosition) {
		return new Coordinate(alliesPosition.getX() - enemyCoordinateList.get(0).getX(),
				alliesPosition.getY() - enemyCoordinateList.get(0).getY());
	}

	public boolean isAttackable(Coordinate alliesCoordinate, Coordinate enemyCoordinate, double range) {
		return Math.hypot(enemyCoordinate.getX() - alliesCoordinate.getX(),
				enemyCoordinate.getY() - alliesCoordinate.getY()) <= range * GameUnit.UNIT_SIZE;
	}

	public void update() {
		counter++;
		// Update enemy position
		if (counter == 3) {
			counter = 0;
			setLeft(!isLeft);
			// Make enemy move in direction of allies at front
			double front_x = enemyCoordinateList.get(0).getX();
			double front_y = enemyCoordinateList.get(0).getY();
			for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
				if (entity instanceof CurrentAllies) {
					Coordinate alliesCoordinate = ((CurrentAllies) entity).getAlliesCoordinateList().get(0);
					double dx = getAlliesDistance(alliesCoordinate).getX();
					double dy = getAlliesDistance(alliesCoordinate).getY();
					if (Math.abs(dx) >= Math.abs(dy)) {
						if (dx >= 0) {
							enemyCoordinateList.add(0, new Coordinate(front_x + GameUnit.UNIT_SIZE, front_y));
						} else {
							enemyCoordinateList.add(0, new Coordinate(front_x - GameUnit.UNIT_SIZE, front_y));
						}
					} else {
						if (dy >= 0) {
							enemyCoordinateList.add(0, new Coordinate(front_x, front_y + GameUnit.UNIT_SIZE));
						} else {
							enemyCoordinateList.add(0, new Coordinate(front_x, front_y - GameUnit.UNIT_SIZE));
						}
					}

					enemyCoordinateList.remove(enemyCoordinateList.size() - 1);
					break;
				}
			}
		}
		// Check if enemy can attack allies
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).setCurCd(enemyList.get(i).getCurCd() - 1);
			if (enemyList.get(i).getCurCd() == 0) {
				for (int k = 0; k < RenderableHolder.getInstance().getEntities().size(); k++) {
					if (RenderableHolder.getInstance().getEntities().get(k) instanceof CurrentAllies) {
						CurrentAllies currentAllies = (CurrentAllies) RenderableHolder.getInstance().getEntities()
								.get(k);
						for (int j = 0; j < currentAllies.getAlliesList().size(); j++) {
							if (isAttackable(enemyCoordinateList.get(i), currentAllies.getAlliesCoordinateList().get(j),
									enemyList.get(i).getRange())) {
								Projectile projectile = enemyList.get(i).attack(enemyCoordinateList.get(i),
										currentAllies.getAlliesCoordinateList().get(j));
								if (projectile != null) {
									GameSystem.getInstance().gameScreen.initObject(projectile);
								}
								enemyList.get(i).setCurCd(enemyList.get(i).getMaxCd());
							
								break;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < enemyList.size(); i++) {
			if (isLeft) {
				gc.drawImage(enemyList.get(i).getImageLeft(), enemyCoordinateList.get(i).getX(),
						enemyCoordinateList.get(i).getY());
			} else {
				gc.drawImage(enemyList.get(i).getImageRight(), enemyCoordinateList.get(i).getX(),
						enemyCoordinateList.get(i).getY());
			}
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(2.0);
			gc.strokeRect(enemyCoordinateList.get(i).getX() + 4, enemyCoordinateList.get(i).getY() - 3, 32, 8);
			gc.setFill(Color.RED);
			gc.fillRect(enemyCoordinateList.get(i).getX() + 5, enemyCoordinateList.get(i).getY() - 2,
					30 * enemyList.get(i).getCurHp() / enemyList.get(i).getMaxHp(), 6);
		}
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

	@Override
	public boolean isRemove() {
		// TODO Auto-generated method stub
		for (int i = enemyList.size() - 1; i >= 0; i--) {
			if (enemyList.get(i).getCurHp() == 0) {
				GameStat.increaseEnemyKill();
				Random rand = new Random();
				int seed = rand.nextInt(100);
				if (seed < 25) {
					GameSystem.getInstance().gameScreen.initObject(new NormalMedkit(getEnemyCoordinateList().get(i)));
				} else if (seed > 91) {
					GameSystem.getInstance().gameScreen.initObject(new SpecialMedkit(getEnemyCoordinateList().get(i)));
				}
				enemyList.remove(i);
			}
		}
		if (enemyList.isEmpty()) {
			GameSystem.getInstance().gameScreen.getWaveSystem().allEnemyKilled();
			return true;
		}
		return false;
	}
	
	private void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public LinkedList<Coordinate> getEnemyCoordinateList() {
		return enemyCoordinateList;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

}
