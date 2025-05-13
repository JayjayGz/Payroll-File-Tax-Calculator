
public class QPP extends Deductions
{
	double pension = 0;
	
	@Override //Method to calculate the Quebec Pension Plan (QPP) deductions.
	public double calculateTax(double annualGrossSalary)
	{
		pension = 10.8/100*annualGrossSalary;
		
		if(pension > 7700.40)
		{	
			return(7700.40);
		}
		else
		{
			return(pension);
		}
	}
}
