package com.example.modelos;

public class Periodo {
	public static final String TABLE_NAME = "Periodo";
	public static final String INICIO = "inicio";
	public static final String FINAL = "final";
	public static final String DURACION = "duracion";
	public static final String ID = "id";
	
	public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + 
			INICIO + " TEXT, " + 
			FINAL + " TEXT, " + 
			DURACION + " INT);";
}
