package com.me.gameEri;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "gameEri";
		cfg.useGL20 = false;
		cfg.width = 1024;
		cfg.height = 1024;
		
		new LwjglApplication(new GameEri(), cfg);
	}
}
