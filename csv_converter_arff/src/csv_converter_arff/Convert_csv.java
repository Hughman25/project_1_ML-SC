/*
 * CSV & TXT file conversion into ARFF (Attribute Relationship File Format)
 * Authors: Cory Peterson, Mike Pollard, Hugh Jackovich
 * 
 */

package csv_converter_arff;
import java.io.File;

import javax.swing.JFileChooser;

// Imports from Weka library
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class Convert_csv {
	/**
	 * Convert_csv will prompt the user for a file using the dialog box
	 * certain data will be taken such as directory and file name.
	 * The file is then loaded into Weka's converter and formatted into
	 * an ARFF file, and saved where the original file was located.
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception{
    	/**
    	 * Main method of Convert_csv, executes entire program
    	 */
    	
    	// Retrieves file chosen by user using dialog box
    	JFileChooser chooser = new JFileChooser();
    	
    	chooser.setCurrentDirectory(new java.io.File("C:/"));
    	chooser.setDialogTitle("Find your file");
    	chooser.showOpenDialog(null);
    	
    	// Sets file as the chosen file from the dialog box
    	File file = chooser.getSelectedFile();
    	String path = file.getAbsolutePath();
    	

        // Load the CSV/TXT file (chosen file) into Weka converter
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(path));
        
        // Saves directory path of file and retains file name to be used
        String save_path = path.substring(0, path.lastIndexOf("."));

        Instances data = loader.getDataSet();

        // save as an  ARFF (output file)
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(save_path + ".arff"));
        saver.writeBatch();
    }
}

