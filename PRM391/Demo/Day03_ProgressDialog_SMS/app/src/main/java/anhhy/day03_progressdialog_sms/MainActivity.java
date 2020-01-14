package anhhy.day03_progressdialog_sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProgress;
    private ProgressDialog myProBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProgress = findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProBar = new ProgressDialog(MainActivity.this);
                myProBar.setMessage("Loading...");
                myProBar.setTitle("Please wait...");
                myProBar.setProgressStyle(myProBar.STYLE_HORIZONTAL);
                myProBar.setProgress(0);
                myProBar.setMax(20);
                myProBar.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while(myProBar.getProgress() < myProBar.getMax()){
                                Thread.sleep(1000);
                                handler.sendMessage(handler.obtainMessage());
                            }
                            if(myProBar.getProgress() >= myProBar.getMax()){
                                myProBar.dismiss();
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            Handler handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    myProBar.incrementProgressBy(2);
                }
            };
        });
    }

    public void clickToSMS(View view) {
        Intent intent = new Intent(this, SMSActivity.class);
        startActivity(intent);
    }
}
