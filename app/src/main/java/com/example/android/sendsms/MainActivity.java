package com.example.android.sendsms;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements EditSMSFragment.OnFragmentInteractionListener{
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setDrawerView();
    }

    private void setDrawerView() {
        final DrawerLayout drawer= (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        toggle.syncState();
        NavigationView navigationView= (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.smsItem_menu:{
                        getSupportFragmentManager().beginTransaction().add(R.id.frag_container,new EditSMSFragment()).commit();
                        break;
                    }
                    case R.id.picItem_menu:{
                        break;
                    }
                }
                drawer.closeDrawers();
                return true;
            }
        });
    }

    private void setToolbar() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(String msg,int number) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"+number));
        intent.putExtra("sms_body",msg);
        startActivity(intent);
    }
}
