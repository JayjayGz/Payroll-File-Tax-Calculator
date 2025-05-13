
public class EI extends Deductions
{
	
	
	
	@Override //Method to calculate the Employment Insurance (EI) deduction.
	public double calculateTax(double annualGrossSalary)
	{
		
		
			double employmentInsurance = (annualGrossSalary / 100)* 1.64;
			
			if(employmentInsurance > 1077.48)
			{
				return(1077.48);
			}
			else
			{
				return(employmentInsurance);
			}
	}
}
