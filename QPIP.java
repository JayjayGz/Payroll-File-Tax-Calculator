
public class QPIP extends Deductions
{
	double parentalInsurance = 0;
	
	@Override //Method to calculate the Quebec Parental Insurance Plan (QPIP) deductions.
	public double calculateTax(double annualGrossSalary)
	{
		parentalInsurance = 0.494/100*annualGrossSalary;
		
		if(parentalInsurance > 484.12)
		{
			//Mistake in instructions: should be $484.12
			return(484.12);
		}
		else
		{
			return(parentalInsurance);
		}
	}
}
