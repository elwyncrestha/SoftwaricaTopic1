package com.softwarica.topic1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.softwarica.topic1.R;

public class GridLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnRemainder, btnEvaulate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        bindControls();
    }

    private void bindControls() {
        this.btnZero = findViewById(R.id.btnZero);
        this.btnOne = findViewById(R.id.btnOne);
        this.btnTwo = findViewById(R.id.btnTwo);
        this.btnThree = findViewById(R.id.btnThree);
        this.btnFour = findViewById(R.id.btnFour);
        this.btnFive = findViewById(R.id.btnFive);
        this.btnSix = findViewById(R.id.btnSix);
        this.btnSeven = findViewById(R.id.btnSeven);
        this.btnEight = findViewById(R.id.btnEight);
        this.btnNine = findViewById(R.id.btnNine);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.btnSubtract = findViewById(R.id.btnSubtract);
        this.btnMultiply = findViewById(R.id.btnMultiply);
        this.btnDivide = findViewById(R.id.btnDivide);
        this.btnRemainder = findViewById(R.id.btnRemainder);
        this.btnEvaulate = findViewById(R.id.btnEvaluate);
    }

    @Override
    public void onClick(View v) {

    }
}
