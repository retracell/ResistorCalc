package com.ryzhang.resistor;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ResistorLookupActivity extends Activity {
	Resistor myResistor;
	RadioGroup myToleranceGroup;
	EditText resistanceNumber;
	AlertDialog errorDialog;
	View colourbands[] = new View[4];
	int hex = 0;
	
	HashMap<String, Integer> map = new HashMap<String, Integer>() {
		{
			put("black", 0xFF000000);
			put("brown", 0xFF964B00);
			put("red", 0xFFFF0000);
			put("orange", 0xFFFF7F00);
			put("yellow", 0xFFFFFF00);
			put("green", 0xFF00FF00);
			put("blue", 0xFF0000FF);
			put("violet", 0xFF7F00FF);
			put("gray", 0xFF808080);
			put("white", 0xFFFFFFFF);
			put("gold", 0xFFFFD700);
			put("silver", 0xFFC9C0BB);
			put("none", 0x00000000);
		}
	};

	public void onCreate(Bundle me) {
		super.onCreate(me);
		setContentView(R.layout.main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		colourbands[0] = (View) findViewById(R.id.band1);
		colourbands[1] = (View) findViewById(R.id.band2);
		colourbands[2] = (View) findViewById(R.id.band3);
		colourbands[3] = (View) findViewById(R.id.band4);

		resistanceNumber = (EditText) findViewById(R.id.resistance_value);
        resistanceNumber.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    calculateResistance();
                    return true;
                }
                return false;
            }
        });
		myToleranceGroup = (RadioGroup) findViewById(R.id.tolerances);
	}

    public void calculateResistance() {
        String resistance;
        int tolerance = 0;

        resistance = resistanceNumber.getText().toString();
        if (myToleranceGroup.getCheckedRadioButtonId() == R.id.five_percent) tolerance = 5;
        else if (myToleranceGroup.getCheckedRadioButtonId() == R.id.ten_percent) tolerance = 10;
        else tolerance = 20;

        if (resistance.length() > 1) {
            updateResistorImage(resistance, tolerance);
        } else if (resistance.length() == 1) {
            errorDialog.setMessage("Single digit resistance is not yet supported Please try again.");
            errorDialog.show();
        } else {
            errorDialog.setMessage("You entered an invalid resistance value. Please try again.");
            errorDialog.show();
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(resistanceNumber.getWindowToken(), 0);
    }


	public void getResistanceClicked(View v) {
        calculateResistance();
	}

	public String arrayToString(String[] array) {
		String tempString = "";
		for (int i = 0; i < array.length; ++i) {
			tempString = tempString + array[i] + " ";
		}
		return tempString;
	}

	public void updateResistorImage(String resistance, int tolerance) {
		myResistor = new Resistor(resistance, tolerance);
		String[] bands = myResistor.getBandColours();
		
		//Toast.makeText(getApplicationContext(), arrayToString(bands), Toast.LENGTH_LONG).show();
		
		for (int i = 0; i < colourbands.length; i++) {
			colourbands[i].setBackgroundColor(map.get(bands[i]));
		}
	}
}