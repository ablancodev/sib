package sib.inout;

import org.w3c.dom.Document;

import sib.models.datatype.NoteType;
import sib.models.datatype.PartitureType;

public class SibMusicXMLInput implements SibInputController {

	protected PartitureType partiture;
	public Document doc;

	public SibMusicXMLInput( PartitureType p ) {
		partiture = p;
	}

	public void readPartiture() {
		// @todo implementarlo - Devuelve void, porque escribirá sobre la variable global $partiture
	}

	public NoteType readNote() {
		// @todo implementarlo
		return null;
	}

}
