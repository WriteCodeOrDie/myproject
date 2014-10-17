package de.training.training;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SimProvider_Details extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sim_detail);
		setTitle("Sim Details");
		
		final Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
			
			TextView txtDetail_number = (TextView) findViewById(R.id.tv_detail_number);
			txtDetail_number.setText(extras.getString("DETAIL_NUMBER"));
			
			TextView txtDetail_name = (TextView) findViewById(R.id.tv_detail_name);
			txtDetail_name.setText(extras.getString("DETAIL_NAME"));
			
		}
		
	}

}
