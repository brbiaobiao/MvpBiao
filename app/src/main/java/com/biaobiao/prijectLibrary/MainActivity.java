package com.biaobiao.prijectLibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView packname_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packname_tv = (TextView)findViewById(R.id.packname_tv);
        packname_tv.setText(BuildConfig.APPLICATION_ID);

    }
}
