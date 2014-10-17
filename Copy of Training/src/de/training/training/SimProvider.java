package de.training.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SimProvider extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sim_provider);
		simladen();
	
	}

	private void simladen() {
		final HashMap<String, String> hm = new HashMap<>();
		final ListView lv = getListView();
		Uri simUri = Uri.parse("content://icc/adn");

		Cursor simCursor = getContentResolver().query(
				simUri, // z.B. content://de.training.training.provider......
				null, null, null, null);

		while (simCursor.moveToNext()) {

			String number = simCursor.getString(simCursor.getColumnIndex("number"));
			String name = simCursor.getString(simCursor.getColumnIndex("name"));
			
			if (name.length() == 0) {
				
				name = getString(R.string.empty_sim_contact_name);
			}
			
			if (number.length() == 0) {
				
				number = getString(R.string.empty_sim_contact_phone_number);
			}

			hm.put(name, number);
		}

		List<String> arr_names = new ArrayList<String>(hm.keySet());
		List<String> arr_numbers = new ArrayList<String>();
		
		int[] images = new int[simCursor.getCount()];
		for (int i = 0; i < simCursor.getCount(); i++) {
			images[i] = R.drawable.ic_action_person;
		}

		simCursor.close();
		
		Collections.sort(arr_names, String.CASE_INSENSITIVE_ORDER);
		
		for (String n : arr_names) {
			for (String s : hm.keySet()) {
				if (n.equals(s)) {
					arr_numbers.add(hm.get(s));
				}
			}
		}
		
		CustomAdapter adapter = new CustomAdapter(this,R.layout.single_row,R.id.textView1,R.id.textView2,R.id.imageView1,arr_names, images, arr_numbers);

//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, arr_names);

		setListAdapter(adapter);


		lv.setOnItemClickListener(new OnItemClickListener() {
			

			
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent in = new Intent(getApplicationContext(),
						SimProvider_Details.class);
				String detail_name = lv.getItemAtPosition(position).toString();
				in.putExtra("DETAIL_NUMBER", hm.get(detail_name));
				in.putExtra("DETAIL_NAME", detail_name);
				startActivity(in);

			}
		});

	}

}
