package hw07;
/*
* By Jesus Perez Arias, CS 2012-01, Friday November 13 2020
*
* This is a custom DateFormatException written by Professor Keenan
* which writes a super message for dateFormatException class
*
*
*/
/**
 * Custom exception class for project.
 * @author Keenan
 *
 */
public class DateFormatException extends Exception {
	private String date;
	
	public DateFormatException(String msg) {
		super(msg);
	}

}