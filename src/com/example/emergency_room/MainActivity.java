package com.example.emergency_room;
import java.io.IOException;


import com.example.emergency_room.ER;
import com.example.emergency_room.Patient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity{
	
	private ER p;
	private static EditText input;
		
	
		@Override
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
				
			try{
				p = new ER(this);
				p.setHealthCardNumberAsKey();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
			
			Button next = (Button) findViewById(R.id.button1);
			next.setOnClickListener(new OnClickListener(){
				
				@Override 
				public void onClick(View v){
					
				setInput((EditText) findViewById(R.id.health_card_number_field));
				if(!ER.patients.keySet().contains(getInput().getText().toString())){
					getInput().setError("Invalid Health Card Number");
				}else{

				Patient n = p.getPatientPersonalData(getInput().getText().toString());
				Intent myIntent = new Intent(getBaseContext(), DisplayData.class);
				myIntent.putExtra("Patient", n);
				startActivity(myIntent);
				}
				}					   		

				
				});
			
		}


		public static EditText getInput() {
			return input;
		}


		public void setInput(EditText input) {
			MainActivity.input = input;
		}
}
	
			
	



