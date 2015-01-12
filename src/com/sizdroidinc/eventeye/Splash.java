package com.sizdroidinc.eventeye;

import java.io.FileOutputStream;

import com.sizdroidinc.smartsalary.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	MediaPlayer intro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		//for the music part..
		intro = MediaPlayer.create(Splash.this, R.raw.splash);
		intro.start();
		Thread timer = new Thread(){
			public void run(){
			try{
				FileOutputStream fos = openFileOutput("profiles", Context.MODE_PRIVATE);fos.close();
				sleep(500);}
			catch(InterruptedException e){e.printStackTrace();}
			catch(Exception e){e.printStackTrace();}
			finally{
				//Create the profile file here,,
				

				
				Intent openMain;
				openMain = new Intent("com.sizdroidinc.eventeye.Menu");
				startActivity(openMain);}
				}
			};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		intro.pause();
		finish();
	
		//This is important beacuse it will destroy the class ..so splash wont appear when user press back..
	}
	

}
