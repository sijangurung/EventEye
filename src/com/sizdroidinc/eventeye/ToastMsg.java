package com.sizdroidinc.eventeye;

import android.content.Context;
import android.widget.Toast;

public class ToastMsg {
	int duration = Toast.LENGTH_SHORT;

	Toast toast;
	public ToastMsg(Context context,String str){
		toast = Toast.makeText(context, str, duration);
		toast.show();
	}

}
