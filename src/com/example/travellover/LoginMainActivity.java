package com.example.travellover;

import com.travellover.register.RegisterUserFirstActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		Button userBtn = (Button)findViewById(R.id.loginUserBtn);
		userBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginMainActivity.this, RegisterUserFirstActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
