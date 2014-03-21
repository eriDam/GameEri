package com.me.gameEri;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;

	//Creo esta 1 clase q va a ser la encargada de control, toda la parte logica del juego
	public class GameEriController {
		//Un mapa de puntos representa una imagen en la memoria.
		//Tiene una anchura y altura expresada en píxeles
		private Pixmap plataforma;
		//creamos la textura y la hago public
		public Texture textura;
		
	
	public GameEriController() {
		init();
		
	}

	//nuevo metodo q podre usar para resetear el anterior
	public void init(){
		this.initPlataformas();
	}
	
	//metodo encargado de las actualizaciones del juego
	//todas las partes se van a aejecutar muchas veces por segundo, esto se va a realizar a través de esta variable deltaTime
	public void update(float deltaTime){
		
		
		
	}
	//Creamos para ordenar el codigo
	private void initPlataformas(){
		//------------------Crear nuestra plataforma------------------
		
				plataforma=new Pixmap (32, 32, Format.RGBA8888 );
				plataforma.setColor(1,0,0,0.5f);
				plataforma.fill();//Rellenar por completo la plataforma
				plataforma.setColor(1,1,0,1);
				plataforma.drawLine(0, 0, 32, 32);//dibujar una linea
				plataforma.drawLine(32, 0, 0, 32);
				plataforma.setColor(0,1,1,1);//le doy otro color
				plataforma.drawRectangle(0,0,32,32);
				
		//---------------necesitamos ponerlo en memoria vamos a pintar a traves de una textura - Cargar textura
				//entre parentesis cargariamos nuestra imagen del fichero pero vamos a cargar la plataforma d momento
				textura=new Texture(plataforma);
				plataforma.dispose();//para que elimine de memoria el pixmap una vez pintado
				//sprite=new Sprite();//utilizare el escenario batch para q dibuje el texture
	}
	
}
