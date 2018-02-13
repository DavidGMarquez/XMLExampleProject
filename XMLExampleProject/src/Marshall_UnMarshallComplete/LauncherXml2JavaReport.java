package Marshall_UnMarshallComplete;

import Marshall_UnMarshallComplete.POJOs.Employee;
import Marshall_UnMarshallComplete.POJOs.Report;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LauncherXml2JavaReport {

    public static void main(String[] args) throws JAXBException {

        // Create the JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
        // Get the unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Use the Unmarshaller to unmarshal the XML document from a file
        File file = new File("./xml/Report3.xml");
        Report report = (Report) unmarshaller.unmarshal(file);

        // Print the report
        System.out.println("Report:");
        System.out.println("Name: " + report.getName());
        System.out.println("Content: " + report.getContent());
        System.out.println("Date: " + report.getLocalDate());
        List<Employee> emps = report.getAuthors();
        for (Employee emp : emps) {
            System.out.println("Author: " + emp);
        }
    }
}
