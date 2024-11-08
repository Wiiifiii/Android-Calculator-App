package com.example.calculatorapp_23_24;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity; //view.Gravity for text alignment

public class CalculatorActivity extends AppCompatActivity {

    private TextView display;
    private TextView alignLabel;
    private StringBuilder currentInput = new StringBuilder();
    private Switch alignSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.display);
        alignLabel = findViewById(R.id.alignLabel);
        alignSwitch = findViewById(R.id.alignSwitch);

        // Set initial alignment to left
        display.setGravity(View.TEXT_ALIGNMENT_TEXT_START | View.TEXT_ALIGNMENT_CENTER);
        alignLabel.setText("Default alignment: Left");

        // Setup alignment toggle behavior
        alignSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> toggleAlignment(isChecked));

        setupCalculatorButtons();
    }
    // Setup the click listeners for the calculator buttons
    private void setupCalculatorButtons() {
        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide,
                R.id.buttonDot, R.id.buttonEqual, R.id.buttonClear
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(buttonClickListener);
        }
    }
    // Click listener for the calculator buttons that appends the button's value to the input
    private final View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            String value = button.getText().toString();

            if ("=".equals(value)) {
                calculateResult();
            } else if ("Tyhjennä".equals(value)) {
                clearInput();
            } else {
                appendToInput(value);
            }
        }
    };
    // Appends the given value to the current input and updates the display
    private void appendToInput(String value) {
        currentInput.append(value);
        display.setText(currentInput.toString());
    }
    // Clears the current input and updates the display
    private void clearInput() {
        currentInput.setLength(0);
        display.setText("");
    }
    // Calculates the result of the current input and updates the display
    private void calculateResult() {
        try {
            double result = evaluateExpression(currentInput.toString());

            if (result == (int) result) {
                display.setText(currentInput.toString() + " =\n" + String.valueOf((int) result));
            } else {
                display.setText(currentInput.toString() + " =\n" + result);
            }

            currentInput.setLength(0);  // Clear input for next calculation
        } catch (Exception e) {
            display.setText("Error");
        }
    }
    // Evaluates the given expression and returns the result
    private double evaluateExpression(String expression) {
        double result = 0;
        double currentNumber = 0;
        char currentOperator = '+';
    // Loop through the expression and apply the operators
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i++));
                }
                i--;
                currentNumber = Double.parseDouble(number.toString());
            } else {
                result = applyOperator(result, currentNumber, currentOperator);
                currentOperator = ch;
                currentNumber = 0;
            }
        }
        // Apply the last operator
        result = applyOperator(result, currentNumber, currentOperator);
        return result;
    }
    // Applies the given operator to the result and returns the new result
    private double applyOperator(double result, double number, char operator) {
        switch (operator) {
            case '+': return result + number;
            case '-': return result - number;
            case 'x': return result * number;
            case '/': return (number != 0) ? result / number : 0;
            default: return result;
        }
    }

    /**
     * TASK 24:
     * Toggles the alignment of the display TextView based on the Switch state
     * which is left by default.
     */

    private void toggleAlignment(boolean isRightAligned) {
        if (isRightAligned) {
            display.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);  // Align text to the right
            alignLabel.setText("Switch to Left Alignment");
        } else {
            display.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);  // Align text to the left
            alignLabel.setText("Switch to Right Alignment");
        }
    }
}
