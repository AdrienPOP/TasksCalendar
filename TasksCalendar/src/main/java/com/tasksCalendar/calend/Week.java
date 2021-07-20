package com.tasksCalendar.calend;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

	/**
	 * 
	 * @author Adrien POPLIN
	 *
	 */

public class Week {
	public static final String[] DAY = { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche" };
	private ArrayList<Day> daysOfWeek;
	private Date firstDay;
	private LocalDate date;
	private String previous;
	private String next;
	private int idUser;
	
	/**
	 * return the week at the specified date.
	 * @param date {@link java.time.LocalDate};
	 */
	
	public Week(LocalDate date) {
		this.date = date;
		setFirstDay(date);
		setDaysOfWeek(firstDay);
		setNext();
		setPrevious();
	}
	
	public Week(LocalDate date, int idUser) {
		this.date = date;
		this.idUser = idUser;
		setFirstDay(date);
		setDaysOfWeek(firstDay);
		setNext();
		setPrevious();
	}

	// Getters and Setters :

	/**
	 * 
	 * @return java.time.LocalDate Corresponds to firstdate of week
	 */
	public LocalDate getFirstDay() {
		LocalDate fd = this.firstDay.toLocalDate();
		return fd;
	}

	/**
	 * 
	 * @param date {@link java.time.LocalDate}
	 */
	private void setFirstDay(LocalDate date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Date.valueOf(date));
		calendar.set(Calendar.DAY_OF_WEEK, (calendar.getActualMinimum(Calendar.DAY_OF_WEEK) + 1));
		java.util.Date firstD = calendar.getTime();
		firstDay = new Date(firstD.getTime());
	}

	/**
	 * 
	 * @return date {@link java.time.LocalDate}
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 
	 * @param date {@link java.time.LocalDate} Sets date by java.time.LocalDate
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * 
	 * @return String[] Get names of 7 days [Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche]
	 */
	public static String[] getDay() {
		return DAY;
	}

	/**
	 * 
	 * @return String date(String) of previous week
	 */
	public String getPrevious() {
		return previous;
	}

	/**
	 * Sets String date of previous week
	 */
	private void setPrevious() {
		LocalDate dt = this.date.plusWeeks(-1);
		String dateprevious = dt.toString();
		this.previous = dateprevious;

	}
	/**
	 * 
	 * @return String date(String) of next week
	 */
	public String getNext() {
		return next;
	}

	/**
	 * Sets String date of next week
	 */
	private void setNext() {
		LocalDate dt = this.date.plusWeeks(1);
		String dateNext = dt.toString();
		this.next = dateNext;
	}

	

	public ArrayList<Day> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(Date firstDay) {
		LocalDate fd = firstDay.toLocalDate();
		ArrayList<Day> dataDays = new ArrayList<Day>();
		for( int i = 0; i < 7; i++) {
			dataDays.add(new Day(fd.plusDays(i), idUser));
		}
		this.daysOfWeek = dataDays;
	}

	// ToString:
	@Override
	public String toString() {
		return "Week firstDay=" + firstDay;
	}
}
