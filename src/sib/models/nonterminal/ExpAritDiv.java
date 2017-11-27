package sib.models.nonterminal;

public class ExpAritDiv extends ExpresionAritmetica {

	OperandoAritmetico operIzq, operDer;

	public ExpAritDiv( OperandoAritmetico op1, OperandoAritmetico op2 ) {
		operIzq = op1;
		operDer = op2;
	}

	public TipoNumero run() {
		OperandoAritmetico izq, der;
		izq = operIzq.run();
		der = operDer.run();
		if ( ( izq.getClass() == TipoNumero.class ) && ( der.getClass() == TipoNumero.class ) ) {
			izq = (TipoNumero)izq;
			der = (TipoNumero)der;
			int valor = Integer.valueOf( ( (TipoNumero)izq ).valor ) / Integer.valueOf( ( (TipoNumero)der ).valor );
			TipoNumero n = new TipoNumero( String.valueOf( valor ), ( (TipoNumero)izq ).tipo );
			return n;
		}
		return null;
	}
	
}
