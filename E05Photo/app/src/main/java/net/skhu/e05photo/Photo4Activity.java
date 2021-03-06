package net.skhu.e05photo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Photo4Activity extends AppCompatActivity {

    OnBackPressedCallback backPressedCallback = new OnBackPressedCallback(false) {
        @Override
        public void handleOnBackPressed() {
            button.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            this.setEnabled(false);
        }
    };

    ImageView imageView;
    FloatingActionButton button;
    FileRecyclerView3Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo4);
        setSupportActionBar(findViewById(R.id.toolbar));

        button = findViewById(R.id.btnTakePhoto);
        button.setOnClickListener((view) -> startActivity_takePhoto());

        imageView = findViewById(R.id.imageView1);
        imageView.setVisibility(View.GONE);
        imageView.setOnClickListener((view) -> {
            button.setVisibility(View.VISIBLE);
            view.setVisibility(View.GONE);
            backPressedCallback.setEnabled(false);
        });

        File directory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File[] files = directory.listFiles();

        OnFileClickListener clickListener = (index, file) -> {
            button.setVisibility(View.INVISIBLE);
            imageView.setImageURI(Uri.fromFile(file));
            imageView.setVisibility(View.VISIBLE);
            backPressedCallback.setEnabled(true);
        };
        OnFileShareListener shareListener = (index, file) -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            Uri uri = FileProvider.getUriForFile(this, AUTHORITIES, file);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.setType("image/jpeg");
            startActivity(Intent.createChooser(intent, "사진 공유"));
        };
        adapter = new FileRecyclerView3Adapter(this, files, clickListener, shareListener);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        getOnBackPressedDispatcher().addCallback(backPressedCallback);
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        String imageFileName = "PHOTO" + timeStamp + ".jpg";
        File directory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return new File(directory, imageFileName);
    }

    static final int RC_TAKE_PHOTO = 1;
    File cameraFile;
    static final String AUTHORITIES = "net.skhu.e05photo.fileProvider";

    private void startActivity_takePhoto() {
        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) == null) return;
            cameraFile = createImageFile();
            Uri uri = FileProvider.getUriForFile(this, AUTHORITIES, cameraFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,  uri);
            startActivityForResult(intent, RC_TAKE_PHOTO);
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onActivityResult(int requestCode,int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK && requestCode == RC_TAKE_PHOTO)
            adapter.add(cameraFile);
    }
}

