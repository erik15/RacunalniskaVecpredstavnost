package com.test.myfirsttriangle;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class TrikotnikAplikacija {
	public static void main (String[] argv) {
        new JoglApplication(new Trikotnik(), "Trikotnik", 300, 300, false);               
}


}
