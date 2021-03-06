package com.ultron.tamu_carpool;

import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.amap.api.maps2d.MapsInitializer;

import com.ultron.tamu_carpool.login.LoginActivity;
import com.ultron.tamu_carpool.ctrlcenter.CtrlCenterActivity;
import com.ultron.tamu_carpool.usr.User;
public class MainActivity extends AppCompatActivity {

    private String user_id;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentlogin = new Intent(MainActivity.this,LoginActivity.class);
        startActivityForResult(intentlogin, 1);
        //startActivity(new Intent(MainActivity.this,LoginActivity.class));
        //LoginActivity.finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            int userType = data.getIntExtra("usertype", 1);
            String id = data.getStringExtra("id");
            User user = new User(id, userType);
            Intent intentCtrlCenter = new Intent(MainActivity.this, CtrlCenterActivity.class);
            intentCtrlCenter.putExtra("user", user);
            startActivity(intentCtrlCenter);
        }
    }


}
