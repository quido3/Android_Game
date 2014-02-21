package com.home.game.actors;

import com.badlogic.gdx.math.Rectangle;

public class Tile {

	public static final float SIZE = 1f;
	
	private int ID;
	private int xCord, yCord;
	
	boolean trapped;
	boolean interact;
	boolean walkable;
	INTERACTSTYLE istyle;
	TRAPSTYLE tstyle;
	TILEIMAGE image;
	Rectangle bounds = new Rectangle();

	public enum INTERACTSTYLE {
		LEVER, ELEVATOR, STAIRS, BUTTON
	}

	public enum TRAPSTYLE {
		POISON, FIRE, SPIKE
	}

	public enum TILEIMAGE {
		FLOOR, ROOF, WOOD, STAIR, FLOOR2
	}

	public Tile(int x, int y, TILEIMAGE image, boolean walkable) {
		this.xCord = x;
		this.yCord = y;
		this.image = image;
		this.bounds.setX(x);
		this.bounds.setY(y);
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		this.walkable = walkable;
	}

	public void setTStyle(TRAPSTYLE tstyle) {
		trapped = true;
		this.tstyle = tstyle;
	}

	public void setIStyle(INTERACTSTYLE istyle) {
		interact = true;
		this.istyle = istyle;
	}

	public int getXCord() {
		return xCord;
	}

	public int getYCord() {
		return yCord;
	}

	public float getSize() {
		return SIZE;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public TILEIMAGE getImage() {
		return this.image;
	}
	
	public boolean isWalkable(){
		return walkable;
	}
}
