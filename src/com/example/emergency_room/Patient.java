package com.example.emergency_room;

import java.io.Serializable;

public class Patient implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String[] name;
	private String health_card_num;
	private String birth_date;
	private String arrival_time;
	
	/**Creates Patient with a health card number, a name and a date of birth. 
	 * @param String Patient's health card number. 
	 * @param String[] Patient's first name at index 0 and last name starting at index 1(Patient)
	 * may have a middle name or more than 1 last name.
	 * @param String Date of birth of the Patient.
	 */
	
	public Patient(String health_card_num, String[] name, String dob){
		
		this.name = name; 
		this.health_card_num = health_card_num;
		this.birth_date = dob;
		
	}
	
	/**Returns a List of the Patient's full name. 
	 * @return String[] List of Patient's full name. 
	 */

	public String[] getName() {
		return name;
	}
	
	/**Returns the date of birth of the Patient. 
	 * @return String Patient's date of birth. 
	 */
	
	public String getDateOfBirth(){
		return birth_date;
	}
	
	/**Returns Patient's health_card_number. 
	 * @return String Patient's health card number. 
	 */
	
	public String getHealthCardNumber(){
		return health_card_num;
	}
	
	/**Returns Patient's arrival time at the Emergency Room. 
	 * @return String Patient's arrival time. 
	 */
	
	public String getArrivalTime(){
		return arrival_time;
	}
	
	/**Returns string representation of Patient. 
	 * @return String String representation of the Patient containing Full name, Date of Birth
	 * and Health Card Number. 
	 */
	
	public String toString(){
		String t = ""; 
		String s = "";
		for(int i = 1; i < name.length; i++){
			t += name[i] + " "; 
			s = "Patient:" + t.trim() + "," + name[0] + "\nDate of birth:" + birth_date + "\nHealth Card Number:" + health_card_num;
		}
		return s;
	}
}