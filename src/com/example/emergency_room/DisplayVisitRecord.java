package com.example.emergency_room;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.example.emergency_room.VisitRecord;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayVisitRecord extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_visit_record);
		
		TextView patient_history;
		String records_list= "";
		
		String hcn = MainActivity.getInput().getText().toString();
		patient_history= (TextView) findViewById(R.id.record_history);
		
		try {
	    	 InputStream is = openFileInput(hcn);
	    	 InputStreamReader inputreader = new InputStreamReader(is);
	    	 BufferedReader buffreader = new BufferedReader(inputreader);
	         String line = buffreader.readLine();
	            while (line!=null) {
	            	String[] record = line.split(",");
			   		String[] health_card_list = record[0].split(":");
			   		String health_card_num = health_card_list[1];
			   		String[] temp_list = record[3].split(":");
			   		String temp = temp_list[1];
			   		String[] heart_rate_list = record[4].split(":");
			   		String heart_rate = heart_rate_list[1];
			   		String[] blood_pressure_list = record[5].split(":");
			   		String blood_pressure = blood_pressure_list[1];
			   		VisitRecord r = new VisitRecord(health_card_num, temp, heart_rate, blood_pressure);
			   		records_list += r.toString() + "\n";
			   		line = buffreader.readLine();
					}
	            buffreader.close();
	     }catch (IOException e) {
	    	 Toast.makeText(getApplicationContext(),"Patient has no record history." ,Toast.LENGTH_LONG).show();
	     }
		patient_history.setText(records_list);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_visit_record, menu);
		return true;
	}

}
