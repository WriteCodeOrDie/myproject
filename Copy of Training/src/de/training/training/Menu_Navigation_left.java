package de.training.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public abstract class Menu_Navigation_left extends ActionBarActivity implements OnItemClickListener {
	
	protected DrawerLayout drawerLayout;
	private ListView listview;
	private ActionBarDrawerToggle drawerListener;
	private Adapter_Menu_left myAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.menu_nav_left);
		drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);

		listview=(ListView) findViewById(R.id.drawelist);
//		listview.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu_array));
		myAdapter = new Adapter_Menu_left(this);
		listview.setAdapter(myAdapter);
		
		drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.menu_open, R.string.menu_closed) {
			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
			}
			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
			}
			
			
		};
		drawerLayout.setDrawerListener(drawerListener);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		listview.setOnItemClickListener(this);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (drawerListener.onOptionsItemSelected(item)){
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		drawerLayout.closeDrawers();
		
		
		switch (position) {
		
		case 0: // Hauptmenü
			startActivity(new Intent(this, MainActivity.class));
//			selectItem(position);
//			setTitle(menu_names);
			break;
			
		}
		
	}

//	private void selectItem(int position) {
//		listview.setItemChecked(position, true);
//	}
//	
//	private void setTitle (String title) {
//		getSupportActionBar().setTitle(title);
//	}

}


