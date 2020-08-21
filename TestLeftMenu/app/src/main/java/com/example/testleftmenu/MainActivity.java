package com.example.testleftmenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled( true );
        actionBar.setHomeAsUpIndicator( R.drawable.ic_baseline_dehaze_24 );
        drawerLayout = findViewById( R.id.drawerlayout );
        navigationView = findViewById( R.id.nav_view );

        drawerToggle = new ActionBarDrawerToggle( this, drawerLayout, R.string.drawer_open, R.string.drawer_close );
        drawerLayout.setDrawerListener( drawerToggle );
        Button btn1,btn2,btn3;
        btn1 = findViewById( R.id.btn1 );
        btn2 = findViewById( R.id.btn2 );
        btn3 = findViewById( R.id.btn3 );
        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment( Fragment_1.newInstance() );
                drawerLayout.closeDrawers();
            }
        } );
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment( Fragment_2.newInstance() );
                drawerLayout.closeDrawers();
            }
        } );
        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment( Fragment_3.newInstance() );
                drawerLayout.closeDrawers();
            }
        } );
        getFragment( Fragment_1.newInstance() );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater( this );
        menuInflater.inflate( R.menu.menu, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected( item ))
            return true;
        return super.onOptionsItemSelected( item );
    }
        @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate( savedInstanceState );
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged( newConfig );
        drawerToggle.onConfigurationChanged( newConfig );
    }
    public void getFragment(Fragment fragment){
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }
}