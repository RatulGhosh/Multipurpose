package com.example.multipurpose;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Alone extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		TextView tv1 = new TextView(this);
		tv1.setText("This is Alone");
		Button b1 = new Button(this);
		b1.setText("Click Here");
		ll.addView(tv1);
		ll.addView(b1);
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		ll.setBackgroundColor(Color.rgb(r, g, b));
		setContentView(ll);
	}
	

}
