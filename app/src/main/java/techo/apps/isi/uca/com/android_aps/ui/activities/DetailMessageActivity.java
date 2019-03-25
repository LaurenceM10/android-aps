package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.facebook.drawee.view.SimpleDraweeView;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.ui.adapters.ChatMessageAdapter;

public class DetailMessageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_message);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SimpleDraweeView avatar = findViewById(R.id.avatar);
        avatar.setImageURI("https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_960_720.png");

        initViews();
        initActions();
        setupRecyclerView();
        fetchMessages();
    }

    /**
     * To get references of the view elements
     */
    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    /**
     * To init action when events occur on the elements
     */
    private void initActions() {

    }

    /**
     * To setup the recycler view
     */
    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.smoothScrollToPosition(0);
    }

    /**
     * To fetch the messages of a chat
     */
    private void fetchMessages() {
        //static data
        recyclerView.setAdapter(new ChatMessageAdapter());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
