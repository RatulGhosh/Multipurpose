package com.example.multipurpose;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator extends Activity {
	
    EditText ref1,ref2,ref3;
    Button b1,b2,b3,b4,b5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		ref1 = (EditText)findViewById(R.id.input1);//ref1.getText();
        ref2 = (EditText)findViewById(R.id.Input2);
        ref3 = (EditText)findViewById(R.id.output);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(ref1.getText().toString());
                    double b = Double.parseDouble(ref2.getText().toString());
                    double c = a + b;
                    ref3.setText(String.valueOf(c));
                }catch(Exception e)
                {
                    Toast.makeText(Calculator.this,"Please enter numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(ref1.getText().toString());
                    double b = Double.parseDouble(ref2.getText().toString());
                    double c = a - b;
                    ref3.setText(String.valueOf(c));
                }catch(Exception e)
                {
                    Toast.makeText(Calculator.this,"Please enter numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(ref1.getText().toString());
                    double b = Double.parseDouble(ref2.getText().toString());
                    double c = a * b;
                    ref3.setText(String.valueOf(c));
                }catch(Exception e)
                {
                    Toast.makeText(Calculator.this,"Please enter numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(ref1.getText().toString());
                    double b = Double.parseDouble(ref2.getText().toString());
                    double c = a / b;
                    ref3.setText(String.valueOf(c));
                }catch(ArithmeticException e) {
                    Toast.makeText(Calculator.this,"Divide by zero",Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(Calculator.this,"Please enter numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ref1.setText("");
                ref2.setText("");
                ref3.setText("");
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
