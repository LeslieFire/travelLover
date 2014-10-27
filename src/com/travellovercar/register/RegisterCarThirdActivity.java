package com.travellovercar.register;

import com.example.travellover.R;

import com.example.travellover.R.layout;
import com.example.travellover.R.menu;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RegisterCarThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_car_third);
		ImageButton imageBtn1=(ImageButton)findViewById(R.id.carcertificate);
		ImageButton imageBtn2=(ImageButton)findViewById(R.id.drivercertificate);
		imageBtn1.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println("you are the best");
				//Toast.makeText(RegisterCarThirdActivity.this, "clicked", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("image/*");
				startActivityForResult(intent,1);
				
			}
			
		});
		imageBtn2.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("image/*");
				startActivityForResult(intent,2);
			}
			
		});
	}
    
	protected void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode!=RESULT_OK)
		{
			return;
		}
		if(requestCode==1)
		{
			try
			{
				LinearLayout layout=(LinearLayout)findViewById(R.id.imagebuttonshow);
				layout.setVisibility(LinearLayout.VISIBLE);
				ContentResolver resolver=getContentResolver();
				Uri orginalUri=data.getData();
				Bitmap bitmap=MediaStore.Images.Media.getBitmap(resolver, orginalUri);
				ImageButton imagebutton1=(ImageButton)findViewById(R.id.carcertificate);
				imagebutton1.setImageBitmap(bitmap);
				imagebutton1.setVisibility(ImageButton.VISIBLE);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(requestCode==2)
		{
			try
			{
				LinearLayout layout=(LinearLayout)findViewById(R.id.imagebuttonshow);
				layout.setVisibility(LinearLayout.VISIBLE);
				ContentResolver resolver=getContentResolver();
				Uri orginalUri=data.getData();
				Bitmap bitmap=MediaStore.Images.Media.getBitmap(resolver, orginalUri);
				ImageButton imagebutton1=(ImageButton)findViewById(R.id.carcertificate);
				imagebutton1.setImageBitmap(bitmap);
				imagebutton1.setVisibility(ImageButton.VISIBLE);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}try
			{
				LinearLayout layout=(LinearLayout)findViewById(R.id.imagebuttonshow);
				layout.setVisibility(LinearLayout.VISIBLE);
				ContentResolver resolver=getContentResolver();
				Uri orginalUri=data.getData();
				Bitmap bitmap=MediaStore.Images.Media.getBitmap(resolver, orginalUri);
				ImageButton imagebutton1=(ImageButton)findViewById(R.id.carcertificate);
				imagebutton1.setImageBitmap(bitmap);
				imagebutton1.setVisibility(ImageButton.VISIBLE);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
