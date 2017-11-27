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

	// @todo falta implementar la evaluacion de las operaciones aritmeticas para las variables. Ahora solo lo hace sbre numeros
	public ValorAsignacion evalua( TablaSimbolos ts ) {
		ValorAsignacion result = null;
		operandoIzq = (OperandoAritmetico) operandoIzq.evalua( ts );
		operandoDer = (OperandoAritmetico) operandoDer.evalua( ts );
		if ( ( operandoIzq.getClass() == TipoNumero.class ) && ( operandoDer.getClass() == TipoNumero.class ) ) {  // TipoNumero
			float fl;
			switch ( operador ) {
				case ExpresionAritmetica.MAS :
					fl = ( ((TipoNumero) operandoIzq).toFloat() + ((TipoNumero) operandoDer).toFloat() );
					result = new TipoNumero( String.valueOf( fl ),  ((TipoNumero) operandoIzq).getTipo() );
					break;
				case ExpresionAritmetica.MENOS :
					fl = ( ((TipoNumero) operandoIzq).toFloat() - ((TipoNumero) operandoDer).toFloat() );
					result = new TipoNumero( String.valueOf( fl ),  ((TipoNumero) operandoIzq).getTipo() );
					break;
				case ExpresionAritmetica.DIV :
					fl = ( ((TipoNumero) operandoIzq).toFloat() / ((TipoNumero) operandoDer).toFloat() );
					result = new TipoNumero( String.valueOf( fl ),  ((TipoNumero) operandoIzq).getTipo() );
					break;
				case ExpresionAritmetica.MULT :
					fl = ( ((TipoNumero) operandoIzq).toFloat() * ((TipoNumero) operandoDer).toFloat() );
					result = new TipoNumero( String.valueOf( fl ),  ((TipoNumero) operandoIzq).getTipo() );
					break;
				case ExpresionAritmetica.MOD :
					fl = ( ((TipoNumero) operandoIzq).toFloat() % ((TipoNumero) operandoDer).toFloat() );
					result = new TipoNumero( String.valueOf( fl ),  ((TipoNumero) operandoIzq).getTipo() );
					break;
				default:
					// Quizás lanzar excepcion de error
					break;
			}
		}
		return result;
	}

	protected ExpresionAritmetica clone() {
		ExpresionAritmetica exp = new ExpresionAritmetica( this.operador, (OperandoAritmetico) this.operandoIzq.clone(), (OperandoAritmetico) this.operandoDer.clone() );
		return exp;
	}

}
