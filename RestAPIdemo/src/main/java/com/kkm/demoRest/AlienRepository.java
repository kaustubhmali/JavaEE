package com.kkm.demoRest;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class AlienRepository {
	
	List<Aliens> aliens;
	
	Connection con;
	
	public AlienRepository() {
		
		String url = "jdbc:mysql://localhost:3306/aliendb";
		String username = "root";
		String password = "root";
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aliens> getAliens() {
		
		List<Aliens> aliens = new ArrayList<Aliens>();
		String sql = "select * from aliens";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Aliens a = new Aliens();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(aliens);
		return aliens;
	}
	
	public Aliens getAlien(int id) {
		Aliens a = new Aliens();
		String sql = "select * from aliens where id = "+id;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
			
	}

	public void createAlien(Aliens a) {
		String sql = "insert into aliens values (?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, a.getId());
			stm.setString(2, a.getName());
			stm.setInt(3, a.getPoints());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAlien(Aliens a) {
		String sql= "update aliens set name=?, points=? where id=?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(3, a.getId());
			stm.setString(1, a.getName());
			stm.setInt(2, a.getPoints());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Aliens delelteAlien(int id) {
		Aliens a = new Aliens();
		String sql = "delete from aliens where id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
}
