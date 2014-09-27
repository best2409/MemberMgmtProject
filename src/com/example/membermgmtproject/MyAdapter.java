package com.example.membermgmtproject;

import java.util.*;

import android.content.*;
import android.view.*;
import android.widget.*;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private List<Member> list;
	
	
	public MyAdapter(Context context, List<Member> data) {
		this.context = context;
		this.list = data;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Member getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.customer, parent, false);
		}
		
		TextView userName = (TextView) convertView.findViewById(R.id.userName);
		TextView userEmail = (TextView) convertView.findViewById(R.id.userEmail);
		
		
		userName.setText(getItem(position).getUserName());
		userEmail.setText(getItem(position).getUserEmail());
		
		return convertView;
	}

}
