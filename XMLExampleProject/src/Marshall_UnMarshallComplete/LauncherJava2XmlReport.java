package Marshall_UnMarshallComplete;

import Marshall_UnMarshallComplete.POJOs.Department;
import Marshall_UnMarshallComplete.POJOs.Employee;
import Marshall_UnMarshallComplete.POJOs.Report;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class LauncherJava2XmlReport {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static void printReports(List<Report> reps) {
        // Print the reports
        reps.forEach((rep) -> {
            System.out.println(rep);
        });
    }

    public static void main(String[] args) throws Exception {
        // Create the JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
        // Get the marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Pretty formatting
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //Create Departments
        Department dep1 = new Department(1, "Marketing", "Burgos");
        Department dep2 = new Department(2, "Technology", "Arganda");

        //Create Employees
        List<Employee> empleados = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // Create the employee
            Employee employee = new Employee();
            employee.setId(i);
            employee.setName("Employee-" + i);
            employee.setDob(Date.valueOf(LocalDate.parse("2016-12-" + (20 + i), formatter)));
            employee.setAddress("Address-" + i);
            employee.setSalary((double) i + 100 * i);
            // Insert employee into the DB
            empleados.add(employee);
            // Assign the employee to a department
            employee.setDepartment(dep1);
            dep1.addEmployee(employee);
        }

        //Create Reports
        Report rep1 = new Report(1, "Sales Report 1", "Nothing Sold", LocalDate.parse("2016-12-15", formatter));
        Report rep2 = new Report(2, "Sales Report 2", "Everything Sold", LocalDate.parse("2016-12-30", formatter));
        Report rep3 = new Report(3, "Sales Report 3", "Something Sold", LocalDate.parse("2017-12-30", formatter));

        Employee emp1 = empleados.get(1);
        emp1.setDepartment(dep2);
        dep1.removeEmployee(emp1);
        dep2.addEmployee(emp1);
        emp1.addReport(rep1);
        emp1.addReport(rep2);
        rep1.addAuthor(emp1);
        rep2.addAuthor(emp1);

        Employee emp2 = empleados.get(2);

        emp1.addReport(rep3);
        emp2.addReport(rep3);
        rep3.addAuthor(emp1);
        rep3.addAuthor(emp2);
        

        // Use the Marshaller to marshal the Java object to a file
        File file1 = new File("./xml/Report1.xml");
        marshaller.marshal(rep1, file1);
        // Printout
        marshaller.marshal(rep1, System.out);

        File file2 = new File("./xml/Report2.xml");
        marshaller.marshal(rep2, file2);

        marshaller.marshal(rep2, System.out);

        File file3 = new File("./xml/Report3.xml");
        marshaller.marshal(rep3, file3);
        marshaller.marshal(rep3, System.out);
    }
}
