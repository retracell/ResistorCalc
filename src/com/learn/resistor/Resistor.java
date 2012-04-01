package com.learn.resistor;

public class Resistor {
	private int resistance;
	private int tolerance;
	int band[] = new int[4];

	String[] colourCode = { "Black", "Brown", "Red", "Orange", "Yellow",
			"Green", "Blue", "Violet", "Grey", "White" };
	String[] toleranceCode = { "None", "Silver", "Gold" };
	String[] bandColours = new String[4];

	public Resistor(int resistance, int tolerance) {
		this.resistance = resistance;
		this.tolerance = tolerance;
		determineBandColours();
	}

	private void convertResistanceToBand() {
		String resistanceAsString = Integer.toString(resistance);
		band[0] = Integer.parseInt(resistanceAsString.substring(0, 1));
		band[1] = Integer.parseInt(resistanceAsString.substring(1, 2));
		band[2] = determineCountMultiplier(resistanceAsString);
		band[3] = tolerance;
	}

	private int determineCountMultiplier(String resistance) {
		char[] resistanceAsCharArray = resistance.toCharArray();
		int count = 0;
		for (int i = 0; i <= resistanceAsCharArray.length; ++i) {
			if (resistanceAsCharArray[i] == '0') {
				count++;
			}
		}
		return count;
	}

	private void determineBandColours() {
		convertResistanceToBand();
		// Band[1-4] now holds the value we need to look for and corresponds to
		// index in colour arrays.
		bandColours[0] = colourCode[band[0]];
		bandColours[1] = colourCode[band[1]];
		bandColours[2] = colourCode[band[2]];
		// Will need to change tolerance to RadioGroup as there is only 5%, 10%,
		// and 20%

	}

	public String[] getBandColours() {
		return bandColours;
	}
}
