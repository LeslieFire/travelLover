package com.travellover.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.travellover.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class DriverCloseLineListActivity extends Activity {

	private Button singleBtn;
	private Button doubleBtn;
	private Button placeBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.driver_close_line);
		Button backBtn = (Button)findViewById(R.id.driverCloseLineBackBtn);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		placeBtn = (Button)findViewById(R.id.driverClosePlaceBtn);
		placeBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder headshotSelect = new AlertDialog.Builder(DriverCloseLineListActivity.this);
				headshotSelect.setTitle("更换城市");
				headshotSelect.setItems(new String[]{"杭州", "广州", "深圳", "取消"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						switch(arg1) {
						case 0:
							placeBtn.setText("杭州");
							break;
						case 1:
							placeBtn.setText("广州");
							break;
						case 2:
							placeBtn.setText("深圳");
							break;
						}
					}
					
				});
				headshotSelect.show();
			}
			
		});
		singleBtn = (Button)findViewById(R.id.driverSingleBtn);
		doubleBtn = (Button)findViewById(R.id.driverDoubleBtn);
		singleBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				singleBtn.setTextColor(0xffffffff);
				singleBtn.setBackgroundResource(R.drawable.button_style11);
				doubleBtn.setTextColor(0xffaaaaaa);
				doubleBtn.setBackgroundResource(R.drawable.button_style12);
			}
			
		});
		doubleBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doubleBtn.setTextColor(0xffffffff);
				doubleBtn.setBackgroundResource(R.drawable.button_style11);
				singleBtn.setTextColor(0xffaaaaaa);
				singleBtn.setBackgroundResource(R.drawable.button_style12);
			}
			
		});
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("startPoint", "长丰县");
		map1.put("destinationPoint", "东莞市");
		map1.put("driverName", "阿东");
		map1.put("orderDepartureTime", "出发时间:2013");
		listItem.add(map1);
		ListView lineListView = (ListView)findViewById(R.id.driverCloseLineListView);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源
            R.layout.driver_line_item,//ListItem的XML实现
            //动态数组与ImageItem对应的子项
            new String[] {"startPoint", "destinationPoint", "driverName", "orderDepartureTime", "orderType"},
            //ImageItem的XML文件里面的两个TextView ID
            new int[] {R.id.driverStartPoint, R.id.driverDestinationPoint, R.id.driverName, R.id.driverLineDepartureTime}
        );
		lineListView.setAdapter(listItemAdapter);
		lineListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DriverCloseLineListActivity.this, LineDetailActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
