package com.travellover.register;

import com.example.travellover.R;
import com.travellover.user.MainUserActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginWithNameActivity extends Activity {

	private EditText passwordText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main_withname);
		passwordText = (EditText)findViewById(R.id.loginWithUsernamePassword);
		Button loginBtn = (Button)findViewById(R.id.loginWithNameBtn);
		loginBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String password = passwordText.getText().toString();
				if(!password.equals("")) {
					SharedPreferences mySharedPreferences= getSharedPreferences("information",Activity.MODE_PRIVATE);
					SharedPreferences.Editor editor = mySharedPreferences.edit();
					editor.putString("password", password);
					editor.commit();
					Intent intent = new Intent();
					intent.setClass(LoginWithNameActivity.this, MainUserActivity.class);
					startActivity(intent);
					finish();
				}
			}
			
		});
	}

}
