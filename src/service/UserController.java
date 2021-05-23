package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.obs.dao.DBConnection;
import com.obs.model.UserModel;

public class UserController {

	private static Connection con;
	private static PreparedStatement prepa;

	public void addUsers(UserModel user) {
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("INSERT INTO users (name, email, country) " + "VALUES (?, ?, ?)");
			con.setAutoCommit(false);

			prepa.setString(1, user.getName());
			prepa.setString(2, user.getEmail());
			prepa.setString(3, user.getCountry());

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

	public ArrayList<UserModel> getUserList() {
		ArrayList<UserModel> userList = new ArrayList<>();
		con = DBConnection.getDBConnection();

		try {
			prepa = con.prepareStatement("select * from users");
			ResultSet rs1 = prepa.executeQuery();

			while (rs1.next()) {
				UserModel u = new UserModel();

				u.setId(rs1.getInt(1));
				u.setName(rs1.getString(2));
				u.setEmail(rs1.getString(3));
				u.setCountry(rs1.getString(4));

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

	public UserModel getUserDetail(String id) {

		con = DBConnection.getDBConnection();

		UserModel u = new UserModel();
		try {
			prepa = con.prepareStatement("select * from users where id = ?");

			prepa.setString(1, id);

			ResultSet rs1 = prepa.executeQuery();

			if (rs1.next()) {

				u.setId(rs1.getInt(1));
				u.setName(rs1.getString(2));
				u.setEmail(rs1.getString(3));
				u.setCountry(rs1.getString(4));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	public void deleteUser(int id) {
		con = DBConnection.getDBConnection();
		
		try {
			prepa = con.prepareStatement("DELETE FROM users WHERE id = ?");
			prepa.setInt(1, id); 
			prepa.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(prepa != null) {
					prepa.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
			}
		}
		
	}
	
	public int updateUser(UserModel c1, String id ) {
		int status = 0;
		try {
			con = DBConnection.getDBConnection();
			prepa = con.prepareStatement("update users as c set c.name = ?, c.email = ?, c.country = ? where c.id = ?");
			prepa.setString(1, c1.getName());
			prepa.setString(2, c1.getEmail());
			prepa.setString(3, c1.getCountry());
			prepa.setString(4, id);
			
			
			status = prepa.executeUpdate(); 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(prepa != null) {
					prepa.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
			}
		}

		return status; 
	}

}
