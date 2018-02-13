package Marshall_UnMarshallSimple;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Sir_D
 */
@XmlRootElement(name = "Empleado")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmpleadoBasico implements Serializable {

    private static final long serialVersionUID = 1L;

    public EmpleadoBasico() {
    }

    public EmpleadoBasico(String nombre, String puesto, String DNI) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.DNI = DNI;
    }

    @XmlElement(name = "Nombre")
    String nombre;

    @XmlElement(name = "Puesto")
    String puesto;

    @XmlAttribute
    String DNI;

    @XmlTransient
    Integer ID_Clase = 1;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public Integer getID_Clase() {
        return ID_Clase;
    }

    public void setID_Clase(Integer ID_Clase) {
        this.ID_Clase = ID_Clase;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "EmpleadoBasico{" + "nombre=" + nombre + ", puesto=" + puesto + ", DNI=" + DNI + ", ID_Clase=" + ID_Clase + '}';
    }

}
