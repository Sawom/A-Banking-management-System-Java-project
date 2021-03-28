package employee.system;

public class HourlyEmployee extends Employee {
	
	double hourlyRate;
	int hourWorked;
	
	public HourlyEmployee(String name, String id, String designation, double hourlyRate, int hourWorked) {
		super(name, id, designation);
		this.hourlyRate = hourlyRate;
		this.hourWorked = hourWorked;
	}
	
	double getSalary(int hWorked) {
		
		return hourlyRate*hWorked;
	}
	
	@Override
	void increaseSalary(double amt) throws InvalidSalaryException{

		if(hourlyRate+amt > 500){
			throw new InvalidSalaryException("Hourly rate can not be more than 500");
		}

		else {
			hourlyRate += amt;
		}
	}
	
	@Override
	double getSalary() {
		
		return hourlyRate*hourWorked;
	}
	
	@Override
	void display() {
		
		super.display();
		System.out.println("Rate: "+hourlyRate);
	}

}