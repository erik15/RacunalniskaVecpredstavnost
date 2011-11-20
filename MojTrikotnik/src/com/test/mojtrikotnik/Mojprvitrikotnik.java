package com.test.mojtrikotnik;

import com.badlogic.gdx.backends.android.AndroidApplication;
import android.view.KeyEvent;
import com.test.myfirsttriangle.Trikotnik;

import android.os.Bundle;

public class Mojprvitrikotnik extends AndroidApplication {
    /** Called when the activity is first created. */
	AddSound sound = new AddSound();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new Trikotnik(), false);
        
        Pesem();
        sound.Predvajaj();
    }
    
    public void Pesem()
    {
        sound.SelectSound("data","Kalimba.mp3");
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
    	super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_Z) 
        {
        	sound.Predvajaj();
        }
        if (keyCode == KeyEvent.KEYCODE_P) 
        {
        	sound.Stop();
        	Pesem();
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
	public void onResume() 
    { 
		super.onResume();
		sound.Predvajaj();
	}
    
	@Override
	public void onPause() 
	{ 
		super.onPause();
	}
	
	@Override
	public void onDestroy() 
	{
		super.onDestroy();
		sound.Stop();
	}
}