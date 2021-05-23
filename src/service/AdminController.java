package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.obs.dao.DBConnection;
import com.obs.model.AdminModel;

public class AdminController{

	private  static Connection con;
	private  static PreparedStatement prepa;

	public static boolean validate(AdminModel adminModel) {
		boolean status = false;

		try {
			con = DBConnection.getDBConnection();

			prepa = con.prepareStatement("select * from admin where username = ? and password = ? ");
			prepa.setString(1, AdminModel.getUsername());
			prepa.setString(2, AdminModel.getPassword());

			ResultSet rs = prepa.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}

		return status;
	}
	
	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
