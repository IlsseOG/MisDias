package com.example.modelos;

public class Notas_Sintomas {
	public static final String TABLE_NAME = "Nota_Sintoma";
	public static final String IDNOTA = "idNota";
	public static final String IDSINTOMA = "idSintoma";

	
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + 
			IDNOTA + " INT, " + 
			IDSINTOMA + " INT );";
}
