package com.ninh.game01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

public class MainMenuScreen implements Screen {

  final Drop game;

	OrthographicCamera camera;
	Rectangle playBound;
	Rectangle highscoreBound;
	Rectangle helpBound;
	Vector3 touchPoint;
	public static TextureRegion mainMenu;
	public static Texture items;
	
	public static Texture loadTexture(String file){
		return new Texture(Gdx.files.internal(file));
	}

	public MainMenuScreen(final Drop gam) {
		game = gam;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		playBound = new Rectangle(800/2 - 300/2, 480/2 + 18, 300, 36);
		highscoreBound = new Rectangle(800/2 - 300 /2, 480/2 - 18, 300 ,36);
		helpBound = new Rectangle(800 /2 - 300/2, 480/2 -18 -36, 300, 36);
		touchPoint = new Vector3();
		
		//load texture
		items = loadTexture("items.png");
		mainMenu = new TextureRegion(items, 0, 224, 300, 110);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
//		game.font.draw(game.batch, "Drop Game !!! ", 800/2, 0);
//		game.font.draw(game.batch, "Tap start game!", 800/2, 480/2);
		game.batch.draw(mainMenu, 800/2 - 300/2, 480/2 - 110/2, 300, 110);
		game.batch.end();
		
		if(Gdx.input.isTouched()){
			camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
			if(playBound.contains(touchPoint.x, touchPoint.y)){
				System.out.println("start game");
				game.setScreen(new GameScreen(game));
				dispose();
			}
			
			if(highscoreBound.contains(touchPoint.x, touchPoint.y)){
				System.out.println("high score");
				game.setScreen(new HighScore(game));
				dispose();
			}
			if(helpBound.contains(touchPoint.x, touchPoint.y)){
				System.out.println("help");
			}
		}

//		if (Gdx.input.isTouched()) {
//			game.setScreen(new GameScreen(game));
//			dispose();
//		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
