package de.training.training;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

public class FragmentTest extends Menu_Navigation_left {

	ViewPager viewPager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.fragmenttest_main);
		viewPager = (ViewPager) findViewById(R.id.pager);
		FragmentManager fragmentManager =  getSupportFragmentManager();
		viewPager.setAdapter(new CustomFragmentAdaper(fragmentManager));

		
//		ViewGroup vg = (ViewGroup) findViewById(R.layout.menu_nav_left);
//		LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		View contentView = inflator.inflate(R.layout.fragmenttest_main,null, false);
//		DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
//		drawer.addView(contentView, 0);
//		drawerLayout.addView(contentView,0);
		
		
	}
	
class CustomFragmentAdaper extends FragmentPagerAdapter {

		public CustomFragmentAdaper(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int i) {
			Fragment fragment = null;
			
			if (i == 0) {
				fragment = new Fragment1();
			}
			if (i == 1) {
				fragment = new Fragment2();
			}
			if (i == 2) {
				fragment = new Fragment3();
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return 3;
		}
		
		
	}
	

}
