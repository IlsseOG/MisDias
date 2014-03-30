package com.example.misdias;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.helpers.DatabaseHelper;

public class VerNotas extends ListActivity {
	ArrayList<String> results = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ver_notas);
		
		 DatabaseHelper dh = new DatabaseHelper(this);//creamos una instancia del DB HELPER
	        Log.v("Ver Notas", "BD lista");
	        
	        Cursor c = dh.todasNotas();//estara apuntando a todos los registros
	        
	        while(c.moveToNext())
	        {
	        	//getColumnIndex(Alumnos.matricula)
	        	String nota_id = c.getString(0);
	        	String nombre_nota = c.getString(1);
	        	String fecha = c.getString(2);
	        	String result = nota_id + ", Cliente: " + nombre_nota + ". Fecha: " + fecha + ". ";
	        	results.add(result);
	        }
	        
	        c.close();
	        //se asignan al list adapter
	        this.setListAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,results));
	}
	
	//Metodo para agregar notas
	public void agregarNota(View v)
	{
		Intent intent = new Intent(VerNotas.this, Notas.class); 
		startActivity(intent);	
	}
	
	//Metodo para ir al inicio
	public void irInicio(View v)
	{
		Intent intent = new Intent(VerNotas.this, Principal.class); 
		startActivity(intent);	
	}
}
