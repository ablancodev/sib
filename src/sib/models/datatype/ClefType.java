/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class ClefType
 * @version 1.0
 * 
 */

package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;
import sib.models.nonterminal.Variable;

import java.lang.Exception;

public class ClefType extends DataType {

	public static final String DEFAULT_VALUE = "G2";
	private String value;

	public ClefType( String str ) {
		if ( isValidClefValue( str ) ) {
			value = str;
		} else {
			try {
				throw new Exception( "Clef value not valid:" + str );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ClefType() {
		value = ClefType.DEFAULT_VALUE;
	}

	public String getType() {
		return "clef";
	}

	public void setValue( String str ) {
		if ( isValidClefValue( str ) ) {
			value = str;
		} else {
			try {
				throw new Exception( "Clef value not valid:" + str );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return value;
	}

	public String getSign() {
		return String.valueOf( value.charAt(0) );
	}

	public String getLine() {
		return String.valueOf( value.charAt(1) );
	}

	public ValorAsignacion evalua() {
		return this;
	}

	public ValorAsignacion clone() {
		ClefType st = new ClefType( this.value );
		return st;
	}

	@Override
	public void trans(Float float1) {
		try {
			throw new Exception( "No tiene sentido Trans() sobre un tipo ClefType.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean igualQue(ValorAsignacion oper2) {
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
		boolean result = false;
		try {
			if ( isValidClefValue( op2.getStringValue() ) ) {
				switch (op2.getType() ) {
					case "string":
					case "clef":
						result = this.value.compareTo( op2.getStringValue() ) == 0;
						break;
					default:
						throw new Exception();
				}
			}
		} catch (Exception e) {
			System.err.println(  "ERROR ClefType: Comparación igualQue entre elementos incompatibles." );
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean distintoQue(ValorAsignacion op2) {
		return !igualQue( op2 );
	}

	@Override
	public boolean menorQue(ValorAsignacion oper2) {
		// función hash: valor numérico = ( línea * 7 ) + Step.toInt()
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
		boolean result = false;
		try {
			if ( isValidClefValue( op2.getStringValue() ) ) {
				switch (op2.getType() ) {
					case "string":
					case "clef":
						String op2string = op2.getStringValue();
						StepType op2step = new StepType( op2string.substring(0, 1) );
						int op2line = Integer.getInteger( op2string.substring(1, 2) );
						StepType op1step = new StepType( value.substring(0, 1) );
						int op1line = Integer.getInteger( value.substring(1, 2) );
						int hashop1 = (op1line * 7) + op1step.toInt();
						int hashop2 = (op2line * 7) + op2step.toInt();
						result = hashop1 < hashop2;
						break;
					default:
						throw new Exception();
				}
			}
		} catch (Exception e) {
			System.err.println(  "ERROR ClefType: Comparación menorQue entre elementos incompatibles." );
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean menorIgualQue(ValorAsignacion op2) {
		return menorQue( op2 ) || igualQue( op2 );
	}

	@Override
	public boolean mayorQue(ValorAsignacion op2) {
		return !menorQue( op2 ) && !igualQue( op2 );
	}

	@Override
	public boolean mayorIgualQue(ValorAsignacion op2) {
		return !menorQue( op2 );
	}

	private boolean isValidClefValue(String str) {
		boolean valid = false;
		if ( ( str.compareTo( "C1" ) == 0 )
				|| ( str.compareTo( "C2" ) == 0 )
				|| ( str.compareTo( "C3" ) == 0 )
				|| ( str.compareTo( "C4" ) == 0 )
				|| ( str.compareTo( "G2" ) == 0 )
				|| ( str.compareTo( "F3" ) == 0 )
				|| ( str.compareTo( "F4" ) == 0 ) ) {
			valid = true;
		}
		return valid;
	}

	public int getHashCode() {
		StepType op1step = new StepType( value.substring(0, 1) );
		int op1line = Integer.getInteger( value.substring(1, 2) );
		return (op1line * 7) + op1step.toInt();
	}

}
