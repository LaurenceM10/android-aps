package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.ui.fragments.ChatFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.ExperienceFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.UserFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call all the necessary methods
        initViews();
        configureViewElements();
        initActions();

        //Set default home item selected
        setDefaultItemSelected();
    }


    /**
     * To get references of the view elements
     */
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        floatingActionButton = findViewById(R.id.fab);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    /**
     * To initiate actions when events occur on the elements
     */
    private void initActions() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "We are working", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * To configure some elements of the activity
     */
    private void configureViewElements() {
        //set the support for the action bar
        setSupportActionBar(toolbar);

        //Configure the ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Setup the navigation view
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
        getMenuInflater().inflate(R.menu.main, menu);
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
        Class fragmentClass = null;

        if (id == R.id.nav_home) {
            fragmentClass = ExperienceFragment.class;
        } else if (id == R.id.nav_chat) {
            fragmentClass = ChatFragment.class;
        } else if (id == R.id.nav_users) {
            fragmentClass = UserFragment.class;
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (id == R.id.nav_logout) {
            logout();
        }

        //Replace the fragment in the activity
        replaceFragment(fragmentClass);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * To replace the fragments
     */
    private void replaceFragment(Class fragmentClass){
        /**
         * Here we replace the fragments. These will be hosted in a FrameLayout
         * that is inside the content_main (layout).
         */
        try {
            //can be null
            assert fragmentClass != null;
            Fragment fragment = (Fragment) fragmentClass.newInstance();

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * Set the selected home element by default when you start the application
     */
    private void setDefaultItemSelected(){
        // Selected by default
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));

        // Checked by default
        onNavigationItemSelected(navigationView.getMenu().getItem(0).setChecked(true));
    }


    /**
     * To close the session
     */
    private void logout(){
        startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }
}
