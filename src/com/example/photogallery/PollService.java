package com.example.photogallery;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class PollService extends IntentService {
	private static final String TAG = "PollService";
	private static final int POLL_INTERVAL = 1000;
	
	public PollService() {
		super(TAG);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Toast.makeText(getApplicationContext(), "111111111111", 1000).show();
		Log.i(TAG, "Received an intent: " + intent);
	}
	
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public static void setServiceAlarm(Context context, boolean isOn){
		Intent i = new Intent(context, PollService.class);
		PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		if (isOn) {
			alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), POLL_INTERVAL, pi);
		} else {
			alarmManager.cancel(pi);
			pi.cancel();
		}
	}

}
