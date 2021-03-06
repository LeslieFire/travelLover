package com.travellover.register;

import com.example.travellover.R;
import com.travellover.user.MainUserActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginUserActivity extends Activity {

	private EditText usernameText;
	private EditText passwordText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_without_username);
		usernameText = (EditText)findViewById(R.id.loginWithoutUsernameName);
		passwordText = (EditText)findViewById(R.id.loginWithoutUsernamePassword);
		Button loginBtn = (Button)findViewById(R.id.loginWithoutUsernameLoginBtn);
		loginBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username = usernameText.getText().toString();
				String password = passwordText.getText().toString();
				if(!username.equals("") && !password.equals("")) {
					SharedPreferences mySharedPreferences= getSharedPreferences("information",Activity.MODE_PRIVATE);
					SharedPreferences.Editor editor = mySharedPreferences.edit();
					editor.putString("username", username);
					editor.putString("password", password);
					editor.putString("status", "0");
					editor.commit();
					Intent intent = new Intent();
					intent.setClass(LoginUserActivity.this, MainUserActivity.class);
					startActivity(intent);
				}
				else {
					Toast.makeText(LoginUserActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
				}
			}
			
		});
	}

}
