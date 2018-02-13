package Marshall_UnMarshallSimple;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Sir_D
 */
public class LauncherUnMarshalling {

    public static void main(String[] args) {
        // Creamos el objeto
        try {
            // Creamos el JAXBContext
            JAXBContext jAXBContext = JAXBContext.newInstance(EmpleadoBasico.class);
            // Creamos el Unmarshaller
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();

            //Seleccionar Fichero ///Esto esta mal no debería de ser el fichero fijo, es solo un ejemplo
            File XMLFile = new File("EmpleadoBase.xml");

            //Obtener Empleado de Fichero
            EmpleadoBasico empleado = (EmpleadoBasico) unmarshaller.unmarshal(XMLFile);
            //Utilizamos el método toString que hemos definido
            System.out.println(empleado);

        } catch (JAXBException ex) {
            Logger.getLogger(LauncherMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
