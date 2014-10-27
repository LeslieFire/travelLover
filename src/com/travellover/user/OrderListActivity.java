package com.travellover.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.travellover.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class OrderListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_list);
		Button backBtn = (Button)findViewById(R.id.orderListBackBtn);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("startPoint", "长丰县");
		map1.put("destinationPoint", "东莞市");
		map1.put("driverName", "阿东");
		map1.put("orderDepartureTime", "出发时间:2013");
		map1.put("orderType", "上下班");
		listItem.add(map1);
		ListView orderListView = (ListView)findViewById(R.id.orderListView);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源
            R.layout.order_list_item,//ListItem的XML实现
            //动态数组与ImageItem对应的子项
            new String[] {"startPoint", "destinationPoint", "driverName", "orderDepartureTime", "orderType"},
            //ImageItem的XML文件里面的两个TextView ID
            new int[] {R.id.startPoint, R.id.destinationPoint, R.id.driverName, R.id.orderDepartureTime, R.id.orderType}
        );
		orderListView.setAdapter(listItemAdapter);
		orderListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
