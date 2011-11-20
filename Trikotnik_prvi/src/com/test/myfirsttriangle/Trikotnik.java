package com.test.myfirsttriangle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Trikotnik implements ApplicationListener {
        //private Mesh mesh; //objekt ki ga bom oprikazali
        private Mesh[] faces;
        private OrthographicCamera camera;
        private float rotationSpeed;

        @Override
        public void create() {
        	rotationSpeed = 0.5f;

                /*if (mesh == null) {
                	mesh = new Mesh(true, 3, 3, 
                	        new VertexAttribute(Usage.Position, 3, "pozicija"),
                	        new VertexAttribute(Usage.ColorPacked, 4, "barva"));         

                        //polozaj tock trikotnika, barve v RGB, Alpha
                	mesh.setVertices(new float[] { -0.5f, -0.5f, 0, Color.toFloatBits(255, 0, 0, 0),
                            0.5f, -0.5f, 0, Color.toFloatBits(255, 0, 0, 0),
                            0, 0.5f, 0, Color.toFloatBits(255, 0, 0, 0) });        
                	
                	mesh.setIndices(new short[] { 0, 1, 2 }); //povezava toèk                   
                }*/
        	if (faces == null) {
        	      faces = new Mesh[6];
        	 
        	      for (int i = 0; i < 6; i++) {
        	        faces[i] = new Mesh(true, 4, 4,
        	            new VertexAttribute(Usage.Position, 3, "pozicija"),
        	            new VertexAttribute(Usage.ColorPacked, 4, "barva"));
        	 
        	        faces[i].setIndices(new short[] { 0, 1, 2, 3 });
        	      }
        	 
        	      faces[0].setVertices(new float[] {
        	          0.5f, 0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255),
        	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255),
        	          0.5f, -0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255),
        	          -0.5f, -0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255) });
        	 
        	      faces[1].setVertices(new float[] {
        	          0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 0, 0, 255),
        	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 0, 0, 255),
        	          0.5f, -0.5f, -0.5f,  Color.toFloatBits(255, 0, 0, 255),
        	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 0, 0, 255) });
        	 
        	      faces[2].setVertices(new float[] {
        	          0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
        	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
        	          0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 255),
        	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 255) });
        	 
        	      faces[3].setVertices(new float[] {
        	          0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 96, 0, 255),
        	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 96, 0, 255),
        	          0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 96, 0, 255),
        	          -0.5f, -0.5f, 0.5f,  Color.toFloatBits(0, 96, 0, 255) });
        	 
        	      faces[4].setVertices(new float[] {
        	          0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 255),
        	          0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 255),
        	          0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 255),
        	          0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 255) });
        	 
        	      faces[5].setVertices(new float[] {
        	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 96, 255),
        	          -0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 96, 255),
        	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 96, 255),
        	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 96, 255) });
        	    }
        	Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
        }

        @Override
        public void dispose() { }

        @Override
        public void pause() { }
        private int total = 0;
        private float movementIncrement = 0.0006f;

        @Override
        public void render() {
        	handleInput();

            total += 1;
            if (total > 500) {
                movementIncrement = -movementIncrement;
                total = -200;
            }
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            Gdx.gl10.glAlphaFunc(GL10.GL_GREATER, 0);
            //camera.rotate(movementIncrement * 20, 0, 1, 0);
            //camera.translate(movementIncrement, 0, movementIncrement);


                Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
                //mesh.render(GL10.GL_TRIANGLES, 0, 3);
                camera.update();
                camera.apply(Gdx.gl10);
                for (Mesh face : faces) {
                    face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
                  }
        }

        @Override
        public void resize(int width, int height) {
            float aspectRatio = (float) width / (float) height;
            camera = new OrthographicCamera(2f * aspectRatio, 2f);
        }

        @Override
        public void resume() { }
        
        private void handleInput() {
            
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                camera.rotate(-rotationSpeed, 0, 0, 1);
	        }	        
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
	                camera.rotate(rotationSpeed, 0, 0, 1);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
                camera.rotate(rotationSpeed, 1, 0, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                camera.rotate(-rotationSpeed, 1, 0, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
                camera.rotate(rotationSpeed, 0, 1, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                camera.rotate(rotationSpeed, 0, -1, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.L)) {
                camera.translate(0.1f,0 ,0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.R)) {
                camera.translate(-0.1f,0 ,0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.O)) {
                camera.zoom += 0.02;
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.Z)) {
                camera.zoom-=0.02;
	        }
    }
}