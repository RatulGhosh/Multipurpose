package com.example.multipurpose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts.Intents;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Quizresult extends Activity {

	TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizresult);
		result = (TextView)findViewById(R.id.tv1);
		Intent rd = getIntent();
		Bundle b = rd.getExtras();
		String type = b.getString("qt");
		int mo = b.getInt("mo");
		int mm = b.getInt("mm");
		String dc = "RESULT : \n--------------------------------\n";
		dc += "QUIZ TYPE: "+type+"\n";
		dc += "MARKS OBTAINED: "+mo+"\n";
		dc += "TOTAL MARKS: "+mm+"\n";
		if((double)(mo/mm)>=0.9)
			dc += "GRADE: "+"A";
		else if((double)(mo/mm)>=0.8&&(double)(mo/mm)<0.9)
			dc += "GRADE: "+"B";
		else if((double)(mo/mm)>=0.7&&(double)(mo/mm)<0.8)
			dc += "GRADE: "+"C";
		else if((double)(mo/mm)>=0.6&&(double)(mo/mm)<0.7)
			dc += "GRADE: "+"D";
		else if((double)(mo/mm)>=0.5&&(double)(mo/mm)<0.6)
			dc += "GRADE: "+"E";
		else
		{
		String s = "FAILED";
		dc += s;
		result.setText(dc);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quizresult, menu);
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
