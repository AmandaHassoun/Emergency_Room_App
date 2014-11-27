package com.example.emergency_room;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import android.os.Bundle;
import com.example.emergency_room.Nurse;
import com.example.emergency_room.VisitRecord;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VitalSignsDisplay extends Activity {
	
	private EditText temp_text;
	private EditText heart_rate_text;
	private EditText blood_pressure_text;
	private Nurse nurse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vital_signs_display);
		//Intent intent = getIntent(); 
		
		try{
			nurse = new Nurse(this);
			nurse.setHealthCardNumberAsKey();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		temp_text = (EditText) findViewById(R.id.temp_value);
		heart_rate_text = (EditText) findViewById(R.id.heart_rate_value);
		blood_pressure_text = (EditText) findViewById(R.id.blood_pressure_value);
		
		
		Button next = (Button) findViewById(R.id.save_vitals);
		next.setOnClickListener(new OnClickListener(){
	
		@Override  
			public void onClick(View v){
			String hcn = MainActivity.getInput().getText().toString();
			String temp = temp_text.getText().toString();
			String hr = heart_rate_text.getText().toString();
			String b = blood_pressure_text.getText().toString();
				
			try {
				VisitRecord visit_record = new VisitRecord(hcn,temp,hr,b);
				FileOutputStream fou = openFileOutput(hcn, MODE_APPEND);
				OutputStreamWriter osw = new OutputStreamWriter(fou);
				try{
					osw.append(visit_record.toString());
					osw.close();
					Toast.makeText(getBaseContext(), "Patient Visit Record has been saved", Toast.LENGTH_LONG).show();
				} catch (IOException e){
					e.printStackTrace();
				}
					
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finish();
		}

	});

	}}