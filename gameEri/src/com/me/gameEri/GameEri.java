package com.me.gameEri;
//Este es el core
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameEri implements ApplicationListener {
	//1 Creo el objeto de tipo privado para utilizar la clase GameEriController
	private GameEriController gameController;
	//Creamos nueva variable de GameEriRenderer
	private GameEriRenderer gameRenderer;
	
	//se utilizara cuando inicie el juego
	@Override
	public void create() {		
		//inicializo el objeto aqui que es donde inicializo la aplicacion
		gameController=new GameEriController();
		//generamos una nueva variable
		gameRenderer=new GameEriRenderer(gameController);
	}

	@Override
	//se utilizara cuando finalice el juego
	public void dispose() {
	
	}

	@Override
	//se llamara cuando el juego se vaya actualizando, va a ser llamado 50-60 veces por segundo
	public void render() {		
		//Utilizamos con el objeto el metodo creado update, deltaTime lo conseguimos de la libreria GDX
		//Llamar a actualizar toda la parte de control
		gameController.update(Gdx.graphics.getDeltaTime());
		//llamadas clasicas dentro de libGdx (ponemos el color)
		Gdx.gl.glClearColor(0.64f,  0.95f,  0.95f,  1f);
		//Clears the screen, para colocar el color
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//Por ultimo se llama a la funcion Render game world to screen
		gameRenderer.render();
	}

	@Override
	//para redimensionar
	public void resize(int width, int height) {
	}

	@Override//Cuando pongamos pausa
	public void pause() {
	}

	@Override //cuando volvemos de una pausa
	public void resume() {
	}
}
