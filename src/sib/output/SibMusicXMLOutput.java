package sib.output;

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
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class SibMusicXMLOutput {

	public Document doc;

	public SibMusicXMLOutput() {
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
			partName.appendChild( doc.createTextNode( "Hello world" ) );
			scorepart.appendChild( partName );

			// Part
			Element part = doc.createElement("part");
			part.setAttribute( "id", "P1" );
			rootElement.appendChild( part );

			// Part - Measure
			Element measure = doc.createElement("measure");
			measure.setAttribute( "number", "1" );
			part.appendChild( measure );
			// Attributes
			Element attr = doc.createElement("attributes");
			measure.appendChild( attr );

			this.addMeasureAttributes( attr );
			
			// Testing
			printNote( "C", "4" );
			printNote( "C", "5" );

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		fifths.appendChild( doc.createTextNode( "0" ) );
		key.appendChild( fifths );

		// Time
		Element tim = doc.createElement("time");
		attr.appendChild( tim );
		// Time - beats
		Element beats = doc.createElement("beats");
		beats.appendChild( doc.createTextNode( "4" ) );
		tim.appendChild( beats );
		// Time - beat-type
		Element beatt = doc.createElement("beat-type");
		beatt.appendChild( doc.createTextNode( "4" ) );
		tim.appendChild( beatt );

		// Clef
		Element clef = doc.createElement("clef");
		attr.appendChild( clef );
		// Clef - sign
		Element sign = doc.createElement("sign");
		sign.appendChild( doc.createTextNode( "G" ) );
		clef.appendChild( sign );
		// Clef - line
		Element line = doc.createElement("line");
		line.appendChild( doc.createTextNode( "2" ) );
		clef.appendChild( line );

	}

	public void printNote( String step, String octave ) {
		NodeList mea = doc.getElementsByTagName("measure");

		// New note
		Element n = doc.createElement( "note" );
		Element pi = doc.createElement( "pitch" );
		n.appendChild( pi );
		Element st = doc.createElement( "step" );
		st.appendChild( doc.createTextNode( step ) );
		pi.appendChild( st );
		Element oc = doc.createElement( "octave" );
		oc.appendChild( doc.createTextNode( octave ) );
		pi.appendChild( oc );

		Element dur = doc.createElement( "duration" );
		dur.appendChild( doc.createTextNode( "4" ) );
		n.appendChild( dur );
		Element ty = doc.createElement( "type" );
		ty.appendChild( doc.createTextNode( "whole" ) );
		n.appendChild( ty );

		mea.item(0).appendChild( n );
	}

	public void appendString(String str) {
		//this.cadena += str;
	}
	

	/*
	 * public void read() { try { DocumentBuilderFactory dbFactory =
	 * DocumentBuilderFactory.newInstance(); DocumentBuilder dBuilder =
	 * dbFactory.newDocumentBuilder(); Document doc = dBuilder.parse(
	 * this.cadena ); doc.getDocumentElement().normalize();
	 * System.out.println("Root element :" +
	 * doc.getDocumentElement().getNodeName()); NodeList nList =
	 * doc.getElementsByTagName("student");
	 * System.out.println("----------------------------");
	 * 
	 * for (int temp = 0; temp < nList.getLength(); temp++) { Node nNode =
	 * nList.item(temp); System.out.println("\nCurrent Element :" +
	 * nNode.getNodeName());
	 * 
	 * if (nNode.getNodeType() == Node.ELEMENT_NODE) { Element eElement =
	 * (Element) nNode; System.out.println("Student roll no : " +
	 * eElement.getAttribute("rollno")); System.out.println( "First Name : " +
	 * eElement.getElementsByTagName("firstname").item(0).getTextContent());
	 * System.out.println( "Last Name : " +
	 * eElement.getElementsByTagName("lastname").item(0).getTextContent());
	 * System.out.println( "Nick Name : " +
	 * eElement.getElementsByTagName("nickname").item(0).getTextContent());
	 * System.out.println("Marks : " +
	 * eElement.getElementsByTagName("marks").item(0).getTextContent()); } } }
	 * catch (Exception e) { e.printStackTrace(); } }
	 */

	public void print() {

		try {
/*
			FileWriter fw = new FileWriter("out.txt");
			fw.write( this.cadena );
			fw.close();
*/

			/*
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("cars");
			doc.appendChild(rootElement);

			// supercars element
			Element supercar = doc.createElement("supercars");
			rootElement.appendChild(supercar);

			// setting attribute to element
			Attr attr = doc.createAttribute("company");
			attr.setValue("Ferrari");
			supercar.setAttributeNode(attr);

			// carname element
			Element carname = doc.createElement("carname");
			Attr attrType = doc.createAttribute("type");
			attrType.setValue("formula one");
			carname.setAttributeNode(attrType);
			carname.appendChild(doc.createTextNode("Ferrari 101"));
			supercar.appendChild(carname);

			Element carname1 = doc.createElement("carname");
			Attr attrType1 = doc.createAttribute("type");
			attrType1.setValue("sports");
			carname1.setAttributeNode(attrType1);
			carname1.appendChild(doc.createTextNode("Ferrari 202"));
			supercar.appendChild(carname1);
*/
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty( OutputKeys.DOCTYPE_SYSTEM, "http://www.musicxml.org/dtds/partwise.dtd" );
			transformer.setOutputProperty( OutputKeys.DOCTYPE_PUBLIC, "-//Recordare//DTD MusicXML 3.0 Partwise//EN" );
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("cars.xml"));
			transformer.transform(source, result);

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
