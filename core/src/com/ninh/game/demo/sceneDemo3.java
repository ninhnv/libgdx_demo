package com.ninh.game.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;

public class sceneDemo3 implements ApplicationListener{

	private Stage stage;
	private Group group;
	
	@Override
	public void create() {
		stage = new Stage();
		final TextureRegion jetTexture = new TextureRegion(new Texture("demo/jet.png"));
		final TextureRegion flameTexture = new TextureRegion(new Texture("demo/flame.png"));
		
		final Actor jet = new Actor(){
			public void draw(Batch batch, float alpha){
				batch.draw(jetTexture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
			}
		};
		
		jet.setBounds(jet.getX(), jet.getY(), jetTexture.getRegionWidth(), jetTexture.getRegionHeight());
		
		final Actor flame = new Actor(){
			public void draw(Batch batch, float alpha){
				batch.draw(flameTexture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
			}
		};
		
		flame.setBounds(0, 0, flameTexture.getRegionWidth(), flameTexture.getRegionHeight());
		flame.setPosition(jet.getWidth()-25, 80);
		
		group = new Group();
		group.addActor(jet);
		group.addActor(flame);
		
//		group.addAction(Parallel);
		
		stage.addActor(group);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
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
		stage.dispose();
		
	}

}
