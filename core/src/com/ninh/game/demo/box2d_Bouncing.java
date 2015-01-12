package com.ninh.game.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class box2d_Bouncing implements ApplicationListener{
	
	SpriteBatch batch;
	TextureAtlas textureAtlas;
	AtlasRegion img;
	Sprite sprite;
	
	World world = new World(new Vector2(0,-100), true);
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera;
	
	static final float BOX_STEP = 1/60f;
	static final int BOX_VELOCITY_ITERATIONS = 6;
	static final int BOX_POSITION_ITERATIONS = 2;
	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_WORLD_TO = 100f;
	
	@Override
	public void create() {
		textureAtlas = new TextureAtlas("demo/Characters.atlas");
		img = textureAtlas.findRegion("WalkRight_MouthOpen_Red1");
		
		camera = new OrthographicCamera();
		camera.viewportWidth = 480;
		camera.viewportHeight = 320;
		camera.position.set(camera.viewportWidth * .5f, camera.viewportHeight * .5f, 0f);
		camera.update();
		
		sprite = new Sprite(img);
		sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2 +200);
		
		//ground body
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.position.set(new Vector2(0, 10));
		Body groundBody = world.createBody(groundBodyDef);
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox((camera.viewportWidth) * 2, 10.0f);
		groundBody.createFixture(groundBox, 0.0f);
		
		//dynamic body
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2);
		Body body = world.createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() /2);
		
		CircleShape dynamicCircle = new CircleShape();
		dynamicCircle.setRadius(15f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 1;
		body.createFixture(fixtureDef);
		debugRenderer = new Box2DDebugRenderer();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		debugRenderer.render(world, camera.combined);  
		world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS);
//		batch.setProjectionMatrix(camera.combined);
//        batch.begin();
//        batch.draw(sprite, sprite.getX(), sprite.getY(),sprite.getOriginX(),
//                sprite.getOriginY(),
//                sprite.getWidth(),sprite.getHeight(),sprite.getScaleX(),sprite.
//                        getScaleY(),sprite.getRotation());  
//        batch.end();
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
