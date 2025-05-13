
public class PIT extends Deductions
{
	double annualTaxable = 0;
	
	@Override //Method to calculate the Provincial Income Tax (PIT) deductions.
	public double calculateTax(double annualGrossSalary)
	{
		if(annualGrossSalary <= 18571)
		{
			annualTaxable = 0;
		}
		else if (annualGrossSalary <= 53255)
		{
			annualTaxable = ((annualGrossSalary-18571)*14/100);
		}
		else if(annualGrossSalary <= 106495)
		{
			annualTaxable = ((53255-18571)*14/100 + (annualGrossSalary-53255)*19/100);
		}
		else if(annualGrossSalary <= 129590)
		{
			annualTaxable = ((53255-18571)*14/100  + (106495-53255)*19/100 + (annualGrossSalary-106495)*24/100);
		}
		else
		{
			annualTaxable = ((53255-18571)*14/100  + (106495-53255)*19/100 + (129590-106495)*24/100 + (annualGrossSalary-129590)*25.75/100);
		}
		
		return(annualTaxable);
	}
}
