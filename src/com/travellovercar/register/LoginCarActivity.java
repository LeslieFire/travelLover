package com.travellovercar.register;

import com.example.travellover.R;
import com.example.travellover.R.layout;
import com.example.travellover.R.menu;
import com.travellover.register.LoginUserActivity;
import com.travellover.user.MainDriverActivity;
import com.travellover.user.MainUserActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginCarActivity extends Activity {

	private EditText driverName;
	private EditText driverPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_car);
		Button ownerloginBtn=(Button)findViewById(R.id.ownerloginbutton);
		driverName = (EditText)findViewById(R.id.ownerloginname);
		driverPassword = (EditText)findViewById(R.id.ownerloginpassword);
		ownerloginBtn.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//密码验证
				String username = driverName.getText().toString();
				String password = driverPassword.getText().toString();
				if(!username.equals("") && !password.equals("")) {
					SharedPreferences mySharedPreferences= getSharedPreferences("information",Activity.MODE_PRIVATE);
					SharedPreferences.Editor editor = mySharedPreferences.edit();
					editor.putString("username", username);
					editor.putString("password", password);
					editor.putString("status", "1");
					editor.commit();
					Intent intent = new Intent();
					intent.setClass(LoginCarActivity.this, MainDriverActivity.class);
					startActivity(intent);
				}
				else {
					Toast.makeText(LoginCarActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
				}
			}
			
		});
	}

}
