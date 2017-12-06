package sib.models.nonterminal;

import sib.models.datatype.*;

public class Variable extends OperandoAritmetico {

	TablaSimbolos tablaSimbolos;

	String name;
	String tipo;
	ValorAsignacion valor;

	public Variable(String n, TablaSimbolos ts ) {

		tablaSimbolos = ts;
		name = n;

		Variable v = ts.getVariable( n );
		if ( v != null ) {
			tipo = v.getType();
			valor = v.valor;
		} else {
			tipo = "";
			valor = null;
		}

		this.register();
	}

	/**
	 * Registra la variable en la tabla de simbolos.
	 */
	public void register() {
		tablaSimbolos.addVariable( this );
	}

	public String getType() {
		return tipo;
	}

	public void setType( String t ) {
		tipo = t;
		if ( valor == null ) {
			// Establecemos los valores por defecto en caso de que aún no tenga valor asignado
			// Si declaramos una variable de tipo note, directamente debe contener los valores por defecto
			switch ( tipo ) {
				case DataType.TYPE_NOTE:
					valor = new NoteType();
					break;
				case DataType.TYPE_CLEF:
					valor = new ClefType();
					break;
				case DataType.TYPE_PARTITURE:
					valor = new PartitureType();
					break;
				case DataType.TYPE_STEP:
					valor = new StepType();
					break;
				case DataType.TYPE_STRING:
					valor = new StringType();
					break;
				case TipoNumero.TYPE_INT:
					valor = new TipoNumero( TipoNumero.DEFAULT_VALUE, TipoNumero.TYPE_INT);
					break;
				case TipoNumero.TYPE_FLOAT:
					valor = new TipoNumero( TipoNumero.DEFAULT_VALUE, TipoNumero.TYPE_FLOAT);
					break;
				case TipoNumero.TYPE_FRAC:
					valor = new TipoNumero( TipoNumero.DEFAULT_VALUE, TipoNumero.TYPE_FRAC);
					break;
				case TipoNumero.TYPE_NFRAC:
					valor = new TipoNumero( TipoNumero.DEFAULT_VALUE, TipoNumero.TYPE_NFRAC);
					break;
			}
		}
		// Actualizamos TablaSimbolos
		tablaSimbolos.updateVariable( this );
		
	}

	public void setValue( ValorAsignacion v ) {
		this.setValue( v, null );
	}
	public void setValue( ValorAsignacion v, String prop ) {
		if ( v != null ) {
			//ValorAsignacion newV = v.clone(); #estopuedeser
			ValorAsignacion newV = v.getValue();
			if ( prop == null ) {
				if ( v.getClass() == Variable.class ) {
					valor = ( (Variable)newV ).valor;
				} else {
					valor = newV;
				}
			} else {
				if ( v.getClass() == Variable.class ) {
					valor = ( (Variable)newV ).valor;
				} else {
					if ( ( valor.getClass() == NoteType.class ) && ( v.getClass() != NoteType.class ) ) {
						((NoteType)valor).setPropertyValue( prop, newV );
					} else if ( ( valor.getClass() == PartitureType.class ) && ( v.getClass() != PartitureType.class ) ) {
						((PartitureType)valor).setPropertyValue( prop, newV );
					} else {
						valor = newV;
					}
				}
			}
			// Actualizamos TablaSimbolos
			tablaSimbolos.updateVariable( this );
		} else {
			try {
				throw new Exception( "ERROR variable->setValue, v es null para " + this.name + ", propiedad:" + prop );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ValorAsignacion getValue() {
		return this.valor;
	}

	public String getStringValue() {
		return this.valor.getStringValue();
	}

	public void aplicarOperadorNota( String op ) {
		// @todo implementar el operador sobre una variable, tendrá que aplica sobre cada tipo de dato posible
		if ( this.esAplicable( op ) && ( valor != null ) ) {
			switch ( this.tipo ) {
				case DataType.TYPE_NOTE:
					( (NoteType)valor ).applyOperator( op );
					break;
			}
			// Actualizamos TablaSimbolos
			tablaSimbolos.updateVariable( this );
		}
	}

/*
	public ValorAsignacion evalua( TablaSimbolos ts ) {
		Variable temp = ts.getVariable( name );
		if ( temp != null ) {
			valor = temp.valor;
			tipo = temp.getType();
		}
		return valor;
	}
*/
	public ValorAsignacion evalua() {
		// Cargamos desde la tabla de simbolos
		Variable v = this.tablaSimbolos.getVariable( this.name );
		this.tipo = v.tipo;
		this.setValue( v.valor );

		try {
			if ( valor != null ) {
				if ( this.valor.getClass() == Variable.class ) {
					return this.valor;
				} else {
					return valor.evalua();
				}
			}
		} catch ( Exception e ) {
			System.err.println( "ERROR evalua variable:" + e.getMessage() );
		}
		return null;
	}

	public String toString() {
		String v = "";
		if ( valor != null ) {
			v = valor.toString();
		}
		return tipo + ":" + name + "->" + v;
	}

	/**
	 * Checkea si es aplicable o no un operador nota.
	 * @param op String
	 * @return boolean
	 */
	private boolean esAplicable( String op ) {
		boolean result = false;
		switch ( tipo ) {
			case DataType.TYPE_NOTE:
				switch ( op ) {
					case "_#":
					case "_##":
					case "_b":
					case "_bb":
					case "_@":
					case "_.":
					case "_..":
					case "_...":
						result = true;
						break;
					default:
						result = false;
						break;
				}
				break;
			default:
				result = false;
				break;
		}
		return result;
	}

	public void trans( Float float1 ) {
		Variable v = tablaSimbolos.getVariable( this.name );
		valor = v.valor;
		valor.trans( float1 );
		// Actualizamos TablaSimbolos
		tablaSimbolos.updateVariable( this );
	}

	protected Variable clone() {
		Variable v = new Variable( this.name, this.tablaSimbolos );
		v.setType( this.tipo );
		if ( this.valor != null ) {
			v.setValue( this.valor.clone() );
		}
		return v;
	}

	/**
	 * Obtiene un valor float para las operaciones aritmeticas.
	 * Lanza excepción en caso de no ser de un tipo correcto.
	 *
	 * @return float representacion del valor
	 */
	public float toFloat() {
		if ( valor.getClass() == TipoNumero.class ) {
			return ((TipoNumero)valor).toFloat();
		} else {
			try {
				throw new Exception( "Variable " + name + " no es aplicable toFloat(), es de tipo: " + tipo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		return this.valor.igualQue( op2 );
		//return this.getValue().compareTo( op2.getValue() ) == 0;
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.valor.distintoQue( op2 );
		//return this.getValue().compareTo( op2.getValue() ) != 0;
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.valor.menorQue( op2 );
		//return this.getValue().compareTo( op2.getValue() ) < 0;
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.valor.menorIgualQue( op2 );
		//return this.getValue().compareTo( op2.getValue() ) <= 0;
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.valor.mayorQue( op2 );
		//return this.getValue().compareTo( op2.getValue() ) > 0;
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.valor.mayorIgualQue( op2 );
		//return this.getValue().compareTo( op2.getValue() ) >= 0;
	}

}
