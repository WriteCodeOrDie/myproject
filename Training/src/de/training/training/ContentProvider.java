package de.training.training;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.SimpleCursorAdapter;

public class ContentProvider extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_provider);
		kontakteladen();
	}
	
	
	@SuppressWarnings("deprecation")
	private void kontakteladen(){
		
		
		Cursor kontaktCursor = getContentResolver().query(
				Contacts.CONTENT_URI, // z.B. content://de.training.training.provider...... 
				new String[] {Contacts._ID, Contacts.DISPLAY_NAME}, 
				null, 
				null, 
				Contacts.DISPLAY_NAME);
		
		startManagingCursor(kontaktCursor);
		SimpleCursorAdapter kontaktAdapter = 
				new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, kontaktCursor, new String[] {Contacts.DISPLAY_NAME}, new int[] {android.R.id.text1});
		
		setListAdapter(kontaktAdapter);
		
		
	}

}
