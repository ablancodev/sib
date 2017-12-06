package sib.models.datatype;

import sib.models.nonterminal.TipoNumero;
import sib.models.nonterminal.ValorAsignacion;

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
	private int[] slurs;
	private int wedge;

	public PartitureType() {
		// Valores por defecto
		clef = new ClefType( "G2" );
		tempo = 60;
		keysign = 0;
		//time = new TipoNumero( "4/4", TipoNumero.TYPE_NFRAC );
		time = new TipoNumero( "2/3", TipoNumero.TYPE_NFRAC );
		volume = 50;
		slurs = new int[2];
		slurs[0] = 0;
		slurs[1] = 0;
		wedge = 0;
	}

	public void setClef( ClefType c ) {
		clef = c;
	}

	public void setTempo( int t ) {
		tempo = t;
	}

	public void setKeysign( int k ) {
		keysign = k;
	}

	public void setTime( TipoNumero t ) {
		time = t;
	}

	public void setVolume( int v ) {
		volume = v;
	}

	public void setSlurs( int[] sl ) {
		slurs = new int[2];
		slurs[0] = sl[0];
		slurs[1] = sl[1];
	}

	public void setWedge( int w ) {
		wedge = w;
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

	public int[] getSlurs() {
		return slurs;
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
		n.slurs = slurs.clone();
		n.wedge = wedge;
		*/
		return null;
	}

	@Override
	public boolean igualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean distintoQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean menorQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean menorIgualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayorQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayorIgualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
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
	}

}
