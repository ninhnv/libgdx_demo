package com.ninh.game01.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ninh.game.demo.Physic1Demo;
import com.ninh.game.demo.box2d_Bouncing;
import com.ninh.game.demo.handlingInput;
import com.ninh.game.demo.kidDracula;
import com.ninh.game.demo.scene2d;
import com.ninh.game.demo.scene2d_p2;
import com.ninh.game.demo.sceneDemo3;
import com.ninh.game.demo.sceneDemo4;
import com.ninh.game.demo.simpleAnimation;
import com.ninh.game01.Drop;
import com.ninh.game01.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Drop";
		config.width = 800;
		config.height = 480;
//		new LwjglApplication(new simpleAnimation(), config);
		new LwjglApplication(new kidDracula(), config);
	}
}
