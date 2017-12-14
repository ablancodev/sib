/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class InstIf
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

public class InstIf extends Instruccion {

	Condicion condicion;
	ListaInstrucciones ifInstrucciones, elseInstrucciones;

	public InstIf( Condicion c, ListaInstrucciones insts ) {
		condicion = c;
		ifInstrucciones = insts;
		elseInstrucciones = null;
	}

	public void setElse( ListaInstrucciones insts ) {
		elseInstrucciones = insts;
	}

	public void run() {
		if ( condicion.evalua() ) {
			ifInstrucciones.run();
		} else {
			if ( elseInstrucciones != null ) {
				elseInstrucciones.run();
			}
		}
	}

}
