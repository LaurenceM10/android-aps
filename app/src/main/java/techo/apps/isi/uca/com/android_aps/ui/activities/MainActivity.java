package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import techo.apps.isi.uca.com.android_aps.ApplicationProject;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;
import techo.apps.isi.uca.com.android_aps.ui.fragments.ChatFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.ExperienceFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.UserFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Inject
    AppDatabase appDatabase;

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationProject.getInjectComponent(this).inject(this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        //Fragment mainFragment = new MainFragment();
        //openFragment(mainFragment);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initActions();

        //Set default home item selected
        setDefaultItemSelected();
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

        clearSelected();


        navigationView.getMenu().findItem(id).setChecked(true);
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

    private void clearSelected() {

        navigationView.getMenu().findItem(R.id.nav_home).setChecked(false);
        navigationView.getMenu().findItem(R.id.nav_chat).setChecked(false);
        navigationView.getMenu().findItem(R.id.nav_logout).setChecked(false);

        navigationView.getMenu().findItem(R.id.nav_profile).setChecked(false);
        navigationView.getMenu().findItem(R.id.nav_users).setChecked(false);
    }
}
