package com.tasksCalendar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDb implements Crud <User> {
	
	public ArrayList<User> selectAll() {
		
		ArrayList<User> dataUsers = new ArrayList<>();
		
		String query = "SELECT * FROM users;";
		try {
			PreparedStatement prep = DbConnect.getConnector().prepareStatement(query);
			ResultSet result =  prep.executeQuery();
			
			
			while (result.next()) {
				User user = new User();
				user.setId(result.getInt("id_user"));
				user.setName(result.getString("name"));
				user.setSurname(result.getString("surname"));
				user.setAdress(result.getString("adress"));
				user.setMail(result.getString("email"));
				user.setPhone(result.getString("phone"));
				user.setPseudo(result.getString("pseudo"));
				user.setPassword(result.getString("password"));
				dataUsers.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataUsers;
	}


	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, User> select() {
		return null;
	}
}
