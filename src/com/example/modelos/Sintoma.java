package com.example.modelos;

public class Sintoma {
	public static final String TABLE_NAME = "Sintoma";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";

	public static final String INSERT_FIELDS = " INSERT INTO " + TABLE_NAME + " ( " + NOMBRE + ", " + 
	DESCRIPCION + ") VALUES ('Dolor de cabeza', 'Dolor de cabeza')";
	
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + 
			NOMBRE + " TEXT, " + 
			DESCRIPCION + " TEXT );";

}
