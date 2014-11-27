package com.example.emergency_room;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import android.content.Context;
import android.content.res.AssetManager;

public class ER implements Serializable{
	
	/**Database containing all Patient objects in patient_records.txt.
	 */
	
	private static final long serialVersionUID = 1L;
	
	public static TreeMap<String, Patient> patients;
	public ArrayList<Patient> n;
	
	/**
	 * The Emergency Room constructor instantiates an ArrayList, which will be
	 * used to store Patient objects and a TreeMap patients which will map Patient 
	 * objects to String keys corresponding to the Patient's personal data.
	 * @param Context Retrieves patient_records.txt file from assets folder in MainActivity.java.
	 */
	 
	public ER(Context c) throws IOException { 
		this.n = new ArrayList<Patient>();
		ER.patients = new TreeMap<String, Patient>();
		this.populate(c); 
	}
	
	/**
	 * Populates the ArrayList n with all Patient objects created from patient_records.txt. 
	 * @param Context Retrieves patient_records.txt file from assets folder in MainActivity.java.
	 */
	
	private void populate(Context c) throws IOException { 
		AssetManager am = c.getAssets();
		Scanner scanner = new Scanner(am.open("patient_records.txt")); 
		String[] record;
		while(scanner.hasNextLine()) {
			record = scanner.nextLine().split(",");
			String health_card_num = record[0];
			String[] name = record[1].split(" ");
			String dob = record[2];
			n.add(new Patient(health_card_num, name, dob));
		}
	scanner.close();
	}
	
	/**
	 * Returns Patient with the corresponding health_card_num. 
	 * @param String Health Card Number of the Patient.
	 * @return Patient The Patient object with the corresponding @param.
	 */
	public Patient getPatientPersonalData(String health_card_num) {
		return patients.get(health_card_num);
	}

	/**
	 * Returns an ArrayList containing all Patient objects in patient_records.txt.
	 * @return ArrayList<Patient> An ArrayList of Patient objects. 
	 */
	
	public ArrayList<Patient> getPatients(){
		return n;
	}
	
	/**
	 * Sets key values of the ER TreeMap to the health_card_num of each Patient from 
	 * patient_records.txt and the corresponding values the Patient object itself. 
	 */
	
	public void setHealthCardNumberAsKey() {  
		for(Patient p: n){
		patients.put(p.getHealthCardNumber(), new Patient(p.getHealthCardNumber(), 
				p.getName(), p.getDateOfBirth()));
		}
	}

}