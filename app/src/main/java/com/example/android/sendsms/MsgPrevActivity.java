package com.example.android.sendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MsgPrevActivity extends AppCompatActivity {
    TextView previewTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_prev);
        previewTV= (TextView) findViewById(R.id.previewTV);
        String msg=getIntent().getExtras().getString("sms_body","error");
        previewTV.setText(msg);
    }
}
