package com.lp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static Connection con = null;
	public static void main(String[] args) {
		System.out.println("Test ");
		try {
			Class.forName("java.sql.Connection");
			//step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//	step2 create  the connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@ofss-mum-338.snbomprshared1.gbucdsint02bom.oraclevcn.com:1523:FCIS12C2", "GTTOG14D", "GTTOG14D");
			//step3 create the statement object
			Statement stmt = con.createStatement();
			//step4 execute query
			ResultSet rs = stmt.executeQuery("select * from bodoutstandingunitstbl");
			
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			//step5 close the connection object
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
