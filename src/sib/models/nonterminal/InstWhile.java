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
