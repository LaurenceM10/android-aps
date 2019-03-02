package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import techo.apps.isi.uca.com.android_aps.api.ApiInterface;
import techo.apps.isi.uca.com.android_aps.models.AccessToken;
import techo.apps.isi.uca.com.android_aps.models.UserModel;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Remember.init(getApplicationContext(),"techo.apps.isi.uca.com.android_aps.ui.activities");
      //  Remember.init(getApplicationContext(),"techo.apps.isi.uca.com.android_aps.ui.activities");

        //Call all the necessary methods
        initViews();

    }

    /**
     * To get references of the view elements
     */
    private void initViews() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }



    private void login() {
        String nickname = String.valueOf(username.getText().toString());
        String pass= String.valueOf(password.getText().toString());
        if(nickname.equals("") || pass.equals("")) {
            Toast.makeText(getApplicationContext(),"Can't leave empty fields",Toast.LENGTH_SHORT).show();
        }else{
            UserModel userModel = new UserModel();
            userModel.setUsername(username.getText().toString());
            userModel.setPassword(password.getText().toString());
            saveUserData(nickname,pass);
            Call<UserModel> AccessTokenCall =Api.instance().loginUser(userModel);
            AccessTokenCall.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    if(response.isSuccessful()) {
                        Remember.putString("access_token", response.body().getId(), new Remember.Callback() {
                            @Override
                            public void apply(Boolean success) {
                                Toast.makeText(getApplicationContext(), "Success to login", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }else{
                        Toast.makeText(getApplicationContext(),"An error occur while login was doing",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    Log.e("Err","An error occur while                    login was doing", t);

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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttom_login:
                login();
                break;
           /*Recovery
            case :

                break;*/
        }


    }



}
