package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.facebook.drawee.view.SimpleDraweeView;

import techo.apps.isi.uca.com.android_aps.R;

public class DetailMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_message);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SimpleDraweeView avatar = findViewById(R.id.avatar);
        avatar.setImageURI("https://avatars3.githubusercontent.com/u/13529689?s=400&u=7e716ae5a9be7dcfdbb66e4f880b8550c4c90105&v=4");

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
