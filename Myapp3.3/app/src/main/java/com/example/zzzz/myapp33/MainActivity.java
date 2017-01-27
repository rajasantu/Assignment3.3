package com.example.zzzz.myapp33;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getImage (View v){

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,50);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case (50):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    System.out.println(contactData.getScheme());
                    ImageView view = (ImageView) findViewById(R.id.imageView);


                    try {
                        InputStream stream = getContentResolver().openInputStream(contactData);
                        ;
                        Drawable d = Drawable.createFromStream(stream, null);
                        view.setImageDrawable(d);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                break;
        }
    }

}



