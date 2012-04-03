package com.learn.resistor;

public class Resistor {
	private int resistance;
	private int tolerance;
	public int band[] = new int[4];

	String[] colourCode = { "Black", "Brown", "Red", "Orange", "Yellow",
			"Green", "Blue", "Violet", "Grey", "White" };
	String[] toleranceCode = { "Gold", "Silver", "None" };
	String[] bandColours = new String[4];

	public Resistor(int resistance, int tolerance) {
		this.resistance = resistance;
		this.tolerance = tolerance;
		determineBandColours();
	}

	// This is the general method that is used to determine what colour the
	// resistance bands should be based on the resistance integer given.
	private void determineBandColours() {
		convertResistanceToBand();
		bandColours[0] = colourCode[band[0]];
		bandColours[1] = colourCode[band[1]];
		bandColours[2] = colourCode[band[2] - 1];
		switch (band[3]) {
		case 5:
			bandColours[3] = toleranceCode[0];
			break;
		case 10:
			bandColours[3] = toleranceCode[1];
			break;
		case 20:
			bandColours[3] = toleranceCode[2];
		}
		// Will need to change tolerance to RadioGroup as there is only 5%, 10%,
		// and 20%
	}

	// This method parses the integer into a string and determines from an array
	// what each band's colour is.
	private void convertResistanceToBand() {
		String resistanceAsString = Integer.toString(resistance);
		band[0] = Integer.parseInt(resistanceAsString.substring(0, 1));
		band[1] = Integer.parseInt(resistanceAsString.substring(1, 2));
		band[2] = determineCountMultiplier(resistanceAsString);
		band[3] = tolerance;
	}

	// Used for the third band by counting the number of 0s to determine what
	// multiplier is applied to the resistance.
	private int determineCountMultiplier(String resistance) {
		char[] resistanceAsCharArray = resistance.toCharArray();
		int count = 0;
		for (int i = 0; i < resistanceAsCharArray.length; ++i) {
			if (resistanceAsCharArray[i] == '0') {
				count++;
			}
		}
		return count;
	}

	// Called by the activity, returns the band colours as an array.
	public String[] getBandColours() {
		return bandColours;
	}

	// Testing methods...
	public String arrayToString(int[] array) {
		String tempString = "";
		for (int i = 0; i < array.length; ++i) {
			tempString = tempString + array[i] + " ";
		}
		return tempString;
	}
}
