package com.home.game.util;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;
import com.home.game.actors.Movable;
import com.home.game.actors.Tile;
import com.home.game.level.GameMap;

public class CollisionChecker {

	private static Pool<Rectangle> rectPool = new Pool<Rectangle>() {
		@Override
		protected Rectangle newObject() {
			return new Rectangle();
		}
	};

	public static void checkCollision(Movable mover, float delta, GameMap map) {

		mover.getVelocity().scl(delta);

		Rectangle heroRect = rectPool.obtain();
		heroRect.set(mover.getBounds().x, mover.getBounds().y,
				mover.getBounds().width, mover.getBounds().height);

		heroRect.x += (mover.getVelocity().x) * 2;

		map.getCollisionRects().clear();

		for (Tile tile : map.getTilesToDraw(mover)) {
			if (tile.isWalkable() == false) {
				if (heroRect.overlaps(tile.getBounds())) {
					mover.getVelocity().x = 0;
					map.getCollisionRects().add(tile.getBounds());
					break;
				}
			}
		}

		heroRect.x = mover.getPosition().x;

		heroRect.y += (mover.getVelocity().y) * 2;

		for (Tile tile : map.getTilesToDraw(mover)) {
			if (tile.isWalkable() == false) {
				if (heroRect.overlaps(tile.getBounds())) {
					mover.getVelocity().y = 0;
					map.getCollisionRects().add(tile.getBounds());
					break;
				}
			}
		}
		heroRect.y = mover.getPosition().y;
		mover.getVelocity().scl(1 / delta);
	}
}
