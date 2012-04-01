package com.learn.resistor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResistorLookup extends Activity {
	Resistor myResistor;
	EditText resistanceNumber;
	EditText toleranceNumber;

	public void onCreate(Bundle me) {
		super.onCreate(me);
		setContentView(R.layout.main);
		resistanceNumber = (EditText) findViewById(R.id.resistance_value);
		toleranceNumber = (EditText) findViewById(R.id.tolerance_value);
	}

	public void getResistanceClicked(View v) {
		
		int resistance = Integer
				.parseInt(resistanceNumber.getText().toString());
		int tolerance = Integer.parseInt(toleranceNumber.getText().toString());
		Toast toast = Toast.makeText(getApplicationContext(), resistance + " + " + tolerance, Toast.LENGTH_LONG);
		toast.show();
		//myResistor = new Resistor(resistance, tolerance);
		//myResistor.getBandColours();
	}

	public void updateResistorImage(String[] resistorColours) {

	}
}