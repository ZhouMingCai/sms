package com.example.testmsm.obs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SystemEventReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent){

		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){

			context.startService(new Intent(Globals.IMICHAT_SERVICE));
			Toast.makeText(context, "SystemEventReceiver 启动了 ", Toast.LENGTH_SHORT).show();
		}else if (intent.getAction().equals(Globals.ACTION_SEND_SMS)){

			MessageItem mItem =

			(MessageItem) intent.getSerializableExtra(Globals.EXTRA_SMS_DATA);

			if (mItem != null && mItem.getPhone() != null
					&& mItem.getBody() != null){

				SmsManager.getDefault()

				.sendTextMessage(mItem.getPhone(), null,

				mItem.getBody(), null, null);


			}

		}

	}
}
