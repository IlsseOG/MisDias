package com.example.modelos;

public class Nota {
	public static final String TABLE_NAME = "Nota";
	public static final String ID = "id";
	public static final String DESCRIPCION = "descripcion";
	public static final String FECHA = "fecha";

	
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + 
			DESCRIPCION + " TEXT, " + 
			FECHA + " TEXT );";
}
