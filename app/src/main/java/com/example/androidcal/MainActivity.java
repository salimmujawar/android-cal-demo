package com.example.androidcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;

    String runningNumber = "";
    String leftBucket;
    String rightBucket;

    public enum Operation {
            ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    };

    Operation currentOperation;

    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResult);

        //Take reference of the Number Button elements
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn0 = (Button) findViewById(R.id.btn0);

        //Take reference of the Arithmetic Button elements
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        ImageButton btnSub = (ImageButton) findViewById(R.id.btnSub);
        ImageButton btnMul = (ImageButton) findViewById(R.id.btnMul);
        ImageButton btnDiv = (ImageButton) findViewById(R.id.btnDiv);

        //Take reference of remaining element
        Button btnClr = (Button) findViewById(R.id.btnClr);
        ImageButton btnEqu = (ImageButton) findViewById(R.id.btnEqu);

        //Set Textview to Zero
        txtResult.setText("");

        //Hook Listener for the buttons
        btn1.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
            numberPressed(1);
          }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNumber = "";
                leftBucket = "";
                rightBucket = "";
                result = 0;
                currentOperation = null;
                txtResult.setText("");
            }
        });

        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

    }

    void processOperation(Operation operation) {
        if (currentOperation != null) {

            if (runningNumber != null) {
                rightBucket = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                            result = Integer.parseInt(leftBucket) + Integer.parseInt(rightBucket);
                        break;
                    case SUBTRACT:
                            result = Integer.parseInt(leftBucket) - Integer.parseInt(rightBucket);
                        break;
                    case MULTIPLY:
                            result = Integer.parseInt(leftBucket) * Integer.parseInt(rightBucket);
                        break;
                    case DIVIDE:
                            result = Integer.parseInt(leftBucket) / Integer.parseInt(rightBucket);
                        break;
                }

                leftBucket = String.valueOf(result);
                txtResult.setText(leftBucket);
            }
        }else {
            leftBucket = runningNumber;
            runningNumber = "";
        }

        currentOperation = operation;
    }

    /*
        What number was pressed
     */
    public void numberPressed(int number){
        runningNumber += number;
        txtResult.setText(runningNumber);
    }
}
