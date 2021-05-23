package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.obs.dao.DBConnection;
import com.obs.model.EmployeeModel;

public class UserController {

	private static Connection con;
	private static PreparedStatement prepa;

	public void addUsers(EmployeeModel user) {
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("INSERT INTO employee (eid,name,email,nic,address,phonenumber,password) "
					+ "VALUES (?, ?, ?,?, ?, ?,?)");
			con.setAutoCommit(false);

			prepa.setString(1, user.getEid());
			prepa.setString(2, user.getName());
			prepa.setString(3, user.getEmail());
			prepa.setString(4, user.getNic());
			prepa.setString(5, user.getAddress());
			prepa.setString(6, user.getPassword());
			prepa.setString(7, user.getPassword());

			prepa.execute();
			con.commit();

		} catch (SQLException s) {
			System.out.println(s);
		}

		finally {
			try {
				if (prepa != null) {
					prepa.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException s) {
				System.out.println(s);
			}
		}

	}

	public ArrayList<EmployeeModel> getUserList() {
		ArrayList<EmployeeModel> userList = new ArrayList<>();
		con = DBConnection.getDBConnection();

		try {
			prepa = con.prepareStatement("select * from employee");
			ResultSet rs1 = prepa.executeQuery();

			while (rs1.next()) {

				EmployeeModel u = new EmployeeModel(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7));

				userList.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (prepa != null) {
					prepa.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}

		return userList; /* returns candidate details */
	}

	public EmployeeModel getUserDetail(String eid) {

		con = DBConnection.getDBConnection();
		EmployeeModel u = null;
		try {
			prepa = con.prepareStatement("select * from employee where eid = ?");

			prepa.setString(1, eid);

			ResultSet rs1 = prepa.executeQuery();
			
			if (rs1.next()) {

				u = new EmployeeModel(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (prepa != null) {
					prepa.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return u;
	}

	public void deleteUser(String eid) {
		con = DBConnection.getDBConnection();

		try {
			prepa = con.prepareStatement("DELETE FROM employee WHERE eid = ?");
			prepa.setString(1, eid);
			prepa.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepa != null) {
					prepa.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}

	}

	public int updateUser(EmployeeModel c1, String eid) {
		int status = 0;
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("update employee as c set c.name = ?, c.email = ?, c.address = ?, c.phonenumber = ? , c.password = ?, c.nic = ? where c.eid = ?");
			prepa.setString(1, c1.getName());
			prepa.setString(2, c1.getEmail());
			prepa.setString(3, c1.getAddress());
			prepa.setString(4, c1.getPhonenumber());
			prepa.setString(5, c1.getPassword());
			prepa.setString(6, c1.getNic());
			prepa.setString(7, eid);

			status = prepa.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (prepa != null) {
					prepa.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}

		return status;
	}

}
