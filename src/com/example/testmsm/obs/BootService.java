package com.example.testmsm.obs;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BootService extends Service{

    public static final String TAG = "BootService";

   

    private ContentObserver mObserver;

 

    private Handler mHandler = new Handler();

   

    @Override

    public void onCreate(){

       Log.i(TAG, "onCreate().");

       super.onCreate();

      

       addSMSObserver();
       Toast.makeText(BootService.this, "BootService 启动了 ", Toast.LENGTH_SHORT).show();
    }

   

    public void addSMSObserver() {

       Log.i(TAG, "add a SMS observer. ");

      

       ContentResolver resolver = getContentResolver();

      

       Handler handler = new SMSHandler(this);

       mObserver = new SMSObserver(resolver, handler);

       resolver.registerContentObserver(SMS.CONTENT_URI, true, mObserver);

    }

 

    @Override

    public IBinder onBind(Intent intent){

       return null;

    }

 

    @Override

    public void onDestroy(){

       Log.i(TAG, "onDestroy().");

      

        this.getContentResolver().unregisterContentObserver(mObserver);

      

       super.onDestroy();


//        Process.killProcess(Process.myPid());

       System.exit(0);

    }
}
