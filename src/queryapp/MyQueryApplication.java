package queryapp;

import java.sql.Date;
import java.util.Scanner;

import bean.Employee;
import dao.EmployeeDao;

public class MyQueryApplication {
	static Scanner s = new Scanner(System.in);
	static EmployeeDao eDao ;
	static Employee e = new Employee();
	public static void main(String[] args) {
		
		
		int choice;
		eDao = new EmployeeDao();
		do
		{
			System.out.println("1. Add Record\n2. Modify Record\n3. Delete Record\n4. Display one Record"
					+ "\n5. Display All\n6. Exit");
			 choice = s.nextInt();
			
		switch(choice)
		{
		
		case 1:
		{
			
			String firstName,lastName,dateOfBirth,department,designation,qualification,address,city,pin;
			int basicSalary;
			long phone;
			//s.useDelimiter("$$");
		System.out.println("enter Employee’s First Name");
		 firstName = s.next();
		 e.setFirstName(firstName);
		System.out.println("enter Employee’s last Name");
		 lastName = s.next();
		 e.setLastName(lastName);
		System.out.println("enter Date of Birth(format yyyy-mm-dd)");
		 dateOfBirth = s.next();
		 e.setDateOfBirth(Date.valueOf(dateOfBirth));
		System.out.println("enter Department");
		 department = s.next();
		 e.setDepartment(department);
		System.out.println("enter Designation");
		 designation = s.next();
		 e.setDesignation(designation);
		System.out.println("enter Basic Salary");
		 basicSalary = s.nextInt();
		 e.setBasicSalary(basicSalary);
		System.out.println("enter Educational Qualification");
		  qualification = s.next();
		  e.setQualification(qualification);
		System.out.println("enter Address");
		 address = s.next();
		 e.setAddress(address);
		System.out.println("enter City");
		 city =  s.next();
		 e.setCity(city);
		System.out.println("enter Pin");
		 pin = s.next();
		 e.setPin(pin);
		System.out.println("enter Phone");
		 phone = s.nextLong();
		 e.setPhone(phone);
		 e.setJoinDate(new java.sql.Date(new java.util.Date().getTime()));
		 eDao.AddRecord(e);
		break;
		}
		case 2:
		{
			break;
		}
		case 3:
		{
			
			System.out.println("enter employee id of which you want to delete.");
			int empNo = s.nextInt();
			if(eDao.checkAvailable(empNo))
				System.out.println(eDao.deleteRecord(empNo));
			break;
		}
		case 4:
		{
			System.out.println("enter id of employee to be shown");
			eDao.displayOneRecord(s.nextInt());
			break;
		}
		case 5:
		{
			eDao.displayAllRecord();
			break;
		}
		
		
		}
		}while(choice!=6);
		System.out.println("thanks!!!!");
	}

}
