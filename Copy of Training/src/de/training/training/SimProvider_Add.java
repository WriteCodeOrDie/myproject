package de.training.training;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SimProvider_Add extends Activity {
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sim_new);
	}
	

	public  void insertSim() {
		
		
		EditText mNumber = (EditText)findViewById(R.id.etNumber);
		EditText mName = (EditText)findViewById(R.id.etName);
//		mNumber.setText("");
//		mName.setText("");
		
		if (mNumber.length() != 0 && mName.length() != 0) { 
		Uri simUri = Uri.parse("content://icc/adn");
		
		ContentValues values = new ContentValues();
		values.put("number", mNumber.getText().toString());
		values.put("tag", mName.getText().toString());
		
		getContentResolver().insert(simUri, values);
		
		Toast.makeText(getApplicationContext(), "Sim Kontakt wurde hinzugefügt", Toast.LENGTH_SHORT).show();
		
		} else {
			Toast.makeText(getApplicationContext(), "Bitte füllen Sie beide Felder aus", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public void onButtonClick(View view){
		switch(view.getId()) {
		
		case R.id.btnAddContact:
			insertSim();
			break;
		case R.id.btnCancel:
			 finish();
			 break;
		}
		
		
	}
	
	
	

}
