package com.me.gameEri;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

//Parte q controla la parte de vision la parte mas grafica
public class GameEriRenderer implements Disposable{
	//necesitamos una camara ortogonal, perpendicular a la zona de pintar de los graficos
	private OrthographicCamera camera;
	private SpriteBatch batch;//controlador del espacio donde se pinte
	private GameEriController gameController;//recibir el gameControler a traves del constructor
	
	
	
	
	public GameEriRenderer(GameEriController gC) {
		// TODO Auto-generated constructor stub
	}
	//Generamos metodos
	private void init(){}
	public void render(){}
	public void resize(int width, int height){}//metodo propio de los dispositivos moviles
	@Override
	public void dispose(){}//metodo para la liberacion de los recursos
}
