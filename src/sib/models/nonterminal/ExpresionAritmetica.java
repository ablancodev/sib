package sib.models.nonterminal;

import sib.models.datatype.DataType;
import sib.models.datatype.NoteType;

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
	 * @return OperandoAritmetico TipoNumero float con el resultado
	 */
	public OperandoAritmetico evalua() {
		OperandoAritmetico result = null;
		OperandoAritmetico operandoIzq;
		if ( this.operandoIzq.getClass() == Variable.class ) {
			operandoIzq = (OperandoAritmetico) this.operandoIzq.clone();
		} else {
			operandoIzq = (OperandoAritmetico) this.operandoIzq.evalua();
		}
		OperandoAritmetico operandoDer = (OperandoAritmetico) this.operandoDer.evalua();
		float fl;
		switch ( operador ) {
			case ExpresionAritmetica.MAS :
				switch ( operandoIzq.getType() ) {
					case DataType.TYPE_NOTE:
						operandoIzq.trans( operandoDer.toFloat());
						result = operandoIzq;
						break;
					case TipoNumero.TYPE_INT:
					case TipoNumero.TYPE_FLOAT:
					case TipoNumero.TYPE_FRAC:
					case TipoNumero.TYPE_NFRAC:
						fl = operandoIzq.toFloat() + operandoDer.toFloat();
						result = new TipoNumero( String.valueOf( fl ),  TipoNumero.TYPE_FLOAT );
						break;
				}
				break;
			case ExpresionAritmetica.MENOS :
				switch ( operandoIzq.getType() ) {
					case DataType.TYPE_NOTE:
						operandoIzq.trans( -operandoDer.toFloat());
						result = operandoIzq;
						break;
					case TipoNumero.TYPE_INT:
					case TipoNumero.TYPE_FLOAT:
					case TipoNumero.TYPE_FRAC:
					case TipoNumero.TYPE_NFRAC:
						fl = operandoIzq.toFloat() - operandoDer.toFloat();
						result = new TipoNumero( String.valueOf( fl ),  TipoNumero.TYPE_FLOAT );
						break;
				}
				break;
			case ExpresionAritmetica.DIV :
				switch ( operandoIzq.getType() ) {
					case DataType.TYPE_NOTE:
						NoteType note = (NoteType)operandoIzq.getValue();
						note.duration.setValue( note.duration.toNFrac( String.valueOf(note.duration.toFloat() / operandoDer.toFloat() ) ) );
						result = operandoIzq;
						break;
					case TipoNumero.TYPE_INT:
					case TipoNumero.TYPE_FLOAT:
					case TipoNumero.TYPE_FRAC:
					case TipoNumero.TYPE_NFRAC:
						fl = operandoIzq.toFloat() / operandoDer.toFloat();
						result = new TipoNumero( String.valueOf( fl ),  TipoNumero.TYPE_FLOAT );
						break;
				}
				break;
			case ExpresionAritmetica.MULT :
				switch ( operandoIzq.getType() ) {
				case DataType.TYPE_NOTE:
					NoteType note = (NoteType)operandoIzq.getValue();
					note.duration.setValue( note.duration.toNFrac( String.valueOf(note.duration.toFloat() * operandoDer.toFloat() ) ) );
					result = operandoIzq;
					break;
				case TipoNumero.TYPE_INT:
				case TipoNumero.TYPE_FLOAT:
				case TipoNumero.TYPE_FRAC:
				case TipoNumero.TYPE_NFRAC:
					fl = operandoIzq.toFloat() * operandoDer.toFloat();
					result = new TipoNumero( String.valueOf( fl ),  TipoNumero.TYPE_FLOAT );
					break;
			}
			break;
			case ExpresionAritmetica.MOD :
				fl = operandoIzq.toFloat() % operandoDer.toFloat();
				result = new TipoNumero( String.valueOf( fl ), TipoNumero.TYPE_FLOAT );
				break;
			default:
				try {
					throw new Exception ( "Operador aritmético no válido.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	public String getType() {
		return this.evalua().getType();
	}

	public ValorAsignacion getValue() {
		return this.evalua().getValue();
	}

	public String getStringValue() {
		return this.evalua().getStringValue();
	}

	public void trans(Float float1) {
		// TODO Auto-generated method stub
		OperandoAritmetico op = this.evalua();
		op.trans( float1 );
	}
}
