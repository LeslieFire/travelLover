package com.travellover.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.travellover.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AboutMainActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> list1;
	private ArrayList<HashMap<String, Object>> list2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_main);
		list1 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("item", "提交反馈");
		list1.add(map1);
		ListView part1 = (ListView)findViewById(R.id.aboutMainPart1);
		SimpleAdapter adapter1 = new SimpleAdapter(getApplicationContext(), list1, R.layout.setting_list_item,
				new String[]{"item"}, new int[]{R.id.settingContent});
		part1.setAdapter(adapter1);
		
		list2 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map2.put("item", "当前版本号2.7.0");
		map3.put("item", "关于我们");
		map4.put("item", "清除图片缓存");
		list2.add(map2);
		list2.add(map3);
		list2.add(map4);
		ListView part2 = (ListView)findViewById(R.id.aboutMainPart2);
		SimpleAdapter adapter2 = new SimpleAdapter(getApplicationContext(), list2, R.layout.setting_list_item,
				new String[]{"item"}, new int[]{R.id.settingContent});
		part2.setAdapter(adapter2);
	}

}
