package sib.models.nonterminal;

public class OrdenWhile extends Orden {

	Comparacion comparacion;
	ListaInstrucciones listaInstrucciones;

	public OrdenWhile( Comparacion c, ListaInstrucciones insts ) {
		comparacion = c;
		listaInstrucciones = insts;
	}

	@Override
	public void run( TablaSimbolos ts ) {
		while ( comparacion.evalua() ) {
			listaInstrucciones.run( ts );
		}
	}

}
