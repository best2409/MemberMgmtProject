package com.example.membermgmtproject;
import java.util.*;

import android.app.*;
import android.os.*;
import android.util.*;
import android.widget.*;


public class SubActivity extends Activity {
	private DBMgmt  mgmt;
	
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		listView = (ListView) findViewById(R.id.listView);
		
		mgmt = new DBMgmt();
		
		List<Member> list = mgmt.selectMember();
		
		Log.e("jsoninfo", list.get(0).getUserName());
		
		MyAdapter adapter = new MyAdapter(this, list);
		
		listView.setAdapter(adapter);
		
	}
	
}
