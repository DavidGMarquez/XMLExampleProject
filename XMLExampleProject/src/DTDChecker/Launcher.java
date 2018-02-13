package DTDChecker;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Launcher {

    public static void main(String[] args) {
        File xmlFile = new File("EmpleadoconDTD.xml"); //DTD es Empleado.dtd
        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            dBF.setValidating(true);
            DocumentBuilder builder = dBF.newDocumentBuilder();
            //In this case we are creating a different ErrorHandler, if not we do like the well-formed Checker+
            CustomErrorHandler customErrorHandler = new CustomErrorHandler();

            builder.setErrorHandler(customErrorHandler);
            Document doc = builder.parse(xmlFile);
            if (customErrorHandler.isValid()) {
                System.out.println(xmlFile + " was valid!");
            } else {
                System.out.println(xmlFile + " was not valid!");
            }

        } catch (ParserConfigurationException ex) {
            System.out.println(xmlFile + " error while parsing!");
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            System.out.println(xmlFile + " was not well-formed!");
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println(xmlFile + " was not accesible!");
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
