package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBConnectMySQL;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public void insertUser (int Id) {
		
	}

	@Override
	public List<UserModel> findAll() {

		String sql = "SELECT * FROM users";

		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			List<UserModel> list = new ArrayList<UserModel>();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"),  rs.getString("fullName"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("avatar"),
						rs.getString("phoneNumber") , rs.getDate("createdDate"), rs.getInt("roleid")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByID(int id) {

		String sql = "SELECT * FROM users WHERE id = ? ";

		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setRoleId(Integer.parseInt(rs.getString("roleid")));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO users(fullName, username, password, email, phoneNumber, roleId) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectMySQL().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getPhoneNumber());
			ps.setInt(6, user.getRoleId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByUsername(String username) {

		String sql = "select * from users where users.username = ?";

		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			if (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullName"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setRoleId(Integer.parseInt(rs.getString("roleid")));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "SELECT * FROM users WHERE email = ?";

		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT * FROM users WHERE username = ?";

		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "SELECT * FROM users WHERE phone = ?";

		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return duplicate;
	}

	public static void main(String[] args) {
		try {
			IUserService userService = new UserServiceImpl();
			IUserDao userDao = new UserDaoImpl();
			//System.out.println(userDao.findAll());
			//userDao.insert(new UserModel("a", "a", "123", "htfhta", "1233", 1));
			userDao.findByUsername("n");
			System.out.println(userService.login("n", "n"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
