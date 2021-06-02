package edu.neu.madcourse.numad21su_emilycolladay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        if(v.getId() == R.id.button_about){
            Intent intent = new Intent(this, ButtonClick.class);
            startActivity(intent);

        }else if(v.getId() == R.id.button_letters){
            Intent intent = new Intent(this, LettersClick.class);
            startActivity(intent);
        }else if(v.getId() == R.id.button_links){
            Intent intent = new Intent(this, com.example.recyclerviewsample.LinksClick.class);
            startActivity(intent);
        }

    }
}