package Marshall_UnMarshallComplete;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class LauncherXml2HtmlReport {

    /**
     * Simple transformation method. You can use it in your project.
     *
     * @param sourcePath - Absolute path to source xml file.
     * @param xsltPath - Absolute path to xslt file.
     * @param resultDir - Directory where you want to put resulting files.
     */
    public static void simpleTransform(String sourcePath, String xsltPath, String resultDir) {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
            transformer.transform(new StreamSource(new File(sourcePath)), new StreamResult(new File(resultDir)));
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(LauncherXml2HtmlReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(LauncherXml2HtmlReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        simpleTransform("./xml/Report1.xml", "./xml/Report-Style.xslt", "./xml/Report1.html");

    }
}
