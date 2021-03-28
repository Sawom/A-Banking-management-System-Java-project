package employee.system;

import java.util.Scanner;

public class UAP {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InvalidSalaryException {
		
		UapCse myUap = new UapCse("University of Asia Pacific");
		
		while(true)
		{
			int option = showmenu();
			
			switch(option)
			{
			case 1:
				System.out.println("Press 1 for Salaried\nPress 2 for Hourly\nPress 3 for Commission");
				int type = scan.nextInt();
				
				if(type==1)
				{
					System.out.println("Please Enter Name, ID, Designation and M1onthlySalary for new Employee");
					String nm = scan.next();
					String id = scan.next();
					String des = scan.next();
					double msal = scan.nextDouble();
					
					myUap.addNewEmployees(nm, id, des, msal);
				}
				
				else if(type==2)
				{
					System.out.println("Please Enter Name, ID, Designation, HourlyRate and HourWorked for new Employee");
					String nm = scan.next();
					String id = scan.next();
					String des = scan.next();
					double hr = scan.nextDouble();
					int hw = scan.nextInt();
					
					myUap.addNewEmployees(nm, id, des, hr, hw);
				}
				
				else if(type==3)
				{
					System.out.println("Please Enter Name, ID, Designation, Commission and Sale for new Employee");
					String nm = scan.next();
					String id = scan.next();
					String des = scan.next();
					double cm = scan.nextDouble();
					int s = scan.nextInt();
					
					myUap.addNewEmployees(nm, id, des, cm, s);
				}
				break;
				
			case 2: 
				System.out.println("Please Enter Employee ID for Salary Info");
				String id = scan.next();
				
				double Sal = myUap.getSalary(id);
				System.out.println("Salary: "+Sal);
				break;
				
			case 3:
				System.out.println("Please Enter Employee ID and Amount for increase Salary");
				String ID = scan.next();
				double amt = scan.nextDouble();
				
				myUap.increaseSalary(ID, amt);
				break;
				
			case 4: 
				System.out.println("Please Enter Employee ID for Display his/her Info");
				String Roll = scan.next();
				
				myUap.displayInfo(Roll);
				break;
				
			case 5: 
				System.out.println(myUap.name+" all Employee Info");
				myUap.display();
				break;
				
			case 0:
				System.exit(0);
			}
		}
	}
	
	public static int showmenu()
	{
		System.out.println("\nPress 1 for Employee Type\nPress 2 for Salary Info for Particular Employee\nPress 3 for Increse the Salary of Employee\nPress 4 for Display Specific Employee Info\nPress 5 for Display all Employee Info\nPress 0 for Exit");
		
		int op = scan.nextInt();
		return op;
	}
}