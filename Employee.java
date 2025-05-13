
public class Employee 
{
	//Employee's attributes
	private long number;
	private String firstName;
	private String lastName;
	private double hoursWorked;
	private double hourlyWage;
	private double annualGrossSalary;
	private double annualNetSalary;
	private double totalDeductions;
	
	//Default constructor
	public Employee()
	{
		this.number = 0;
		this.firstName = "";
		this.lastName = "";
		this.hoursWorked = 0;
		this.hourlyWage = 0;
		this.annualGrossSalary = 0;
		this.annualNetSalary = 0;
		this.totalDeductions = 0;
	}
	
	//Parameterized constructor
	public Employee(long number, String firstName, String lastName, double hoursWorked, double hourlyWage)
	{
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked;
		this.hourlyWage = hourlyWage;
	}
	
	//Copy constructor
	public Employee(Employee otherEmployee)
	{
		 this.number = otherEmployee.number;
		 this.firstName = otherEmployee.firstName;
		 this.lastName = otherEmployee.lastName;
		 this.hoursWorked = otherEmployee.hoursWorked;
		 this.hourlyWage = otherEmployee.hourlyWage;
		 this.annualGrossSalary = otherEmployee.annualGrossSalary;
		 this.annualNetSalary = otherEmployee.annualNetSalary;
		 this.totalDeductions = otherEmployee.totalDeductions;
	}
	
	//Getter: Employee's number
	public long getNumber() 
	{
		return number;
	}
	//Setter: Employee's number
	public void setNumber(long number)
	{
		this.number = number;
	}
	//Getter: Employee's first name
	public String getFirstName() 
	{
		return firstName;
	}
	//Setter: Employee's first name
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	//Getter: Employee's last name
	public String getLastName()
	{
		return lastName;
	}
	//Setter: Employee's last name
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	//Getter: Employee's hours worked
	public double getHoursWorked() 
	{
		return hoursWorked;
	}
	//Setter: Employee's hours worked
	public void setHoursWorked(double hoursWorked) 
	{
		this.hoursWorked = hoursWorked;
	}
	//Getter: Employee's hourly wage
	public double getHourlyWage() 
	{
		return hourlyWage;
	}
	//Setter: Employee's hourly wage
	public void setHourlyWage(double hourlyWage) 
	{
		this.hourlyWage = hourlyWage;
	}
	//Getter: Emplyee's calculated annual gross salary
	public double getAnnualGrossSalary()
	{
		double grossSalary = getHoursWorked()*getHourlyWage()*52;
		return(grossSalary);
	}
	//Setter: Emplyee's calculated annual gross salary
	public void setAnnualGrossSalary(double annualGrossSalary)
	{
		this.annualGrossSalary = annualGrossSalary;
	}
	//Getter: Emplyee's calculated deductions from annual gross salary
	public double getTotalDeductions()
	{
		return totalDeductions;
	}
	//Setter: Emplyee's calculated deductions from annual gross salary
	public void setTotalDeductions(double totalDeductions)
	{
		this.totalDeductions = totalDeductions;
	}
	//Getter: Emplyee's calculated annual net salary
	public double getAnnualNetSalary()
	{
		double netSalary = getAnnualGrossSalary()-getTotalDeductions();  
		
		return (Math.round(netSalary*100.0)/100.0);
	}
	//Setter: Emplyee's calculated annual net salary
	public void setAnnualNetSalary(double annualNetSalary)
	{
		this.annualNetSalary = annualNetSalary;
	}
	
	//toString method for Employee's attributes
	public String toString() {
		return "Employee [number=" + getNumber() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", hoursWorked="
				+ getHoursWorked() + ", hourlyWage=" + getHourlyWage()  + ", annualGrossSalary=" + getAnnualGrossSalary() 
				+  ", totalDeductions=" + getTotalDeductions() + ", annualNetSalary=" + getAnnualNetSalary() +"]";
	}
	
	//equals method for Employee's attributes
	public boolean equals(Object otherObject) 
	{
		if (otherObject != null)
		{
			return false;
		}
		else if (this.getClass() != otherObject.getClass())
		{
			return false;
		}
		else 
		{
			Employee otherEmployee = (Employee) otherObject;
			
			return(getNumber() == otherEmployee.getNumber() &&
					getFirstName().equals(otherEmployee.getFirstName()) &&
					getLastName().equals(otherEmployee.getLastName()) &&
					getHoursWorked() == otherEmployee.getHoursWorked() &&
					getHourlyWage() == otherEmployee.getHourlyWage() &&
					getAnnualGrossSalary() == otherEmployee.getAnnualGrossSalary() &&
					getTotalDeductions() == otherEmployee.getTotalDeductions() &&
					getAnnualNetSalary() == otherEmployee.getAnnualNetSalary());
		}
	
	}
}
