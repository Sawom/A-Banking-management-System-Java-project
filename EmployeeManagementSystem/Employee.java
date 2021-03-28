package employee.system;

abstract class Employee {
	private String name;
	private String id;
	private String designation;
	
	public Employee(String name, String id, String designation) {
		super();
		this.name = name;
		this.id = id;
		this.designation = designation;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	abstract double getSalary();
	
	abstract void increaseSalary(double amt) throws InvalidSalaryException;
	
	void display()
	{
		System.out.println("Name: "+name+" ID: "+id+" Designation: "+designation);
	}
}