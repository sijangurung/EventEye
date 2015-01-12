package com.sizdroidinc.eventeye;

import java.io.File;

import com.sizdroidinc.smartsalary.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manage_Event extends Activity {

	String str="";
	File traceFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manage_profile);
		Button btnClear = (Button) findViewById(R.id.btnDelAll);
		
		//Here is the initialization part..
		try{
			traceFile = new File(((Context)this).getExternalFilesDir(null), "TraceFile.txt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		btnClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				traceFile.delete();	
				new ToastMsg(getApplicationContext(),"All Events Cleared !");
				
			}
		});//end of btnClear onclick listener...'
		
	}

}
