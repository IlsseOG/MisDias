package com.example.misdias;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.helpers.DatabaseHelper;

public class Sintomas extends ListActivity {

	ArrayList lvSintomas = new ArrayList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sintomas);
		
		DatabaseHelper bd = new DatabaseHelper(this);
		
		Cursor c = bd.todosSintomas();
		
		while (c.moveToNext()){
			//int colid = c.getColumnIndex(Sintomas.ID);
			//String sin_id = c.getString(0);
			String nombre_id = c.getString(1);
			//String descrip_id = c.getString(2);
			
			lvSintomas.add(nombre_id);
		}
		
		c.close();
		
		this.setListAdapter(new ArrayAdapter (this, android.R.layout.simple_list_item_1, lvSintomas));
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}*/

}
