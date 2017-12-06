package sib.inout;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import sib.models.datatype.NoteType;
import sib.models.datatype.PartitureType;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class SibMusicXMLOutput implements SibOutputController {

	protected PartitureType partiture;
	public Document doc;

	/**
	 * Indica los tiempos consumidos del actual compás, para añadir nuevo compás cuando playNote()
	 */
	private float actualDuration = 0;

	public SibMusicXMLOutput( PartitureType p ) {
		partiture = p;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
			
			// score-partwise
			Element rootElement = doc.createElement("score-partwise");
			rootElement.setAttribute( "version", "3.0" );
			doc.appendChild(rootElement);

			// de momento sólo una part-list
			Element partList = doc.createElement("part-list");
			rootElement.appendChild( partList );
			Element scorepart = doc.createElement("score-part");
			scorepart.setAttribute( "id", "P1" );
			partList.appendChild( scorepart );
			Element partName = doc.createElement("part-name");
			partName.appendChild( doc.createTextNode( "Generada por Sib" ) );
			scorepart.appendChild( partName );

			// Part
			Element part = doc.createElement("part");
			part.setAttribute( "id", "P1" );
			rootElement.appendChild( part );

			// Part - Measure
//			Element measure = doc.createElement("measure");
//			measure.setAttribute( "number", "1" );
//			part.appendChild( measure );
//			// Attributes
//			Element attr = doc.createElement("attributes");
//			measure.appendChild( attr );

//			this.addMeasureAttributes( attr );

			// Datos de ejemplo - @todo eliminar la carga de datos de ejemplo
//			NoteType nota1 = new NoteType();
//			NoteType nota2 = new NoteType();
//			playNote( nota1 );
//			playNote( nota2 );

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playPartiture() {
		// @todo implementarlo. Posiblemente sea parecido a addMeasureAttributes
	}

	public void addMeasureAttributes( Element attr ) {
		// Divisions
		Element divv = doc.createElement("divisions");
		divv.appendChild( doc.createTextNode( "1" ) );
		attr.appendChild( divv );
		// Key
		Element key = doc.createElement("key");
		attr.appendChild( key );
		// Key - Fifths
		Element fifths = doc.createElement("fifths");
		fifths.appendChild( doc.createTextNode( String.valueOf( partiture.getKeysign() ) ) );
		key.appendChild( fifths );

		// Time
		Element tim = doc.createElement("time");
		attr.appendChild( tim );
		// Time - beats
		Element beats = doc.createElement("beats");
		beats.appendChild( doc.createTextNode( String.valueOf( partiture.getTimeBeats() ) ) );
		tim.appendChild( beats );
		// Time - beat-type
		Element beatt = doc.createElement("beat-type");
		beatt.appendChild( doc.createTextNode( String.valueOf( partiture.getTimeBeatType() ) ) );
		tim.appendChild( beatt );

		// Clef
		Element clef = doc.createElement("clef");
		attr.appendChild( clef );
		// Clef - sign
		Element sign = doc.createElement("sign");
		sign.appendChild( doc.createTextNode( partiture.getClef().getSign() ) );
		clef.appendChild( sign );
		// Clef - line
		Element line = doc.createElement("line");
		line.appendChild( doc.createTextNode( partiture.getClef().getLine() ) );
		clef.appendChild( line );

	}

	public void playNote( NoteType note ) {

		// New note
		Element n = doc.createElement( "note" );
		Element pi = doc.createElement( "pitch" );
		n.appendChild( pi );
		Element st = doc.createElement( "step" );
		st.appendChild( doc.createTextNode( note.getStringValue() ) );
		pi.appendChild( st );
		Element oc = doc.createElement( "octave" );
		oc.appendChild( doc.createTextNode( String.valueOf( note.octave ) ) );
		pi.appendChild( oc );

		Element dur = doc.createElement( "duration" );
		dur.appendChild( doc.createTextNode( String.valueOf( note.duration ) ) );
		n.appendChild( dur );
		Element ty = doc.createElement( "type" );
		ty.appendChild( doc.createTextNode( this.noteDurationToType( note.duration ) ) );
		n.appendChild( ty );
		Element ac = doc.createElement( "accidental" );
		ac.appendChild( doc.createTextNode( note.accidental ) );
		n.appendChild( ac );

		Element dot = null;
		for ( int cnt = 0; cnt < note.dots; cnt++ ) {
			dot = doc.createElement( "dot" );
			n.appendChild( dot );
		}

		NodeList score = doc.getElementsByTagName("score-partwise");

		actualDuration += note.duration;
		if ( ( actualDuration ) >= 4 ) {
			// Añadimos nuevo compás - measure
			// Part - Measure
			Element measure = doc.createElement("measure");
			measure.setAttribute( "number", "1" );
			score.item( score.getLength() - 1 ).appendChild( measure );

			// Attributes
			Element attr = doc.createElement("attributes");
			measure.appendChild( attr );

			this.addMeasureAttributes( attr );
			measure.appendChild( n );

			actualDuration = 0;
		} else {
			NodeList mea = doc.getElementsByTagName("measure");
			if ( mea.getLength() == 0 ) {
				// Añadimos nuevo compás - measure
				// Part - Measure
				Element measure = doc.createElement("measure");
				measure.setAttribute( "number", "1" );
				score.item( score.getLength() - 1 ).appendChild( measure );

				// Attributes
				Element attr = doc.createElement("attributes");
				measure.appendChild( attr );

				this.addMeasureAttributes( attr );
				measure.appendChild( n );
			} else {
				mea.item( mea.getLength() - 1 ).appendChild( n );
			}
		}

	}

	/**
	 * Devuelve el type de una nota (string) a partir de su duración.
	 *
	 * @param duration int
	 * @return String
	 */
	private String noteDurationToType( int duration ) {
		String resultado = "quarter"; // 4
		switch ( duration ) {
			case 1:
				resultado = "whole";
				break;
			case 2:
				resultado = "half";
				break;
			case 4:
				resultado = "quarter";
				break;
			case 8:
				resultado = "eighth";
				break;
			case 16:
				resultado = "16th";
				break;
		}
		// @todo duration to type - añadir el resto de correspondencias
		return resultado;
	}

	/**
	 * Genera el fichero MusicXML
	 */
	public void print() {

		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty( OutputKeys.DOCTYPE_SYSTEM, "http://www.musicxml.org/dtds/partwise.dtd" );
			transformer.setOutputProperty( OutputKeys.DOCTYPE_PUBLIC, "-//Recordare//DTD MusicXML 3.0 Partwise//EN" );
			
			DOMSource source = new DOMSource(doc);

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);

			StreamResult result = new StreamResult(new File("my_musicxml_output.xml"));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
