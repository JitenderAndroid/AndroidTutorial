package com.jitenderkumar.demoducat.imagevideo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jitenderkumar.demoducat.R;

import java.io.IOException;

public class ImageVideoActivity extends AppCompatActivity {

    private int REQUEST_CAMERA = 101;
    private int REQUEST_GALLERY = 102;
    private ImageView imagePreview;
    public static Uri videoUri;

    // 1. record audio and video
    // 2. intent to record video
    // 3. read and write image exif details
    // 4. multimedia supported formats
    // 5. control playback

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_video);

        Button buttonPick = findViewById(R.id.btn_pick);
        Button buttonGo = findViewById(R.id.btn_go);
        imagePreview = findViewById(R.id.image_preview);

        buttonPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ImageVideoActivity.this, VideoActivity.class));
            }
        });
    }

    void onPickMedia() {
    }

    private void selectImage() {
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Upload Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals(items[0])) {
                    cameraIntent();
                } else if (items[item].equals(items[1])) {
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    0);
            return;
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"), REQUEST_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 101:
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                imagePreview.setImageBitmap(thumbnail);
                break;
            case 102:
                Bitmap bm=null;
                Uri uri = data.getData();

                Log.e("uri", ""+uri);

                videoUri = uri;
                if (data != null) {
                    try {
                        bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                        imagePreview.setImageBitmap(bm);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
