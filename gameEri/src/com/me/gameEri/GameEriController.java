package com.me.gameEri;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Sprite;

	//Creo esta 1 clase q va a ser la encargada de control, toda la parte logica del juego
	public class GameEriController extends InputAdapter { //LE indico con extends qeu herede de InputAdapter (habrá q importar)
		//Un mapa de puntos representa una imagen en la memoria.
		//Tiene una anchura y altura expresada en píxeles
		private Pixmap plataforma;
		//creamos la textura y la hago public
		public Texture textura;
		//El Sprite nos permite incorporar movimiento y hacer ocsas que una textura no nos permite hacer
		public Sprite cube;
		
	
	public GameEriController() {
		init();
		//Quien va a recibir los eventos de los teclados, le decimos this para q sea esta misma clase la que vaya a recibir y tratar esos eventos
		Gdx.input.setInputProcessor(this);
	}

	//nuevo metodo q podre usar para resetear el anterior
	public void init(){
		this.initPlataformas();//cuando utilizo this es para indicarle q utilizo todos los atributos y metodos de esta clase
	}
	
	//--------------Metodo encargado de las actualizaciones del juego--------------------------------
	
	//todas las partes se van a ejecutar muchas veces por segundo, esto se va a realizar a través de esta variable deltaTime
	public void update(float deltaTime){
		//el movimiento q vamos a introudcir sera cuado presionmos una tecla, es un evento que hay que capturar
		//va a ser repetido mientras la tecla este apreta, el movimineto permances y va a ser dependiente de lo que libgdx tiene omo deltatime
		//Voy a imprimir para ver que valor tiene deltaTime, tiene unos valores bajos dependiendo de los frames que sea ctualiza por segundo
		//System.out.println(deltaTime);
		//Creo un nuevo metodo para
		hdlControls(deltaTime);
	}
	
	/*-------------------Creamos para ordenar el codigo--------------------
	 *-----------Crea y coloca el cubo ----*/
	private void initPlataformas(){
				//Crear nuestra plataforma------------------
				plataforma=new Pixmap (32, 32, Format.RGBA8888 );
				plataforma.setColor(1,0,0,0.5f);
				plataforma.fill();//Rellenar por completo la plataforma
				plataforma.setColor(1,1,0,1);
				plataforma.drawLine(0, 0, 32, 32);//dibujar una linea 
				plataforma.drawLine(32, 0, 0, 32);
				plataforma.setColor(0,1,1,1);//le doy otro color
				plataforma.drawRectangle(0,0,32,32);
				
		//-- Cargar textura------necesitamos ponerlo en memoria vamos a pintar a traves de una textura 
				//entre parentesis cargariamos nuestra imagen del fichero pero vamos a cargar la plataforma d momento
				textura=new Texture(plataforma);
				//vamos a cargar dentro de nuestro cubo la textura y lo vamos a posicionar
				cube=new Sprite(textura);//Ir a Renderer y cambiar que ya no este pintando la textura si no el cubo
				cube.setPosition(0, 0);//
				plataforma.dispose();//para que elimine de memoria el pixmap una vez pintado
				//sprite=new Sprite();//utilizare el escenario batch para q dibuje el texture
	}
	
	//Creo un nuevo metodo para capturar apretar teclas
	private void hdlControls(float deltaTime){
		
		//Una vez realizadas todas las capturas de teclas, podemos crear una variable para atrapar elmovimiento
		float cubeSpeed=deltaTime*100;
		
		
		//para capturar apretar teclas tenemos una libreria que nos informa si una tecla ha sido apretada
		if(Gdx.input.isKeyPressed(Keys.A)){
			//Lo movemos a la izquierda, -5*deltaTime es para que nos parezca un movimeinto continuado
			this.cube.translate(-cubeSpeed,0);//el metódo moveCube esta bajo
		}
		if(Gdx.input.isKeyPressed(Keys.W)){
			//Hacia arriba
			this.cube.translate(0,cubeSpeed);
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			//Hacia abajo será justo al contrario que el de arriba en negativo
			this.cube.translate(0,-cubeSpeed);
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			//Hacia la derecha
			//moveCube(5*deltaTime,0);lo dejo comentado x q uso la variable moveSpeed
			this.cube.translate(cubeSpeed,0);
		}
	}

	/*//Implementar el método moveCube  --Dejo comentado por que en el video 7Reiniciandojuego desaparece y cambia arriba this.cube
	private void moveCube(float xAmount,float yAmount){
		//En el vamos a mover el cubo a partir del método q nos proporciona sprite que se llama translate
		//Que se mueva una cantidad x hacia x y en y
		cube.translate(xAmount, yAmount);}*/
	
	@Override //estamos sobreescribiendo el metodo que nos proporciona la clase padre que es inputAdapter
	public boolean keyUp (int keycode){
		//Reiniciamos el juego cuando se presione la tecla escape
		
		if(keycode==Keys.ESCAPE)
		{
			//llamamos al metodo init
			this.init();
		}
		return true;
	}
	}
