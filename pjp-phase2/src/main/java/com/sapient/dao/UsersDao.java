package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.User;
import com.sapient.utils.DbUtil;

public class UsersDao {

	// CRUD operations

	public void create(User user) {
		// add user data to the database table as a new record
	}

	public User getById(Integer id) {
		String sql = "select * from users where id=?";

		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return resultSetToUser(rs);
				}
			}

		} // conn, stmt, rs will be closed here automatically
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	User resultSetToUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));
		u.setPhone(rs.getString("phone"));
		u.setGender(rs.getString("gender"));
		u.setCity(rs.getString("city"));
		return u;
	}

	public void update(User user) {

	}

	public void delete(Integer id) {

	}

	// QUERY operations

	public List<User> getAll() {
		String sql = "select * from users";
		List<User> users = new ArrayList<>();

		try (Connection conn = DbUtil.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			// loop through rs and convert each record into a user object
			// add each user object to an ArrayList object
			while (rs.next()) {
				users.add(resultSetToUser(rs));
			}

		} // conn, stmt, rs will be closed here automatically
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;
	}

	public User getByEmail(String email) {
		return null;
	}

	public User getByPhone(String phone) {
		return null;
	}

	public List<User> getByGender(String gender) {
		return null;
	}

	public List<User> getByCity(String city) {
		return null;
	}

	public static void main(String[] args) {

		UsersDao dao = new UsersDao();
		List<User> list = dao.getAll();
		for (User u : list) {
			System.out.println(u);
		}
	}
}
