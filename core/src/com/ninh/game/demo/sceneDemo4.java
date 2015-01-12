package com.ninh.game.demo;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class sceneDemo4 implements ApplicationListener{

	public class jet extends Actor{
		private TextureRegion _texture;
		
		public jet(TextureRegion texture){
			_texture = texture;
			setBounds(getX(), getY(), _texture.getRegionWidth(), _texture.getRegionHeight());
			
			this.addListener(new InputListener(){
				public boolean touchDown(InputEvent event, float x, float y, int point, int button){
					System.out.println("Touched "+getName());
					setVisible(false);
					return true;
				}
			});
		}
		
		public void draw(Batch batch, float alpha){
			batch.draw(_texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		}
		
		public Actor hit(float x, float y, boolean touchable){
			if(!this.isVisible() || this.getTouchable() == Touchable.disabled){
				return null;
			}
			
			float centerX = getWidth() / 2;
			float centerY = getHeight() / 2;
			
			float radius = (float)Math.sqrt(centerX * centerX + centerY * centerY);
			float distance = (float)Math.sqrt(((centerX - x)*(centerX - x)+(centerY - y)*(centerY-y)));
			if(distance <= radius){
				return this;
			}
			return null;
		}
	}
	
	private jet[] jets;
	private Stage stage;
	
	@Override
	public void create() {
		stage = new Stage();
		final TextureRegion jetTexture= new TextureRegion(new Texture("demo/jet.png"));
		jets = new jet[10];
		
		Random random = new Random();
		for(int i = 0; i < 10; i++){
			jets[i] = new jet(jetTexture);
			jets[i].setPosition(random.nextInt(Gdx.graphics.getWidth() - (int)jets[i].getWidth()), random.nextInt(Gdx.graphics.getHeight() - (int)jets[i].getHeight()));
			jets[i].setName(Integer.toString(i));
			
			stage.addActor(jets[i]);
		}
		Gdx.input.setInputProcessor(stage);
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
