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

public class Month {
	public static final String[] MONTH = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout",
			"Septembre", "Octobre", "Novembre", "Decembre" };
	private Date firstDayMonth;
	private LocalDate date;
	private int number;
	private int numberOfWeek;
	private String previous;
	private String next;
	private ArrayList<Week> weeksOfMonth = new ArrayList<Week>();
	
	/** 
	 * return the month at the specified date.
	 * @param date {@link java.time.LocalDate};
	 * 
	 */
	
	public Month(LocalDate date) {
		this.date = date;
		setFirstDayMonth(date);
		setNumberOfWeek();
		getNumberOfWeek();
		setNext();
		setPrevious();
		setWeeksOfMonth(getFirstDayMonth());
		setNumber();
	}

	// Getters and Setters:
	
	/**
	 * Sets first day of the month.
	 * @param date {@link java.time.LocalDate};
	 */
	
	private void setFirstDayMonth(LocalDate date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Date.valueOf(date));
		calendar.set(Calendar.DAY_OF_MONTH, (calendar.getActualMinimum(Calendar.DAY_OF_MONTH)));
		java.util.Date firstD = calendar.getTime();
		this.firstDayMonth = new Date(firstD.getTime());
	}

	/**
	 * Sets numbers of weeks in the month.
	 */
	private void setNumberOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Date.valueOf(date));
		int nw = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		calendar.setTime(getFirstDayMonth());
		if (calendar.get(Calendar.DAY_OF_WEEK) == 1 || nw == 4) {
			this.numberOfWeek = (nw + 1);
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 7 && calendar.getActualMaximum(Calendar.DAY_OF_MONTH) == 31){
			this.numberOfWeek = (nw + 1);
		}	
		else {
			this.numberOfWeek = nw;
		}

	}

	/**
	 * Sets ArrayList of Week
	 * @param date {@link java.time.LocalDate};
	 */
	private void setWeeksOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(Date.valueOf(date));
		calendar.setTime(getFirstDayMonth());
		LocalDate ld = date.toLocalDate();
		
		ArrayList<Week> weeks = new ArrayList<Week>();
		
		if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
			for (int i = 0; i < this.numberOfWeek; i++) {
				weeks.add(new Week(ld.plusWeeks(i)));
			}
		} else {
			for (int i = 0; i < this.numberOfWeek; i++) {
				weeks.add(new Week(ld.plusWeeks(i)));
			}
		}
		
		this.weeksOfMonth = weeks;
	}
	
	/**
	 * Sets number of month
	 */
	
	private void setNumber() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Date.valueOf(date));
		int nm = calendar.get(Calendar.MONTH);
		this.number = nm + 1;
	}

	/**
	 * 
	 * @return int Corresponds of max number of week in month
	 */
	public int getNumberOfWeek() {
		return numberOfWeek;
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
	 * @param date {@link java.time.LocalDate}
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * 
	 * @return String name of month
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 
	 * @return String date(String) of previous month
	 */
	public String getPrevious() {
		return previous;
	}

	/**
	 * 	Sets date(String) of previous month
	 */
	private void setPrevious() {
		LocalDate dt = this.date.plusMonths(-1);
		String datePrevious = dt.toString();
		this.previous = datePrevious;
	}

	/**
	 * 
	 * @return String date(String) of next month
	 */
	public String getNext() {
		return next;
	}

	/**
	 * 	Sets date(String) of next month
	 *
	 */
	private void setNext() {
		LocalDate dt = this.date.plusMonths(1);
		String dateNext = dt.toString();
		this.next = dateNext;
	}
	/**
	 * 
	 * @return String[] Get names of 12 months [Janvier, Fevrier, Mars, Avril, Mai, Juin, Juillet, Aout, Septembre, Octobre, Novembre, Decembre]
	 */
	public static String[] getMonth() {
		return MONTH;
	}

	/**
	 * 
	 * @return java.sql.Date Get Date of first day in month
	 */
	public Date getFirstDayMonth() {
		return firstDayMonth;
	}
	
	/**
	 * 
	 * @return ArrayList<Week> Get Arraylist of weeks in the month
	 */
	public ArrayList<Week> getWeeksOfMonth() {
		return weeksOfMonth;
	}

	@Override
	public String toString() {
		return "Month [firstDay=" + firstDayMonth + ", date=" + date + " numero=" + number
				+ ", numberOfWeek=" + numberOfWeek + ", previous=" + previous + ", next=" + next + ", weeksOfMonth="
				+ weeksOfMonth + "]";
	}

}
