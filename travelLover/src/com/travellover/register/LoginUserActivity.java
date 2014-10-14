package com.travellover.register;

import com.example.travellover.R;
import com.travellover.user.MainUserActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginUserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_without_username);
		Button loginBtn = (Button)findViewById(R.id.loginWithoutUsernameLoginBtn);
		loginBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginUserActivity.this, MainUserActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
