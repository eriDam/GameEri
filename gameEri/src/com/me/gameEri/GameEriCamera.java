package com.me.gameEri;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GameEriCamera {
 // Haremos el seguimiento para que este centrada la camara
	private Sprite objetivo;
	private Vector2 posicion;//importamos Vector2 libreria si no da error, 
	
	public GameEriCamera() {
		posicion=new Vector2();//Creamos nuevo objeto y en Controller hay q ir al update y colocar que se actualice igual que deltaTime
		
	}

	//Creamos metodo inicializador como en el resto

	public void init()
	{
		
	}

	public void setSprite(Sprite objetivo)
	{
		
		//el objeto que queremos seguir se lo pasaremos desde GameEriController
		this.objetivo=objetivo;	
	}
		//Hay que actualizar las posiciones de la camara segun se vaya moviendo nuestro objeto cube

	public void update() {
		posicion.x=objetivo.getOriginX()+objetivo.getX();
		posicion.y=objetivo.getOriginY()+objetivo.getY();
		
	}

	// Metodo para mover camara de posicion
	public void moverCamera(OrthographicCamera camera) {
		
	camera.position.x=posicion.x;
	camera.position.y=posicion.y;
	camera.update();
	}
	

}


