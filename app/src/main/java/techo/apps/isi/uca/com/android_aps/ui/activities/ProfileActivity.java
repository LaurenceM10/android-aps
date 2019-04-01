package techo.apps.isi.uca.com.android_aps.ui.activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import techo.apps.isi.uca.com.android_aps.R;

public class ProfileActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE=1001;
    Uri image_Uri;
    private ImageButton imageButton_settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        //OnClickListener of the settings button
        imageButton_settings.setOnClickListener(v -> showDialog());

    }

    private void initViews() {
        imageButton_settings = findViewById(R.id.profile_image);
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
        ADBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();//Close the dialog
            }
        });

        //Capture 'OnClick' event from the dialog items
        ADBuilder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int _item) {

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
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);

                }
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
                    imageButton_settings.setImageBitmap(bitmap);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }else{
                imageButton_settings.setImageURI(image_Uri);
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
}
