/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class Condicion
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

public class Condicion {

	ValorAsignacion operador1;
	ValorAsignacion operador2;
	String condicion;

	public Condicion( ValorAsignacion op1, String cc, ValorAsignacion op2 ) {
		operador1 = op1;
		operador2 = op2;
		condicion = cc;
	}

	public boolean evalua() {
		boolean result = false;

		if ( operador1.getClass() == Variable.class ) {
			((Variable)operador1).update();
		}
		if ( operador2.getClass() == Variable.class ) {
			((Variable)operador2).update();
		}
		if ( operador1.getClass() == Property.class ) {
			((Property)operador1).update();
		}
		if ( operador2.getClass() == Property.class ) {
			((Property)operador2).update();
		}

		if ( operador1.getType().equals( operador2.getType() ) ) {
			switch ( condicion ) {
			case "==":
				result = operador1.igualQue( operador2 );
				break;
			case "!=":
				result = operador1.distintoQue( operador2 );
				break;
			case "<":
				result = operador1.menorQue( operador2 );
				break;
			case "<=":
				result = operador1.menorIgualQue( operador2 );
				break;
			case ">":
				result = operador1.mayorQue( operador2 );
				break;
			case ">=":
				result = operador1.mayorIgualQue( operador2 );
				break;
			default:
				result = false;
				try {
					throw new Exception( "Comparador no válido." );
				} catch (Exception e) {
					System.err.println( e.getMessage() );
					e.printStackTrace();
				}
				break;
			}
		} else {
			try {
				throw new Exception( "Para comparar dos elementos, deben ser del mismo tipo:" + operador1.getType() + "-" + operador2.getType() );
			} catch (Exception e) {
				System.err.println( e.getMessage() );
				e.printStackTrace();
			}
		}
		return result;
	}

}
