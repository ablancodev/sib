package sib.inout;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sib.models.datatype.NoteType;
import sib.models.datatype.PartitureType;
import sib.models.datatype.StepType;
import sib.models.nonterminal.TablaSimbolos;
import sib.models.nonterminal.TipoNumero;

public class SibMusicXMLInput implements SibInputController {

	protected TablaSimbolos tablaSimbolos;
	public Document doc;
	protected File file;
	private int currentNoteIndex;

	public SibMusicXMLInput( TablaSimbolos ts ) {
		tablaSimbolos = ts;
		currentNoteIndex = 0;
	}

	public void readPartiture() {
		JFileChooser fileChooserLoadFile = new JFileChooser();
		FileFilter typeSib = new FileNameExtensionFilter("MusicXML files", "xml");
		fileChooserLoadFile.setDialogTitle( "ReadPartiture()" );
		fileChooserLoadFile.addChoosableFileFilter(typeSib);
		fileChooserLoadFile.setFileFilter(typeSib); // Initial filter setting
		File workingDirectory = new File(System.getProperty("user.dir"));
		fileChooserLoadFile.setCurrentDirectory(workingDirectory);
		int returnVal = fileChooserLoadFile.showOpenDialog(null); //replace null with your swing container
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooserLoadFile.getSelectedFile();
		}
		
		currentNoteIndex = 0;
	}

	public NoteType readNote() {
		NoteType note = null;
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setFeature("http://xml.org/sax/features/namespaces", false);
			dbFactory.setFeature("http://xml.org/sax/features/validation", false);
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			NodeList nList = doc.getElementsByTagName("note");
			Node node = nList.item( currentNoteIndex );

			if ( node != null ) {
				note = new NoteType();
				Element eElement = (Element) node;
				if ( eElement.getElementsByTagName("duration").getLength() > 0 ) {
					note.setPropertyValue( "duration", new TipoNumero( eElement.getElementsByTagName("duration").item(0).getTextContent() + "/" + String.valueOf( SibMusicXMLOutput.DIVISIONS ), TipoNumero.TYPE_NFRAC ) );
				}
				if ( eElement.getElementsByTagName("dot").getLength() > 0 ) {
					note.setPropertyValue( "dots", new TipoNumero( String.valueOf( eElement.getElementsByTagName("dot").getLength() ), TipoNumero.TYPE_INT ) );
				}
				if ( eElement.getElementsByTagName("pitch").getLength() > 0 ) {
					NodeList pList = eElement.getElementsByTagName("pitch").item(0).getChildNodes();
					for (int i = 0; i < pList.getLength(); i++) {
						if (pList.item(i).getNodeType() == Node.ELEMENT_NODE) {
							eElement = (Element) pList.item(i);
							if ( eElement.getNodeName().equalsIgnoreCase( "step" ) ) {
								note.setPropertyValue( "step", new StepType( eElement.getTextContent() ) );
							}
							if ( eElement.getNodeName().equalsIgnoreCase( "octave" ) ) {
								note.setPropertyValue( "octave", new TipoNumero( eElement.getTextContent(), TipoNumero.TYPE_INT ) );
							}
						}
					}
				}
			}

			currentNoteIndex++;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return note;
	}

}
