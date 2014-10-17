package de.training.training;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter<String> {

	Context context;
	int[] images;
	List<String> titlearray;
	List<String> descarray;
	int resource;
	int imageview;
	int textview1;
	int textview2;
	
 	public CustomAdapter(Context context, int resource_layout,int textview1, int textview2, int imageview, List<String> titles, int imgs[], List<String> desc) {
		super(context, resource_layout, R.id.textView1, titles);
//		super(context, resource_layout);
		this.context = context;
		this.images = imgs;
		this.titlearray = titles;
		this.descarray = desc;
		this.resource = resource_layout;
		this.textview1 = textview1;
		this.textview2 = textview2;
		this.imageview = imageview;
		
	}
 	
@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		View row = convertView;
		ViewHolder vh = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(resource, parent, false);
			vh = new ViewHolder(row, imageview, textview1, textview2);
			row.setTag(vh);
		} else {
			
			vh = (ViewHolder) row.getTag();
		}
		
		String[] title = titlearray.toArray(new String[titlearray.size()]);
		String[] desc = descarray.toArray(new String[descarray.size()]);
		
		vh.getMyImage().setImageResource(images[position]);
		vh.getMyTextview1().setText(title[position]);
		vh.getMyTextview2().setText(desc[position]);

//		ImageView myImage = (ImageView) row.findViewById(imageview);
//		TextView myTitle = (TextView) row.findViewById(textview1);
//		TextView myDesc = (TextView) row.findViewById(textview2);
//		myImage.setImageResource(images[position]);
//		myTitle.setText(title[position]);
//		myDesc.setText(desc[position]);
		
		return row;
	}

}
