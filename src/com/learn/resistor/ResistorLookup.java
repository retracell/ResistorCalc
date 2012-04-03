package com.learn.resistor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResistorLookup extends Activity {
	Resistor myResistor;
	EditText resistanceNumber;
	EditText toleranceNumber;
	AlertDialog errorDialog;

	public void onCreate(Bundle me) {
		super.onCreate(me);
		setContentView(R.layout.main);
		errorDialog = new AlertDialog.Builder(this).create();
		errorDialog.setTitle("Error");
		errorDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				errorDialog.dismiss();
			}
		});
		resistanceNumber = (EditText) findViewById(R.id.resistance_value);
		toleranceNumber = (EditText) findViewById(R.id.tolerance_value);
	}

	public void getResistanceClicked(View v) {
		int resistance = 0;
		int tolerance = 0;
		String resistanceString = resistanceNumber.getText().toString();
		String toleranceString = toleranceNumber.getText().toString();
		tolerance = Integer.parseInt(toleranceString);
		if (Integer.parseInt(resistanceString) != 0) {
			if (resistanceString.length() > 1) {
				resistance = Integer.parseInt(resistanceString);
				myResistor = new Resistor(resistance, tolerance);
				// Toast toast = Toast.makeText(getApplicationContext(),
				// myResistor.arrayToString(myResistor.band),
				// Toast.LENGTH_LONG);
				String[] tempArray = myResistor.getBandColours();
				Toast toast = Toast.makeText(getApplicationContext(),
						arrayToString(tempArray), Toast.LENGTH_LONG);
				toast.show();
			} else if (resistanceString.length() == 1) {
				errorDialog
						.setMessage("Single digit resistance is not yet supported Please try again.");
				errorDialog.show();
			}
		} else {
			errorDialog
					.setMessage("You entered an invalid resistance value. Please try again.");
			errorDialog.show();
		}
	}

	public String arrayToString(String[] array) {
		String tempString = "";
		for (int i = 0; i < array.length; ++i) {
			tempString = tempString + array[i] + " ";
		}
		return tempString;
	}

	public void updateResistorImage(String[] resistorColours) {

	}
}