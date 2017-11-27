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
		instrucciones.run( tablaSimbolos );
	}

	public void print( ViewsControllerFase1 vc ) {
		tablaSimbolos.print( vc );
	}
}
