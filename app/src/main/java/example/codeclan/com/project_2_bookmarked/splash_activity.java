package example.codeclan.com.project_2_bookmarked;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);

        int secondDelayed = 3;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(new Intent(splash_activity.this, MainActivity.class));
                finish();
            }
        }, secondDelayed * 1000);
    }
}
