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

public class Login extends Activity {
    EditText ref1,ref2;
    Button ref3;
    String[] name = {"A","B","C"};
    int[] pass = {1,2,3};
   // boolean flag = false;
    int flag=0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
        ref1 = (EditText)findViewById(R.id.et1);//ref1.getText();
        ref2 = (EditText)findViewById(R.id.et2);
        ref3 = (Button)findViewById(R.id.b1);
        Button b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String an = "com.example.multipurpose.Calculator";
                String an1 = "com.example.multipurpose.Fail";
                try{
                    String st = ref1.getText().toString();
                    int pwd = Integer.parseInt(ref2.getText().toString());
                    for(int i = 0;i<3;i++) {
                        if (st.equals(name[i]) && pwd == pass[i])
                            flag=1;//flag = true;
                    }
                        if(flag == 1) {
                            Class cts = Class.forName(an);
                            Intent i1 = new Intent(Login.this, cts);
                            startActivity(i1);

                        }
                        else
                        {
                             Class cts = Class.forName(an1);
                             Intent i2 = new Intent(Login.this, cts);
                             startActivity(i2);
                        }
                        ref1.setText("");
                        ref2.setText("");
                        finish();
                }catch(Exception e) {
                	try{
                        Class cts = Class.forName(an1);
                        Intent i2 = new Intent(Login.this, cts);
                        startActivity(i2);
                        Toast.makeText(Login.this, "Error", Toast.LENGTH_LONG ).show();
                    }catch(Exception e1){Toast.makeText(Login.this, "No Activity", Toast.LENGTH_LONG ).show();}
                }
            }
        });
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
