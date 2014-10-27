package com.travellover.user;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.travellover.MainTabActivity;
import com.example.travellover.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainDriverActivity extends Activity {

	private ImageButton headshotBtn;
	private LinearLayout mainViewLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.driver_main);
		mainViewLayout = (LinearLayout)findViewById(R.id.mainDriverViewLayout);
		ImageButton settingBtn = (ImageButton)findViewById(R.id.mainDriverSettingBtn);
		settingBtn.setOnClickListener(new ImageButton.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, UserSettingActivity.class);
				startActivity(intent);
			}
			
		});
		ImageButton personalBtn = (ImageButton)findViewById(R.id.mainDriverPersonalBtn);
		personalBtn.setOnClickListener(new ImageButton.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, PersonalDriverMainActivity.class);
				startActivity(intent);
			}
			
		});
		Button processBtn = (Button)findViewById(R.id.mainDriverProceedBtn);
		processBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, PersonalDriverMainActivity.class);
				startActivity(intent);
			}
			
		});
		headshotBtn = (ImageButton)findViewById(R.id.driverHeadshotBtn);
		headshotBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder headshotSelect = new AlertDialog.Builder(MainDriverActivity.this);
				headshotSelect.setTitle("设置头像");
				headshotSelect.setItems(new String[]{"拍一张", "从相册选择", "取消"}, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						switch(arg1) {
						case 0:
							Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
							startActivityForResult(cameraIntent, 1);
							break;
						case 1:
							Intent pictureIntent = new Intent(Intent.ACTION_GET_CONTENT);
							pictureIntent.setType("image/*");
							startActivityForResult(pictureIntent, 2);
							break;
						case 2:
						}
					}
				});
				headshotSelect.show();
			}
			
		});
		LinearLayout backgroundLinear = (LinearLayout)findViewById(R.id.backgroundDriverLinear);
		backgroundLinear.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder backgroundSelect = new AlertDialog.Builder(MainDriverActivity.this);
				backgroundSelect.setTitle("更换封面");
				backgroundSelect.setItems(new String[]{"拍一张", "从相册选择", "使用默认封面", "取消"}, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						switch(arg1) {
						case 0:
							Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
							startActivityForResult(cameraIntent, 3);
							break;
						case 1:
							Intent pictureIntent = new Intent(Intent.ACTION_GET_CONTENT);
							pictureIntent.setType("image/*");
							startActivityForResult(pictureIntent, 4);
							break;
						case 2:
							mainViewLayout.setBackgroundResource(R.drawable.bg_car_passenger);
							break;
						case 3:
						}
					}
				});
				backgroundSelect.show();
			}
			
		});
		Button orderBtn = (Button)findViewById(R.id.driverOrderBtn);
		orderBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, LineListActivity.class);
				startActivity(intent);
			}
			
		});
		Button collectionBtn = (Button)findViewById(R.id.driverCollectionBtn);
		collectionBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, LineListActivity.class);
				startActivity(intent);
			}
			
		});
		Button attentionBtn = (Button)findViewById(R.id.driverAttentionBtn);
		attentionBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, MainTabActivity.class);
				startActivity(intent);
			}
			
		});
		Button farBtn = (Button)findViewById(R.id.mainDriverFarLineBtn);
		farBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, DriverFarLineListActivity.class);
				startActivity(intent);
			}
			
		});
		Button closeBtn = (Button)findViewById(R.id.mainDriverCloseLineBtn);
		closeBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainDriverActivity.this, DriverCloseLineListActivity.class);
				startActivity(intent);
			}
			
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			if(requestCode == 2) {
				ContentResolver resolver = getContentResolver();
				Uri originalUri = data.getData();
				try {
					Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
					headshotBtn.setImageBitmap(photo);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(requestCode == 1) {
				Bitmap photo = (Bitmap) data.getExtras().get("data");
				headshotBtn.setImageBitmap(photo);
			}
			else if(requestCode == 3) {
				Bitmap photo = (Bitmap) data.getExtras().get("data");
				BitmapDrawable bd= new BitmapDrawable(getResources(), photo); 
				mainViewLayout.setBackgroundDrawable(bd);
			}
			else if(requestCode == 4) {
				ContentResolver resolver = getContentResolver();
				Uri originalUri = data.getData();
				try {
					Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
					BitmapDrawable bd= new BitmapDrawable(getResources(), photo); 
					mainViewLayout.setBackgroundDrawable(bd);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
