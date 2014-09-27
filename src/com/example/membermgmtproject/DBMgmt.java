package com.example.membermgmtproject;

import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.message.*;
import org.apache.http.params.*;

import android.util.*;

public class DBMgmt {
	private String urlString = "http://192.168.0.34:8080/JSONServerProject/register.jsp";
	private DefaultHttpClient client;
	private HttpPost post;
	private HttpResponse response; 
	private HttpParams params;
	
	private int resCode = 0;
	
	public DBMgmt() {
		client = new DefaultHttpClient();
		
		
		
	}
	
	public void insertMember(Member m) {
		try {
			
/*			params.setParameter("userName", m.getUserName());
			params.setParameter("userPwd", m.getUserPwd());
			params.setParameter("userEmail", m.getUserEmail());*/
			//post.setParams(params);

			
			List<NameValuePair> dataList = new ArrayList<NameValuePair>();
            dataList.add(new BasicNameValuePair("userName", m.getUserName()));
            dataList.add(new BasicNameValuePair("userPwd", m.getUserPwd()));
            dataList.add(new BasicNameValuePair("userEmail", m.getUserEmail()));
            urlString = urlString + "?" + URLEncodedUtils.format(dataList, "UTF-8");
			
            
            post = new HttpPost(urlString);
			
			response = client.execute(post);
			
			resCode = response.getStatusLine().getStatusCode();
			//Integer.toString(resCode)
			
		
			Log.i("jsoninfo", Integer.toString(resCode));
			
			System.out.println("gggggg");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("jsoninfo", Integer.toString(resCode));
		}
	}
}
