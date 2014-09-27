package com.example.membermgmtproject;

import android.app.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;


public class MainActivity extends Activity {
	
	private EditText userName, userEmail, userPwd;
	private Button loginBtn;
	
	private DBMgmt mgmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        
        userName = (EditText) findViewById(R.id.userName);
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPwd = (EditText) findViewById(R.id.userPwd);
        
        loginBtn = (Button) findViewById(R.id.btnLogin);
    }
    
    

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		mgmt = new DBMgmt();
        
        loginBtn.setOnClickListener(new OnClickListener() {
        	String uName, uPwd, uEmail;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_SHORT).show();
				Log.e("jsoninfo", "DB Start");
				
				uName = userName.getText().toString();
				uPwd = userPwd.getText().toString();
				uEmail = userEmail.getText().toString();
				
				
				Member m = new Member(uName, uPwd, uEmail);
				
				mgmt.insertMember(m);
				
				Log.e("jsoninfo", "DB End");
				Toast.makeText(getApplicationContext(), uName + "=" + uPwd + "=" + uEmail, Toast.LENGTH_SHORT).show();
			}
        	
        });
		
	}



	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
    
    

}
