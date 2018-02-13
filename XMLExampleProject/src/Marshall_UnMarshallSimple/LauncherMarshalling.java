package Marshall_UnMarshallSimple;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class LauncherMarshalling {

    public static void main(String[] args) {
        // Creamos el objeto
        EmpleadoBasico empleado = new EmpleadoBasico("Juan", "Jefe", "303030");
        //El ID no se va a serializar
        empleado.setID_Clase(11);
        try {
            // Creamos el JAXBContext
            JAXBContext jAXBContext = JAXBContext.newInstance(EmpleadoBasico.class);
            // Creamos el JAXBMarshaller
            Marshaller marshaller = jAXBContext.createMarshaller();
            //Opcional formateo bonito
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Escribir el resultado por pantalla
            marshaller.marshal(empleado, System.out);

            //Escribir el resultado en un fichero
            File XMLFile = new File("EmpleadoBase.xml");
            marshaller.marshal(empleado, XMLFile);

        } catch (JAXBException ex) {
            Logger.getLogger(LauncherMarshalling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
