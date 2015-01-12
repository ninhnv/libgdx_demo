package com.ninh.game.demo;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class handlingInput implements ApplicationListener, InputProcessor{
	private SpriteBatch batch;
	private BitmapFont font;
	private String message = "touch something already";
	private int w,h;
	
	class TouchInfo{
		public float touchX = 0;
		public float touchY = 0;
		public boolean toached = false;
	}
	
	private Map<Integer, TouchInfo> touches = new HashMap<Integer, TouchInfo>();

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("demo/arial.fnt"),false);
		font.setColor(Color.RED);
		w = Gdx.graphics.getWidth();
		h= Gdx.graphics.getHeight();
		Gdx.input.setInputProcessor(this);
		for(int i = 0; i< 5; i++){
			touches.put(i, new TouchInfo());
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		message = "";
		for(int i = 0; i < 5;i++){
			if(touches.get(i).toached){
				message += "finger: " + Integer.toString(i) + "touch at: " + Float.toString(touches.get(i).touchX)+
						"," +
						Float.toString(touches.get(i).touchY)+"\n";
			}
		}
		
		TextBounds tb = font.getBounds(message);
		float x = w/2 - tb.width /2;
		float y = h/2 - tb.height /2;
		font.drawMultiLine(batch, message, x, y);
		
		batch.end();
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
		batch.dispose();
		font.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
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
