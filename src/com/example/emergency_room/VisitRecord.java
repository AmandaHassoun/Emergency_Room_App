package com.example.emergency_room;

import java.io.Serializable;

import com.example.emergency_room.Nurse;

public class VisitRecord implements Serializable{
	
	/**Constructs Visit Record used to store patient vital signs. 
	 */
	
	private static final long serialVersionUID = 1L;
	private String health_card_number;
	private String temperature;
	private String heart_rate;
	private String blood_pressure;
	private String age;

	/**Constructs Visit Record with a health_card_number, a temperature, a heart_rate,
	 * and a blood_pressure.
	 * @param String Health card number of the patient.
	 * @param String Temperature of the patient. 
	 * @param String Heart Rate of the patient. 
	 * @param String Blood pressure of the Patient. 
	 */
	
	public VisitRecord(String health_card_number, String temp,
			String heart_rate, String blood_pressure){
		this.health_card_number = health_card_number;
		this.temperature= temp;
		this.heart_rate= heart_rate;
		this.blood_pressure= blood_pressure;
	}
	
	/**Returns Health Card Number corresponding to the Visit Record.
	 * @return String Health Card number. 
	*/
	
	public String getHealthCardNumberFromVisitRecord(){
		return health_card_number;
	}
	
	/**Returns Temperature of the Patient.
	 * @return String Temperature. 
	*/
	
	public String getTemp(){
		return temperature;
	}
	
	/**Returns Heart Rate of the Patient.
	 * @return String Heart Rate. 
	*/
	
	public String getHeartRate(){
		return heart_rate;
	}
	
	/**Returns Blood Pressure of the Patient.
	 * @return String Blood Pressure. 
	*/
	
	public String getBloodPressure(){
		return blood_pressure;
	}
	
	public String getAge(){
		return age;
	}
	
	/**Returns String representation of the Visit Record of the Patient.
	 * @return String 
	*/

	public String toString(){
		return "Health Card Number :" + " " + health_card_number + ",  " + "Date :" + " " + Nurse.getDate() +
				",  " + "Arrival Time :" + " " + Nurse.getTime() + ",  " + "Temperature :" + " " + temperature + ",  " + 
				"Heart Rate :" + " " + heart_rate + Nurse.getBloodPressureType(blood_pressure);
	}
	
}
