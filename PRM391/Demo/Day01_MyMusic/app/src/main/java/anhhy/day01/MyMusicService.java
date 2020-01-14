package anhhy.day01;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicService extends Service {
    MediaPlayer mp_object;
    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp_object = MediaPlayer.create(getApplicationContext(), R.raw.demosong);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp_object.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp_object.release();
    }
}
