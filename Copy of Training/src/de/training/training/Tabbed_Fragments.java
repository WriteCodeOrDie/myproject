package de.training.training;

import java.util.Locale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tabbed_Fragments extends Fragment {
	
	public static final String TAG = Tabbed_Fragments.class.getSimpleName();
	
	public static Tabbed_Fragments newinstance() {
		return new Tabbed_Fragments();
	}

	ViewPager viewPager = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	
	
		@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

			View v = inflater.inflate(R.layout.fragmenttest_main, container, false);
//			setContentView(R.layout.fragmenttest_main);
			viewPager = (ViewPager) v.findViewById(R.id.pager);
			FragmentManager fragmentManager =  getChildFragmentManager();
			viewPager.setAdapter(new CustomFragmentAdaper(fragmentManager));
			
			return v;
			
	}
		
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
		
		
		@Override
		public CharSequence getPageTitle(int position) {
//			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return "Fragment1";
			case 1:
				return "Fragment2";
			case 2:
				return "Fragment3";
			}
			return null;
		}
		
		
	}
	


