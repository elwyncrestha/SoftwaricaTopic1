package com.softwarica.topic1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.softwarica.topic1.R;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbImage1, rbImage2, rbImage3;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        rbImage1 = findViewById(R.id.rbImage1);
        rbImage2 = findViewById(R.id.rbImage2);
        rbImage3 = findViewById(R.id.rbImage3);
        ivImage = findViewById(R.id.ivImage);

        rbImage1.setOnClickListener(this);
        rbImage2.setOnClickListener(this);
        rbImage3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbImage1:
                this.ivImage.setImageResource(R.drawable.image1);
                break;
            case R.id.rbImage2:
                this.ivImage.setImageResource(R.drawable.image2);
                break;
            case R.id.rbImage3:
                this.ivImage.setImageResource(R.drawable.image3);
                break;
        }
    }
}
