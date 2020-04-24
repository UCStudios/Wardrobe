package com.ucstudios.wardrobe;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int i =1;
    int itemnumber=0;
    public String Name;
    public String TechShit;
    BottomNavigationView bottomNavigation;
    DatabaseHelper mDatabaseHelper;
    ArrayList<String> Categories ;
    ArrayList<String> Items;
    Bitmap imagepreview;
    int positionaftweswapcateg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabaseHelper = new DatabaseHelper(this);
        Cursor C = mDatabaseHelper.getData();
        int controlloiniziale=0;
        while (C.moveToNext()){
            controlloiniziale++;
        }
        if(controlloiniziale==0){
            FirstOpenDialog dialog = new FirstOpenDialog(this);
            dialog.show();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(SmsFragment.newInstance("", ""));
        bottomNavigation.setSelectedItemId(R.id.navigation_sms);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return onOptionsItemSelected(item);
    }


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }




    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {




                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_sms:
                            openFragment(SmsFragment.newInstance("", ""));

                            return true;
                        case R.id.navigation_notifications:
                            openFragment(NotificationFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public void onClick(View v) {

    }





}
