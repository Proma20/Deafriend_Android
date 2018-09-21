package com.mist.edu.deaf2riend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class record4 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView rcrd;
    ImageView play;
    ImageView stop;
    ImageView home;
    private static final String LOG_TAG = "AudioRecordTest";
    private MediaRecorder myAudio;
    private String outputFile=null;

    private StorageReference mStorage;
    private ProgressDialog mprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        home=(ImageView) findViewById(R.id.home);
        stop=(ImageView)findViewById(R.id.imageView10);
        play=(ImageView)findViewById(R.id.imageView9);
        rcrd=(ImageView)findViewById(R.id.imageView3);
        mStorage= FirebaseStorage.getInstance().getReference();
        mprogress=new ProgressDialog(this);


///////////////////output file jekhane save hobe
        outputFile= Environment.getExternalStorageDirectory().getAbsolutePath();
        outputFile+="/myrecord.3gp";


        home.setClickable(true);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(record4.this,activate.class);
                startActivity(i);
            }
        });

        rcrd.setClickable(true);
        rcrd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                       // Toast.makeText(getApplicationContext(),"Recording prb",Toast.LENGTH_LONG).show();
                                        try{

                                            myAudio=new MediaRecorder();
                                            myAudio.setAudioSource(MediaRecorder.AudioSource.MIC);
                                            myAudio.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                                            myAudio.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                                            myAudio.setOutputFile(outputFile);
                                            myAudio.prepare();
                                            myAudio.start();



                                        }catch (IllegalStateException ise){
                                            Log.e(LOG_TAG, "prepare(gghhhjjj) failed");

                                        }catch (IOException ioe){
                                            Log.e(LOG_TAG, "prepare() failed");

                                        }


                                        Toast.makeText(getApplicationContext(),"Recording Started",Toast.LENGTH_LONG).show();


                                    }
                                }
        );

        stop.setClickable(true);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    myAudio.stop();
                    myAudio.release();
                    myAudio=null;
                }catch (IllegalStateException ise){
                    Log.e(LOG_TAG, "prepare() failed");

                }


                Toast.makeText(getApplicationContext(),"Recording sucessful!",Toast.LENGTH_LONG).show();

            }
        });



        play.setClickable(true);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp=new MediaPlayer();

                try {
                    mp.setDataSource(outputFile);
                    mp.prepare();
                } catch (IllegalStateException ise){

                }catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();


                }

                mp.start();
                Toast.makeText(getApplicationContext(),"Playing",Toast.LENGTH_LONG).show();



            }
                                }

        );





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.record4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
          //  Toast.makeText(getApplicationContext(),"ok fine",Toast.LENGTH_LONG).show();



            StorageReference filpath=mStorage.child("Audio1").child("myrecord.3gp");
            Uri uri=Uri.fromFile(new File(outputFile));

            mprogress.setMessage("Uploading Audio.....");
            mprogress.show();

            filpath.putFile(uri).addOnSuccessListener(record4.this,new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mprogress.dismiss();
                    Toast.makeText(getApplicationContext(),"Uploading Finished",Toast.LENGTH_LONG).show();


                }
            });
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.choose_action1) {
            Intent i=new Intent(record4.this,actionradio.class);
            startActivity(i);
        }  if (id == R.id.convert_voice1) {
            Intent i=new Intent(record4.this,voice_con.class);
            startActivity(i);

        } if (id == R.id.flash_allert1) {
            Intent i=new Intent(record4.this,flashalert.class);
            startActivity(i);

        }  if (id == R.id.how_use1) {
            Intent i=new Intent(record4.this,Howtouse.class);
            startActivity(i);

        } if (id == R.id.about_us1) {
            Intent i=new Intent(record4.this,Aboutus.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
