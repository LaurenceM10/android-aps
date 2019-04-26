package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.navigation.NavigationView;
import com.tumblr.remember.Remember;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.api.Api;
import techo.apps.isi.uca.com.android_aps.api.ApiInterface;
import techo.apps.isi.uca.com.android_aps.models.AccessToken;
import techo.apps.isi.uca.com.android_aps.models.Person;
import techo.apps.isi.uca.com.android_aps.models.Student;
import techo.apps.isi.uca.com.android_aps.models.UserModel;

public class ProfileActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE=1001;
    Uri image_Uri;
    private ImageButton imageButton_settings;
    ImageView addImageMenu;

    private TextView userNameTextView;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
        Glide.with(getApplicationContext()).load(R.drawable.profile_img_placeholder).apply(new RequestOptions().circleCrop()).into(imageButton_settings);

        initActions();
        fillUserInfo();

    }

    private void initViews() {
        addImageMenu = findViewById(R.id.add_image_menu);
        imageButton_settings = findViewById(R.id.profile_image);

        userNameTextView = findViewById(R.id.userName_textView);
    }

    private void initActions(){
        //OnClickListener of the settings button
        //imageButton_settings.setOnClickListener(v -> );
        addImageMenu.setOnClickListener(view -> {
            showDialog();
        });
        imageButton_settings.setOnClickListener(view -> showDialogPreviewImage());
    }

    private void showDialog(){

        //Create a new AlertDialog.Builder with the context as parameter
        AlertDialog.Builder ADBuilder = new AlertDialog.Builder(ProfileActivity.this);

        ADBuilder.setIcon(R.drawable.ic_settings);//Icon of the dialog
        ADBuilder.setTitle("Elija una opción");//message tittle

        //Create a new 'Strings' ArrayAdapter with parameters (Contexto, int id "Referencia a layout");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(ProfileActivity.this,android.R.layout.select_dialog_singlechoice);

        //Add the items that we are going to show
        arrayAdapter.add("Cámara");
        arrayAdapter.add("Galería");

        //Create a dismiss button
        ADBuilder.setNegativeButton("Cancelar", (dialog, which) -> {
            dialog.dismiss();//Close the dialog
        });

        //Capture 'OnClick' event from the dialog items
        ADBuilder.setAdapter(arrayAdapter, (dialog, _item) -> {

            //Create the If to show the selected item
            if (_item == 0) { //Camera
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA)==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                                    PackageManager.PERMISSION_DENIED){
                        String [] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else{
                        //Open camera
                        openCamera();
                    }
                }
                else {
                    //Open camera
                    openCamera();
                }
            } else if (_item == 1) {//gallery
                //open gallery
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);

            }
        });

        ADBuilder.show();//Show the dialog
    }

    private void openCamera() {
        ContentValues values= new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the camera");
        image_Uri= getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,image_Uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }



    //Maping the image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            if (data != null) {
                Uri uri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    // imageButton where you want to set image
                    //imageButton_settings.setImageBitmap(bitmap);
                    Glide.with(getApplicationContext())
                            .load(uri).apply(new RequestOptions()
                            .circleCrop()).into(imageButton_settings);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }else{
                //imageButton_settings.setImageURI(image_Uri);
                Glide.with(getApplicationContext()).load(image_Uri).apply(new RequestOptions().circleCrop()).into(imageButton_settings);
            }
        }

    }

    //Permissions to access the camera
    // private static final int MY_CAMERA_REQUEST_CODE = 100;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length >0 && grantResults [0]==
                        PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }else{
                    Toast.makeText(this, "PERMISSION DENIED....",Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void showDialogPreviewImage(){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.dialog_preview_image, null); // The view that contains the ImageView we will use.
        ImageView previewImage = view.findViewById(R.id.preview_profile_image); // This is the ImageView that we need to send link into.

        // Through Glide library load uri (is image's URL) into ImageView.
        Glide.with(this).load(imageButton_settings.getDrawable()).apply(new RequestOptions().optionalCenterInside()).into(previewImage);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Black_NoTitleBar); // Here we change the theme of AlertDialog
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        if(view.getParent() != null) {
            ((ViewGroup)view.getParent()).removeView(view);
        }
        dialog.setView(view); // We say to the dialog that it will show the ImageView.
        dialog.show(); // Open the dialog.
    }

    private void fillUserInfo(){
        Call<Student> callStudent = Api.instance().getStudentById("Bearer "+ Remember.getString("access_token",""),
                1129);
        callStudent.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) {

                    Log.i("Debug",response.body().toString());

                    String name = response.body().getName();
                    userNameTextView.setText(name);



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

    }

}
