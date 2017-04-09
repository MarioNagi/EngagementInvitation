package com.kimbshkorp.minaengagement;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Slideshow extends AppCompatActivity {
    private AudioManager audioManager;
    private MediaPlayer mediaPlayer;
     int NUM_PAGES=9;
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    int currentPage = 0;
    boolean isplaying=true;
    private static final String TAG = "MyActivity";
   // Timer timer;
   // final long DELAY_MS = 3500;//delay in milliseconds before task is to be executed
  //  final long PERIOD_MS = 5000; // time in milliseconds between successive task executions.

    @Override
    protected void onStop() {
        mediaPlayer.release();
        super.onStop();
    }

    @Override
    protected void onStart() {
        mediaPlayer.start();
         super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);
        Toast.makeText(this,"Swipe to the left",Toast.LENGTH_LONG).show();
        mediaPlayer = MediaPlayer.create(this, R.raw.letmeloveyou);

         viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter= new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });
        /*   Log.v(TAG,"if current page value is "+currentPage);
        if (currentPage == NUM_PAGES-1)
        {
            currentPage = 0;
            mediaPlayer.pause();
            mediaPlayer.release();

        }
        else{

            viewPager.setCurrentItem(currentPage++, true);
            Log.v(TAG,"else current page value is "+currentPage);} */}
       /*  final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                Log.v(TAG,"current page value is "+currentPage);
                if (currentPage == NUM_PAGES-1)
                {
                    currentPage = 0;
                    mediaPlayer.pause();
                    mediaPlayer.release();

                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };}

     //   timer = new Timer(); // This will create a new Thread
     /*   timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 3000);

    }
*/


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_settings){
            mediaPlayer.release();

            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        }
        else if (id == R.id.action_face){
            mediaPlayer.release();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/shabab.cairod"));
            startActivity(intent);}

        return super.onOptionsItemSelected(item);
    }


}

