package com.example.travellover;

import android.app.TabActivity;
import android.os.Bundle;




import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TextView;

public class MainTabActivity extends TabActivity {

	TabHost tabhost=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		tabhost=getTabHost();
		tabhost.addTab(tabhost.newTabSpec("tab1")
				.setIndicator("议价")
				.setContent(R.id.tab01));
		tabhost.addTab(tabhost.newTabSpec("tab2")
				.setIndicator("推荐路线")
				.setContent(R.id.tab02));
		tabhost.addTab(tabhost.newTabSpec("tab3")
				.setIndicator("通知")
				.setContent(R.id.tab03));
		/*mTabHost = (TabHost) findViewById(R.id);  
		mTabHost.setup();  
		View []viewtabs= new View[]{null,null,null,null};  
		int []tabids=new int[]{R.id.tab1,R.id.tab2,R.id.tab3,R.id.tab4};  
		String[]tabnames=new String[]{"tab1","tab2","tab3","tab4"};  
		for(int i=0;i<tabids.length;i++)  { //得到标签视图
			viewtabs[i]=LayoutInflater.from(this).inflate(R.layout.tabs,null);  
			TextView tv=(TextView)viewtabs[i].findViewById(R.id.tv1); 
			tv.setText(tabnames[i]); 
			mTabHost.addTab(mTabHost.newTabSpec(tabnames[i]).setIndicator(viewtabs[i])  .setContent(tabids[i]));  //setIndicator(viewtabs[i])表示自定义标签  //setContent(tabids[i])表示设置Tab的布局内容  }  //设置监听  mTabHost.setOnTabChangedListener(this);  }
		}*/
	}

}
