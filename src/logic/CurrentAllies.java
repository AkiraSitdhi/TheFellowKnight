package logic;

import java.util.ArrayList;
import java.util.LinkedList;

import character.allies.*;
import character.base.Allies;
import constants.GameUnit;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import projectile.Projectile;
import render.IRenderable;
import render.RenderableHolder;

public class CurrentAllies implements IRenderable,Updatable {

	private LinkedList<Coordinate> alliesCoordinateList;
	private ArrayList<Allies> alliesList;
	private boolean isLeft;
	private int counter;
	private boolean isVisible=true;
	private boolean isRemove=false;

	public CurrentAllies() {
		this.counter=0;
		initCoordinateList();
		initAlliesList();
		setLeft(true);
	}

	public void initCoordinateList() {
		this.alliesCoordinateList = new LinkedList<Coordinate>();
		alliesCoordinateList.add(new Coordinate(480, 640));
		alliesCoordinateList.add(new Coordinate(480, 680));
		alliesCoordinateList.add(new Coordinate(480, 720));
		alliesCoordinateList.add(new Coordinate(480, 760));
		alliesCoordinateList.add(new Coordinate(480, 800));
	}

	public void initAlliesList() {
		this.alliesList = new ArrayList<Allies>();
		alliesList.add(new Knight());
		alliesList.add(new Archer());
		alliesList.add(new Wizard());
		alliesList.add(new Bomber());
		alliesList.add(new Executioner());		
	}

	public boolean isAttackable(Coordinate alliesCoordinate, Coordinate enemyCoordinate, double range) {
		return Math.hypot(enemyCoordinate.getX() - alliesCoordinate.getX(), enemyCoordinate.getY() - alliesCoordinate.getY()) <= range*GameUnit.UNIT_SIZE;
	}

	public void update() {
		if (counter == 3) {
			counter = 0;
			setLeft(!isLeft);
		}
		counter++;
		// Check if allies are all dead
		if (alliesList.isEmpty()) {
			GameStat.defeatReason="All of your allies have been defeated...";
			GameStat.isGameOver=true;
			return;
		}
		// Update Position
		double front_x = alliesCoordinateList.get(0).getX();
		double front_y = alliesCoordinateList.get(0).getY();
		if (InputUtility.isUp()) {
			alliesCoordinateList.add(0, new Coordinate(front_x, front_y - GameUnit.UNIT_SIZE));
			alliesCoordinateList.remove(alliesCoordinateList.size() - 1);
		}
		if (InputUtility.isRight()) {
			alliesCoordinateList.add(0, new Coordinate(front_x + GameUnit.UNIT_SIZE, front_y));
			alliesCoordinateList.remove(alliesCoordinateList.size() - 1);
		}
		if (InputUtility.isDown()) {
			alliesCoordinateList.add(0, new Coordinate(front_x, front_y + GameUnit.UNIT_SIZE));
			alliesCoordinateList.remove(alliesCoordinateList.size() - 1);
		}
		if (InputUtility.isLeft()) {
			alliesCoordinateList.add(0, new Coordinate(front_x - GameUnit.UNIT_SIZE, front_y));
			alliesCoordinateList.remove(alliesCoordinateList.size() - 1);
		}
		// Check if allies can attack enemy
		for (int i=0;i<alliesList.size();i++) {
			boolean hasAtk = false;
			alliesList.get(i).setCurCd(alliesList.get(i).getCurCd()-1);
			if (alliesList.get(i).getCurCd()==0) {
				for (int k=0;k<RenderableHolder.getInstance().getEntities().size();k++) {
					if (hasAtk) break;
					if (RenderableHolder.getInstance().getEntities().get(k) instanceof CurrentEnemy) {
						CurrentEnemy currentEnemy = (CurrentEnemy) RenderableHolder.getInstance().getEntities().get(k);
						for (int j=0;j<currentEnemy.getEnemyList().size();j++) {
							if (isAttackable(alliesCoordinateList.get(i), currentEnemy.getEnemyCoordinateList().get(j), alliesList.get(i).getRange())) {
//								initProjectile.add(alliesList.get(i).attack(alliesCoordinateList.get(i), currrentEnemy.getEnemyCoordinateList().get(j)));
								hasAtk=true;
								Projectile projectile = alliesList.get(i).attack(alliesCoordinateList.get(i), currentEnemy.getEnemyCoordinateList().get(j));
								if (projectile!=null) {
									GameSystem.getInstance().gameScreen.initObject(projectile);
									//RenderableHolder.getInstance().add(projectile);
								}
								alliesList.get(i).setCurCd(alliesList.get(i).getMaxCd());
								break;
							}
						}
					}
				}
			}
		}

		// Check if collide with map boarder
		front_x = alliesCoordinateList.get(0).getX();
		front_y = alliesCoordinateList.get(0).getY();
		if (front_x < GameUnit.UNIT_SIZE 
				|| front_x >= GameUnit.MAP_WIDTH - GameUnit.UNIT_SIZE
				|| front_y < GameUnit.UNIT_SIZE
				|| front_y >= GameUnit.MAP_HEIGHT - GameUnit.UNIT_SIZE) {
			GameStat.defeatReason="You have run out of map boundary...";
			GameStat.isGameOver=true;		}
		
		// Check if collide with ourselves
		for (int i = 1; i < alliesList.size(); i++) {
			if (alliesCoordinateList.get(i).getX() == front_x && alliesCoordinateList.get(i).getY() == front_y) {
				GameStat.defeatReason="You have run into yourselves...";
				GameStat.isGameOver=true;
				return;
			}
		}
		// Check if collide with enemy
		for (int k=0;k<RenderableHolder.getInstance().getEntities().size();k++) {
			if (RenderableHolder.getInstance().getEntities().get(k) instanceof CurrentEnemy) {
				CurrentEnemy currentEnemy = (CurrentEnemy) RenderableHolder.getInstance().getEntities().get(k);
				for (int j=0;j<currentEnemy.getEnemyList().size();j++) {
					if (alliesCoordinateList.get(0).getX()==currentEnemy.getEnemyCoordinateList().get(j).getX() &&
							alliesCoordinateList.get(0).getY()==currentEnemy.getEnemyCoordinateList().get(j).getY()) {
						GameStat.defeatReason="You have run into enemy...";
						GameStat.isGameOver=true;
						return;
					}
				}
			}
		}	
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < alliesList.size(); i++) {
			if (isLeft) {
				gc.drawImage(alliesList.get(i).getImageLeft(), alliesCoordinateList.get(i).getX(),
						alliesCoordinateList.get(i).getY());
			} else {
				gc.drawImage(alliesList.get(i).getImageRight(), alliesCoordinateList.get(i).getX(),
						alliesCoordinateList.get(i).getY());
			}
			
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(2.0);
			gc.strokeRect(alliesCoordinateList.get(i).getX()+4, alliesCoordinateList.get(i).getY()-3, 32, 8);
			gc.setFill(Color.GREEN);
			gc.fillRect(alliesCoordinateList.get(i).getX()+5 , alliesCoordinateList.get(i).getY()-2, 
					30*alliesList.get(i).getCurHp()/alliesList.get(i).getMaxHp(), 6);
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
		for (int i = alliesList.size() - 1; i >= 0; i--) {
			alliesList.get(i).updateGameStat();
			if (alliesList.get(i).getCurHp() == 0) {
				alliesList.remove(i);
			}
		}
		return isRemove;
	}
	

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}


	public ArrayList<Allies> getAlliesList() {
		return alliesList;
	}
	
	public LinkedList<Coordinate> getAlliesCoordinateList() {
		return alliesCoordinateList;
	}


}
