package sib.models.nonterminal;

public class ExpresionAritmetica extends ValorAsignacion {

	public static final String MAS = "+";
	public static final String MENOS = "-";
	public static final String DIV = "/";
	public static final String MULT = "*";
	public static final String MOD = "%";

	String operador;
	OperandoAritmetico operandoIzq;
	OperandoAritmetico operandoDer;

	public ExpresionAritmetica( String operador, OperandoAritmetico oper1, OperandoAritmetico oper2 ) {
		this.operador = operador;
		this.operandoIzq = oper1;
		this.operandoDer = oper2;
	}

	/**
	 * Evalua la expresión aritmética.
	 * Coge los valores float de los operandos y aplica la función matemática para obtener el resultado.
	 *
	 * @param ts TablaSimbolos
	 * @return OperandoAritmetico TipoNumero float con el resultado
	 */
	public OperandoAritmetico evalua( TablaSimbolos ts ) {
		OperandoAritmetico result = null;
		OperandoAritmetico operandoIzq = (OperandoAritmetico) this.operandoIzq.evalua( ts );
		OperandoAritmetico operandoDer = (OperandoAritmetico) this.operandoDer.evalua( ts );
		float fl;
		switch ( operador ) {
			case ExpresionAritmetica.MAS :
				fl = operandoIzq.toFloat() + operandoDer.toFloat();
				result = new TipoNumero( String.valueOf( fl ),  "float" );
				break;
			case ExpresionAritmetica.MENOS :
				fl = operandoIzq.toFloat() - operandoDer.toFloat();
				result = new TipoNumero( String.valueOf( fl ),  "float" );
				break;
			case ExpresionAritmetica.DIV :
				fl = operandoIzq.toFloat() / operandoDer.toFloat();
				result = new TipoNumero( String.valueOf( fl ),  "float" );
				break;
			case ExpresionAritmetica.MULT :
				fl = operandoIzq.toFloat() * operandoDer.toFloat();
				result = new TipoNumero( String.valueOf( fl ),  "float" );
				break;
			case ExpresionAritmetica.MOD :
				fl = operandoIzq.toFloat() % operandoDer.toFloat();
				result = new TipoNumero( String.valueOf( fl ),  "float" );
				break;
			default:
				// Quizás lanzar excepcion de error
				break;
		}
		return result;
	}

	protected ExpresionAritmetica clone() {
		ExpresionAritmetica exp = new ExpresionAritmetica( this.operador, (OperandoAritmetico) this.operandoIzq.clone(), (OperandoAritmetico) this.operandoDer.clone() );
		return exp;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		return this.operandoIzq.igualQue( (OperandoAritmetico)op2 );
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.operandoIzq.distintoQue( (OperandoAritmetico)op2 );
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.operandoIzq.menorQue( (OperandoAritmetico)op2 );
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.operandoIzq.menorIgualQue( (OperandoAritmetico)op2 );
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.operandoIzq.mayorQue( (OperandoAritmetico)op2 );
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.operandoIzq.mayorIgualQue( (OperandoAritmetico)op2 );
	}
}
