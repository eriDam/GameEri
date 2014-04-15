package com.me.gameEri;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

//Parte q controla la parte de vision la parte mas grafica
public class GameEriRenderer implements Disposable{
	//Todo necesita una camara, necesitamos una camara ortogonal, perpendicular a la zona de pintar de los graficos, si da error importar la libreria d clase
	private OrthographicCamera camera;
	private SpriteBatch batch;//controlador del espacio donde se pinte
	private GameEriController gC;//recibir el gameControler a traves del constructor, cambio gameController por gC
	
	
	//objetos graficos
	
	//Creamos el Sprite, describe tanto la textura como la geometria, es como otro envoltorio dentro de la textura
	//private Sprite sprite; //dejo comentado por que no lo voy a utilizar voya usar un batch
	
	public GameEriRenderer(GameEriController gC) {
		//Llamamos al inicializador dentro del constructor
		init();
		this.gC=gC;//al hacer this es para utilizar todos los metodos y atributos de esta clase
	}
	//Generamos metodos
	private void init(){
		//---------------Camara de visión-------------------------
		//creamos una nueva OrthographicCamera
		camera=new OrthographicCamera(480,320);//hacemos que nuestra camara coja todo el escenario(en main esta el tamaño)
		//la  situo en la posicion 000
		camera.position.set(0,0,0);
		//Actualizare la misma
		camera.update();
		
		//------------------Escenario, es el q va a pintar viene representado por batch(lote,grupo)
		//Creo un nuevo batch
		batch=new SpriteBatch();
	
	}
	
	
	//----------------------Metodo Render para empezar a pintar
	public void render(){
		batch.setProjectionMatrix(camera.combined);
		
		//Todo lo que vayamos a pintar tiene que entar en medio de nuestro batch begin nuestro escenario y batch.end el final, todo lo que haya hay se ira actualizando y repintando
		batch.begin();
			//vamos a pintar nuestro sprite y vamos a  dibujar el cuadrado, ahora cambio sprite x batch utilizare el escenario batch para q dibuje el texture
			//batch.draw(gC.textura,0,0);
			//Como he cambiado en controller y he indicado q pinte el cubo
			gC.cube.draw(batch);
		batch.end();
		
		
	}
	//----------------------metodo propio de los dispositivos moviles
	public void resize(int width, int height){
		
	}
	@Override
	//----------------------metodo para la liberacion de los recursos
	public void dispose(){
		
	}
}
