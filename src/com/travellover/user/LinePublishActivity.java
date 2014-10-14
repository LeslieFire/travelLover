package com.travellover.user;

import java.util.ArrayList;
import java.util.List;

import com.example.travellover.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LinePublishActivity extends Activity implements OnPageChangeListener {

	private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private TextView t1, t2;// 页卡头标
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line_publish);
		
		mPager = (ViewPager) findViewById(R.id.vPager);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        listViews.add(mInflater.inflate(R.layout.linepublish_close, null));
        listViews.add(mInflater.inflate(R.layout.linepublish_far, null));
        
        PagerAdapter pa=new PagerAdapter(){
        	
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return listViews.size();
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                // TODO Auto-generated method stub
                ((ViewPager)container).removeView(listViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0==arg1;
            }

            @Override
            public void finishUpdate(View arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public Object instantiateItem(View arg0, int arg1) {
                // TODO Auto-generated method stub
                ((ViewPager)arg0).addView(listViews.get(arg1),0);
                return listViews.get(arg1);
            }

            @Override
            public void restoreState(Parcelable arg0, ClassLoader arg1) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public Parcelable saveState() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void startUpdate(View arg0) {
                // TODO Auto-generated method stub
                
            }
        };
        
        mPager.setAdapter(pa);
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
