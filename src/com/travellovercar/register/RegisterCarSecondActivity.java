package com.travellovercar.register;

import com.example.travellover.R;
import com.example.travellover.R.layout;
import com.example.travellover.R.menu;
import com.travellover.user.MainDriverActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterCarSecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_car_second);
		Button backBtn=(Button)findViewById(R.id.registercarBackBtn);
		backBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(RegisterCarSecondActivity.this, RegisterCarFirstActivity.class);
				finish();
			}
			
		});
		Button RegistercarBtn=(Button)findViewById(R.id.registercarbutton);
		RegistercarBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		    String username=((EditText)findViewById(R.id.registercarloginname)).getText().toString();
		    String password=((EditText)findViewById(R.id.registercarpassword)).getText().toString();
		    String passwordcheck=((EditText)findViewById(R.id.passworddoublecheck)).getText().toString();
		    if(username.length()>0&&password.length()>0&&password.equals(passwordcheck))
		    {
			    SharedPreferences mySharedPreferences= getSharedPreferences("information",Activity.MODE_PRIVATE);
				SharedPreferences.Editor editor = mySharedPreferences.edit();
				editor.putString("username", username);
				editor.putString("password", password);
				editor.putString("status", "1");
				editor.commit();
				Intent intent = new Intent();
				intent.setClass(RegisterCarSecondActivity.this, MainDriverActivity.class);
				startActivity(intent);
		    }
		    else if(username.length()<=0)
		    {
		    	Toast.makeText(RegisterCarSecondActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
		    }
		    else if(password.length()<=0)
		    {
		    	Toast.makeText(RegisterCarSecondActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
		    }
		    else if(!password.equals(passwordcheck))
		    {
		    	Toast.makeText(RegisterCarSecondActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
		    }
			}
			
		});
	}

}
