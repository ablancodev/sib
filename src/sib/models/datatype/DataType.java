package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;

public abstract class DataType extends ValorAsignacion {

	public static final String TYPE_CLEF = "clef";
	public static final String TYPE_STEP = "step";
	public static final String TYPE_NOTE = "note";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_PARTITURE = "partiture";

	// Los distintos TipoNumero están definidos en la clase TipoNumero.java
}
