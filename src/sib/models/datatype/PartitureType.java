package sib.models.datatype;

import sib.models.nonterminal.TipoNumero;
import sib.models.nonterminal.ValorAsignacion;
import sib.models.nonterminal.Variable;

/**
 * Representa el tipo de datos Partiture
 *
 * @author Antonio Blanco
 *
 */
public class PartitureType extends DataType {

	private ClefType clef;
	private int tempo;
	private int keysign;
	private TipoNumero time;
	private int volume;
	private int wedge;

	/**
	 * Flag que indica si la partiture fue modificada desde su última "impresión"
	 */
	public boolean isModified = true;

	public PartitureType() {
		// Valores por defecto
		clef = new ClefType( "G2" );
		tempo = 60;
		keysign = 0;
		time = new TipoNumero( "4/4", TipoNumero.TYPE_NFRAC );
		volume = 50;
		wedge = 0;
	}

	public void setClef( ClefType c ) {
		clef = c;
		isModified = true;
	}

	public void setTempo( int t ) {
		tempo = t;
		isModified = true;
	}

	public void setKeysign( int k ) {
		keysign = k;
		isModified = true;
	}

	public void setTime( TipoNumero t ) {
		time = t;
		isModified = true;
	}

	public void setVolume( int v ) {
		volume = v;
		isModified = true;
	}

	public void setWedge( int w ) {
		wedge = w;
		isModified = true;
	}

	public ClefType getClef() {
		return clef;
	}

	public int getTempo() {
		return tempo;
	}

	public int getKeysign() {
		return keysign;
	}

	public TipoNumero getTime() {
		return time;
	}

	public int getTimeBeats() {
		return time.getNumerator();
	}

	public int getTimeBeatType() {
		return time.getDenominator();
	}

	public int getVolume() {
		return volume;
	}

	public int getWedge() {
		return wedge;
	}

	@Override
	public String getType() {
		return DataType.TYPE_PARTITURE;
	}

	@Override
	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return null;
	}

	@Override
	public ValorAsignacion evalua() {
		return this;
	}

	@Override
	public void trans(Float float1) {
		// No procede transportar esta clase, quizás haya que lanzar una excepción
		
	}

	@Override
	public ValorAsignacion clone() {
		try {
			throw new Exception ( "PARTITURE no debe ser clonada !!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		PartitureType n = new PartitureType();
		n.clef = (ClefType)clef.clone();
		n.tempo = tempo;
		n.keysign = keysign;
		n.time = (TipoNumero)time.clone();
		n.volume = volume;
		n.wedge = wedge;
		*/
		return null;
	}

	@Override
	public boolean igualQue(ValorAsignacion oper2) {
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
		float hashop1 = clef.getHashCode() + tempo + keysign + time.toFloat() + volume + wedge;
		float hashop2 = clef.getHashCode() + tempo + keysign + time.toFloat() + volume + wedge;
		return ( hashop1 == hashop2 );
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
		float hashop1 = clef.getHashCode() + tempo + keysign + time.toFloat() + volume + wedge;
		float hashop2 = clef.getHashCode() + tempo + keysign + time.toFloat() + volume + wedge;
		return ( hashop1 < hashop2 );
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

	public void setPropertyValue( String prop, ValorAsignacion v ) {
		try {
			switch ( prop ) {
				case "clef":
					clef = new ClefType( v.getStringValue() );
					break;
				case "tempo":
					tempo = new Float( v.getStringValue() ).intValue();
					break;
				case "keysign":
					keysign = new Float( v.getStringValue() ).intValue();
					break;
				case "time":
					time = new TipoNumero( v.getStringValue(), TipoNumero.TYPE_NFRAC );
					break;
				case "volume":
					volume = new Float( v.getStringValue() ).intValue();
					break;
				case "wedge":
					wedge = new Float( v.getStringValue() ).intValue();
					break;
				default:
					throw new Exception( "Nombre de propiedad no existe: " + prop );
			}
		} catch ( Exception e ) {
			System.err.println( "ERROR en PartitureType->setPropertyValue():" + v.getStringValue() );
			e.printStackTrace();
		}
		isModified = true;
	}

}
