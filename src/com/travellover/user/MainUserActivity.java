package com.travellover.user;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainUserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_user);
		Button publishBtn = (Button)findViewById(R.id.mainUserLinePublishBtn);
		publishBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainUserActivity.this, LinePublishActivity.class);
				startActivity(intent);
			}
			
		});
		ImageButton personalBtn = (ImageButton)findViewById(R.id.mainUserPersonalBtn);
		personalBtn.setOnClickListener(new ImageButton.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		ImageButton settingBtn = (ImageButton)findViewById(R.id.mainUserSettingBtn);
		settingBtn.setOnClickListener(new ImageButton.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainUserActivity.this, UserSettingActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
