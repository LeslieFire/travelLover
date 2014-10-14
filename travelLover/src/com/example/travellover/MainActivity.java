package com.example.travellover;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnPageChangeListener {
	
	ViewPager mvp;
    ImageView []images;
    ImageView iv;
    LinearLayout ll;
    ViewGroup vg;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ArrayList<View> aViews=new ArrayList<View>();
        LayoutInflater lf=LayoutInflater.from(this);
        vg=(ViewGroup) lf.inflate(R.layout.welcome_activity, null);
        View v1=lf.inflate(R.layout.welcome_first, null);
        View v2=lf.inflate(R.layout.welcome_second, null);
        View v3=lf.inflate(R.layout.welcome_third, null);
        aViews.add(v1);
        aViews.add(v2);
        aViews.add(v3);
        mvp=(ViewPager) vg.findViewById(R.id.welcomeViewPager);
        ll=(LinearLayout) vg.findViewById(R.id.welcomeImageGroup);
        
        
        images=new ImageView[aViews.size()];
        for(int i=0;i<images.length;i++)
        {
            iv=new ImageView(this);
            iv.setLayoutParams(new LayoutParams(20,20));
            iv.setPadding(20, 0, 20, 0);
            if(i==0)
            {
                iv.setBackgroundResource(R.drawable.guide_dot_white);
            }
            else
            {
                iv.setBackgroundResource(R.drawable.guide_dot_black);
            }
            images[i]=iv;
            ll.addView(images[i]);
        }
        
        PagerAdapter pa=new PagerAdapter(){
        	
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return aViews.size();
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                // TODO Auto-generated method stub
                ((ViewPager)container).removeView(aViews.get(position));
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
                ((ViewPager)arg0).addView(aViews.get(arg1),0);
                return aViews.get(arg1);
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
        setContentView(vg);
        mvp.setAdapter(pa);
        mvp.setOnPageChangeListener(this);
        /*Button enterBtn = (Button)findViewById(R.id.welcomeEnterButton);
		enterBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "欢迎使用", Toast.LENGTH_SHORT).show();
			}
			
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
		for(int i=0;i<images.length;i++)
        {
            if(i==arg0)
            {
                images[i].setBackgroundResource(R.drawable.guide_dot_white);
            }
            else
            {
                images[i].setBackgroundResource(R.drawable.guide_dot_black);
            }
        }
		if(arg0 == 2) {
			Button enterBtn = (Button)findViewById(R.id.welcomeEnterButton);
			enterBtn.setOnClickListener(new Button.OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "欢迎使用", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, LoginMainActivity.class);
					startActivity(intent);
					finish();
				}
				
			});
		}
	}

}
