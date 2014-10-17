package de.training.training;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	
	public ImageView myImage;
	public TextView myTextview1;
	public TextView myTextview2;
	
	public ImageView getMyImage() {
		return myImage;
	}

	public void setMyImage(ImageView myImage) {
		this.myImage = myImage;
	}

	public TextView getMyTextview1() {
		return myTextview1;
	}

	public void setMyTextview1(TextView myTextview1) {
		this.myTextview1 = myTextview1;
	}

	public TextView getMyTextview2() {
		return myTextview2;
	}

	public void setMyTextview2(TextView myTextview2) {
		this.myTextview2 = myTextview2;
	}

	public ViewHolder(View v, int image, int textview1, int textview2) {
		
		setMyImage((ImageView)v.findViewById(image));
		setMyTextview1((TextView)v.findViewById(textview1));
		setMyTextview2((TextView)v.findViewById(textview2));
		
	}

}
