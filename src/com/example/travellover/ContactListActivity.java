package com.example.travellover;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ContactListActivity extends Activity {
	//ArrayList<String> contactlist=new ArrayList<String>();
	ArrayList<HashMap<String,Object>>listItems=new ArrayList<HashMap<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list);
		
		Button searchBtn=(Button)findViewById(R.id.searchcontact);
		searchBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		HashMap<String,Object> map1 = new HashMap<String, Object>();
		map1.put("username", "yangfei");
		HashMap<String,Object> map2 = new HashMap<String, Object>();
		map2.put("username", "zhangteng");
		HashMap<String,Object> map3 = new HashMap<String, Object>();
		map3.put("username", "longweiyu");
		HashMap<String,Object> map4 = new HashMap<String, Object>();
		map4.put("username", "lvrunbin");
		HashMap<String,Object> map5 = new HashMap<String, Object>();
		map5.put("username", "yangdongsheng");
		listItems.add(map1);
		listItems.add(map2);
		listItems.add(map3);
		listItems.add(map4);
		listItems.add(map5);
		
		//contactlist=idsql.getcontact();
		/*ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1,contactlist);
		listview.setAdapter(arrayAdapter);*/
	    ListView listview=(ListView)findViewById(R.id.contactlist);
		SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.contract_list_item,
				new String[]{"headshot","username"},
				new int[]{R.id.contractImage,R.id.contractname});
		listview.setAdapter(simpleAdapter);
		listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String contactname=new String();
				contactname=(String) listItems.get(arg2).get("username");
				//Toast.makeText(ContactListActivity.this, contactname, Toast.LENGTH_LONG).show(); 
				String password="";
				Bundle bundle=new Bundle();
				bundle.putString("username", contactname);
				bundle.putString("password", password);
				
					Intent intent=new Intent();
					intent.putExtras(bundle);
					intent.setClass(ContactListActivity.this, MessageofcontactActivity.class);
					startActivity(intent);
		        
			}
			
		});
		  

		/*listview.setOnItemClickListener(new OnItemClickListener(){

			/*public void onItemClick(ListView listview,arg0, View arg1, int arg2,
					long arg3) {
				Map map=(Map)listview.getItemAtPosition(arg2);
				Toast toast = Toast.makeText(this, map.get("username")+" is selected.", Toast.LENGTH_LONG);  
		        toast.show();  
				// TODO Auto-generated method stub
				//System.out.println("Hello");
				String contactname=new String();
				//contactname=contactlist.get(arg2);
				Toast.makeText(ContactListActivity.this, contactname, Toast.LENGTH_SHORT).show();
				/*String password=idsql.Search(contactname);
				Bundle bundle=new Bundle();
				bundle.putString("username", contactname);
				bundle.putString("password", password);
				
					Intent intent=new Intent();
					intent.putExtras(bundle);
					intent.setClass(ContactListActivity.this, MessageofcontactActivity.class);
					startActivity(intent);
				
			}
			
		}

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			});*/
		
	}

}
