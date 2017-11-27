package sib.models.nonterminal;

public class OrdenIf extends Orden {

	Comparacion comparacion;
	ListaInstrucciones listaInstrucciones, elseInstrucciones;
	
	public OrdenIf( Comparacion c, ListaInstrucciones insts ) {
		comparacion = c;
		listaInstrucciones = insts;
		elseInstrucciones = null;
	}

	public void setElse( ListaInstrucciones insts ) {
		elseInstrucciones = insts;
	}

	public void run( TablaSimbolos ts ) {
		if ( comparacion.evalua() ) {
			listaInstrucciones.run( ts );
		} else {
			if ( elseInstrucciones != null ) {
				elseInstrucciones.run( ts );
			}
		}
	}

}
