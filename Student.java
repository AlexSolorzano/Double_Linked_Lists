//package edu.uga.cs1302.list
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
/**
 * @author Alexandra Solorzano
 * This beautifully coded class defines what a student
 * is and includes getters/setters and extends Person Class.
 *
 */

@SuppressWarnings({ "serial", "unused" })
public class Student extends Person{
	private String collegeName;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param idNumber
	 * @param dateOfBirth
	 * @param collegeName
	 * @throws ParseException
	 */
	public Student(String firstName, String lastName, int idNumber, Date dateOfBirth, String collegeName) throws ParseException
	{
		super(firstName,lastName,idNumber, dateOfBirth);
		this.collegeName=collegeName;
	}
	
	/**
	 * 
	 * @throws ParseException
	 */
	public Student() throws ParseException
	{
		super();
		collegeName="";
	}
	
	/**
	 * 
	 * @param collegeName
	 * @throws ParseException
	 */
	public Student(String collegeName) throws ParseException
	{
		super();
		this.collegeName=collegeName;
		
	}
	
	/**
	 * 
	 * @param collegeName
	 */
	public void setCollegeName(String collegeName)
	{
		this.collegeName=collegeName;
	}
	
	/**
	 * 
	 * @return collegeName;
	 */
	public String getCollegeName()
	{
		return collegeName;
	}
	
	/**
	 * 
	 * @param s
	 * @return answer
	 */
	public int compareTo(Student s)
	{
		return super.compareTo(s);
	}

	/**
	 * return string
	 */
	public String toString()
	{
		String information=super.toString()+" ["+this.collegeName+"]";
		return information;
	}
}
