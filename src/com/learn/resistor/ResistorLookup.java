package com.learn.resistor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class ResistorLookup extends Activity {
	RadioGroup orientation;
	RadioGroup gravity;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);	
	}
}