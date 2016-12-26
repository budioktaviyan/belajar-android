package com.baculsoft.belajarandroid.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.baculsoft.belajarandroid.R;
import com.baculsoft.belajarandroid.views.fragments.DetailFragment;
import com.baculsoft.belajarandroid.views.fragments.HomeFragment;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainActivity extends AppCompatActivity {
    MenuItem mMenuItem;
    DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nv_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
                        mMenuItem = menuItem;
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        return true;
                    }
                });

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(final View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(final View drawerView) {
                super.onDrawerClosed(drawerView);

                if (null != mMenuItem) {
                    switchNavigationMenu(mMenuItem.getItemId());
                }
            }

            @Override
            public void onDrawerSlide(final View drawerView, final float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                if (null != drawerView && drawerView == navigationView) {
                    super.onDrawerSlide(drawerView, 0);
                } else {
                    super.onDrawerSlide(drawerView, slideOffset);
                }
            }
        };

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
        showHomeFragment();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            finish();
        }
    }

    public void switchNavigationMenu(final int itemId) {
        switch (itemId) {
            case R.id.menu_home: {
                showHomeFragment();
                break;
            }
            case R.id.menu_detail: {
                showDetailFragment();
                break;
            }
        }
    }

    private int getStatusBarHeight() {
        final int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? getResources().getDimensionPixelSize(resourceId) : 0;
    }

    private void showHomeFragment() {
        final String tag = HomeFragment.class.getSimpleName();

        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            final Fragment fragment = new HomeFragment();
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_main, fragment, tag);
            fragmentTransaction.commit();
        }
    }

    private void showDetailFragment() {
        final String tag = DetailFragment.class.getSimpleName();

        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            final Fragment fragment = new DetailFragment();
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_main, fragment, tag);
            fragmentTransaction.commit();
        }
    }
}