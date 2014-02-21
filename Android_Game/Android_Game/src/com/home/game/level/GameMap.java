package com.home.game.level;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.home.game.actors.Movable;
import com.home.game.actors.Tile;

public class GameMap {

	Level level;
	LevelMaker levelMaker;
	Array<Tile> TilesToDraw = new Array();
	Array<Tile> collisionTiles = new Array();
	Array<Rectangle> collisionRects = new Array<Rectangle>();


	public GameMap() {
		levelMaker = new LevelMaker();
		// TODO load all saved levels to levelMaker
		level = levelMaker.getNewLevel();
	}
	
	public Array<Rectangle> getCollisionRects() {
		return collisionRects;
	}

	public Array<Tile> getTilesToDraw(Movable center) {
		Array<Tile> tiles = level.getTiles();
		TilesToDraw.clear();
		for (Tile tile : tiles) {
			if (Math.abs(center.getPosition().x - tile.getXCord()) < 7
					&& Math.abs(center.getPosition().y - tile.getYCord()) < 7) {
				TilesToDraw.add(tile);
			}
		}
		return TilesToDraw;
	}
	
	public Array<Tile> getCollideTiles(Movable center){
		Array<Tile> tiles = level.getTiles();
		collisionTiles.clear();
		for (Tile tile : tiles) {
			if (Math.abs(center.getPosition().x - tile.getXCord()) < 2
					&& Math.abs(center.getPosition().y - tile.getYCord()) < 2) {
				collisionTiles.add(tile);
			}
		}
		return collisionTiles;
	}

}
