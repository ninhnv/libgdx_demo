package com.ninh.game.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class kidDracula implements ApplicationListener{
	
	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	private float elapseTime = 0;
	private TextureRegion[] kid;

	@Override
	public void create() {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("kid/kidracula.atlas");
		kid = new TextureRegion[3];
		kid[0] = textureAtlas.findRegion("kid1");
		kid[1] = textureAtlas.findRegion("kid2");
		kid[2] = textureAtlas.findRegion("kid1");
		animation = new Animation(1/8f, kid);
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
		elapseTime = elapseTime + Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapseTime,true), 0, 0);
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
		textureAtlas.dispose();
	}
	

}
