package com.example.travellover;

import com.travellover.map.MapLocationActivity;
import com.travellover.map.MapRoutePlanActivity;
import com.travellover.register.RegisterUserFirstActivity;
import com.travellovercar.register.LoginCarActivity;
import com.travellovercar.register.RegisterCarFirstActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		Button driverBtn = (Button)findViewById(R.id.loginOwnerBtn);
		driverBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginMainActivity.this, RegisterCarFirstActivity.class);
				startActivity(intent);
			}
			
		});
		
		// 添加地图测试相关按钮  add by leslie 2014/10/30  begin
		
		Button locatBtn = (Button)findViewById(R.id.bMapLocat);
		locatBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginMainActivity.this, MapLocationActivity.class);
				startActivity(intent);
			}
			
		});
		
		Button RoutePlanBtn = (Button)findViewById(R.id.bRoutePlan);
		RoutePlanBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginMainActivity.this, MapRoutePlanActivity.class);
				startActivity(intent);
			}
			
		});
		// 添加地图定位按钮  add by leslie 2014/10/30  end
	}

}
