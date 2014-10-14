package com.travellover.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.travellover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class UserSettingActivity extends Activity {

	private ArrayList<HashMap<String, String>> list1;
	private ArrayList<HashMap<String, Object>> list2;
	private ArrayList<HashMap<String, String>> list3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_main);
		list1 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		map1.put("item", "拼车安全");
		map2.put("item", "拼车攻略");
		list1.add(map1);
		list1.add(map2);
		ListView part1 = (ListView)findViewById(R.id.settingViewPart1);
		SimpleAdapter adapter1 = new SimpleAdapter(getApplicationContext(), list1, R.layout.setting_list_item,
				new String[]{"item"}, new int[]{R.id.settingContent});
		part1.setAdapter(adapter1);
		
		list2 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map5.put("item", "我是乘客");
		map5.put("image", R.drawable.greencheck);
		map6.put("item", "我是车主");
		map6.put("image", null);
		list2.add(map5);
		list2.add(map6);
		ListView part2 = (ListView)findViewById(R.id.settingViewPart2);
		SimpleAdapter adapter2 = new SimpleAdapter(getApplicationContext(), list2, R.layout.setting_list_item1,
				new String[]{"item", "image"}, new int[]{R.id.settingContent, R.id.settingImg});
		part2.setAdapter(adapter2);
		
		list3 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		HashMap<String, String> map4 = new HashMap<String, String>();
		map3.put("item", "周边信息");
		map4.put("item", "关于我们");
		list3.add(map3);
		list3.add(map4);
		ListView part3 = (ListView)findViewById(R.id.settingViewPart3);
		SimpleAdapter adapter3 = new SimpleAdapter(getApplicationContext(), list3, R.layout.setting_list_item,
				new String[]{"item"}, new int[]{R.id.settingContent});
		part3.setAdapter(adapter3);
		part3.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2 == 1) {
					Intent intent = new Intent();
					intent.setClass(UserSettingActivity.this, AboutMainActivity.class);
					startActivity(intent);
				}
			}
			
		});
	}

}
