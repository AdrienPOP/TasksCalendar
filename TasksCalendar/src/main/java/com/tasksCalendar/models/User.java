package com.tasksCalendar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Crud {

	private int id;
	private String name;
	private String surname;
	private String adress;
	private String phone;
	private String mail;
	private String pseudo;
	private String password;

	/**
	 * Default Constructor
	 */
	public User() {

	};

	/**
	 * 
	 * @param id int Corresponds id of user to Data Base
	 * @param name Corresponds user name
	 * @param adress Corresponds user adress
	 * @param phone Corresponds user phone
	 * @param mail Corresponds user mail
	 * @param password Corresponds user password
	 */
	public User(int id, String name, String surname, String adress, String phone, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;
		this.mail = mail;
	}
	
	/**
	 * 
	 * @return boolean Return boolean, User has a password in DB. If true, set password with password in DB
	 */
	
	public boolean selectByPseudo() {
		String query = "SELECT password FROM users WHERE pseudo = ?; ";
		try(PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			 prep.setString(1, this.pseudo);
			 ResultSet result = prep.executeQuery();
			 while (result.next()) {
				 this.password = result.getString("password");
				 return true;
			 }
			 DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * set id, name and password with data in DB
	 */
	public void selectByPseudoFull() {
		String query = "SELECT id_user, name, pseudo, password FROM users WHERE pseudo = ?; ";
		
		try(PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			 prep.setString(1, this.pseudo);
			 ResultSet result = prep.executeQuery();
			 while (result.next()) {
				 this.id = result.getInt("id_user");
				 this.name = result.getString("name");
				 this.password = result.getString("password");
				 
			 }
			 DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Methods Crud

	@Override
	public void insert() {
		String query = "INSERT INTO users (name, surname, adress, phone, email, pseudo, password) VALUES(?, ?, ?, ?, ?, ?, ?);";
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS)) {

			prep.setString(1, this.name);
			prep.setString(2, this.surname);
			prep.setString(3, this.adress);
			prep.setString(4, this.phone);
			prep.setString(5, this.mail);
			prep.setString(6, this.pseudo);
			prep.setString(7, this.password);
			prep.executeUpdate();

			ResultSet result = prep.getGeneratedKeys();
			while (result.next())
				this.id = result.getInt(1);
			DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, User> select() {
		HashMap<String, User> dataUsers = new HashMap<>();
		String query = "SELECT id_user, pseudo, password FROM users WHERE id_user = ?;";

		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)) {

			prep.setInt(1, this.id);

			ResultSet result = prep.executeQuery();

			while (result.next()) {
				User u = new User();
				u.setId(result.getInt("id_user"));
				u.setPseudo(result.getString("pseudo"));
				u.setPassword(result.getString("password"));
				dataUsers.put("u", u);
			}
			DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataUsers;
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
	public ArrayList<?> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// Getters and Setters :

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	// To-String :

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", adress=" + adress + ", phone=" + phone
				+ ", mail=" + mail + ", pseudo=" + pseudo + ", password=" + password + "]";
	}

}
