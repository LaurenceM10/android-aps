package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import techo.apps.isi.uca.com.android_aps.R;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Call all the necessary methods
        initViews();
        initActions();
    }

    /**
     * To get references of the view elements
     */
    private void initViews() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }


    /**
     * To initiate actions when events occur on the elements
     */
    private void initActions() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }


    /**
     * To login with username and password
     */
    private void doLogin() {
        if (!validateEmptyFields()) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }
    }


    /**
     * To validate empty fields in login
     *
     * @return false if there is one or more empty elements
     * and true if the fields are completed
     */
    private boolean validateEmptyFields() {
        if (username.getText().toString().isEmpty()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return true;
        } else if (password.getText().toString().isEmpty()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

}
