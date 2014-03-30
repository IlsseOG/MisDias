package com.example.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.modelos.Nota;
import com.example.modelos.Notas_Sintomas;
import com.example.modelos.Periodo;
import com.example.modelos.Sintoma;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "periodo.db";
	private static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		Log.v("Creacion DB", "Creacion de tablas");
		db.execSQL(Periodo.CREATE_TABLE);
		db.execSQL(Sintoma.CREATE_TABLE);
		db.execSQL(Nota.CREATE_TABLE);
		db.execSQL(Notas_Sintomas.CREATE_TABLE);

	} // onCreate

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// //METODOS PARA PERIODO

	// Metodo para agregar un periodo
	// TODO: VERIFICAR QUE FUNCIONA
	public long agregarPeriodo(String inicioPeriodo, String finalPeriodo) {
		int duracion = 0;

		SQLiteDatabase db = getWritableDatabase();
		String query = "SELECT julianday('" + finalPeriodo + "') - julianday('"
				+ inicioPeriodo + "');";
		Cursor c = db.rawQuery(query, null);
		if (c != null && c.moveToFirst()) {
			duracion = c.getInt(0); // El 0 es el indice de la columna, como
									// esperamos una columna, el indice es 0
		}
		c.close();

		
		ContentValues cv = new ContentValues();
		cv.put(Periodo.INICIO, inicioPeriodo);
		cv.put(Periodo.FINAL, finalPeriodo);
		cv.put(Periodo.DURACION, duracion);

		long result = db.insert(Periodo.TABLE_NAME, null, cv);
		
		db.close();
		return result;
	}

	// Metodo para traernos todos los periodos. Para historial
	public Cursor todosPeriodos() {
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.query(Periodo.TABLE_NAME, null, null, null, null, null,
				null);
		db.close();
		return c;
	}

	// //FINAL METODOS PERIODO

	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// /METODOS PARA SINTOMAS

	// Metodo para agregar sintoma
	public long agregarSintoma(String nombre, String descripcion) {
		ContentValues cv = new ContentValues();
		cv.put(Sintoma.NOMBRE, nombre);
		cv.put(Sintoma.DESCRIPCION, descripcion);

		SQLiteDatabase db = getWritableDatabase();
		long result = db.insert(Periodo.TABLE_NAME, null, cv);
		db.close();
		return result;
	}

	// Metodo para traernos todos los sintomas. Para historial
	public Cursor todosSintomas() {
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.query(Sintoma.TABLE_NAME, null, null, null, null, null,
				null);
		return c;
	}

	// Metodo para traernos un solo sintoma segun el nombre
	// TODO: VERIFICAR
	public Cursor obtenerSintoma(String nombre) {
		SQLiteDatabase db = getWritableDatabase();
		String query = "SELECT id FROM Sintoma WHERE nombre like " + nombre;
		Cursor c = db.rawQuery(query, null);
		return c;
	}

	// FIN METODOS PARA SINTOMAS

	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// METODOS PARA NOTAS

	// Metodo para agregar nota
	// TODO: VERIFICAR. Se incluye un array de sintomas porque podria traer mas
	// de 1 sintoma por nota
	public long agregarNota(String nombre, String fecha, String[] nombreSintoma) {

		int notaId = 0;
		
		ContentValues cv = new ContentValues();
		cv.put(Nota.DESCRIPCION, nombre);
		cv.put(Nota.FECHA, fecha);

		SQLiteDatabase db = getWritableDatabase();
		long result = db.insert(Nota.TABLE_NAME, null, cv);
		notaId = obtenerUltimaNota();

		//recorremos el arreglo de sintomas
		for (int i = 0; i < nombreSintoma.length; i++) {
			Cursor c = obtenerSintoma(nombreSintoma[i]);
			if (c != null && c.moveToFirst()) {
				int sintomaId = c.getInt(0);
				agregarNotaSintoma(notaId,sintomaId);
			}
			c.close();
		}
		db.close();
		return result;
	}
	
	//Metodo para obtener todas las notas
	public Cursor todasNotas() {
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.query(Nota.TABLE_NAME, null, null, null, null, null,null);
		return c;
	}
	
	//Metodo para obtener la id de la ultima nota
	int obtenerUltimaNota(){
		int lastId = 0;
		
		SQLiteDatabase db = getWritableDatabase();
		String query = "SELECT ROWID from Nota order by ROWID DESC limit 1";
		Cursor c = db.rawQuery(query, null);
		if (c != null && c.moveToFirst()) {
			lastId = c.getInt(0); 
		}
		c.close();
		db.close();
		return lastId;
	}
	
	////FIN METODOS NOTAS
	
	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// METODOS PARA NOTAS_SINTOMAS
	
	public long agregarNotaSintoma(int notaId, int sintomaId) {
		ContentValues cv = new ContentValues();
		cv.put(Notas_Sintomas.IDNOTA, notaId);
		cv.put(Notas_Sintomas.IDSINTOMA, sintomaId);

		SQLiteDatabase db = getWritableDatabase();
		long result = db.insert(Notas_Sintomas.TABLE_NAME, null, cv);
		db.close();
		return result;
	}
}
