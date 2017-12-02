package sib.inout;

import sib.models.datatype.NoteType;

public interface SibOutputController {

	public void playPartiture();

	public void playNote( NoteType note );

	public void print();

}
