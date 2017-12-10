package sib.models.datatype;

import sib.models.nonterminal.TipoNumero;
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
	public TipoNumero duration;
	public int octave;
	public int dots;
	public String articulation;
	public String accidental;
	public int alter;

	public NoteType() {
		value = new StepType( "C" );
		duration = new TipoNumero( "1/4", TipoNumero.TYPE_NFRAC );
		octave = 4;
		dots = 0;
		articulation = "";
		accidental = NoteType.ACCIDENTAL_NONE;
		alter = 0;
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
		/*
		int current = this.value.getCurrentPositionValues();
		// Actualizamos step
		this.value.trans( ntones );
		// Actualizamos octave
		this.octave += Math.round( ( current + Math.round( ntones ) ) / 7 );
		int modulo = ( current + Math.round( ntones ) ) % 7;
		if ( modulo != 0 ) {
			if ( ( ntones > 0 ) && ( this.value.getCurrentPositionValues() < current ) ) {  // ha dado la vuelta
				this.octave++;
			}
			if ( ( ntones < 0 ) && ( this.value.getCurrentPositionValues() > current ) ) {  // ha dado la vuelta
				this.octave--;
			}
		}
		// Hay semitonos ?
		if ( ( ntones - Math.round( ntones ) ) != 0 ) {
			if ( ntones > 0 ) { // hay medio tono positivo
				applySharp(1);
			} else {
				applyFlat(1);
			}
		}
		*/
		// Octavas
		octave = octave + numOctaves( ntones );

		// Semitonos?
		int semitones = semitonesExtra( ntones );
		if ( semitones > 0 ) {
			applySharp( semitones );
		}
		if ( semitones < 0 ) {
			applyFlat( Math.abs( semitones ) );
		}

		// Actualizamos step
		this.value.trans( ntones );

	}

	private int numOctaves(Float ntones) {
		int octaves = 0;
		boolean negative = false;
		if ( ntones < 0 ) {
			negative = true;
		}
		float tonos = Math.abs( ntones );
		int current = this.value.stepValues.indexOf( this.value.value );
		// caso especial si inicialmente current = 0
		if ( negative && ( current == 0 ) ) {
			octaves--;
		}
		while ( tonos > 0 ) {
			if ( negative ) {
				int temp =( current - 1 ) % 7;
				if ( temp < 0 ) {
					temp = temp + 7;
				}
				tonos = ( tonos - this.value.tonesValues[temp] );
			} else {
				tonos = ( tonos - this.value.tonesValues[current] );
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
				if ( current == 0 ) {
					if ( negative ) {
						octaves--;
					} else {
						octaves++;
					}
				}
			}
		}
		return octaves;
	}

	private int semitonesExtra(Float ntones) {
		int semi = 0;
		boolean negative = false;
		if ( ntones < 0 ) {
			negative = true;
		}
		float tonos = Math.abs( ntones );
		int current = this.value.stepValues.indexOf( this.value.value );
		while ( tonos > 0 ) {
			if ( negative ) {
				int temp =( current - 1 ) % 7;
				if ( temp < 0 ) {
					temp = temp + 7;
				}
				tonos = ( tonos - this.value.tonesValues[temp] );
			} else {
				tonos = ( tonos - this.value.tonesValues[current] );
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
		if ( tonos < 0 ) {
			if ( negative ) {
				semi--;
			} else {
				semi++;
			}
		}
		return semi;
	}

	@Override
	public ValorAsignacion clone() {
		NoteType n = new NoteType();
		n.value = (StepType)value.clone();
		n.articulation = articulation;
		n.dots = dots;
		n.duration = duration.clone();
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
			alter = Math.max( alter - 1, -2 );
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
			alter = Math.max( alter - 2, -2 );
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
			alter = Math.min( alter + 1, 2 );
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
			alter = Math.min( alter + 2, 2 );
		}
	}

	public void setPropertyValue( String prop, ValorAsignacion v ) {
		try {
			switch ( prop ) {
				case "step":
					value = new StepType( v.getStringValue() );
					break;
				case "duration":
					if ( duration != null ) {
						duration.setValue( v.getStringValue() );
					} else {
						duration = new TipoNumero( v.getStringValue(), TipoNumero.TYPE_NFRAC );
					}
					break;
				case "octave":
					octave = new Float( v.getStringValue() ).intValue();
					break;
				case "dots":
					dots = new Float( v.getStringValue() ).intValue();
					break;
				case "articulation":
					articulation = v.getStringValue();
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
