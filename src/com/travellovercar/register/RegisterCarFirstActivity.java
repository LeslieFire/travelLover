package com.travellovercar.register;

import com.example.travellover.ContactListActivity;
import com.example.travellover.R;
import com.example.travellover.R.layout;
import com.example.travellover.R.menu;
import com.example.travellover.MainTabActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterCarFirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_car_first);
		Button nextBtn=(Button)findViewById(R.id.carRegisterFirstNextBtn);
		Button loginBtn=(Button)findViewById(R.id.carRegisterFirstLoginBtn);
		
		nextBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(RegisterCarFirstActivity.this, RegisterCarSecondActivity.class);
				startActivity(intent);
			}
			
		});
		loginBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(RegisterCarFirstActivity.this, LoginCarActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
