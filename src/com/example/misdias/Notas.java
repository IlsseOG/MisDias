package com.example.misdias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Notas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notas);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}*/

	//Metodo para ver historial de notas
		public void verSintomas(View v)
		{
			Intent intent = new Intent(Notas.this, Sintomas.class); 
			startActivity(intent);	
		}
}
