
public class FIT extends Deductions
{
	double annualTaxable = 0;
	
	@Override //Method to calculate the Federal Income Tax (FIT) deductions.
	public double calculateTax(double annualGrossSalary)
	{
		if(annualGrossSalary < 16129)
		{
			annualTaxable = 0;
		}
		else if (annualGrossSalary <= 57375)
		{
			annualTaxable = ((annualGrossSalary-16129)*15/100);
		}
		else if(annualGrossSalary <= 114750)
		{
			annualTaxable = ((57375-16129)*15/100 + (annualGrossSalary-57375)*20.5/100);
		}
		else if(annualGrossSalary <= 177882)
		{
			annualTaxable = ((57375-16129)*15/100 + (114750-57375)*20.5/100 + (annualGrossSalary-114750)*26/100);
		}
		else if( annualGrossSalary <= 253414)
		{
			annualTaxable = ((57375-16129)*15/100 + (114750-57375)*20.5/100 + (177882-114750)*26/100 + (annualGrossSalary-177882)*29/100);
		}
		else
		{
			annualTaxable = ((57375-16129)*15/100 + (114750-57375)*20.5/100 + (177882-114750)*26/100 + (253414-177882)*29/100 + (annualGrossSalary-253414)*33/100);
		}
		
		return(annualTaxable);
	}
}
