package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tumblr.remember.Remember;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.api.Api;
import techo.apps.isi.uca.com.android_aps.models.AccessToken;
import techo.apps.isi.uca.com.android_aps.models.UserModel;
import techo.apps.isi.uca.com.android_aps.ui.dialog.SyncUpCatalogDialogFragment;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Remember.init(getApplicationContext(),"techo.apps.isi.uca.com.android_aps.ui.activities");
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //Call all the necessary methods
        validateSession();
        initViews();
        initActions();

    }

    /**
     * To get references of the view elements
     */
    private void initViews() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.buttom_login);

    }



    private void login() {
        String nickname = String.valueOf(username.getText().toString());
        String pass= String.valueOf(password.getText().toString());
        if(nickname.equals("") || pass.equals("")) {
            Toast.makeText(getApplicationContext(),"No puede dejar campos vacíos",Toast.LENGTH_SHORT).show();
        }else{
            UserModel userModel = new UserModel();
            userModel.setUsername(username.getText().toString());
            userModel.setPassword(password.getText().toString());
            saveUserData(nickname,pass);
            Call<AccessToken> AccessTokenCall =Api.instance().loginUser(userModel);
            AccessTokenCall.enqueue(new Callback<AccessToken>() {
                @Override
                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                    if(response.isSuccessful()) {
                        Remember.putString("access_token", response.body().getToken(), new Remember.Callback() {
                            @Override
                            public void apply(Boolean success) {
                                SyncUpCatalogDialogFragment dialog = SyncUpCatalogDialogFragment.newInstance();
                                dialog.setCancelable(false);
                                dialog.show(getFragmentManager(), "");
                                Toast.makeText(getApplicationContext(), "Sesión iniciada", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                    }else{
                        Toast.makeText(getApplicationContext(),"Ocurrió un error al iniciar sesión",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    Log.e("Err","Ocurrió un error al iniciar sesión", t);

                }
            });

        }
    }
    public void saveUserData(String u, String p){

        SharedPreferences sharedPreferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",u);
        editor.putString("password",p);

        editor.commit();
    }
    private void initActions() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void validateSession() {
        if (!Remember.getString("access_token", "").isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
