package com.example.multipurpose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question extends Activity implements OnClickListener {
	TextView ref1;
	Button ref4;
	RadioButton ref2,ref3;
	RadioGroup ref5;
	public static String[] ques = {
			"Q1 : Java is an OOP language ?",
			"Q2 : DVM is registered based ?",
			"C",
			"D",
			"E",
			"F"};
	public static String[] ans = {"true","false","false","false","true","true"};
	int c = ques.length;
	int p = 0;
	int marks = 0;
	String type = "MCQ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		ref1 = (TextView)findViewById(R.id.tv1);
		ref2 = (RadioButton)findViewById(R.id.r1);
		ref3 = (RadioButton)findViewById(R.id.r2);
		ref5 = (RadioGroup)findViewById(R.id.TrueFalse);
		ref4 = (Button)findViewById(R.id.b1);
		ref4.setOnClickListener(this);
		ref1.setText(ques[p]);
		
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(p < c-1)
		{
			if((ref2.getText().toString()).equals(ans[p]) && ref2.isChecked())
				marks++;
			else if((ref3.getText().toString()).equals(ans[p]) && ref3.isChecked())
				marks--;
			p++;
			ref1.setText(ques[p]);
			ref5.clearCheck();
			if(p == c-1)
			{
				ref4.setText("SUBMIT");
				if((ref2.getText().toString()).equals(ans[p]) && ref2.isChecked())
					marks++;
				else if((ref3.getText().toString()).equals(ans[p]) && ref3.isChecked())
					marks--;
			}
			
		}
		else
		{
			Intent i1 = new Intent(Question.this,Quizresult.class);
			i1.putExtra("qt",type);
			i1.putExtra("mm",c);
			i1.putExtra("mo", marks);
			startActivity(i1);
			finish();
			
		}
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
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
