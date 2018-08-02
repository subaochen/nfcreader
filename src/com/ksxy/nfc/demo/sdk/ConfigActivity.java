package com.ksxy.nfc.demo.sdk;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class ConfigActivity extends Activity {
	
	private EditText address_edit;

	private Button buttonCancel,buttonSave;
	
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.activity_set);			 
		buttonCancel = (Button) findViewById(R.id.buttonCancel);
		address_edit = (EditText) findViewById(R.id.address_edit);
		address_edit.setKeyListener(DigitsKeyListener.getInstance("01"));
		
		
		buttonSave= (Button) findViewById(R.id.buttonSave);
		String path = null;
		try {
			path =  SpUtil.getString(context, "touxiang_set","0");

		}catch(Exception ex) {
			
		}
		address_edit.setText(path);
		
		buttonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (null !=  address_edit.getText().toString() && !"".equals(address_edit.getText().toString().trim())) {
					String data = address_edit.getText().toString().trim();
					SpUtil.putString(context, "touxiang_set", data);
					Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();
					finish();
				} else {
					Toast.makeText(context, "请设置头像解析方式", Toast.LENGTH_SHORT).show();
				}
				
					finish();
			}
		});
		
		
		buttonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					finish();
			}
		});
		
	
	}
}
