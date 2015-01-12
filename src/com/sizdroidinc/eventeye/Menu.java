package com.sizdroidinc.eventeye;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	static List<String> classes = new ArrayList<String>();
	String FILENAME = "profiles";
	static ArrayAdapter<String> adapter=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
			adapter.clear();
			classes.clear();
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		//loding the profile should be here..
		ReadFromFile();
		//Default in the list..

	//	 classes.add("Manage_Time");
		classes.add("Create_Event");
		classes.add("Manage_Event");
		adapter = new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String classToRun = classes.get(position);
		Class ourClass;
		//If user clicks of their profile ,, run ManageTime otherwise others....
		//Now program this....Sijan Gurung....
		try {
			if(position > (classes.size() - 3))
			{	ourClass = Class.forName("com.sizdroidinc.eventeye."+classToRun);}
			else
			{	ourClass = Class.forName("com.example.androidhive.CustomizedListView");}
			Intent ourIntent = new Intent(Menu.this,ourClass);
			startActivity(ourIntent);	} 
		catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
public void ReadFromFile(){
	String str=null;
	 try
	   {
	                            // Creates a trace file in the primary external storage space of the 
	                            // current application.
	                            // If the file does not exists, it is created.
	   File traceFile = new File(((Context)this).getExternalFilesDir(null), "TraceFile.txt");
	   if (!traceFile.exists())
	      traceFile.createNewFile();
	   //Reading the records,,
	   FileReader in = new FileReader(traceFile.toString());
	   BufferedReader Reader = new BufferedReader(in);
	   while((str = Reader.readLine()) != null){
		   System.out.println(str);
		   classes.add(str);
	   }
	   Reader.close();
	   
	    MediaScannerConnection.scanFile((Context)(this),
	                                     new String[] { traceFile.toString() },
	                                     null,
	                                     null);
	    
	   
	    }
	catch (IOException e)
	    {
	    Log.e("com.sizdroidinc.eventeye.FileTest", "Unable to read to the TraceFile.txt file.");	 }
//	 return str;
}//end of ReadFromFile.....
}
