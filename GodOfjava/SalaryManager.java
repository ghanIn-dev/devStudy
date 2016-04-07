
public class SalaryManager {

	public static void main(String arge[]){
		
		
		SalaryManager manager = new SalaryManager();
		
		manager.getMonthlySalary(20000000);
		
	}
	
	
	public double getMonthlySalary(int yearlySalary){
		
		double monthlySalary=yearlySalary/12.0;
		
		double allMinus=calculateHealthInsurance(monthlySalary)+calculateNationalPension(monthlySalary)+calculateTax(monthlySalary);
		
		monthlySalary-=allMinus;
		
		
		System.out.println(monthlySalary);
		
		return monthlySalary;
	}
	
	
	public double calculateTax(double monthlySalary){
		
		 return monthlySalary/12.5;
	}
	
	public double calculateNationalPension(double monthlySalary){
		
		 return monthlySalary/8.1;
	}
	
	public double calculateHealthInsurance(double monthlySalary){
		
		 return monthlySalary/13.5;
	}
}
