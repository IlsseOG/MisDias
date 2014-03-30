package com.example.misdias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.helpers.DatabaseHelper;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		 DatabaseHelper dh = new DatabaseHelper(this);
		 dh.agregarSintoma("DolorCabeza", "Dolor en la cabeza");
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}*/
	
	//Metodo para ver historial de notas
	public void verNotas(View v)
	{
		Intent intent = new Intent(Principal.this, VerNotas.class); 
		startActivity(intent);	
	}
	
	//Metodo para ver historial de periodos
	public void verHistorial(View v)
	{
		Intent intent = new Intent(Principal.this, Historial.class); 
		startActivity(intent);	
	}
	
	
}
