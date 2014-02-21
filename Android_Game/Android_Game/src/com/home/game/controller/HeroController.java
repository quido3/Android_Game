package com.home.game.controller;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.utils.Array;
import com.home.game.actors.Hero;
import com.home.game.actors.Tile;
import com.home.game.actors.Movable.Direction;
import com.home.game.actors.Movable.State;
import com.home.game.level.GameMap;
import com.home.game.util.CollisionChecker;

public class HeroController {

	private Hero hero;
	private GameMap map;
	private Array<Tile> collideTiles;
	private int counter = 0;

	enum Keys {
		LEFT, RIGHT, UP, DOWN, ATTACK, PAUSE
	}

	static Map<Keys, Boolean> keys = new HashMap<HeroController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.ATTACK, false);
		keys.put(Keys.PAUSE, false);
	};

	public HeroController(Hero hero, GameMap map) {
		this.hero = hero;
		this.map = map;
	}

	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}

	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}

	public void upPressed() {
		keys.get(keys.put(Keys.UP, true));
	}

	public void downPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}

	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}

	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}

	public void upReleased() {
		keys.get(keys.put(Keys.UP, false));
	}

	public void downReleased() {
		keys.get(keys.put(Keys.DOWN, false));
	}

	public void update(float delta) {
		processInput();

		CollisionChecker.checkCollision(hero, delta, map);

		hero.update(delta);
		hero.getBounds().x = hero.getPosition().x;
		hero.getBounds().y = hero.getPosition().y;
	}

	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			hero.setFacing(Direction.LEFT);
			hero.setState(State.WALKING);
			hero.getVelocity().x = -hero.getSpeed();
		}
		if (keys.get(Keys.UP)) {
			hero.setFacing(Direction.UP);
			hero.setState(State.WALKING);
			hero.getVelocity().y = hero.getSpeed();
		}
		if (keys.get(Keys.DOWN)) {
			hero.setFacing(Direction.DOWN);
			hero.setState(State.WALKING);
			hero.getVelocity().y = -hero.getSpeed();
		}
		if (keys.get(Keys.RIGHT)) {
			hero.setFacing(Direction.RIGHT);
			hero.setState(State.WALKING);
			hero.getVelocity().x = hero.getSpeed();
		}

		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT))
				|| (!keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT)))) {
			hero.getVelocity().x = 0;
		}
		if ((keys.get(Keys.UP) && keys.get(Keys.DOWN))
				|| (!keys.get(Keys.UP) && !(keys.get(Keys.DOWN)))) {
			hero.getVelocity().y = 0;
		}
		if(hero.getVelocity().x != 0 && hero.getVelocity().y != 0){
			hero.setVelocityX((float)(hero.getVelocity().x/Math.pow(Math.pow(Tile.SIZE, 2)+Math.pow(Tile.SIZE, 2), 0.5)));
			hero.setVelocityY((float)(hero.getVelocity().y/(Math.pow(Math.pow(Tile.SIZE, 2)+Math.pow(Tile.SIZE, 2), 0.5))));
		}
	}
}
