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

public class LineListActivity extends Activity {

	private ArrayList<HashMap<String, Object>> listItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line_list);
		Button backBtn = (Button)findViewById(R.id.lineListBackBtn);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		listItem = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("lineStartPoint", "长丰县");
		map1.put("lineDestinationPoint", "东莞市");
		map1.put("lineDriverName", "阿东");
		map1.put("lineDepartureTime", "出发时间:2013");
		map1.put("lineType", "上下班");
		listItem.add(map1);
		ListView lineListView = (ListView)findViewById(R.id.lineListView);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源
            R.layout.line_list_item,//ListItem的XML实现
            //动态数组与ImageItem对应的子项
            new String[] {"lineStartPoint", "lineDestinationPoint", "lineDriverName", "lineDepartureTime", "lineType"},
            //ImageItem的XML文件里面的两个TextView ID
            new int[] {R.id.lineStartPoint, R.id.lineDestinationPoint, R.id.lineDriverName, R.id.lineDepartureTime, R.id.lineType}
        );
		lineListView.setAdapter(listItemAdapter);
		lineListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LineListActivity.this, LineDetailActivity.class);
				startActivity(intent);
			}
			
		});
	}

}
