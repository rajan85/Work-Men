package bean;

import java.sql.Date;

public class Employee {
		private int id,basicSalary;
		private String firstName,lastName,department,designation,city,address,qualification,pin;
		private Date dateOfBirth,joinDate;
		private long phone;
		public int getId() {
			return id;
		}
		
		public void setJoinDate(Date joinDate) {
			this.joinDate = joinDate;
		}

		public int getBasicSalary() {
			return basicSalary;
		}
		public void setBasicSalary(int basicSalary) {
			this.basicSalary = basicSalary;
		}
		
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Date getJoinDate() {
			return joinDate;
		}
		
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getPin() {
			return pin;
		}

		public void setPin(String pin) {
			this.pin = pin;
		}
		
}
 