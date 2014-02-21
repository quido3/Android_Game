package com.home.game.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Movable {

	public enum State {
		IDLE, WALKING, DYING, ATTACKING
	}

	public enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

	public enum Image {
		HERO, MONSTER, NPC
	}

	private float SPEED = 4f; // unit per second
	private float SIZE = 0.5f; // half a unit
	private Image image;
	private Direction direction;

	Vector2 position = new Vector2();
	Vector2 velocity = new Vector2();
	Rectangle bounds = new Rectangle();
	State state = State.IDLE;
	float stateTime = 0;

	public Movable(float SPEED, float SIZE, Image image, Vector2 position) {
		this.SPEED = SPEED;
		this.SIZE = SIZE;
		this.image = image;
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}

	public void setState(State newState) {
		this.state = newState;
	}

	public void update(float delta) {		
		stateTime += delta;
		position.add(velocity.cpy().scl(delta));
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setFacing(Direction direction) {
		this.direction = direction;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public State getState() {
		return state;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}

	public float getSize() {
		return this.SIZE;
	}

	public float getSpeed() {
		return this.SPEED;
	}

	public Vector2 getVelocity() {
		return this.velocity;
	}

	public void setVelocityX(float speedX) {
		this.velocity.x = speedX;
	}

	public void setVelocityY(float speedY) {
		this.velocity.y = speedY;
	}
}
