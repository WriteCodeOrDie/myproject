package de.training.training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Dateisystem extends Activity {
	
	private EditText mTextEingabe;
	private final String DATEINAME = "test.txt";
	private final String VERZEICHNISNAME = "testdir";
	private File verzeichnis;
	private File datei;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.dateisystem);
		
		mTextEingabe = (EditText) findViewById(R.id.etName);
		
		verzeichnis = getDir(VERZEICHNISNAME, MODE_PRIVATE);
		datei = new File(verzeichnis, DATEINAME);
		
	}
	
	public void onButtonClick(View view) {
		
		switch(view.getId()){
		case R.id.btnLaden:
			//todo
			break;
		case R.id.btnSpeichern:
			try {
				FileOutputStream fileOut = new FileOutputStream(datei);
				dateiSpeichern(fileOut);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		
		}
		
	}

	private void dateiSpeichern(FileOutputStream fileOut) {
		OutputStreamWriter write = new OutputStreamWriter(fileOut);
		String text = mTextEingabe.getText().toString();
		
		try {
			write.write(text);
			Toast.makeText(this, "Die Eingabe wurde erfolgreich abgespeichert.", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			
		}
		
	}



}
