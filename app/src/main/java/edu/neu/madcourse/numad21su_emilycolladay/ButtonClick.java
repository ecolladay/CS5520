package edu.neu.madcourse.numad21su_emilycolladay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ButtonClick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        ImageView zorraImage = findViewById(R.id.zorraImage);
        //zorra.setImageResource(R.drawable.zorra);
    }
}