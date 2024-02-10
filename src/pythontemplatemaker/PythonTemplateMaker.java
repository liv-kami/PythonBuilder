
package pythontemplatemaker;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PythonTemplateMaker {
    
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pick your save Directory: ");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int o = chooser.showOpenDialog(null);
        if(o == JFileChooser.CANCEL_OPTION){
            System.exit(0);
        }
        String dir = chooser.getSelectedFile().toString();
        
        String f = JOptionPane.showInputDialog("Enter the name of your file: ");
        if(f == "" || f == null){
            System.exit(0);
        }
        f = f.replaceAll("\\s+", "_");
        System.out.println(f);
        String fullOne = dir + "/" + f + ".py";
        
        System.out.println(fullOne);
        
        File fi = new File(fullOne);
        try {
            if(fi.createNewFile()){
                FileWriter w = new FileWriter(fullOne);
                w.write(template(f + ".py"));
                w.close();
                Desktop.getDesktop().open(fi);
            }
        } catch (IOException ex) {
            Logger.getLogger(PythonTemplateMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String template(String filename){
        String s = "";
        s+="#-----------------------------------------------------------------------------------------------\n" +
"\"\"\"\n" +
"Name: \n" +
"Date: \n" +
"Class: ISCS210 Python Programming\n" +
"Filename: "+filename + ".py\n" +
"Desc:\n" +
"\"\"\"\n" +
"#-----------------------------------------------------------------------------------------------\n" +
"\"\"\"\n" +
"Assignment Prompt:\n" +
"\"\"\"\n" +
"#-----------------------------------------------------------------------------------------------\n" +
"\"\"\"\n" +
"Algorithm:\n" +
"\n" +
"Input -\n" +
"\n" +
"Processing - \n" +
"\n" +
"Output -\n" +
"\n" +
"\"\"\"\n" +
"#-----------------------------------------------------------------------------------------------\n" +
"\"\"\"\n" +
"Test Case:\n" +
"\"\"\"\n" +
"#-----------------------------------------------------------------------------------------------\n" +
"\n" +
"#Explain to the user what the program does:\n" +
"print(\"\")";
        
        return s;
    }

}
