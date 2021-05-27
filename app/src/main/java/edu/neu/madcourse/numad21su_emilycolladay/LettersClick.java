package edu.neu.madcourse.numad21su_emilycolladay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class LettersClick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button buttonA = new Button(this);
        buttonA.setText(R.string.A);
        buttonA.setId(R.id.button_A);

        Button buttonB = new Button(this);
        buttonB.setText(R.string.B);
        buttonB.setId(R.id.button_B);

        Button buttonC = new Button(this);
        buttonC.setText(R.string.C);
        buttonC.setId(R.id.button_C);

        Button buttonD = new Button(this);
        buttonD.setText(R.string.D);
        buttonD.setId(R.id.button_D);

        Button buttonE = new Button(this);
        buttonE.setText(R.string.E);
        buttonE.setId(R.id.button_E);

        Button buttonF = new Button(this);
        buttonF.setText(R.string.F);
        buttonF.setId(R.id.button_F);

        ConstraintLayout myCl = new ConstraintLayout(this);

        myCl.addView(buttonA);
        myCl.addView(buttonB);
        myCl.addView(buttonC);
        myCl.addView(buttonD);
        myCl.addView(buttonE);
        myCl.addView(buttonF);

        setContentView(myCl);

        ConstraintSet csButtonA = new ConstraintSet();

        csButtonA.constrainHeight(buttonA.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonA.constrainWidth(buttonA.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonA.connect(buttonA.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        csButtonA.connect(buttonA.getId(), ConstraintSet.END, buttonB.getId(), ConstraintSet.START, 0);
        csButtonA.connect(buttonA.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        csButtonA.connect(buttonA.getId(), ConstraintSet.BOTTOM, buttonD.getId(), ConstraintSet.TOP, 0);

        csButtonA.applyTo(myCl);

        ConstraintSet csButtonB = new ConstraintSet();

        csButtonB.constrainHeight(buttonB.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonB.constrainWidth(buttonB.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonB.connect(buttonB.getId(), ConstraintSet.START, buttonA.getId(), ConstraintSet.END, 0);
        csButtonB.connect(buttonB.getId(), ConstraintSet.END, buttonC.getId(), ConstraintSet.START, 0);
        csButtonB.connect(buttonB.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        csButtonB.connect(buttonB.getId(), ConstraintSet.BOTTOM, buttonE.getId(), ConstraintSet.TOP, 0);

        csButtonB.applyTo(myCl);

        ConstraintSet csButtonC = new ConstraintSet();

        csButtonC.constrainHeight(buttonC.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonC.constrainWidth(buttonC.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonC.connect(buttonC.getId(), ConstraintSet.START, buttonB.getId(), ConstraintSet.END, 0);
        csButtonC.connect(buttonC.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        csButtonC.connect(buttonC.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        csButtonC.connect(buttonC.getId(), ConstraintSet.BOTTOM, buttonF.getId(), ConstraintSet.TOP, 0);

        csButtonC.applyTo(myCl);

        ConstraintSet csButtonD = new ConstraintSet();

        csButtonD.constrainHeight(buttonD.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonD.constrainWidth(buttonD.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonD.connect(buttonD.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        csButtonD.connect(buttonD.getId(), ConstraintSet.END, buttonE.getId(), ConstraintSet.START, 0);
        csButtonD.connect(buttonD.getId(), ConstraintSet.TOP, buttonA.getId(), ConstraintSet.BOTTOM, 0);
        csButtonD.connect(buttonD.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);

        csButtonD.applyTo(myCl);

        ConstraintSet csButtonE = new ConstraintSet();

        csButtonE.constrainHeight(buttonE.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonE.constrainWidth(buttonE.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonE.connect(buttonE.getId(), ConstraintSet.START, buttonD.getId(), ConstraintSet.END, 0);
        csButtonE.connect(buttonE.getId(), ConstraintSet.END, buttonF.getId(), ConstraintSet.START, 0);
        csButtonE.connect(buttonE.getId(), ConstraintSet.TOP, buttonB.getId(), ConstraintSet.BOTTOM, 0);
        csButtonE.connect(buttonE.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);

        csButtonE.applyTo(myCl);

        ConstraintSet csButtonF = new ConstraintSet();

        csButtonF.constrainHeight(buttonF.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonF.constrainWidth(buttonF.getId(), ConstraintSet.WRAP_CONTENT);
        csButtonF.connect(buttonF.getId(), ConstraintSet.START, buttonE.getId(), ConstraintSet.END, 0);
        csButtonF.connect(buttonF.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        csButtonF.connect(buttonF.getId(), ConstraintSet.TOP, buttonC.getId(), ConstraintSet.BOTTOM, 0);
        csButtonF.connect(buttonF.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);

        csButtonF.applyTo(myCl);


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed: A", Toast.LENGTH_SHORT).show();
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed: B", Toast.LENGTH_SHORT).show();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed: C", Toast.LENGTH_SHORT).show();
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed: D", Toast.LENGTH_SHORT).show();
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed: E", Toast.LENGTH_SHORT).show();
            }
        });

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed: F", Toast.LENGTH_SHORT).show();
            }
        });



        //setContentView(R.layout.activity_button_letters);
    }
}
