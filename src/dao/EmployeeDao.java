package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Employee;
import miniProject_1.MyConnection;

public class EmployeeDao {
	Connection con = MyConnection.getConnection();
	PreparedStatement ps, ps2;
	Statement s, s2;
	ResultSet rst, rst2;
	int basic, hra, da, it, netSalary;

	public void AddRecord(Employee e) {
		try {
			int id = 0;
			con.setAutoCommit(false);
			s = con.createStatement();
			rst = s.executeQuery("select EmpNo from employee");
			
			ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			if(rst.last()==true)
			{
				id=rst.getInt(1)+1;
				
			}
			else{
				id=1001;
						
			}
			ps.setInt(1, id);
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setDate(4, e.getJoinDate());
			ps.setString(5, e.getDesignation());
			ps.setString(6, e.getDepartment());
			ps.setInt(7, e.getBasicSalary());
			int a = ps.executeUpdate();
			if (a > 0)
				System.out.println("Record inserted successfully in Employee_Table");
			else {
				System.out.println("Problem inserting the record in Employee_Table");
				return;
			}

			s = con.createStatement();
			rst = s.executeQuery("select EmpNo from employee");
			rst.last();
			id = rst.getInt(1);

			ps = con.prepareStatement("insert into employee_personal_info values(?,?,?,?,?,?,?)");
			ps.setDate(1, e.getDateOfBirth());
			ps.setString(2, e.getQualification());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getCity());
			ps.setString(5, e.getPin());
			ps.setLong(6, e.getPhone());
			ps.setInt(7, id);

			int b = ps.executeUpdate();
			if (b > 0) {
				System.out.println("Record inserted in Employee_Personal_Info_Table successfully");
				con.commit();
			} else {
				System.out.println("Problem inserting the record in Employee_Personal_Info_Table..");
				System.out.println("Rolling back the record inserted in Employee_table");
				con.rollback();
			}

		} catch (SQLException sqle1) {
			sqle1.printStackTrace();
			if (con != null)
				try {
					con.rollback();
				} catch (SQLException sqle2) {

					sqle2.printStackTrace();
				}
		}
	}

	public String deleteRecord(int empNo) {
		try {
			ps = con.prepareStatement("delete from employee where EmpNo = ?");
			ps.setInt(1, empNo);
			int status = ps.executeUpdate();
			if(status>0)
				return "record deleted!!!!";
			else 
				return "record not deleted!!!!";
		} catch (SQLException sqle) {
			//System.out.println("record not deleted!!!!");
			sqle.printStackTrace();
			return "record not deleted!!!!";
		}

	}

	public void displayOneRecord(int empNo) {
		try {
			ps = con.prepareStatement("select * from employee where EmpNo = ?");

			ps.setInt(1, empNo);
			rst = ps.executeQuery();
			if (rst.next() == false) {
				System.out.println("record doesn't exist!!!");
				return;
			} else {
				System.out.println("Employee No 			:	" + rst.getInt(1));
				System.out.println("Employee Name		 	:	" + rst.getString(2) + " " + rst.getString(3));
				System.out.println("Join Date 				:	" + rst.getDate(4));
				System.out.println("Designation 			:	" + rst.getString(5));
				System.out.println("Department				:	" + rst.getString(6));
				System.out.println("Basic Salary    		:   " + rst.getInt(7));
			}
			ps2 = con.prepareStatement("select * from employee_personal_info where EmpNo = ?");

			ps2.setInt(1, empNo);
			rst2 = ps2.executeQuery();
			System.out.println("Date of Birth				:	" + rst2.getInt(1));
			System.out.println("Educational Qualification	:	" + rst2.getString(2));
			System.out.println("Address                     :   " + rst2.getString(3));
			System.out.println("	City					:	" + rst2.getString(4));
			System.out.println("	Pin						:	" + rst2.getString(5));
			System.out.println("Phone						:	" + rst2.getLong(6));

		} catch (SQLException sqle) {
			System.out.println("record doesn't exist!!!");
			sqle.printStackTrace();
		}
	}

	public void displayAllRecord() {
		try {
			s = con.createStatement();
			s2 = con.createStatement();
			rst = s.executeQuery("select * from employee");
			rst2 = s2.executeQuery("select DateOfBirth from employee_personal_info");
			System.out.println("Emp ID Full Name Date of Birth Designation Department Net Salary");

			while (rst.next() && rst2.next()) {
				basic = rst.getInt(7);
				hra = basic / 5;
				da = 2 * (basic / 5);
				it = (basic + hra + da) / 10;
				netSalary = basic + hra + da - it;
				System.out.println(rst.getInt(1) + "\t" + rst.getString(2) + " " + rst.getString(3) + "\t"
						+ rst2.getDate(1) + "\t" + rst.getString(5) + "\t" + rst.getString(6) + "\t" + netSalary);
			}

		} catch (SQLException e) {
			System.out.println("record doesn't exist!!!");
			e.printStackTrace();
		}
	}

	public boolean checkAvailable(int empNo) {
		try {
			ps = con.prepareStatement("select * from employee where EmpNo = ?");

			ps.setInt(1, empNo);
			rst = ps.executeQuery();
			if (rst.next() == false) {
				System.out.println("record doesn't exist!!!");
				return false;
			} else
				return true;
		} catch (SQLException e) {
			System.out.println("sorry something went wrong!!!!");
			e.printStackTrace();
			return false;
		}

	}

}
