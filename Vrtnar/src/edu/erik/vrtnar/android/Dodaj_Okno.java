package edu.erik.vrtnar.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Dodaj_Okno extends Activity implements OnClickListener {

	//Button shrani;
	Button dnevi_sajenja;
	Menu meni;
	public static final int OPEN_DNEVI=99;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugi);
        
        //shrani = (Button) findViewById(R.id.btn_shrani);
        //shrani.setOnClickListener(this);
        dnevi_sajenja = (Button) findViewById(R.id.btn_dsajenja);
        dnevi_sajenja.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent();
		i.setClass(this, DneviTeden.class);
		startActivityForResult(i, OPEN_DNEVI);
		
	}
	 @Override
	 protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		 if (resultCode==RESULT_OK) {
			 if (requestCode==OPEN_DNEVI) {
				 String izbrani="";
				 if (data.getBooleanExtra(DneviTeden.sPON, false)) { //neki naredis
					 izbrani +="PON "; 
				 }
				 if (data.getBooleanExtra(DneviTeden.sTOR, false)) { //neki naredis
					 izbrani +="TOR "; 
				 }
				 if (data.getBooleanExtra(DneviTeden.sSRE, false)) { //neki naredis
					 izbrani +="SRE "; 
				 }
				 if (data.getBooleanExtra(DneviTeden.sCET, false)) { //neki naredis
					 izbrani +="�ET"; 
				 }
				 if (data.getBooleanExtra(DneviTeden.sPET, false)) { //neki naredis
					 izbrani +="PET "; 
				 }
				 if (data.getBooleanExtra(DneviTeden.sSOB, false)) { //neki naredis
					 izbrani +="SOB "; 
				 }
				 if (data.getBooleanExtra(DneviTeden.sNED, false)) { //neki naredis
					 izbrani +="NET "; 
				 }
				 Toast.makeText(this, izbrani, Toast.LENGTH_SHORT)
					.show(); 
			 }
		 }
	 }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		meni = menu;
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, meni);
		return true;
	}
	
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {			
		case R.id.btn_dsajenja:
			Intent i = new Intent();
			i.setClass(this, MenuPreferences.class);
			startActivityForResult(i, R.id.btn_dsajenja);
			return true;
			
		
		default:// Generic catch all for all the other menu resources
			if (!item.hasSubMenu()) {
				Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT)
				.show();
				return true;
			}
			break;
		}

		return false;
	}
}
