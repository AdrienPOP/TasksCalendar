package com.tasksCalendar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;

public class User implements Crud<User> {

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
		setId(id);
		setName(name);
		setSurname(surname);
		setAdress(adress);
		setPhone(phone);
		setMail(mail);
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
		String query = "SELECT id_user, name, surname, pseudo, password FROM users WHERE pseudo = ?; ";
		
		try(PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			 prep.setString(1, this.pseudo);
			 ResultSet result = prep.executeQuery();
			 while (result.next()) {
				 this.id = result.getInt("id_user");
				 this.name = result.getString("name");
				 this.surname = result.getString("surname");
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
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// Getters and Setters :

	public String getName() {
		return name;
	}

	public void setName(String name){
		if (name == null || !name.matches("[a-zA-Z\\s-']{2,25}")) {
			throw new RuntimeException();
		} else {
			this.name = name;
		}
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname == null || !surname.matches("[a-zA-Z\\s-']{2,25}")) {
			throw new RuntimeException();
		} else {
			this.surname = surname;
		}
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
		if (phone == null || !phone.matches("[0-9]{10}")) {
			throw new RuntimeException();
		} else {
			this.phone = phone;
		}
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		if (mail == null || !mail.matches("[a-zA-Z0-9-_]{2,30}+@[a-z0-9]{2,30}+.[a-z]{2,10}")) {
			throw new RuntimeException();
		} else {
			this.mail = mail;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}$")){
			throw new RuntimeException();
		} else {
			this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		}
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
		if(pseudo == null || !pseudo.matches("[a-zA-Z0-9-]{3,25}")) {
			throw new RuntimeException();
		} else {
			this.pseudo = pseudo;	
		}
	}

	// To-String :

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", adress=" + adress + ", phone=" + phone
				+ ", mail=" + mail + ", pseudo=" + pseudo + ", password=" + password + "]";
	}

}
