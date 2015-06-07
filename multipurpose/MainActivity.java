package com.example.multipurpose;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	String[] mi = {"Calculator","Music","Question","Layout","MI5","MI6","MI7","MI8","MI9","MI10","EXIT","SERVICE"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayAdapter<String> ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mi);
		setListAdapter(ad);
	}
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		super.onListItemClick(l, v, position, id);
		String ci = mi[position];
		Toast.makeText(this,"Clicked : "+ci,1000).show();
		if(ci.equals("EXIT")){
			finish();
		}
		String an = "com.example.multipurpose.Login";
		try{
			if(ci.equals("Calculator"))
			{
				Class cts = Class.forName(an);
				Intent i = new Intent(this,cts);
				startActivity(i);
			}
			else if(ci.equals("Music"))
			{
				Class cts = Class.forName("com.example.multipurpose.Music");
				Intent i = new Intent(this,cts);
				startActivity(i);
			}
			else if(ci.equals("Question"))
			{
				Class cts = Class.forName("com.example.multipurpose.Question");
				Intent i = new Intent(this,cts);
				startActivity(i);
			}
			else if(ci.equals("Layout"))
			{
				Class cts = Class.forName("com.example.multipurpose.Layout");
				Intent i = new Intent(this,cts);
				startActivity(i);
			}
			
			
		}catch(Exception e){}

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
		getMenuInflater().inflate(R.menu.main, menu);
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
