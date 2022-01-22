package projectile;

import java.util.List;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import logic.*;
import render.*;
import character.base.Character;
import constants.GameUnit;

public abstract class Projectile implements IRenderable, Updatable {

	protected int damage;
	protected int timer;
	protected static double baseVelocity;
	protected Coordinate coordinate;
	protected Coordinate velocity;
	protected double angle;
	protected boolean isRemove;
	protected boolean isVisible;

	public Projectile(int damage, int timer, Coordinate beginning, Coordinate destination) {
		setDamage(damage);
		setTimer(timer);
		setCoordinate(beginning);
		setRemove(false);
		setVisible(true);
	}

	public abstract boolean isTriggerable(List<IRenderable> entity);

	public abstract void trigger(Character target);

	public Image rotateImage(Image image, double angle) {
		ImageView iv = new ImageView(image);
		iv.setRotate(angle);
		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);
		return iv.snapshot(params, null);
	}

	public void update() {
		if (timer <= 0) {
			setVisible(false);
			setRemove(true);
			return;
		}
		setCoordinate(new Coordinate(coordinate.getX() + velocity.getX() / 2, coordinate.getY() + velocity.getY() / 2));
		setTimer(getTimer() - 1);
	}

	// GETTERS & SETTERS
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer > 0 ? timer : 0;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getVelocity() {
		return velocity;
	}

	public double getAngle() {
		return angle;
	}

	public double calculateAngle(Coordinate coordinate, Coordinate destination) {
		double dX = destination.getX() - coordinate.getX();
		double dY = destination.getY() - coordinate.getY();
		return Math.toDegrees(Math.atan2(dY, dX));
	}

	public void setAngle(double angle) {
		this.angle = angle % 360;
	}

	public void setVelocity(Coordinate coordinate, Coordinate destination) {
		double dX = destination.getX() - coordinate.getX();
		double dY = destination.getY() - coordinate.getY();
		double distance = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
		this.velocity = new Coordinate(baseVelocity * GameUnit.UNIT_SIZE * dX / distance,
				baseVelocity * GameUnit.UNIT_SIZE * dY / distance);
	}

	public void setBaseVelocity(double baseVelocity) {
		this.baseVelocity = baseVelocity;
	}

	public static double getBaseVelocity() {
		return baseVelocity;
	}

}
