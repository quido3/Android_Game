package com.home.game.level;

import java.util.ArrayList;

import com.badlogic.gdx.utils.Array;
import com.home.game.actors.Tile;
import com.home.game.actors.Tile.*;
import com.home.game.util.Random;

public class LevelMaker {

	Array<Level> levels = new Array();
	Level level;
	boolean debug = true;

	public LevelMaker() {

	}

	public Level getNewLevel() {
		// TODO check if works right. Could return wrong number while making the
		// new level
		level = new Level((levels.size + 1));

		// ------ Start level creation --------

		if (debug) {
			debugLevel(level);
		} else {
			// TODO create real level.
		}

		// ------ End level creation ----------

		levels.add(level);
		return levels.get(levels.size - 1);
	}

	public Level getLevel(int index) {
		return levels.get(index);
	}

	public void debugLevel(Level level) {

		int width = 100;
		int height = 100;
		
		for (int i = 1; i <= width; i++) {
			for (int p = 1; p <= height; p++) {
				if (i == 1 || i == width || p == 1 || p == height){
					level.addTile(new Tile(i,p,TILEIMAGE.ROOF, false));
				}
					
					level.addTile(new Tile(i, p, TILEIMAGE.FLOOR, true));
			}
		}
	}
}
