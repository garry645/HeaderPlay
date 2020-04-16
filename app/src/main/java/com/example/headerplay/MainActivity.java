package com.example.headerplay;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    protected static DrawerLayout drawerLayout;

    static Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;
    protected static AppBarConfiguration appBarConfiguration;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.oneFragment, R.id.twoFragment)
                        .setDrawerLayout(drawerLayout).build();
        navController = Navigation.findNavController(this, R.id.navHostFrag);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);






      /*  //drawerLayout = findViewById(R.id.fragmentOneDrawerLayout);
        NavController navController = Navigation.findNavController(this, R.id.navHostFrag);
        //NavigationView navigationView = findViewById(R.id.nav_view);
        //DrawerLayout drawerLayout = binding.fragmentOneDrawerLayout;
        appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.oneFragment, R.id.twoFragment)
                        .build();
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        *//*setSupportActionBar(toolbar);*//*
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.oneFragment) {
                    //drawerLayout.setVisibility(View.VISIBLE);
                } else {
                    //drawerLayout.setVisibility(View.GONE);
                }
            }
        });*/

    }

    /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.na);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.oneFragment) {
            navController.navigate(R.id.twoFragment);
        }


        if(id == R.id.twoFragment) {
           navController.navigate(R.id.oneFragment);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }

    public static void enableNavDrawer() {
        toolbar.setVisibility(View.VISIBLE);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public static void disableNavDrawer() {
        toolbar.setVisibility(View.INVISIBLE);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void showFragment(Fragment fragment) {
        navController.navigate(R.id.oneFragment);
    }
}
