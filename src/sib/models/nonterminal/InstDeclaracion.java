package sib.models.nonterminal;

public class InstDeclaracion extends Instruccion {

	String tipo;
	ListaVariables variables;

	public InstDeclaracion( String tipo, ListaVariables lv ) {
		this.tipo = tipo;
		this.variables = lv;
	}

	@Override
	public void run( TablaSimbolos ts ) {
		variables.setTipo( tipo );
		variables.run( ts );

		//variable.setTipo( tipo );
		//ts.addVariable( variable, tipo );

	}

}
