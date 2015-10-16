package com.androidhub4you.fragmentdemo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Manish Srivastava
 */

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("<<main activity>>", "<<screen>>");

        //display home back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //In side Create method of MainActivity we will add main fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FragmentMain fragmentMain = new FragmentMain();
        transaction.addToBackStack("fragmentMain");
        transaction.replace(R.id.container, fragmentMain);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                handleBackStack();
                break;
            case R.id.action_settings:
                //do nothing
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //handle back stack from hardware back button and top action bar home back button
    public boolean handleBackStack() {
        //on back press check the count of fragment in stack
        int count = getFragmentManager().getBackStackEntryCount();
        Log.v("<<Fragment in stack>>",String.valueOf(count));
        if (count == 1) {
            //if count is 0 then finish main activity
            finish();
        }else {
            //else remove one fragment from the stack
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            getFragmentManager().popBackStackImmediate();
            transaction.commit();
        }
        return true;
    }

    //set action bar title name
    public void setActionBarTitle(String title) {
       getSupportActionBar().setTitle(title);
    }
    //handle the hardware back press
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            handleBackStack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
