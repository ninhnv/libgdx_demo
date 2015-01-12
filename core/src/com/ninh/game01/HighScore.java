package com.ninh.game01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class HighScore implements Screen{
	final Drop game;
	
	OrthographicCamera camera;
	Rectangle menuBound;
	Vector3 touchPoint;
	
	
	public HighScore(final Drop gam){
		game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		menuBound = new Rectangle(0,0,800,480);
		touchPoint = new Vector3();
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		game.font.draw(game.batch, "High Score", 0, 0);
		game.batch.end();
		
		if(Gdx.input.justTouched()){
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			if(menuBound.contains(touchPoint.x, touchPoint.y)){
				game.setScreen(new MainMenuScreen(game));
				dispose();
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
