package sib.models.nonterminal;

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
		// Actualizamos TablaSimbolos
		tablaSimbolos.updateVariable( this );
	}

	public void setValue( ValorAsignacion v ) {
		if ( v != null ) {
			ValorAsignacion newV = v.clone();
			if ( v.getClass() == Variable.class ) {
				valor = ( (Variable)newV ).valor;
			} else {
				valor = newV;
			}
			// Actualizamos TablaSimbolos
			tablaSimbolos.updateVariable( this );
		} else {
			try {
				throw new Exception( "ERROR variable->setValue, v es null para " + this.name );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// @todo IMPORTANT - creo que no cumple con su cometido, quizás deba devolver sólo .valor y 
	// necesitemos otra funcion para coger el value del .valor
	public String getValue() {
		return this.valor.getValue();
	}

	public void aplicarOperador( String op ) {
		if ( this.esAplicable( op ) ) {
			String v = "";
			if ( valor != null ) {
				v = valor.toString();
			}
			valor = new ValorCadena( v + "_" + op );
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
			case "note":
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
		return this.getValue().compareTo( op2.getValue() ) == 0;
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.getValue().compareTo( op2.getValue() ) != 0;
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.getValue().compareTo( op2.getValue() ) < 0;
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.getValue().compareTo( op2.getValue() ) <= 0;
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.getValue().compareTo( op2.getValue() ) > 0;
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.getValue().compareTo( op2.getValue() ) >= 0;
	}
}
