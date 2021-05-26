package edu.neu.madcourse.numad21su_emilycolladay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button_about);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }
        });

        button2 = (Button) findViewById(R.id.button_letters);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openContact2();}
        });
    }

    private void openContact2() {
        Intent intent = new Intent(this, LettersClick.class);
        startActivity(intent);
    }

    public void openContact() {
        Intent intent = new Intent(this, ButtonClick.class);
        startActivity(intent);
    }
}