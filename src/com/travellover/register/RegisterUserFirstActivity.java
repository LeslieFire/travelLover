package com.travellover.register;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterUserFirstActivity extends Activity {

	private ImageView checkBox;
	private boolean check;
	private Button nextBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_user_first);
		Button backBtn = (Button)findViewById(R.id.userRegisterFirstBackBtn);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		Button nextBtn = (Button)findViewById(R.id.userRegisterFirstNextBtn);
		nextBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(check) {
					Intent intent = new Intent();
					intent.setClass(RegisterUserFirstActivity.this, RegisterUserSecondActivity.class);
					startActivity(intent);
				}
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
		check = true;
		checkBox = (ImageView)findViewById(R.id.userRegisterFirstAcceptImgBtn);
		checkBox.setOnClickListener(new ImageView.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(check) {
					check = false;
					checkBox.setImageResource(R.drawable.ic_checkbox_n);
				}
				else {
					check = true;
					checkBox.setImageResource(R.drawable.ic_checkbox_p);
				}
			}
			
		});
		Button acceptBtn = (Button)findViewById(R.id.userRegisterFirstAcceptBtn);
		acceptBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(check) {
					check = false;
					checkBox.setImageResource(R.drawable.ic_checkbox_n);
				}
				else {
					check = true;
					checkBox.setImageResource(R.drawable.ic_checkbox_p);
				}
			}
			
		});
	}

}
