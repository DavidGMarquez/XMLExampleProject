package XLST_ToHTML_Transformer;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Launcher {

    public static void main(String[] args) {
        File xmlFile = new File("Biblioteca.xml"); 
        File xsltFile = new File("Biblioteca.xslt"); 
        
        //Result
        File htmlFile = new File("Biblioteca.html"); 

        TransformerFactory tFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = tFactory.newTransformer(new StreamSource(xsltFile));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(htmlFile));
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
