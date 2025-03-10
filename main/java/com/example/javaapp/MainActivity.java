package com.example.javaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNumber, inputSecondNumber;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textResult = findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operator) {
        String firstNumberStr = inputFirstNumber.getText().toString();
        String secondNumberStr = inputSecondNumber.getText().toString();

        if (firstNumberStr.isEmpty() || secondNumberStr.isEmpty()) {
            Toast.makeText(this, "Please enter 2 numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            double result = 0;

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    if (secondNumber == 0) {
                        Toast.makeText(this, "error: divisor can't be zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
            }

            if (result == (int) result) {
                textResult.setText(String.valueOf((int) result));
            } else {
                textResult.setText(String.valueOf(result));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid number", Toast.LENGTH_SHORT).show();
        }
    }
}