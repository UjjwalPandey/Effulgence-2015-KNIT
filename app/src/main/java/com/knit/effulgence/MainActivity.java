package com.knit.effulgence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(1500);
                    Intent i = new Intent(getBaseContext(), GeneralActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        timer.start();
    }
}
