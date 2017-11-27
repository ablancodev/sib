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

	public void run( TablaSimbolos ts ) {
		if ( condicion.evalua( ts ) ) {
			ifInstrucciones.run( ts );
		} else {
			if ( elseInstrucciones != null ) {
				elseInstrucciones.run( ts );
			}
		}
	}

}
