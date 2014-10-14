package com.travellover.register;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterUserFirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_user_first);
		Button nextBtn = (Button)findViewById(R.id.userRegisterFirstNextBtn);
		nextBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(RegisterUserFirstActivity.this, RegisterUserSecondActivity.class);
				startActivity(intent);
			}
			
		});
		
		Button loginBtn = (Button)findViewById(R.id.userRegisterFirstLoginBtn);
		loginBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(RegisterUserFirstActivity.this, LoginUserActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
