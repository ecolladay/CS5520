package edu.neu.madcourse.numad21su_emilycolladay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LettersClick extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the content to the XML file
        setContentView(R.layout.activity_button_letters);


        Button buttonA = findViewById(R.id.button_A);
        Button buttonB = findViewById(R.id.button_B);
        Button buttonC = findViewById(R.id.button_C);
        Button buttonD = findViewById(R.id.button_D);
        Button buttonE = findViewById(R.id.button_E);
        Button buttonF = findViewById(R.id.button_F);

        /** Add action listeners

        buttonA.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Pressed: A", Toast.LENGTH_SHORT).show());

        buttonB.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Pressed: B", Toast.LENGTH_SHORT).show());

        buttonC.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Pressed: C", Toast.LENGTH_SHORT).show());

        buttonD.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Pressed: D", Toast.LENGTH_SHORT).show());

        buttonE.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Pressed: E", Toast.LENGTH_SHORT).show());

        buttonF.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Pressed: F", Toast.LENGTH_SHORT).show());
        */
    }

    @Override
    public void onClick(View v) {
        TextView line = (TextView)findViewById(R.id.buttonPressed);
        switch(v.getId()){
            case(R.id.button_A):
                line.setText("Button pressed: A");
                break;
            case(R.id.button_B):
                line.setText("Button pressed: B");
                break;
            case(R.id.button_C):
                line.setText("Button pressed: C");
                break;
            case(R.id.button_D):
                line.setText("Button pressed: D");
                break;
            case(R.id.button_E):
                line.setText("Button pressed: E");
                break;
            case(R.id.button_F):
                line.setText("Button pressed: F");
                break;
        }

    }
}
