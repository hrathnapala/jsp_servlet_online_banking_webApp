package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.obs.dao.DBConnection;
import com.obs.model.AdminModel;
import com.obs.model.CustomerModel;
import com.obs.model.EmployeeModel;

public class UserController {

	private static Connection con;
	private PreparedStatement prepa;

	public UserController() {
	}

	public void addEmployee(EmployeeModel user) {
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

	public ArrayList<EmployeeModel> getEmployeeList() {
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

	public EmployeeModel getEmployeeDetail(String eid) {

		con = DBConnection.getDBConnection();
		EmployeeModel u = null;
		try {
			prepa = con.prepareStatement("select * from employee where eid = ?");

			prepa.setString(1, eid);

			ResultSet rs1 = prepa.executeQuery();

			if (rs1.next()) {

				u = new EmployeeModel(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getString(7));

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

	public void deleteEmployee(String eid) {
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

	public int updateEmployee(EmployeeModel c1, String eid) {
		int status = 0;
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement(
					"update employee as c set c.name = ?, c.email = ?, c.address = ?, c.phonenumber = ? , c.password = ?, c.nic = ? where c.eid = ?");
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

	public boolean validateEmployee(EmployeeModel employeeModel) {
		boolean status = false;

		try {
			con = DBConnection.getDBConnection();

			prepa = con.prepareStatement("select * from employee where eid = ? and password = ? ");
			prepa.setString(1, employeeModel.getEid());
			prepa.setString(2, employeeModel.getPassword());

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

	public boolean validateAdmin(AdminModel adminModel) {
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

	public void addCustomer(CustomerModel customer) {
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement(
					"INSERT INTO user (name,account_number,nic,email,address,phonenumber,account_balance,status,password) "
							+ "VALUES (?, ?, ?,?, ?, ?,?,?,?)");
			con.setAutoCommit(false);

			prepa.setString(1, customer.getName());
			prepa.setLong(2, customer.getAccount_number());
			prepa.setString(3, customer.getNic());
			prepa.setString(4, customer.getEmail());
			prepa.setString(5, customer.getAddress());
			prepa.setInt(6, customer.getPhonenumber());
			prepa.setDouble(7, customer.getAccount_balance());
			prepa.setBoolean(8, customer.isStatus());
			prepa.setString(9, customer.getPassword());

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

	public ArrayList<CustomerModel> getCustomerList() {
		ArrayList<CustomerModel> customerList = new ArrayList<>();
		con = DBConnection.getDBConnection();

		try {
			prepa = con.prepareStatement("select * from user");
			ResultSet rs1 = prepa.executeQuery();

			while (rs1.next()) {

				CustomerModel u = new CustomerModel(rs1.getString(1), rs1.getLong(2), rs1.getString(3),
						rs1.getString(4), rs1.getString(5), rs1.getInt(6), rs1.getDouble(7), rs1.getBoolean(8),
						rs1.getString(9));

				customerList.add(u);
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

		return customerList; /* returns candidate details */
	}

	public CustomerModel getCustomerDetail(long acno) {
		con = DBConnection.getDBConnection();
		CustomerModel u = null;
		try {
			prepa = con.prepareStatement("select * from user where account_number = ?");

			prepa.setLong(1, acno);

			ResultSet rs1 = prepa.executeQuery();

			if (rs1.next()) {

				u = new CustomerModel(rs1.getString(1), rs1.getLong(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getInt(6), rs1.getDouble(7), rs1.getBoolean(8), rs1.getString(9));

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

	public void deleteCustomer(long acno) {
		con = DBConnection.getDBConnection();

		try {
			prepa = con.prepareStatement("DELETE FROM user WHERE account_number = ?");
			prepa.setLong(1, acno);
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

	public int updateCustomer(CustomerModel c1, String acno) {
		int status = 0;
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement(
					"update user as c set c.name = ?,c.nic = ?, c.email = ? , c.address = ?, c.phonenumber = ?, c.account_balance = ?, c.status = ?, c.password = ? where c.account_number = ?");
			prepa.setString(1, c1.getName());
			prepa.setString(2, c1.getNic());
			prepa.setString(3, c1.getEmail());
			prepa.setString(4, c1.getAddress());
			prepa.setInt(5, c1.getPhonenumber());
			prepa.setDouble(6, c1.getAccount_balance());
			prepa.setBoolean(7, c1.isStatus());
			prepa.setString(8, c1.getPassword());
			prepa.setLong(9, c1.getAccount_number());

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

	public boolean validateCustomer(CustomerModel customerModel) {
		boolean status = false;

		try {
			con = DBConnection.getDBConnection();

			prepa = con.prepareStatement("select * from user where account_number = ? and password = ? ");
			prepa.setLong(1, customerModel.getAccount_number());
			prepa.setString(2, customerModel.getPassword());

			ResultSet rs = prepa.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}

		return status;
	}

//	public int TransferMoney(long acno, Double balance) {
//		int status = 0;
//		try {
//			con = DBConnection.getDBConnection();
//			prepa = con.prepareStatement(
//					"update user as c set c.account_balance = ? where c.account_number = ?");
//			prepa.setString(1, c1.getName());
//			prepa.setString(2, c1.getNic());
//			
//
//			status = prepa.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			try {
//				if (prepa != null) {
//					prepa.close();
//				}
//				if (con != null) {
//					con.close();
//				}
//			} catch (SQLException e) {
//			}
//		}
//
//		return status;
//	}
}
