package com.home.game;

import com.badlogic.gdx.Game;

import com.home.game.screens.GameScreen;

public class MyGame extends Game {

	GameScreen gamescreen;

	@Override
	public void create() {
		System.out.println("Game start");
		gamescreen = new GameScreen();
		setScreen(gamescreen);
	}

}
