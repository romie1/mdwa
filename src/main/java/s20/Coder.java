package s20;

import java.time.LocalDate;

public class Coder {
    private long id;
    private String color;
    private String firstName;
    private String lastName;
    private LocalDate hireDate;
    private double salary;

    public Coder() {
    }

    public Coder(String firstName, String lastName, double salary) {
        this(0, firstName, lastName, null, salary);
    }

    public Coder(long id, String firstName, String lastName, double salary) {
        this(id, firstName, lastName, LocalDate.now(), salary);
    }

    public Coder(long id, String firstName, String lastName, LocalDate hireDate, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.salary = salary;
    }
    
    public Coder(String color,long id,  String firstName, String lastName, LocalDate hireDate, double salary) {
    	this(id, firstName, lastName, LocalDate.now(), salary);
    	this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coder [id=").append(id).append(", color=").append(color).append(", firstName=")
				.append(firstName).append(", lastName=").append(lastName).append(", hireDate=").append(hireDate)
				.append(", salary=").append(salary).append("]");
		return builder.toString();
	}

	
}