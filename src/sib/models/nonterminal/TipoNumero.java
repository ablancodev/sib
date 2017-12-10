package sib.models.nonterminal;

public class TipoNumero extends OperandoAritmetico {

	public static final String TYPE_INT = "int";
	public static final String TYPE_FLOAT = "float";
	public static final String TYPE_FRAC = "frac";
	public static final String TYPE_NFRAC = "nfrac";

	public static final String DEFAULT_VALUE = "0";

	float real;
	int numerator;
	int denominator;
	String tipo;

	public TipoNumero( String num, String t ) {
		tipo = t;
		setValue( num );
	}

	public String getType() {
		return tipo;
	}

	/**
	 * Devuelve el valor. Como TipoNúmero es 'atómico', devuelte un TipoNumero
	 *
	 * @return ValorAsignacion > TipoNumero
	 */
	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		String result = "";
		switch ( this.tipo ) {
			case TipoNumero.TYPE_NFRAC:
				result = String.valueOf( numerator ) + "/" + String.valueOf( denominator );
				break;
			case TipoNumero.TYPE_FRAC:
				result = String.valueOf( real ) + " " + String.valueOf( numerator ) + "/" + String.valueOf( denominator );
				break;
			default:
			result = String.valueOf( real );
			break;
		}
		return result;
	}

	public void setValue( String num ) {
		switch ( tipo ) {
			case TipoNumero.TYPE_INT:
			case TipoNumero.TYPE_FLOAT:
				real = Float.parseFloat( num );
				numerator = 0;
				denominator = 0;
				break;
			case TipoNumero.TYPE_FRAC:
				try {
					String[] parts = num.split(" ");
					if ( parts.length == 2 ) {
						real = Integer.valueOf( parts[0] );

						String[] parts2 = parts[1].split("/");
						if ( parts2.length == 2 ) {
							numerator = Integer.valueOf( parts2[0] );
							denominator = Integer.valueOf( parts2[1] );
						} else {
							throw new Exception();
						}
					}
				} catch ( Exception e ) {
					System.err.println( "Error en TipoNumero->setValue con NFRAC " + num);
					e.printStackTrace();
				}
				break;
			case TipoNumero.TYPE_NFRAC:
				try {
					String[] parts = num.split("/");
					if ( parts.length == 2 ) {
						numerator = Integer.valueOf( parts[0] );
						denominator = Integer.valueOf( parts[1] );
						real = 0;
					} else {
						throw new Exception();
					}
				} catch ( Exception e ) {
					System.err.println( "Error en TipoNumero->setValue con NFRAC " + num);
					e.printStackTrace();
				}
				break;
		}
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public float getReal() {
		return real;
	}

	public String toString() {
		// @todo falta hacer switch 
		return String.valueOf( real );
	}

	public float toFloat() {
		float result = 0;
		try {
			result = Float.valueOf( real );
			if ( denominator != 0 ) {
				if ( real < 0 ) {
					result = result - ( (float)numerator / denominator );
				} else {
					result = result + ( (float)numerator / denominator );
				}
			}
		} catch ( Exception e ) {
			System.err.println( e.toString() );
			e.printStackTrace();
		}
		return result;
	}

	public void trans( Float f ) {
		real = real + f;
	}

	public TipoNumero clone() {
		TipoNumero num = new TipoNumero( this.getStringValue(), this.tipo );
		return num;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		return this.toFloat() == ((TipoNumero)op2).toFloat();
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.toFloat() != ((TipoNumero)op2).toFloat();
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.toFloat() < ((TipoNumero)op2).toFloat();
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.toFloat() <= ((TipoNumero)op2).toFloat();
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.toFloat() > ((TipoNumero)op2).toFloat();
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.toFloat() >= ((TipoNumero)op2).toFloat();
	}

	public ValorAsignacion evalua() {
		return this;
	}
}
