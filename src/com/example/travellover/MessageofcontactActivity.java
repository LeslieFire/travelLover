package com.example.travellover;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MessageofcontactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messageofcontact);
		Intent intent=this.getIntent();
		Bundle bundle=intent.getExtras();
		String username=bundle.getString("username");
		String password=bundle.getString("password");
		ListView listview=(ListView)findViewById(R.id.messageofcontact);
		ArrayList messagelist=new ArrayList();
		messagelist.add("姓名"+username);
		messagelist.add("密码"+password);
		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
				this,android.R.layout.simple_list_item_1,messagelist);
		listview.setAdapter(arrayAdapter);
	}

}
