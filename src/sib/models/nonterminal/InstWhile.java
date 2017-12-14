/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class InstWhile
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

public class InstWhile extends Instruccion {

	Condicion condicion;
	ListaInstrucciones instrucciones;

	public InstWhile( Condicion c, ListaInstrucciones insts ) {
		condicion = c;
		instrucciones = insts;
	}

	public void run() {
		while ( condicion.evalua() ) {
			instrucciones.run();
		}
	}

}
