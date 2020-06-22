package com.ssc.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssc.shop.model.UserInfo;

public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(UserInfo user) throws SQLException {
		SqlSession sqlSession = ConnectionUtil.getSqlSessionFactory().openSession();
		Connection con = sqlSession.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO userinfo ('email_id', 'password', 'first_name', 'last_name') VALUES (?,?,?,?)");
			stmt.setString(1, user.getEmailId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.executeQuery();
			sqlSession.commit();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			sqlSession.close();
		}

	}

	@Override
	public UserInfo getUserById(Integer userId) {
		SqlSession sqlSession = ConnectionUtil.getSqlSessionFactory().openSession();
		Connection con = sqlSession.getConnection();
		UserInfo user = new UserInfo();
		try {
//			UserDao userMapper = sqlSession.getMapper(UserDao.class);

//			CallableStatement stmt = con.prepareCall("{CALL get_user(?)}");

			PreparedStatement stmt = con.prepareStatement("select * from userinfo where user_id=?");

			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmailId(rs.getString("email_id"));
			}

//			return userMapper.getUserById(userId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			sqlSession.close();
		}
	}
	@Override
	public UserInfo checkLogin(String email,String password) {
		SqlSession sqlSession = ConnectionUtil.getSqlSessionFactory().openSession();
		Connection con = sqlSession.getConnection();
		UserInfo user = new UserInfo();
		try {
//			UserDao userMapper = sqlSession.getMapper(UserDao.class);

//			CallableStatement stmt = con.prepareCall("{CALL get_user(?)}");

			PreparedStatement stmt = con.prepareStatement("select * from userinfo where email_id=? and password=?");

			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmailId(rs.getString("email_id"));
			}

//			return userMapper.getUserById(userId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			sqlSession.close();
		}
	}

	@Override
	public List<UserInfo> getAllUsers() {
		SqlSession sqlSession = ConnectionUtil.getSqlSessionFactory().openSession();
		List<UserInfo> userInfos = new ArrayList<>();
		Connection con = sqlSession.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM USERINFO");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmailId(rs.getString("email_id"));
				userInfos.add(user);
			}
			return userInfos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			sqlSession.close();
		}
	}

	@Override
	public void updateUser(UserInfo user) {
		SqlSession sqlSession = ConnectionUtil.getSqlSessionFactory().openSession();
		Connection con = sqlSession.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE userinfo SET 'email_id'=?,'password'=?,'first_name'=?,'last_name'=? WHERE 'user_id'=?");
			stmt.setString(1, user.getEmailId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(4, user.getUserId());
			stmt.executeUpdate();
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			sqlSession.close();
		}

	}

	@Override
	public void deleteUser(Integer userId) {
		SqlSession sqlSession = ConnectionUtil.getSqlSessionFactory().openSession();
		Connection con = sqlSession.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM USERINFO WHERE user_id=?" );
			stmt.setInt(1, userId);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			sqlSession.close();
		}

	}

}
