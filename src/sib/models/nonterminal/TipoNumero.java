package sib.models.nonterminal;

public class TipoNumero extends ValorAsignacion {

	String valor;
	String tipo;

	public TipoNumero( String num, String t ) {
		valor = num;
		tipo = t;
	}

	public String getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}

	public ValorAsignacion evalua( TablaSimbolos ts ) {
		return this;
	}

	public String toString() {
		return tipo + ":" + valor;
	}

	public Float toFloat() {
		float result = 0;
		try {
			result = Float.valueOf( valor );
		} catch ( Exception e ) {
			System.err.println( e.toString() );
		}
		return result;
	}

	public void trans( Float f ) {
		Float origen = Float.valueOf( valor );
		origen = origen + f;
		valor = origen.toString();
	}

	protected TipoNumero clone() {
		TipoNumero num = new TipoNumero( this.valor, this.tipo );
		return num;
	}
}
