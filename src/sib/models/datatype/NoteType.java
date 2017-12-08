package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;

/**
 * Representa el tipo de datos note
 *
 * @author Antonio Blanco
 *
 */
public class NoteType extends DataType {

	public static final String ACCIDENTAL_NONE = "";
	public static final String ACCIDENTAL_NATURAL = "natural";
	public static final String ACCIDENTAL_FLAT = "flat";
	public static final String ACCIDENTAL_DOUBLE_FLAT = "flat-flat";
	public static final String ACCIDENTAL_SHARP = "sharp";
	public static final String ACCIDENTAL_DOUBLE_SHARP = "double-sharp";

	public StepType value;
	public int duration;
	public int octave;
	public int dots;
	public String accent;
	public String accidental;

	public NoteType() {
		value = new StepType( "C" );
		duration = 4;
		octave = 4;
		dots = 0;
		accent = "";
		accidental = NoteType.ACCIDENTAL_NONE;
	}

	@Override
	public String getType() {
		return DataType.TYPE_NOTE;
	}

	@Override
	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return value.getStringValue();
	}

	@Override
	public ValorAsignacion evalua() {
		return this;
	}

	@Override
	public void trans( Float ntones ) {
		this.value.trans( ntones );
	}

	@Override
	public ValorAsignacion clone() {
		NoteType n = new NoteType();
		n.value = (StepType)value.clone();
		n.accent = accent;
		n.dots = dots;
		n.duration = duration;
		n.octave = octave;
		n.accidental = accidental;
		return n;
	}

	@Override
	public boolean igualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean distintoQue(ValorAsignacion op2) {
		return !igualQue( op2 );
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

	/**
	 * Aplica un operador nota.
	 *
	 * @param op String
	 */
	public void applyOperator(String op) {
		switch ( op ) {
			case "_.":
				dots ++;
				break;
			case "_..":
				dots = dots + 2;
				break;
			case "_...":
				dots = dots + 3;
				break;
			case "_#":
				applySharp( 1 );
				break;
			case "_##":
				applySharp( 2 );
				break;
			case "_b":
				applyFlat( 1 );
				break;
			case "_bb":
				applyFlat( 2 );
				break;
			case "_@":
				accidental = NoteType.ACCIDENTAL_NATURAL;
				break;
			case "__":
				accidental = NoteType.ACCIDENTAL_NONE;
				break;
		}
	}

	private void applyFlat(int i) {
		if ( i == 1 ) {
			switch ( accidental ) {
				case NoteType.ACCIDENTAL_NONE:
				case NoteType.ACCIDENTAL_NATURAL:
					accidental = NoteType.ACCIDENTAL_FLAT;
					break;
				case NoteType.ACCIDENTAL_FLAT:
					accidental = NoteType.ACCIDENTAL_DOUBLE_FLAT;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_FLAT:
					accidental = NoteType.ACCIDENTAL_DOUBLE_FLAT;
					break;
				case NoteType.ACCIDENTAL_SHARP:
					accidental = NoteType.ACCIDENTAL_NATURAL;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_SHARP:
					accidental = NoteType.ACCIDENTAL_SHARP;
					break;
			}
		} else if ( i == 2 ) {
			switch ( accidental ) {
				case NoteType.ACCIDENTAL_NONE:
				case NoteType.ACCIDENTAL_NATURAL:
					accidental = NoteType.ACCIDENTAL_DOUBLE_FLAT;
					break;
				case NoteType.ACCIDENTAL_FLAT:
					accidental = NoteType.ACCIDENTAL_DOUBLE_FLAT;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_FLAT:
					accidental = NoteType.ACCIDENTAL_DOUBLE_FLAT;
					break;
				case NoteType.ACCIDENTAL_SHARP:
					accidental = NoteType.ACCIDENTAL_FLAT;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_SHARP:
					accidental = NoteType.ACCIDENTAL_NATURAL;
					break;
			}
		}
	}

	private void applySharp(int i) {
		if ( i == 1 ) {
			switch ( accidental ) {
				case NoteType.ACCIDENTAL_NONE:
				case NoteType.ACCIDENTAL_NATURAL:
						accidental = NoteType.ACCIDENTAL_SHARP;
					break;
				case NoteType.ACCIDENTAL_FLAT:
					accidental = NoteType.ACCIDENTAL_NATURAL;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_FLAT:
					accidental = NoteType.ACCIDENTAL_FLAT;
					break;
				case NoteType.ACCIDENTAL_SHARP:
					accidental = NoteType.ACCIDENTAL_DOUBLE_SHARP;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_SHARP:
					accidental = NoteType.ACCIDENTAL_DOUBLE_SHARP;
					break;
			}
		} else if ( i == 2 ) {
			switch ( accidental ) {
				case NoteType.ACCIDENTAL_NONE:
				case NoteType.ACCIDENTAL_NATURAL:
					accidental = NoteType.ACCIDENTAL_DOUBLE_SHARP;
					break;
				case NoteType.ACCIDENTAL_FLAT:
					accidental = NoteType.ACCIDENTAL_SHARP;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_FLAT:
					accidental = NoteType.ACCIDENTAL_NATURAL;
					break;
				case NoteType.ACCIDENTAL_SHARP:
					accidental = NoteType.ACCIDENTAL_DOUBLE_SHARP;
					break;
				case NoteType.ACCIDENTAL_DOUBLE_SHARP:
					accidental = NoteType.ACCIDENTAL_DOUBLE_SHARP;
					break;
			}
		}
	}

	public void setPropertyValue( String prop, ValorAsignacion v ) {
		try {
			switch ( prop ) {
				case "step":
					value = new StepType( v.getStringValue() );
					break;
				case "duration":
					duration = new Float( v.getStringValue() ).intValue();
					break;
				case "octave":
					octave = new Float( v.getStringValue() ).intValue();
					break;
				case "dots":
					dots = new Float( v.getStringValue() ).intValue();
					break;
				case "accent":
					accent = v.getStringValue();
					break;
				case "accidental":
					accidental = v.getStringValue();
					break;
				default:
					throw new Exception( "Nombre de propiedad no existe: " + prop );
			}
		} catch ( Exception e ) {
			System.err.println( "ERROR en NoteType->setPropertyValue():" + v.getStringValue() );
			e.printStackTrace();
		}
	}

}
