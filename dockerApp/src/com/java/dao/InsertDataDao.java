package com.java.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertDataDao {
	static String sql= "insert into studentDetail values(?, ?, ?, ?)";
	static String url = "jdbc:mysql://localhost:3306/DocumentStorage";
	static String username="root";
	static String password = "root";
	public boolean insertData(String studentName,String className,String fees,String fatherName){
		boolean check = false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1,studentName);
			st.setString(2,className);
			st.setString(3,fees);
			st.setString(4,fatherName);
			st.executeUpdate(); 
			st.close(); 
			con.close(); 
			
            check = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return check;
	}

}
