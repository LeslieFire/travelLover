package com.travellover.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class PersonalDriverMainActivity extends Activity {

	private ArrayList<HashMap<String, Object>> list1;
	private ArrayList<HashMap<String, Object>> list2;
	private ArrayList<HashMap<String, String>> list3;
	private ArrayList<HashMap<String, Object>> list4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_driver_main);
		Button backBtn = (Button)findViewById(R.id.personalDriverBackBtn);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		list1 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("headshot", R.drawable.ic_profile_male_134);
		map1.put("name", "旅游ing");
		map1.put("age", "23");
		list1.add(map1);
		ListView part1 = (ListView)findViewById(R.id.personalDriverViewPart1);
		SimpleAdapter adapter1 = new SimpleAdapter(getApplicationContext(), list1, R.layout.personal_list_item1,
				new String[]{"headshot", "name", "age"}, new int[]{R.id.personalHeadshot, R.id.settingContent1, R.id.settingContent2});
		part1.setAdapter(adapter1);
		part1.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2 == 0) {
					Intent intent = new Intent();
					intent.setClass(PersonalDriverMainActivity.this, PersonalDataActivity.class);
					startActivity(intent);
				}
			}
			
		});
		
		list2 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map5.put("item", "手机验证");
		map5.put("content", "已验证");
		map6.put("item", "车主验证");
		map6.put("content", "未提交");
		list2.add(map5);
		list2.add(map6);
		ListView part2 = (ListView)findViewById(R.id.personalDriverViewPart2);
		SimpleAdapter adapter2 = new SimpleAdapter(getApplicationContext(), list2, R.layout.personal_list_item,
				new String[]{"item", "content"}, new int[]{R.id.personalContent1, R.id.personalContent2});
		part2.setAdapter(adapter2);
		
		list4 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map7 = new HashMap<String, Object>();
		HashMap<String, Object> map8 = new HashMap<String, Object>();
		map7.put("item", "爱车信息");
		map7.put("content", "未完善");
		map8.put("item", "常用线路/地点");
		map8.put("content", "未完善");
		list4.add(map7);
		list4.add(map8);
		ListView part4 = (ListView)findViewById(R.id.personalDriverViewPart4);
		SimpleAdapter adapter4 = new SimpleAdapter(getApplicationContext(), list4, R.layout.personal_list_item,
				new String[]{"item", "content"}, new int[]{R.id.personalContent1, R.id.personalContent2});
		part4.setAdapter(adapter4);
		
		list3 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("item", "活动邀请码");
		list3.add(map3);
		ListView part3 = (ListView)findViewById(R.id.personalDriverViewPart3);
		SimpleAdapter adapter3 = new SimpleAdapter(getApplicationContext(), list3, R.layout.setting_list_item,
				new String[]{"item"}, new int[]{R.id.settingContent});
		part3.setAdapter(adapter3);
		
	}

}
