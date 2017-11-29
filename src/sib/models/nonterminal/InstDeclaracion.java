package sib.models.nonterminal;

public class InstDeclaracion extends Instruccion {

	String tipo;
	ListaVariables variables;

	public InstDeclaracion( String tipo, ListaVariables lv ) {
		this.tipo = tipo;
		this.variables = lv;
		variables.setType( tipo );
	}

	@Override
	public void run() {
		variables.run();

		//variable.setTipo( tipo );
		//ts.addVariable( variable, tipo );

	}

}
