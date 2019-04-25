package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.tumblr.remember.Remember;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

import javax.inject.Inject;

import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techo.apps.isi.uca.com.android_aps.ApplicationProject;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.api.Api;
import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;
import techo.apps.isi.uca.com.android_aps.models.Student;
import techo.apps.isi.uca.com.android_aps.ui.fragments.ChatFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.ExperienceFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.MainFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.UserFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView avatar_menu;
    private TextView userNameTextView;
    private TextView emailTextView;
    private String userName;
    private String email;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
        //inject activity main using dagger
        ApplicationProject.getInjectComponent(this).inject(this);
        setContentView(R.layout.activity_main);

        //binding view
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        //init default fragment (home)
        Fragment mainFragment = new MainFragment();
        openFragment(mainFragment);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initViews();
        initActions();

        //Set default home item selected
        setDefaultItemSelected();

        fillUserInfo();
    }

    private void initViews() {
        avatar_menu = findViewById(R.id.avatar_menu);
        userNameTextView = findViewById(R.id.username_menu);
        emailTextView = findViewById(R.id.email_menu);
    }

    /**
     * To initiate actions when events occur on the elements
     */
    private void initActions() {
        floatingActionButton.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "We are working", Toast.LENGTH_SHORT).show());


    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
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

        if (id == R.id.nav_home) {
            Fragment homeFragment = new ExperienceFragment();
            openFragment(homeFragment);
        } else if (id == R.id.nav_chat) {
            Fragment chatFragment = new ChatFragment();
            openFragment(chatFragment);
        } else if (id == R.id.nav_users) {
            Fragment userFragment = new UserFragment();
            openFragment(userFragment);
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (id == R.id.nav_logout) {
            logout();
        }

        //Close navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        //set checked item by id
        navigationView.setCheckedItem(item.getItemId());
        return true;
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

    private void openFragment(Fragment fragment) {
        openFragment(fragment, false);
    }

    private void openFragment(Fragment fragment, boolean anim) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (anim) {
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        }

        fragmentTransaction.replace(R.id.content_frame, fragment);

        FragmentManager manager = getSupportFragmentManager();

        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        fragmentTransaction.commit();

    private void fillUserInfo(){
        Call<Student> callStudent = Api.instance().getStudentById("Bearer "+ Remember.getString("access_token",""), Remember.getInt("id",0));
        callStudent.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) {
                    userName = response.body().getName();
                    email = response.body().getEmails();

                    setDataMenu();

                    Toast.makeText(getApplicationContext(), "Request successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "An error occurred while getting user info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.e("Err", "An error occurred while getting user info", t);
            }
        });

    }

    private void setDataMenu(){
        //To set dinamically data in the drawer menu
        View header = navigationView.getHeaderView(0);
        avatar_menu = header.findViewById(R.id.avatar_menu);

        userNameTextView = header.findViewById(R.id.username_menu);
        userNameTextView.setText(userName);

        emailTextView = header.findViewById(R.id.email_menu);
        emailTextView.setText(email);

    }
}
