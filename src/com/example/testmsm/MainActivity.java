//package com.example.testmsm;
//
//import java.text.SimpleDateFormat;
//
//import com.example.testmsm.obs.BootService;
//import com.example.testmsm.obs.SMS;
//import com.example.testmsm.obs.SMSHandler;
//import com.example.testmsm.obs.SMSObserver;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.ContentResolver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.database.ContentObserver;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.telephony.SmsMessage;
//import android.util.Log;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends Activity {
//	
//	private String TAG = "MainActivity";
//
//	private TextView mTextView;
//
//	 private ContentObserver mObserver;
//
//	 
//
//	 private Handler mHandler = new Handler(){
//		 public void handleMessage(Message msg) {
//			 Log.i("xxxxx", msg.toString());
//		 };
//	 };
//	
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		/*mTextView = (TextView) findViewById(R.id.my_text);
//
//		IntentFilter filter = new IntentFilter();
//		filter.setPriority(1000);
//		filter.addAction("android.provider.Telephony.SMS_RECEIVED");
//		registerReceiver(smsReceiver, filter);*/
//		
//		
//		 addSMSObserver();
//	     Toast.makeText(this, "MainActivity 启动了 ", Toast.LENGTH_SHORT).show();
//	}
//
//	public void addSMSObserver() {
//
//	       Log.e(TAG, "add a SMS observer. ");
//
//	      
//
//	       ContentResolver resolver = getContentResolver();
//
//	      
//
//	       Handler handler = new SMSHandler(this);
//
//	       mObserver = new SMSObserver(resolver, mHandler);
//
//	       resolver.registerContentObserver(SMS.CONTENT_URI, true, mObserver);
//
//	    }
//	
//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//		this.getContentResolver().unregisterContentObserver(mObserver);
//		
////		unregisterReceiver(smsReceiver);
//	}
//
//	
//	/*private Handler mHandler = new Handler() {
//		public void handleMessage(android.os.Message msg) {
//			switch (msg.what) {
//			case 1:
//				String text = (String) msg.obj;
//				mTextView.setText(text);
//				break;
//
//			default:
//				break;
//			}
//
//		}
//	};
//
//	/*private BroadcastReceiver smsReceiver = new BroadcastReceiver() {
//
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			Bundle bundle = intent.getExtras();
//			Object[] objects = (Object[]) bundle.get("pdus");
//			for (Object obj : objects) {
//				SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
//				String body = smsMessage.getDisplayMessageBody();
//				String address = smsMessage.getDisplayOriginatingAddress();
//				long date = smsMessage.getTimestampMillis();
//
//				SimpleDateFormat format = new SimpleDateFormat(
//						"yyyy-MM-dd hh:mm:ss");
//				String dateStr = format.format(date);
//
//				Log.e(TAG, address + " 于  " + dateStr + "给你发了以下内容: " + body);
//
//				Message msg = mHandler.obtainMessage();
//				msg.what = 1;
//				msg.obj = address + " 于  " + dateStr + "给你发了以下内容: " + body;
//				mHandler.sendMessage(msg);
//
//			}
//
//		}
//
//	};*/
//}
