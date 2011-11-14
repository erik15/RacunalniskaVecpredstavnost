package com.test.mojtrikotnik;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.test.myfirsttriangle.Trikotnik;

import android.os.Bundle;

public class Mojprvitrikotnik extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new Trikotnik(), false);
    }
}