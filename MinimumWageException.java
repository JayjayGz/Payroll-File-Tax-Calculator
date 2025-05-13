
// Custom exception class to handle cases where the hourly wage is below legal minimum wage (i.e. $15.75). 
public class MinimumWageException extends Exception
{
	//Default constructor
	public MinimumWageException()
	{
		//Exception message for hourly wage below legal minimum wage
		super("The hourly wage of the employee cannot be below the legal minimum wage of $15.75");
	}
	
	//Parameterized constructor for display of exception message
	public MinimumWageException(String message)
	{
		super(message);
	}
}
