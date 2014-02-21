package com.home.game.actors;

import com.badlogic.gdx.math.Vector2;

public class Hero extends Movable {

	String name;

	public Hero(String name, float SPEED, float SIZE, int x, int y) {
		super(SPEED, SIZE, Image.HERO, new Vector2(x, y));

		this.name = name;
	}
}
