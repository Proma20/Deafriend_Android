package com.mist.edu.deaf2riend;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class actionradio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView home;
    Button prcd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionradio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home=(ImageView) findViewById(R.id.imageView4);
        home.setClickable(true);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(actionradio.this,activate.class);
                startActivity(i);
            }
        });

        prcd=(Button)findViewById(R.id.button3) ;
        prcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(actionradio.this,record4.class);
                startActivity(i);
            }
        });



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
        getMenuInflater().inflate(R.menu.actionradio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.choose_action2) {
            Intent i=new Intent(actionradio.this,actionradio.class);
            startActivity(i);
        }  if (id == R.id.convert_voice2) {
            Intent i=new Intent(actionradio.this,voice_con.class);
            startActivity(i);

        } if (id == R.id.flash_allert2) {
            Intent i=new Intent(actionradio.this,flashalert.class);
            startActivity(i);

        }  if (id == R.id.how_use2) {
            Intent i=new Intent(actionradio.this,Howtouse.class);
            startActivity(i);

        } if (id == R.id.about_us2) {
            Intent i=new Intent(actionradio.this,Aboutus.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton7:
                if (checked)
                {  prcd=(Button)findViewById(R.id.button3) ;
                prcd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(actionradio.this,record4.class);
                        startActivity(i);
                    }
                });}
                    break;
            case R.id.radioButton5:
                if (checked)
                { prcd=(Button)findViewById(R.id.button3) ;
                    prcd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(actionradio.this,record4.class);
                            startActivity(i);
                        }
                    });}
                    break;
            case R.id.radioButton6:
                if (checked)
                {
                    prcd=(Button)findViewById(R.id.button3) ;
                    prcd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(actionradio.this,record4.class);
                            startActivity(i);
                        }
                    });
                }
                    break;
        }
    }


}
