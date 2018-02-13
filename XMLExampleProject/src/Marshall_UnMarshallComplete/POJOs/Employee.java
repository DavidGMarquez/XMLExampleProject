package Marshall_UnMarshallComplete.POJOs;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import Marshall_UnMarshallComplete.util.SQLDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
@XmlType(propOrder = {"name", "dob", "address", "salary"})
public class Employee implements Serializable {

    private static final long serialVersionUID = -1156840724257282729L;

    @XmlAttribute
    private Integer id;
    @XmlAttribute
    private String name;
    @XmlElement
    // Note the type adapter
    @XmlJavaTypeAdapter(SQLDateAdapter.class)
    private Date dob;
    @XmlElement
    private String address;
    @XmlElement
    private Double salary;
    @XmlTransient
    private byte[] photo;

    // This @XmlTransient is here to avoid infinite loops
    @XmlTransient
    private Department department;
    // This @XmlTransient is here to avoid infinite loops
    @XmlTransient
    private List<Report> reports;

    // This constructor is mandatory
    public Employee() {
        super();
        this.reports = new ArrayList<Report>();
    }

    // You can create as many extra constructors as you wish
    public Employee(String name, LocalDate dob, String address, Double salary, byte[] photo, Department department) {
        super();
        this.name = name;
        this.setLocalDateDob(dob);
        this.address = address;
        this.salary = salary;
        this.photo = photo;
        this.department = department;
        this.reports = new ArrayList<Report>();
    }

    public Employee(String name, LocalDate dob, String address, Double salary, byte[] photo, Department department,
            List<Report> reports) {
        super();
        this.name = name;
        this.setLocalDateDob(dob);
        this.address = address;
        this.salary = salary;
        this.photo = photo;
        this.department = department;
        this.reports = reports;
    }

    public Employee(int id, String name, Date dob, String address, Double salary, byte[] photo) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.salary = salary;
        this.photo = photo;
        this.reports = new ArrayList<Report>();
    }

    public Employee(int id, String name, Date dob, String address, Double salary, byte[] photo, Department dep) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.salary = salary;
        this.photo = photo;
        this.department = dep;
        this.reports = new ArrayList<Report>();
    }

    // Hashcode uses primary keys, since they are unique
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    // Equals uses primary keys, since they are unique
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    // Be careful! If employee prints reports and vice-versa,
    // you can end with an infinite loop
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dob=" + dob
                + ", address=" + address + ", salary=" + salary + ", department=" + department + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    // Additional method to use LocalDate objects
    public void setLocalDateDob(LocalDate ldate) {
        this.dob = Date.valueOf(ldate);
    }

    // Additional method to use LocalDate objects
    public LocalDate getLocalDateDob() {
        return this.dob.toLocalDate();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    // Additional method to add to a list
    public void addReport(Report report) {
        if (!reports.contains(report)) {
            this.reports.add(report);
        }
    }

    // Additional method to remove from a list
    public void removeReport(Report report) {
        if (reports.contains(report)) {
            this.reports.remove(report);
        }
    }
}
