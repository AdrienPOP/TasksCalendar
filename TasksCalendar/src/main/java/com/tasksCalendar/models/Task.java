package com.tasksCalendar.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Task implements Crud<Task> {

	private int id;
	private String title;
	private String description;
	private Date dateTask;
	private int idUser;
	private boolean checked;

	public Task() {

	}

	public Task(int id, String title, String description, Date dateTask, int idUser, boolean checked) {
		super();
		setId(id);
		setTitle(title);
		setDescription(description);
		setDateTask(dateTask);
		setIdUser(idUser);
	}
	
	
	public static ArrayList<Task> selectTaskUserByDay(int idUserbyUser, Date date){
		ArrayList<Task> dataTasks = new ArrayList<>();
		String query = "Select id_tasks, title, description, date_tasks FROM tasks WHERE id_user = ? AND date_tasks = ?;";
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			prep.setInt(1, idUserbyUser);
			prep.setDate(2, date);
			ResultSet result = prep.executeQuery();
			while (result.next()) {
				Task t = new Task();
				t.setId(result.getInt("id_tasks"));
				t.setTitle(result.getString("title"));
				t.setDescription(result.getString("description"));
				t.setDateTask(result.getDate("date_tasks"));
				dataTasks.add(t);
			}
			DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataTasks;
	}
	
	public ArrayList<Task> selectTaskByUser(){
		ArrayList<Task> dataTasks = new ArrayList<>();
		String query = "Select id_tasks, title, description, date_tasks, id_user FROM tasks WHERE id_user = ?;";
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			prep.setInt(1, this.idUser);
			ResultSet result = prep.executeQuery();
			while (result.next()) {
				Task t = new Task();
				t.setId(result.getInt("id_tasks"));
				t.setTitle(result.getString("title"));
				t.setDescription(result.getString("description"));
				t.setDateTask(result.getDate("date_tasks"));
				t.setIdUser(result.getInt("id_user"));
				dataTasks.add(t);
			}
			DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataTasks;
	}

	
	// Methods Crud

	@Override
	public void insert() {
		String query = "INSERT INTO tasks (title, description, date_tasks, id_user) VALUES(?, ?, ?, ?);";
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS)) {

			prep.setString(1, this.title);
			prep.setString(2, this.description);
			prep.setDate(3, this.dateTask);
			prep.setInt(4, this.idUser);
			prep.executeUpdate();

			ResultSet result = prep.getGeneratedKeys();
			while (result.next())
				this.id = result.getInt(1);
			DbConnect.getConnector().close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Task> selectAll() {
		ArrayList<Task> dataTasks = new ArrayList<>();
		String query = "Select id_tasks, title, description, date_tasks, id_user FROM tasks;";
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			ResultSet result = prep.executeQuery();
			while (result.next()) {
				Task t = new Task();
				t.setId(result.getInt("id_tasks"));
				t.setTitle(result.getString("title"));
				t.setDescription(result.getString("description"));
				t.setDateTask(result.getDate("date_tasks"));
				t.setIdUser(result.getInt("id_user"));
				dataTasks.add(t);
			}
			DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataTasks;
	}

	@Override
	public HashMap<String, Task> select() {
		HashMap<String, Task> dataTask = new HashMap<>();
		String query = "SELECT id_tasks, title, description, date_tasks, id_user FROM tasks WHERE id_tasks =?;";
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)) {

			prep.setInt(1, this.id);

			ResultSet result = prep.executeQuery();
			while (result.next()) {
				Task t = new Task();
				t.setId(result.getInt("id_tasks"));
				t.setTitle(result.getString("title"));
				t.setDescription(result.getString("description"));
				t.setDateTask(result.getDate("date_tasks"));
				t.setIdUser(result.getInt("id_user"));
				dataTask.put("t", t);
			}
			DbConnect.getConnector().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataTask;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateTask() {
		return dateTask;
	}

	public void setDateTask(Date dateTask) {
		this.dateTask = dateTask;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public boolean isChecked() {
		return checked;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

	// To-String

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dateTask=" + dateTask
				+ ", idUser=" + idUser + "]";
	}

}
