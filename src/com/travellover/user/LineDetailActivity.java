package com.travellover.user;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LineDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line_detail_show);
		Button backBtn = (Button)findViewById(R.id.lineDetailBackBtn);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		ImageView lineDetailHeadshot = (ImageView)findViewById(R.id.lineDetailHeadshot);
		lineDetailHeadshot.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LineDetailActivity.this, TravelerDetailActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
