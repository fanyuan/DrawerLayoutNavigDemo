package com.navigation.demo;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DrawerLayoutBelowToolbarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_below_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //这是带Home旋转开关按钮
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //这是不带Home旋转开关按钮
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);//drawer.setDrawerListener(toggle);
        toggle.syncState();//该方法会自动和Toolbar关联, 将开关的图片显示在了Toolbar上

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //Log.d("debug","onDrawerSlide slideOffset --- " + slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.d("debug","onDrawerOpened ");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.d("debug","--- onDrawerClosed --- " );
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                String state = "";

                if(newState == DrawerLayout.STATE_DRAGGING){
                    state = "STATE_DRAGGING";
                }else if (newState == DrawerLayout.STATE_IDLE){
                    state = "STATE_IDLE";
                }else if (newState == DrawerLayout.STATE_SETTLING){
                    state = "STATE_SETTLING";
                }

                Log.d("debug","onDrawerStateChanged newState --- " + state);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {

        Toast.makeText(this,"onNavigationItemSelected",Toast.LENGTH_SHORT).show();

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
