package com.sizdroidinc.eventeye;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.sizdroidinc.eventeye.R;

import android.app.Activity;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Create_Event extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createprofile);
		
		Button btnSave = (Button) findViewById(R.id.btnSave);
		final EditText startTime = (EditText) findViewById(R.id.startTime);
		final EditText endTime = (EditText) findViewById(R.id.endTime);
		final EditText title = (EditText) findViewById(R.id.title);
		final EditText desc = (EditText) findViewById(R.id.description);
	

		
		btnSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String details = null;
				details = startTime.toString()+"%%";
				details+=endTime.toString()+"%%";
				details+=title.getText()+"%%";
				details+=desc.getText()+"%%";
				
				
				SaveToFile(title.getText().toString(),details);
				

				new ToastMsg(getApplicationContext(), "Event Saved!");
						
			}
		});//end of btnSave onclick listener...'
	}
	public void SaveToFile(String str,String Details){
		 try
		   {
		                            // Creates a trace file in the primary external storage space of the 
		                            // current application.
		                            // If the file does not exists, it is created.
		   File traceFile = new File(((Context)this).getExternalFilesDir(null), "TraceFile.txt");
		   File details = new File(((Context)this).getExternalFilesDir(null), "Details.txt");
		   
		   if (!details.exists())
			      details.createNewFile();if (!traceFile.exists())
		      traceFile.createNewFile();
		                            // Adds a line to the trace file
		   BufferedWriter writer = new BufferedWriter(new FileWriter(traceFile, true /*append*/));
		   BufferedWriter writeDetails = new BufferedWriter(new FileWriter(details,true));
		   writeDetails.write(Details);
		   writeDetails.write("\n");
		   writeDetails.close();
		   
		   writer.write(str);
		   writer.write("\n");
		   writer.close();
		                           // Refresh the data so it can seen when the device is plugged in a
		                           // computer. You may have to unplug and replug the device to see the 
		                           // latest changes. This is not necessary if the user should not modify
		                           // the files.
		    MediaScannerConnection.scanFile((Context)(this),
		                                     new String[] { traceFile.toString() },
		                                     null,
		                                     null);
		   
		    }
		catch (IOException e)
		    {
		    Log.e("com.cindypotvin.FileTest", "Unable to write to the file.");
		    }
	}//end of SaveToFile.....
}
