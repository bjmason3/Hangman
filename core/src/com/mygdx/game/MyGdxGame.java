package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends ApplicationAdapter {
	private static Screen currentScreen;
	
	@Override
	public void create () {
		currentScreen = new StartScreen();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		currentScreen.render();
	}
	
	@Override
	public void dispose () {
		currentScreen.dispose();
	}
	
	public static void setScreen(Screen newScreen) {
		currentScreen = newScreen;
	}
}
