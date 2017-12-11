package sib.models.datatype;

import java.util.ArrayList;

import sib.models.nonterminal.ValorAsignacion;
import sib.models.nonterminal.Variable;

public class StepType extends DataType {

	protected ArrayList<String> stepValues = new ArrayList<String>();
	protected float[] tonesValues = new float[7];

	public static final String DEFAULT_VALUE = "C";
	protected String value;

	public StepType( String str ) {
		// Inicializamos los posibles valores
		stepValues.add( 0, "C" );
		stepValues.add( 1, "D" );
		stepValues.add( 2, "E" );
		stepValues.add( 3, "F" );
		stepValues.add( 4, "G" );
		stepValues.add( 5, "A" );
		stepValues.add( 6, "B" );

		// Inicializamos la lista de tonos que hay entre cada salto
		tonesValues[0] = 1;  // C -> D
		tonesValues[1] = 1;  // D -> E
		tonesValues[2] = (float)0.5;  // E -> F
		tonesValues[3] = 1;
		tonesValues[4] = 1;
		tonesValues[5] = 1;
		tonesValues[6] = (float)0.5;

		value = str;

	}

	public StepType() {
		value = StepType.DEFAULT_VALUE;
	}

	public String getType() {
		return "step";
	}

	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return value;
	}

	public ValorAsignacion evalua() {
		return this;
	}

	public ValorAsignacion clone() {
		StepType st = new StepType( this.value );
		return st;
	}

	@Override
	public void trans( Float tn ) {
		/*
		int tonos = Math.round( tn );
		if ( ( ( tn - tonos ) != 0 ) && ( tn > 0 ) ) { // tiene decimales, asi que hay que restar, ya que round calcula hacia arriba
			tonos--;
		}
		int current = stepValues.indexOf( value );
		if ( current >= 0 ) {  // existe
			current = (current + tonos) % 7;
			if ( current < 0 ) {
				current += 7;
			}
			value = stepValues.get( current );
		}
		*/
		boolean negative = false;
		if ( tn < 0 ) {
			negative = true;
		}
		float tonos = Math.abs( tn );
		int current = stepValues.indexOf( value );
		while ( tonos > 0 ) {
			if ( negative ) {
				int temp =( current - 1 ) % 7;
				if ( temp < 0 ) {
					temp = temp + 7;
				}
				tonos = ( tonos - tonesValues[temp] );
			} else {
				tonos = ( tonos - tonesValues[current] );
			}
			
			if ( tonos >= 0 ) {  // por si hay exceso
				if ( negative ) {
					current = ( current - 1 ) % 7;
					if ( current < 0 ) {
						current = current + 7;
					}
				} else {
					current = ( current + 1 ) % 7;
				}
			}
		}
		value = stepValues.get( current );
	}

	@Override
	public boolean igualQue(ValorAsignacion oper2) {
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
		boolean result = false;
		try {
			switch (op2.getType() ) {
				case "string":
				case "step":
					result = this.value.compareTo( op2.getStringValue() ) == 0;
					break;
				default:
					throw new Exception();
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
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
		boolean result = false;
		try {
			switch (op2.getType() ) {
				case "string":
				case "step":
					result = toInt() < ((StepType)op2).toInt();
					break;
				default:
					throw new Exception();
			}
		} catch (Exception e) {
			System.err.println(  "ERROR StepType: Comparación menorQue entre elementos incompatibles." );
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

	public int getCurrentPositionValues() {
		return stepValues.indexOf( value );
	}

	public int toInt() {
		int result = 0;
		switch ( value ) {
			case "A":
				result = 7;
				break;
			case "B":
				result = 6;
				break;
			case "C":
				result = 5;
				break;
			case "D":
				result = 4;
				break;
			case "E":
				result = 3;
				break;
			case "F":
				result = 2;
				break;
			case "G":
				result = 1;
				break;
		}
		return result;
	}

}
