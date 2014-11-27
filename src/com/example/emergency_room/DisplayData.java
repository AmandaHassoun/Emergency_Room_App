package com.example.emergency_room;

import android.os.Bundle;
import com.example.emergency_room.Patient;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayData extends Activity{
	
	//private EditText input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_data);

		Intent intent = getIntent();
		Patient p = (Patient) intent.getSerializableExtra("Patient");
		TextView patient_data = (TextView) findViewById(R.id.retrieved_data);
		patient_data.setText(p.toString());
		
		
		Button next = (Button) findViewById(R.id.new_visit_record);
		Button next1 = (Button) findViewById(R.id.view_record_history);
		
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent Intent = new Intent(getBaseContext(), VitalSignsDisplay.class);
				startActivity(Intent);
				
			}
		});
	
		next1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent Intent = new Intent(getBaseContext(), DisplayVisitRecord.class);
				startActivity(Intent);

		};
		});
	}
}

