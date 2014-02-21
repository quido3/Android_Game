package com.home.game.screens.layouts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class UiStage extends Stage {
	Table uiTable;
	TextButton button;
	InputMultiplexer plex;
	
	public UiStage(){
		
		
		uiTable = new Table();
		uiTable.setFillParent(true);
		Texture floor = new Texture(Gdx.files.internal("floor.png"));
		Texture roof = new Texture(Gdx.files.internal("roof.png"));
		TextureRegion upRegion = new TextureRegion(floor);
		TextureRegion downRegion = new TextureRegion(floor);
		BitmapFont buttonFont = new BitmapFont();
		TextButtonStyle style = new TextButtonStyle();
		style.up = new TextureRegionDrawable(upRegion);
		style.down = new TextureRegionDrawable(downRegion);
		style.font = buttonFont;		
		
		Table moveTable = new Table();
		Table actionTable = new Table();
		Table mapTable = new Table();
		Table statTable = new Table();
		
		TextButton upBtn = new TextButton("U", style);
		TextButton downBtn = new TextButton("D", style);
		TextButton rigtBtn = new TextButton("R", style);
		TextButton leftBtn = new TextButton("L", style);
		TextButton aBtn = new TextButton("A", style);
		TextButton bBtn = new TextButton("B", style);

		this.addActor(uiTable);
		uiTable.debug();
		uiTable.add(statTable).expandX().top().left();
		uiTable.add(mapTable).expandX().top().right();
		uiTable.row();
		uiTable.add(moveTable).expandX().bottom().left();
		uiTable.add(actionTable).expandX().bottom().right();
		
		moveTable.add(upBtn);
		
		upBtn.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Changed!");
			}
		});
	}
}
