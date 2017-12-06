package sib.models.nonterminal;

import sib.controllers.ViewsControllerFase1;

public class Programa {

	TablaSimbolos tablaSimbolos;

	ListaInstrucciones instrucciones;

	public Programa( TablaSimbolos ts ) {
		tablaSimbolos = ts;
	}

	public void setInstrucciones( ListaInstrucciones lista ) {
		instrucciones = lista;
	}

	public void exec() {
		try {
			instrucciones.run();
		} catch ( Exception e ) {
			System.err.println( "ERROR exec:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void print( ViewsControllerFase1 vc ) {
		try {
			tablaSimbolos.print( vc );
		} catch ( Exception e ) {
			System.err.println( "ERROR print:" + e.getMessage());
		}
	}
}
