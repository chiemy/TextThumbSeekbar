package com.example.textthumbseekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends Activity {
	private TextThumbSeekbar textSeekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSeekbar = (TextThumbSeekbar) findViewById(R.id.textThumbSeekbar1);
        textSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekbar, int progress, boolean user) {
				textSeekbar.setThumbText(progress + "");
			}
		});
    }
    
    
}
