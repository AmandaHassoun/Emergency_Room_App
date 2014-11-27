package com.example.emergency_room;


import com.example.emergency_room.VisitRecord;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

	/**
	 * A representation of a Nurse. The Nurse stores Patient's 
	 * visit records and can view their history.  
	 */
	public class Nurse extends Activity implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		public static TreeMap<String, ArrayList<VisitRecord>> records;
		public static ArrayList<VisitRecord> records_list ;
		
		 
		public Nurse(Context c) throws IOException { 
			Nurse.records_list = new ArrayList<VisitRecord>();
			Nurse.records = new TreeMap<String, ArrayList<VisitRecord>>();
		}
			  
		
		/**
		 * Returns an ArrayList of Visit Records belonging to the Patient with the corresponding 
		 * health_card_num. 
		 * @param String Health Card Number of the Patient.
		 * @return ArrayList<VisitRecord> An ArrayList of all Visit Records of Patient with @param
		 * Health Card Number.
		 */
		
		public ArrayList<VisitRecord> getPatientVisitRecord(String health_card_num) {
			return records.get(health_card_num);
		}

		/**
		 * Returns an ArrayList containing all Visit Record objects retrieved from
		 * storevitals.txt.
		 * @return ArrayList<VisitRecord> An ArrayList of Visit Record objects. 
		 */
		
		public ArrayList<VisitRecord> getRecords(){
			return records_list;
		}
		
		/**
		 * Sets key values of the Nurse TreeMap to the health_card_num of each Patient from 
		 * patient_records.txt and the corresponding values an ArrayList of all their Visit
		 * Records. 
		 * @param String The Patient's Health Card Number.
		 * @return String A String representation of the Patient's visits. 
		 */
		
		public String getPatientVisitRecords(String health_card_num){
			ArrayList<VisitRecord> records = this.getPatientVisitRecord(health_card_num);
			String list_records = "";
		for(VisitRecord r:records){
			list_records += r.toString() + "\r\n";
		}
		return list_records;
		}
		
		/**
		 * Sets key values of the Nurse TreeMap to the health_card_num of each Patient from 
		 * patient_records.txt and the corresponding values an ArrayList of all their Visit
		 * Records. 
		 */
		
		public void setHealthCardNumberAsKey() {  
			Iterator<VisitRecord> it = records_list.iterator();
			while(it.hasNext())
			{
				VisitRecord visit = it.next();
				String hcn = visit.getHealthCardNumberFromVisitRecord();
				ArrayList<VisitRecord> set_of_records = new ArrayList<VisitRecord>();
			    if(!records.keySet().contains(hcn)){
			    	set_of_records.add(new VisitRecord(visit.getHealthCardNumberFromVisitRecord(), 
							visit.getTemp(), visit.getHeartRate(), visit.getBloodPressure()));
			    	records.put(visit.getHealthCardNumberFromVisitRecord(), set_of_records);
			    }else{
			    	records.get(hcn).add(new VisitRecord(visit.getHealthCardNumberFromVisitRecord(), 
							visit.getTemp(), visit.getHeartRate(), visit.getBloodPressure()));
			    	}
			    	
			    }
		}

		/**
		 * Returns a string representation of the date to be used as the
		 * filename of the patient's Emergency Room visit.
		 * @return a string representation of the date.
		 */
		
		@SuppressLint("DefaultLocale")
		public static String getDate(){
			Date date = new Date();
			String temp = String.format("%tD", date);
			String fileName = temp;
			System.out.println(fileName);
			return fileName;
			
		}
		
		/**
		 * Returns a string representation of the time to be called automatically
		 * when the Nurse creates or updates a Patient's visit text file.
		 * @return a string representation of the time.
		 */
		
		@SuppressLint("SimpleDateFormat")
		public static String getTime(){
			Date rawTime = new Date();
			SimpleDateFormat timeformat = 
					new SimpleDateFormat ("hh:mm a");
			String formatedTime = timeformat.format(rawTime);
			return formatedTime;
		}
		
		/**Determines blood pressure. 
		 * @param healthCardNum a Patient's health card number.
		 * @param temperature the Patient's current body temperature.
		 * @param heartRate the Patient's current heart rate.
		 * @param bloodPressure the Patient's current blood pressure.
		 */
		
		public static String getBloodPressureType(String blood_pressure) {
			double value = Double.parseDouble(blood_pressure);
			String blood_press;
			if ( value >= 140.0) {
				blood_press = ",  " + "Systolic :" + " " + blood_pressure + "\r\n";
			} else {
				blood_press = ",  " + "Diastolic :" + " " + blood_pressure + "\r\n";
			} return blood_press;
		}
		
		
			
}