package com.example.android.sendsms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,EditSMSFragment.OnFragmentInteractionListener{
    MenuFragment menuFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragment=new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainLayout,menuFragment).commit();
    }



    @Override
    public void onFragmentInteraction() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout,new EditSMSFragment()).commit();
    }

    @Override
    public void onFragmentInteraction(String msg) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("sms_body",msg);
        startActivity(intent);
    }
}
