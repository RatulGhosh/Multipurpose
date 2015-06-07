package com.example.multipurpose;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Music extends Activity {
	MediaPlayer ourSong;
	Button play,pause,FF;
	TextView ref1,ref2;
	
	/*ourSong = MediaPlayer.create(Music.this, R.raw.indiana);
	ourSong.start();*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		ref1 = (TextView)findViewById(R.id.tv1);
		ref2 = (TextView)findViewById(R.id.tv2);
		play = (Button)findViewById(R.id.b1);
	    pause = (Button)findViewById(R.id.b2);
	    FF = (Button)findViewById(R.id.b3);
	    play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                	ourSong = MediaPlayer.create(Music.this, R.raw.indiana);
                	ourSong.start();
    				String op = "Duration : "+func(ourSong.getDuration());
    				ref1.setText(op);
    				ref2.setText("Current Status : playing");
                	
                }catch(Exception e)
                {
                    
                }
            }

			private String func(int duration) {
				// TODO Auto-generated method stub
				return (duration/1000+""+duration%1000);
			}
        });
	    
	    FF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                	ourSong.seekTo(ourSong.getCurrentPosition()+5000);
    				
                	
                }catch(Exception e)
                {
                    
                }
            }

		
        });
	    pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                	ourSong.pause();
    				
                	
                }catch(Exception e)
                {
                    
                }
            }

		
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music, menu);
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
