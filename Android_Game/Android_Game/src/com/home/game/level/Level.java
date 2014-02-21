package com.home.game.level;

import com.badlogic.gdx.utils.Array;
import com.home.game.actors.Tile;
import com.home.game.actors.Tile.*;

public class Level {

	int width, height;
	Array<Tile> mapTiles = new Array();
	Array asciiMap = new Array();
	int lvlNumber;

	public Level(int lvlNumber) {

	}

	public void arrangeTilesArray() {
		// TODO arrange mapTiles -array by tile position x,y
	}

	public void drawASCII() {
		// TODO build and draw ASCII map based on mapTiles -array. First get
		// farthest tiles and build a new
	}

	public boolean addTile(Tile tile) {
		boolean canPlace = false;

		if (checkPlace(tile.getXCord(), tile.getYCord())) {
			mapTiles.add(tile);
			canPlace = true;
		}

		return canPlace;
	}

	public Array<Tile> getTiles() {
		return mapTiles;
	}

	public boolean checkPlace(int x, int y) {
		boolean empty = true;

		for (Tile tile : mapTiles) {
			if (tile.getXCord() == x && tile.getYCord() == y) {
				empty = false;
			}
		}

		return empty;
	}

}
