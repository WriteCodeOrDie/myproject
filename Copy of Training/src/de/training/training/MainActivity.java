package de.training.training;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Menu_Navigation_left {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);	
		ViewGroup vg = (ViewGroup) findViewById(R.layout.menu_nav_left);

		LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View contentView = inflator.inflate(R.layout.activity_main,vg, false);
		
		DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
		drawer.addView(contentView, 0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onButtonClick(View view) {
		
		switch(view.getId()) {
		case R.id.btnDateizugriff:
			startActivity(new Intent(this, Dateisystem.class));
			 break;
		case R.id.btnReadContact:
			startActivity(new Intent(this, ContentProvider.class));
			break;
		case R.id.btnReadSim:
			startActivity(new Intent(this, SimProvider.class));
			break;
		case R.id.btnAddSim:
			startActivity(new Intent(this, SimProvider_Add.class));
			break;
		case R.id.btnMenu:
			startActivity(new Intent(this, Menu_Navigation_left.class));
			break;
		}
	}

}
