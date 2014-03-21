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
	//necesitamos una camara ortogonal, perpendicular a la zona de pintar de los graficos
	private OrthographicCamera camera;
	private SpriteBatch batch;//controlador del espacio donde se pinte
	private GameEriController gameController;//recibir el gameControler a traves del constructor
	
	
	//objetos graficos
	//Un mapa de puntos representa una imagen en la memoria.
	//Tiene una anchura y altura expresada en píxeles
	private Pixmap plataforma;
	//creamos la textura
	private Texture textura;
	//Creamos el Sprite, describe tanto la textura como la geometria, es como otro envoltorio dentro de la textura
	private Sprite sprite; 
	
	public GameEriRenderer(GameEriController gC) {
		//Llamamos al inicializador dentro del constructor
		init();
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
		
		//------------------Crear nuestra plataforma------------------
		
		plataforma=new Pixmap (32, 32, Format.RGBA8888 );
		plataforma.setColor(1,0,0,0.5f);
		plataforma.fill();//Rellenar por completo la plataforma
		plataforma.setColor(1,1,0,1);
		plataforma.drawLine(0, 0, 32, 32);//dibujar una linea
		plataforma.drawLine(32, 0, 0, 32);
		plataforma.setColor(0,1,1,1);//le doy otro color
		plataforma.drawRectangle(0,0,32,32);
		
		
		//necesitamos ponerlo en memoria vamos a pintar a traves de una textura - Cargar textura
		//entre parentesis cargariamos nuestra imagen del fichero pero vamos a cargar la plataforma d momento
		textura=new Texture(plataforma);
		plataforma.dispose();//para que elimine de memoria el pixmap una vez pintado
		//sprite=new Sprite();//utilizare el escenario batch para q dibuje el texture
		
	}
	
	
	//----------------------Metodo Render para empezar a pintar
	public void render(){
		batch.setProjectionMatrix(camera.combined);
		
		//Todo lo que vayamos a pintar tiene que entar en medio de nuestro batch begin nuestro escenario y batch.end el final, todo lo que haya hay se ira actualizando y repintando
		batch.begin();
			//vamos a pintar nuestro sprite y vamos a  dibujar el cuadrado, ahora cambio sprite x batch utilizare el escenario batch para q dibuje el texture
			batch.draw(textura,0,0);
		
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
