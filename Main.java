//-----------------------------------------------------------
// Assignment 2
//
// This program reads a file named payroll.txt. That file contains information about the employees   
// of the company iDroid Solutions for the year 2025. The company develops business applications 
// for the Android and iOS platforms. Incorrect information or incorrectly entered information is
// printed in the payrollError.txt file while correct information is printed in the payrollReport.txt
// file generated. This program uses the notions of file I/O, exception 
// handling and abstract classes. In addition, it reinforces the notions of inheritance and arrays.
// 
// Written by: Jeffrey Gueyie, Student ID: 40315016
//-----------------------------------------------------------

//Import of packages and classes
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Driver class
public class Main 
{	 
	//Main method
	public static void main(String[] args) 
	{
		//Welcome message
		System.out.println("Welcome to iDroid Solutions payroll information edition 2k25!");
		System.out.println("--------------------------------------------------------------");
		
		//Employee inventory
		Employee[] employees = new Employee[100];
		
		//Constant 
		final double MINIMUM_WAGE = 15.75;
		
		/*Creation of buffered reader for file payroll.txt and creation of file payrollError.txt to read employee's information and rewrite errors. The information goes in the payroll file
		  if it respects the correct format and in the payrollError file if it doesn't. The IOException is accounted for. */
		
				//Here, we read the Payroll file with BufferedReader, by separating each line in 5 (attributes) in order to evaluate their format.
				try
				{
						BufferedReader payrollReader = new BufferedReader(new FileReader("payroll.txt"));
						PrintWriter error = new PrintWriter(new BufferedWriter(new FileWriter("payrollError.txt")));
						
						String line = "";
						
						while((line = payrollReader.readLine()) != null)
						{
							 
								String[] parts = line.split(" ");
	
								//Here we are just trying to see if the information entered by the user is compatible to the number format. If not, nfe is caught.
								try
								{
									if(parts.length != 5)
									{
										throw new NumberFormatException();									
									}
									
									long number = Long.parseLong(parts[0]);
									String firstName = parts[1].toUpperCase();
									String lastName = parts[2].toUpperCase();
									double hoursWorked = Double.parseDouble(parts[3]);
									double hourlyWage = Double.parseDouble(parts[4]);
									
									//If the hourly wage of the employee is below the legal minimum wage, mwe is thrown.
									if(hourlyWage < MINIMUM_WAGE)
									{
										throw new MinimumWageException();
									}
																
									//If there is no issue with the number format and the hourly wage, the information gets stored in the employees array.
									Employee newEmployee = new Employee(number, firstName, lastName, hoursWorked, hourlyWage);
									
									//Create instanceOf concrete classes
									EI eiTax = new EI();
									QPIP qpipTax = new QPIP();
									QPP qppTax = new QPP();
									PIT pitTax = new PIT();
									FIT fitTax = new FIT();
									
									//Calculations of total tax deductions and annual net salary.
									for(int i = 0; i < employees.length; i++)
									{
										if (employees[i] == null)
							            {
											employees[i] = newEmployee;
											
											//Calculation of total deductions adding five taxes together
										double totalDeductions = (eiTax.calculateTax(employees[i].getAnnualGrossSalary()) +
																	  qpipTax.calculateTax(employees[i].getAnnualGrossSalary()) + 
																	  qppTax.calculateTax(employees[i].getAnnualGrossSalary()) +							  
																	  pitTax.calculateTax(employees[i].getAnnualGrossSalary()) +
																      fitTax.calculateTax(employees[i].getAnnualGrossSalary()));
										employees[i].setTotalDeductions(totalDeductions);
											
							                System.out.println("Employee added successfully.");
							                break;
							            }
									}
								}
								//In case of nfe, PayrollError is appended to add employee's informations.
								catch(NumberFormatException nfe)
								{
									error.println(line);
								}
								//In case of mwe, PayrollError is appended to add employee's informations.
								catch(MinimumWageException mwe)
								{
									error.println(line);
								}
							 
						}
						
					payrollReader.close();
					error.close();
				}
				//In case of ioe, a message of exception is printed.
				catch(IOException ioe)
				{	
						System.out.println("A file input/output exception has occured!");
				}
				
		
		/*Creation of buffered file payrollReport to report the employee's array, accounting for IOException. */
		try
		{
			PrintWriter report = new PrintWriter(new BufferedWriter(new FileWriter("payrollReport.txt")));
			report.println("                                  iDroid Solutions");
			report.println("---------------------------------------------------------------------------------------");
			report.printf("%-10s	%-10s	%-10s	%-12s	%-12s	%-12s\n",
                    "Employee no.", 	"First Name", 	"Last Name", 	"Gross Salary",	 "Deductions", 	"Net Salary");
            report.println("---------------------------------------------------------------------------------------");
			
				for(int i = 0; i < employees.length; i++)
				{
					if(employees[i] != null)
					{
						
						report.printf("%-10d	%-10s	%-10s	$%-11.2f	$%-11.2f	$%-11.2f\n", 	employees[i].getNumber(),	 
								employees[i].getFirstName(),	
									 employees[i].getLastName(),	 employees[i].getAnnualGrossSalary(),  
									 employees[i].getTotalDeductions(), 	employees[i].getAnnualNetSalary());
					}
				}	 
			report.close();
		}
		catch(IOException ioe)
		{
			System.out.println("A file input/output exception has occured!");
		}
		
		/*Here, we count the lines in files payroll and payrollError.*/
		try
		{
			System.out.println("> Opening file payroll...");
			System.out.println("\n> Reading file payroll... ");
			BufferedReader payrollReader = new BufferedReader(new FileReader("payroll.txt"));
			
			int count = 0;;
			String line;
			
			while((line = payrollReader.readLine()) != null)
			{
				count++;
			}
			payrollReader.close();
			System.out.println("\n> " + count + " line(s) read from file payroll");
			
			System.out.println("\n> Error lines found in file payroll ");
			BufferedReader payrollErrorReader = new BufferedReader(new FileReader("payrollError.txt"));
			
			int count1 = 0;;
			String line1;
			
			while((line1 = payrollErrorReader.readLine()) != null)
			{	
				count1++;
			}
			payrollErrorReader.close();
			System.out.println("\n> " + count1 + " line(s) written to error file");
			System.out.println("\n> Calculating deductions...");
			System.out.println("\n> Writing report file...");
		}
		catch(IOException ioe)
		{
			System.out.println("A file input/output exception has occured!");
		}
		System.out.println("\nThe program is terminated! Thank you for using our service!");	
	}
}


 

