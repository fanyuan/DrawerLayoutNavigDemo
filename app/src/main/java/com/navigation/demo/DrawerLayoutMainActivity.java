package com.navigation.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DrawerLayoutMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_main);
    }
    public void doclick(View view){
        int id = view.getId();
        switch (id){
            case R.id.drawer_layout_simple:
                startActivity(new Intent(getApplicationContext(),DrawerLayoutSimpleActivity.class));
                break;
            case R.id.drawer_layout_below:
                startActivity(new Intent(getApplicationContext(),DrawerLayoutBelowToolbarActivity.class));
                break;
            case R.id.drawer_layout_layout:
                startActivity(new Intent(getApplicationContext(),DrawerLayoutOtherActivity.class));
                break;
        }

    }
}
