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
	private Pixmap plataforma;
	//creamos la textura
	private Texture textura;
	//Cramos el Sprite, describe tanto la textura como la geometria
	private Sprite sprite;
	
	public GameEriRenderer(GameEriController gC) {
		//Llamamos al inicializador dentro del constructor
		init();
	}
	//Generamos metodos
	private void init(){
		//Crear nuetsra plataforma
		
		plataforma=new Pixmap (32, 32, Format.RGBA8888 );
		plataforma.setColor(1,0,0,0.5f);
		plataforma.fill();//Rellenar
		
		//necesitamos ponerlo en memoria vamos a pintar a traves de una textura - Cargar textura
		//entre parentsis cargariamos nuestra imagen del fichero pero vamos a cargar la plataforma
		textura=new Texture(plataforma);
		sprite=new Sprite();
		
	}
	public void render(){
		
	}
	//metodo propio de los dispositivos moviles
	public void resize(int width, int height){
		
	}
	@Override
	//metodo para la liberacion de los recursos
	public void dispose(){
		
	}
}
