package sib.models.nonterminal;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListaInstrucciones {

	ArrayList<Instruccion> instrucciones;

	public ListaInstrucciones( Instruccion i ) {
		instrucciones = new ArrayList<Instruccion>();
		instrucciones.add( i );
	}

	public void add( Instruccion i ) {
		instrucciones.add( i );
	}

	public void run() {
		Instruccion ins;
		ListIterator<Instruccion> it = instrucciones.listIterator();
		while ( it.hasNext() ) {
			ins = it.next();
			ins.run();
		}
	}
}
