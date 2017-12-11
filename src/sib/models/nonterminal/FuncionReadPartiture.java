package sib.models.nonterminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import sib.inout.SibInputController;

public class FuncionReadPartiture extends InstFuncion {

	SibInputController inputController;

	public FuncionReadPartiture( SibInputController input ) {
		inputController = input;
		
		}


	@Override
	public void run() {
		inputController.readPartiture();
	}
}
