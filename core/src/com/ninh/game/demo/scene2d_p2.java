package com.ninh.game.demo;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;

public class scene2d_p2 implements ApplicationListener{

	public class MyActor extends Actor{
		Texture texture = new Texture("demo/jet.png");
		public boolean started = false;
		
		public MyActor(){
			setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
		}
		
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,this.getX(), this.getY());
		}
	}
	
	private Stage stage;
	
	@Override
	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		MyActor myActor = new MyActor();
		
		MoveToAction moveAction = new MoveToAction();
		RotateToAction rotateAction = new RotateToAction();
		ScaleToAction scaleAction = new ScaleToAction();
		
		moveAction.setPosition(300f, 0);
		moveAction.setDuration(5f);
		myActor.addAction(moveAction);
		rotateAction.setRotation(90f);
		rotateAction.setDuration(5f);
		scaleAction.setScale(0.5f);
		scaleAction.setDuration(5f);
		
		myActor.addAction(moveAction);
		myActor.addAction(rotateAction);
		myActor.addAction(scaleAction);
		
		stage.addActor(myActor);
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
		// TODO Auto-generated method stub
		
	}

}
