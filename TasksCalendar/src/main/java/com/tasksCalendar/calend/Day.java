package com.tasksCalendar.calend;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import com.tasksCalendar.models.Task;

public class Day {
	private LocalDate date;
	private String previous;
	private String next;
	private String name;
	private int idUser;
	private ArrayList<Task> tasksDay;

	public Day(LocalDate date, int idUser) {
		this.date = date;
		this.idUser = idUser;
		setName(date);
		setTasksDay();
	}

	// Getters and Setters :

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(LocalDate date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Date.valueOf(date));
		int nd = calendar.get(Calendar.DAY_OF_WEEK);
		switch (nd) {
		case 1:
			this.name = "Dimanche";
			break;
		case 2:
			this.name = "Lundi";
			break;
		case 3:
			this.name = "Mardi";
			break;
		case 4:
			this.name = "Mercredi";
			break;
		case 5:
			this.name = "Jeudi";
			break;
		case 6:
			this.name = "Vendredi";
			break;
		case 7:
			this.name = "Samedi";
			break;
		default:
			break;
		}
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ArrayList<Task> getTasksDay() {
		return tasksDay;
	}

	public void setTasksDay() {
		Date d = Date.valueOf(date);
		this.tasksDay = Task.selectTaskUserByDay(idUser, d);
	}

	@Override
	public String toString() {
		return "Day [date=" + date + ", previous=" + previous + ", next=" + next + ", nom=" + name + ", tasksDay="
				+ tasksDay + "]";
	}

}
