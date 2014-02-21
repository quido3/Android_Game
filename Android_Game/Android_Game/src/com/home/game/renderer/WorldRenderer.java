package com.home.game.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.home.game.actors.Hero;
import com.home.game.actors.Tile;
import com.home.game.actors.Tile.TILEIMAGE;
import com.home.game.level.GameMap;

public class WorldRenderer {

	private static final float CAMERA_WIDTH = 100f;
	private static final float CAMERA_HEIGHT = 70f;

	private GameMap map;
	private Hero hero;
	public OrthographicCamera cam;

	private Texture floor;
	private Texture roof;
	private Texture heroTexture;

	private SpriteBatch spriteBatch;

	private float camWx = 12.5f, camWy = 7.5f;

	private int width;
	private int height;
	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis

	public WorldRenderer(GameMap map, Hero hero) {
		spriteBatch = new SpriteBatch();
		this.map = map;
		this.hero = hero;
		cam = new OrthographicCamera(camWx, camWy);
		cam.position.set(hero.getPosition().x, hero.getPosition().y, 0);
		floor = new Texture(Gdx.files.internal("floor.png"));
		roof = new Texture(Gdx.files.internal("roof.png"));
		heroTexture = new Texture(Gdx.files.internal("hero.png"));
		
	}

	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float) width / CAMERA_WIDTH;
		ppuY = (float) height / CAMERA_HEIGHT;
	}

	public void render() {
		spriteBatch.setProjectionMatrix(cam.combined);
		spriteBatch.begin();
		Array<Tile> tiles = map.getTilesToDraw(hero);
		//----- Tile drawing ---------
		for (Tile tile : tiles) {
			switch (tile.getImage()) {
			case FLOOR:
				spriteBatch.draw(floor, tile.getXCord(), tile.getYCord(),
						tile.getSize(), tile.getSize());
				break;
			case ROOF:
				spriteBatch.draw(roof, tile.getXCord(), tile.getYCord(),
						tile.getSize(), tile.getSize());
				break;
			default:	System.out.println("Cound not find approppriate image");
				break;
			}
		}
		//----------------------------
		//----- Draw hero-------------
		if(hero != null){
			spriteBatch.draw(heroTexture, hero.getPosition().x, hero.getPosition().y,
					hero.getSize(), hero.getSize());
		}
		
		spriteBatch.end();
		this.cam.position.set(hero.getPosition().x, hero.getPosition().y, 0);
		this.cam.update();
	}

}
