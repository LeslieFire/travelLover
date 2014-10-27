package com.travellover.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.travellover.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PersonalDataActivity extends Activity {

	private ArrayList<HashMap<String, Object>> list1;
	private ArrayList<HashMap<String, Object>> list2;
	private ArrayList<HashMap<String, Object>> list3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personaldata_main);
		list1 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map1.put("item", "昵称");
		map1.put("content", "旅游ing");
		map2.put("item", "性别");
		map2.put("content", "男");
		map3.put("item", "出生年月");
		map3.put("content", "1991-03");
		list1.add(map1);
		list1.add(map2);
		list1.add(map3);
		ListView part1 = (ListView)findViewById(R.id.personalDataPart1);
		SimpleAdapter adapter1 = new SimpleAdapter(getApplicationContext(), list1, R.layout.personal_list_item,
				new String[]{"item", "content"}, new int[]{R.id.personalContent1, R.id.personalContent2});
		part1.setAdapter(adapter1);
		
		list2 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map6.put("item", "居住小区");
		map6.put("content", "未设置");
		map7.put("item", "公司名称");
		map7.put("content", "未设置");
		list2.add(map6);
		list2.add(map7);
		ListView part2 = (ListView)findViewById(R.id.personalDataPart2);
		SimpleAdapter adapter2 = new SimpleAdapter(getApplicationContext(), list2, R.layout.personal_list_item,
				new String[]{"item", "content"}, new int[]{R.id.personalContent1, R.id.personalContent2});
		part2.setAdapter(adapter2);
		
		list3 = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map4.put("item", "所处行业");
		map4.put("content", "计算机硬件/软件");
		map5.put("item", "兴趣爱好");
		map5.put("content", "未设置");
		list3.add(map4);
		list3.add(map5);
		ListView part3 = (ListView)findViewById(R.id.personalDataPart3);
		SimpleAdapter adapter3 = new SimpleAdapter(getApplicationContext(), list3, R.layout.personal_list_item,
				new String[]{"item", "content"}, new int[]{R.id.personalContent1, R.id.personalContent2});
		part3.setAdapter(adapter3);
	}

}
