package com.tasksCalendar.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Adrien POPLIN
 *
 */

public interface Crud<T> {

	/**
	 * Insert Object of DB
	 */
	public void insert();

	/**
	 * Select all line in DB
	 * 
	 * @return ArrayList<?> Return list of all by Object in DB
	 */
	public ArrayList<T> selectAll();

	/**
	 * Select one line in DB
	 * 
	 * @return HashMap<String, ?> Return hashMap of unique Object in DB
	 */
	public HashMap<String, T> select();

	/**
	 * Edit Object in DB
	 */
	public void update();

	/**
	 * Delete Object in DB
	 */
	public void delete();
}
