/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class SibIDE
 * @version 1.0
 * 
 */

package sib.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;

import sib.controllers.ViewsController;

public class SibIDE {

	private JFrame frame;
	public JTextPane textPaneLog;
	private JTextPane textPaneInput;
	private JTextPane textPaneOutput;

	ViewsController viewsController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SibIDE window = new SibIDE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SibIDE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		viewsController = new ViewsController( this );

		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Toolbar
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		// Load file
		JButton btnLoadFile = new JButton("Load file");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooserLoadFile = new JFileChooser();
				FileFilter typeSib = new FileNameExtensionFilter("Sib files", "sib");
				FileFilter typeSid = new FileNameExtensionFilter("Sid files", "sid");
				fileChooserLoadFile.addChoosableFileFilter(typeSib);
				fileChooserLoadFile.addChoosableFileFilter(typeSid);
				fileChooserLoadFile.setFileFilter(typeSib); // Initial filter setting
				File workingDirectory = new File(System.getProperty("user.dir"));
				fileChooserLoadFile.setCurrentDirectory(workingDirectory);
				int returnVal = fileChooserLoadFile.showOpenDialog(null); //replace null with your swing container
				File file;
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = fileChooserLoadFile.getSelectedFile();
					BufferedReader in;
					try {
						in = new BufferedReader(new FileReader(file));
						String line;
						try {
							textPaneInput.setText( "" );
							line = in.readLine();
							while(line != null){
								textPaneInput.setText( textPaneInput.getText() + line + "\n");
								line = in.readLine();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		toolBar.add(btnLoadFile);

		// Run JFlex .sib
		JButton btnRun = new JButton("Run Sib");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewsController.actionRunButton();
			}
		});
		toolBar.add(btnRun);
		
		// Run JFlex .sid
		/*
		JButton btnRunSid = new JButton("Run Sid");
		btnRunSid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewsController.actionRunSidButton();
			}
		});
		toolBar.add(btnRunSid);
		*/

		// Save file
		JButton btnSaveFile = new JButton("Save to file");
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame parentFrame = new JFrame();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo donde guardar");
				
				int userSelection = fileChooser.showSaveDialog(parentFrame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					try {
						File fileToSave = fileChooser.getSelectedFile();
						FileWriter fileWriter = new FileWriter(fileToSave);
						fileWriter.write( textPaneOutput.getText() );
						fileWriter.flush();
						fileWriter.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		toolBar.add(btnSaveFile);

		// Editors / Console
		JSplitPane splitPaneVertical = new JSplitPane();
		splitPaneVertical.setResizeWeight(0.9);
		splitPaneVertical.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPaneVertical, BorderLayout.CENTER);

		// Input / Output
		JSplitPane splitPaneHorizontal = new JSplitPane();
		splitPaneHorizontal.setResizeWeight(0.5);

		textPaneInput = new JTextPane();
		textPaneInput.setText("// Input");
		// Cambiamos tamaños de los tabs
		textPaneInput.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "tab");
		textPaneInput.getActionMap().put("tab", new AbstractAction("tab"){
			private static final long serialVersionUID = -2621537943352838927L;
			public void actionPerformed(ActionEvent e){
				try {
					textPaneInput.getDocument().insertString(textPaneInput.getCaretPosition(), " ", null);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});

		JScrollPane jspInput = new JScrollPane( textPaneInput );
		TextLineNumber tln = new TextLineNumber( textPaneInput );
		jspInput.setRowHeaderView( tln );
		splitPaneHorizontal.setLeftComponent( jspInput );

		textPaneOutput = new JTextPane();
		textPaneOutput.setText("// Output");
		JScrollPane jspOutput = new JScrollPane( textPaneOutput );
		TextLineNumber tlnOutput = new TextLineNumber( textPaneOutput );
		jspOutput.setRowHeaderView( tlnOutput );
		splitPaneHorizontal.setRightComponent( jspOutput );

		// add editors
		splitPaneVertical.setLeftComponent(splitPaneHorizontal);
		// add console
		textPaneLog = new JTextPane();
		JScrollPane jspLog = new JScrollPane( textPaneLog );
		textPaneLog.setText("// log");
		splitPaneVertical.setRightComponent(jspLog);

	}

	public void printLog ( String str ) {
		textPaneLog.setText( textPaneLog.getText() + "\n" + str);
	}

	public void printOutput ( String str ) {
		textPaneOutput.setText( textPaneOutput.getText() + str);
	}

	public void printInput ( String str ) {
		textPaneInput.setText( textPaneInput.getText() + str);
	}

	public String getInputString() {
		return textPaneInput.getText();
	}

	public String getOutputString() {
		return textPaneOutput.getText();
	}

	public void cleanOutput() {
		textPaneOutput.setText( "" );
	}

	public void cleanInput() {
		textPaneInput.setText( "" );
	}

}
