package XQueryEvaluator;

import com.saxonica.xqj.SaxonXQDataSource;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

public class LauncherWithoutQueryFile {

    public static void main(String[] args) {
        try {
            //File XML
            File xmlFile = new File("Biblioteca.xml"); //

            //Create Query
            String query = "doc(\"" + xmlFile.getName() + "\")/biblioteca/libro";

            XQDataSource xqjd = new SaxonXQDataSource();
            XQConnection xqjc = xqjd.getConnection();
            XQExpression expr = xqjc.createExpression();

            XQResultSequence result = expr.executeQuery(query);
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }
            result.close();
            expr.close();
            xqjc.close();
        } catch (XQException ex) {
            Logger.getLogger(LauncherWithoutQueryFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
