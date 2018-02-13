package XPathEvaluator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NodeLauncher {

    public static void main(String[] args) {
        File xmlFile = new File("Biblioteca.xml");
        
        //Mostrar todos los libros
        //String expressionXPath = "//libro";
        
        //Mostrar todos los autores
        //String expressionXPath = "//autor";
        
        //Mostrar todos los libros cuyo precio es menor que 30
        //String expressionXPath = "/Biblioteca/libro[precio < 30.0]";
        
        //Mostrar las novelas  de Unamuno y precio mayor que 30
        String expressionXPath = "/Biblioteca/libro[@categoria='Novela' and autor=\"Miguel de Unamuno\" and precio >30]";

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            XPath xpath = XPathFactory.newInstance().newXPath();

            NodeList nodos = (NodeList) xpath.evaluate(expressionXPath, doc, XPathConstants.NODESET);
            //Imprime solo categoria de libros resultado
            for (int i = 0; i < nodos.getLength(); i++) {
                System.out.println(nodos.item(i).getNodeName() + " : "
                        + mostrarNodo(nodos.item(i)));

            }

        } catch (SAXException ex) {
            Logger.getLogger(NodeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NodeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(NodeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(NodeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //This function is ued to print the node like XML
    private static String mostrarNodo(Node item) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sR = new StreamResult(sw);
            transformer.transform(new DOMSource(item), sR);
            return sw.toString();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(NodeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(NodeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
