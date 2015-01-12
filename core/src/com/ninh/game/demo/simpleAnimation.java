package com.ninh.game.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class simpleAnimation implements ApplicationListener{

	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	private float elapsedTime = 0;
	private TextureRegion[] characters;
	private AtlasRegion playerImage;
	
	private Rectangle player;
	private Sprite sprite;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		//load image pack
		textureAtlas = new TextureAtlas("demo/Characters.atlas");
		characters =  new TextureRegion[4];
		//load characters frame 
		characters[0] = (textureAtlas.findRegion("WalkRight_MouthOpen_Red1"));
		characters[1] = (textureAtlas.findRegion("WalkRight_MouthOpen_Red2"));
		characters[2] = (textureAtlas.findRegion("WalkRight_MouthOpen_Red3"));
		characters[3] = (textureAtlas.findRegion("WalkRight_MouthOpen_Red1"));
		
		animation = new Animation(1/4f,characters);
		
		playerImage = textureAtlas.findRegion("WalkRight_MouthOpen_Red1");
		
		//load all frame image pack
//		animation = new Animation(1/3f, textureAtlas.getRegions());
		
		player = new Rectangle();
		player.x = 800/2 -64/2;
		player.y = 20;
		player.width = 64;
		player.height = 64;
		
		sprite = new Sprite(playerImage);
		sprite.setPosition(0, 0);
		
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isTouched()){
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
//			player.x = touchPos.x - 64/2;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){
				sprite.translateX(-1f);
			}else{
				sprite.translateX(-10.0f);
			}
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)){
				sprite.translateX(1f);
			}else{
				sprite.translateX(10.0f);
			}
		}
		
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
			sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		}
		
		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
//		System.out.println("elapsedTime: "+elapsedTime);
		batch.draw(animation.getKeyFrame(elapsedTime, true),player.x,player.y);
		sprite.draw(batch);
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

}
