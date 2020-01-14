package anhhy.day03_progressdialog_sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {
    private EditText edtPhone, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        edtPhone = findViewById(R.id.edtPhone);
        edtContent = findViewById(R.id.edtContent);
        };


    public void clickToSendSMS(View view) {
        String phone = edtPhone.getText().toString();
        String content = edtContent.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        Intent intent = new Intent("AnhHY_Send_SMS");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent,0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Sent OK";
                if(result != Activity.RESULT_OK){
                    msg = "Sent FAILED";
                }
                Toast.makeText(SMSActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("AnhHY_Send_SMS"));
        smsManager.sendTextMessage(phone, null, content, pendingIntent, null);
        finish();
    }
}
