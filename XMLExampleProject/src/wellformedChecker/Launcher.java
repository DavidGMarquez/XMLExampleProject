package wellformedChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Launcher {

    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        //The filename is readed from the user
        System.out.println("Type file:");
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hello " + name);
        File xmlFile = new File(name);
        //File xmlFile = new File("EmpleadoBase.xml");
        // File xmlFile = new File("EmpleadoMal.xml");
        try {

            // Create a new factory to create parsers
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            // Use the factory to create a parser (builder) and use it to parse the document.
            DocumentBuilder builder = dBF.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);
            System.out.println(xmlFile + "  is well-formed!");
        } catch (SAXException ex) {
            //There was an execption so the file was not well-formed
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);

            System.out.println(xmlFile + " isn't well-formed!");
            System.exit(1);

        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
