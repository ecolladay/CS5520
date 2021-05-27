package edu.neu.madcourse.numad21su_emilycolladay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button button_about = findViewById(R.id.button_about);
        //button_about.setOnClickListener(v -> openContact());

        //Button button_letters = findViewById(R.id.button_letters);
        //button_letters.setOnClickListener(v -> openContact2());
    }

    public void onClick(View v){

        if(v.getId() == R.id.button_about){
            Intent intent = new Intent(this, ButtonClick.class);
            startActivity(intent);

        }else if(v.getId() == R.id.button_letters){
            Intent intent = new Intent(this, LettersClick.class);
            startActivity(intent);
        }

    }

    /**
    public void openContact() {
        Intent intent = new Intent(this, ButtonClick.class);
        startActivity(intent);
    }

    public void openContact2() {
        Intent intent = new Intent(this, LettersClick.class);
        startActivity(intent);
    }
     */
}