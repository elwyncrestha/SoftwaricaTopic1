package com.softwarica.topic1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.softwarica.topic1.R;
import com.softwarica.topic1.util.ExpressionEvaluator;

public class GridLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnRemainder, btnEvaluate, btnErase;
    EditText etResult;
    StringBuilder expression = new StringBuilder();

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
        this.btnEvaluate = findViewById(R.id.btnEvaluate);
        this.etResult = findViewById(R.id.etResult);
        this.btnErase = findViewById(R.id.btnErase);

        this.btnZero.setOnClickListener(this);
        this.btnOne.setOnClickListener(this);
        this.btnTwo.setOnClickListener(this);
        this.btnThree.setOnClickListener(this);
        this.btnFour.setOnClickListener(this);
        this.btnFive.setOnClickListener(this);
        this.btnSix.setOnClickListener(this);
        this.btnSeven.setOnClickListener(this);
        this.btnEight.setOnClickListener(this);
        this.btnNine.setOnClickListener(this);
        this.btnAdd.setOnClickListener(this);
        this.btnSubtract.setOnClickListener(this);
        this.btnMultiply.setOnClickListener(this);
        this.btnDivide.setOnClickListener(this);
        this.btnRemainder.setOnClickListener(this);
        this.btnEvaluate.setOnClickListener(this);
        this.etResult.setOnClickListener(this);
        this.btnErase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.etResult.setError(null);
        switch (v.getId()) {
            case R.id.btnZero:
                this.expression.append("0");
                break;
            case R.id.btnOne:
                this.expression.append("1");
                break;
            case R.id.btnTwo:
                this.expression.append("2");
                break;
            case R.id.btnThree:
                this.expression.append("3");
                break;
            case R.id.btnFour:
                this.expression.append("4");
                break;
            case R.id.btnFive:
                this.expression.append("5");
                break;
            case R.id.btnSix:
                this.expression.append("6");
                break;
            case R.id.btnSeven:
                this.expression.append("7");
                break;
            case R.id.btnEight:
                this.expression.append("8");
                break;
            case R.id.btnNine:
                this.expression.append("9");
                break;
            case R.id.btnAdd:
                this.expression.append("+");
                break;
            case R.id.btnSubtract:
                this.expression.append("-");
                break;
            case R.id.btnMultiply:
                this.expression.append("*");
                break;
            case R.id.btnDivide:
                this.expression.append("/");
                break;
            case R.id.btnRemainder:
                this.expression.append("%");
                break;
            case R.id.btnEvaluate:
                if (this.expression.toString().contains(".")) {
                    this.etResult.setError("Cannot evaluate floating point numbers!!!");
                    return;
                }
                String result = ExpressionEvaluator.evaluate(this.expression.toString());
                this.expression.delete(0, this.expression.length()).append(result);
                break;
            case R.id.btnErase:
                if (this.expression.length() <= 0) {
                    this.etResult.setError("Empty expression");
                    return;
                }
                this.expression.deleteCharAt(this.expression.length() - 1);
                break;
            default:
                throw new IllegalArgumentException();
        }
        this.etResult.setText(this.expression);
    }
}
