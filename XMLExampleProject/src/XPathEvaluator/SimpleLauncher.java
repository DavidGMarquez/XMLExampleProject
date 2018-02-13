package XPathEvaluator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SimpleLauncher {

    public static void main(String[] args) {
        File xmlFile = new File("Biblioteca.xml");
        //Expresion result needs to be a Number

        //Libros con precio mayor que
        //String expressionXPath = "count(//libro[precio > 30.0])";

        //Número de autores total
        //String expressionXPath = "count(//autor)";

        //Libros con más de un autor
        //String expressionXPath = "count(//libro[count(autor)>1])";
        
        //Precio de todos los libros novela
        String expressionXPath = "sum(Biblioteca/libro[@categoria='Novela']/precio)";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            XPath xpath = XPathFactory.newInstance().newXPath();
            //Evaluate expression
            Double result = (Double) xpath.evaluate(expressionXPath, doc, XPathConstants.NUMBER);
            System.out.println("El resultado es " + result);
        } catch (SAXException ex) {
            Logger.getLogger(SimpleLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(SimpleLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SimpleLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
