package com.home.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.home.game.actors.Hero;
import com.home.game.controller.HeroController;
import com.home.game.controller.MonsterController;
import com.home.game.controller.NpcController;
import com.home.game.level.GameMap;
import com.home.game.renderer.WorldRenderer;
import com.home.game.screens.layouts.UiStage;

public class GameScreen implements Screen, InputProcessor {

	private Hero hero;
	private WorldRenderer renderer;
	private GameMap map;
	private HeroController heroController;
	private MonsterController monsterController;
	private NpcController npcConroller;
	UiStage stage;
	InputMultiplexer plex;
	

	private int width, height;

	public GameScreen() {
		plex = new InputMultiplexer();
		
		stage = new UiStage();
		map = new GameMap();
		hero = new Hero("Pena", 5f, 1f, 3, 3);
		heroController = new HeroController(hero, map);
		plex.addProcessor(this);
		plex.addProcessor(stage);
		Gdx.input.setInputProcessor(plex);


	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		heroController.update(delta);
		renderer.render();
		
		Table.drawDebug(stage);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		stage.setViewport(width, height, true);
		this.width = width;
		this.height = height;
	}

	@Override
	public void show() {
		renderer = new WorldRenderer(map, hero);
		Gdx.input.setInputProcessor(plex);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		stage.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {

		switch (keycode) {
		case Keys.LEFT:
			heroController.leftPressed();
			return true;
		case Keys.RIGHT:
			heroController.rightPressed();
			return true;
		case Keys.UP:
			heroController.upPressed();
			return true;
		case Keys.DOWN:
			heroController.downPressed();
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean keyUp(int keycode) {

		switch (keycode) {
		case Keys.LEFT:
			heroController.leftReleased();
			return true;
		case Keys.RIGHT:
			heroController.rightReleased();
			return true;
		case Keys.UP:
			heroController.upReleased();
			return true;
		case Keys.DOWN:
			heroController.downReleased();
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
