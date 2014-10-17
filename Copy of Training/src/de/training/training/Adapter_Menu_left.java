package de.training.training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class Adapter_Menu_left extends BaseAdapter {
	Context context;
	String[] menu_arr;
	int[] image = {R.drawable.ic_menu_emoticons,R.drawable.ic_menu_save, R.drawable.ic_menu_info_details};
	
	public Adapter_Menu_left(Context context){
		this.context = context;
		menu_arr = context.getResources().getStringArray(R.array.menu);
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menu_arr.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return menu_arr[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row= null;
		if (convertView == null) {
			LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflator.inflate(R.layout.menu_nav_single_row, parent, false);
			
		} else {
			row=convertView;
		}
		TextView titleTextview = (TextView) row.findViewById(R.id.textView1);
		ImageView titleImageview = (ImageView) row.findViewById(R.id.imageView1);
		
		titleTextview.setText(menu_arr[position]);
		titleImageview.setImageResource(image[position]);
		
		return row;
	}
	
	
	
}
