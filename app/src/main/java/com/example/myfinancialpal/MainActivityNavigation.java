package com.example.myfinancialpal;

import android.app.FragmentManager;
import android.os.Bundle;

import com.example.myfinancialpal.Adapter.FragmentsAdapter;
import com.example.myfinancialpal.Model.Income;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.annotations.NotNull;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivityNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentsAdapter fragmentsAdapter;
    ViewPager viewPager_contentMain;
    Fragment fragmentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     //   viewPager_appBar = (ViewPager) findViewById(R.id.page_container);

       // fragmentHolder = findViewById(R.id.fragment_holder);
        setContentView(R.layout.activity_main_navigation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        viewPager_contentMain =  findViewById(R.id.page_holder);


        fragmentsAdapter = new FragmentsAdapter(getSupportFragmentManager());

       // setupViewPager(viewPager_appBar);
        setupViewPager(viewPager_contentMain);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.main_activity_navigation, menu);
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
            Toast.makeText(getApplicationContext(), "celalalt meniu ai", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            setViewPager(0);
            Toast.makeText(getApplicationContext(), "Home page", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_income) {

            //TODO bind fragment to activity when menuItem is selected
            setViewPager(1);
            //viewPager.setCurrentItem(1);
            Toast.makeText(this, "income menu item", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_cost) {
            setViewPager(2);
            //viewPager.setCurrentItem(2);
            Toast.makeText(this, "cost menu item", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_statistics) {
            //TODO create fragment then setup in viewPager
           // viewPager.setCurrentItem(4);
            Toast.makeText(this, "statistics menu item", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_settings) {
            //TODO create fragment then setup in viewPager
          //  viewPager.setCurrentItem(5);
            Toast.makeText(this, "settings menu item", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_help) {
            //TODO create fragment then setup in viewPager
          //  viewPager.setCurrentItem(6);
            Toast.makeText(this, "help menu item", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void setupViewPager(ViewPager viewPager){
        FragmentsAdapter adapter = new FragmentsAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment(), "Acasa");
        adapter.addFragment(new AmountList(), "Venituri");
        adapter.addFragment(new AmountList(), "Cheltuieli");
        adapter.addFragment(new AddAmountFragment(), "Suma noua");

        //TODO creaza fragmentele
     /*
        adapter.addFragment(new StatisticsFragment(), "Statistici");
        adapter.addFragment(new SettingsFragment(), "Setari");
        adapter.addFragment(new HelpFragment(), "Ajutor");
      */

        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
    //    viewPager_appBar.setCurrentItem(fragmentNumber);
        viewPager_contentMain.setCurrentItem(fragmentNumber);
    }
}
