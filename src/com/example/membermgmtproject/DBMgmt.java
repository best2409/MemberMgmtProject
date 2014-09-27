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
import org.json.*;

import android.util.*;

public class DBMgmt {
	private String urlString;
	private DefaultHttpClient client;
	private HttpPost post;
	private HttpResponse response; 
	private HttpParams params;
	
	private int resCode = 0;
	
	public DBMgmt() {
		client = new DefaultHttpClient();
	}
	
	
	// 회원 가입 
	public int insertMember(Member m) {
		urlString = "http://192.168.0.34:8080/JSONServerProject/register.jsp";
		
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
			
			if(resCode == HttpStatus.SC_OK) {
				return 1;
			}
			
		
			// Log.i("jsoninfo", Integer.toString(resCode));
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("jsoninfo", Integer.toString(resCode));
		}
		
		return 0;
	}
	
	
	// 회원 리스트  
	public List<Member> selectMember() {
		urlString = "http://192.168.0.34:8080/JSONServerProject/list.jsp";
		List<Member> parseData = null;
		
		try {
			post = new HttpPost(urlString);
			
			response = client.execute(post);
			
			HttpEntity entity = response.getEntity();
			
			
			resCode = response.getStatusLine().getStatusCode();
			
			if(resCode == HttpStatus.SC_OK) {
				BufferedReader bufreader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				
				String line = null;
				String result = "";
	
				while ((line = bufreader.readLine()) != null) {
					result += line;
				}	
				parseData = jsonParserList(result);
			}
			
		
			// Log.i("jsoninfo", Integer.toString(resCode));
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("jsoninfo", Integer.toString(resCode));
		}
		
		return parseData;
	}
	
//  JSON Parsing
	private List<Member> jsonParserList(String pRecvServerPage) {	
		List<Member> list = new ArrayList<Member>();
		
		Member m;
		Log.e("jsoninfo", pRecvServerPage);
		try {
			
			JSONArray jsonArray = new JSONArray(pRecvServerPage);
			JSONObject jsonObject;
			
			String uName, uPwd, uEmail;
			
			for (int i = 0; i < jsonArray.length(); i++) {
				
				jsonObject = jsonArray.getJSONObject(i);
				
				uName = (String) jsonObject.get("userName");
				uEmail = (String) jsonObject.get("userEmail");
				
				m = new Member(uName, "", uEmail);
				
				list.add(m);
			}
			
			return list;
			
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
