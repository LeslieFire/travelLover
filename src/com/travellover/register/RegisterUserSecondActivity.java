package com.travellover.register;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterUserSecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_user_second);
		Button backBtn = (Button)findViewById(R.id.userRegisterSecondBackBtn);
		backBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		Button enterBtn = (Button)findViewById(R.id.userRegisterSecondFinishBtn);
		enterBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(RegisterUserSecondActivity.this, LoginUserActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
