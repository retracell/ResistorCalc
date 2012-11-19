package com.learn.resistor;

public class Resistor {
	private String resistance;
	private int tolerance;
	public String band[] = new String[4];
	String[] colourCode = { "black", "brown", "red", "orange", "yellow",
			"green", "blue", "violet", "gray", "white", "gold", "silver", "none" };

	public Resistor(String resistance, int tolerance) {
		this.resistance = resistance;
		this.tolerance = tolerance;
	}

	// This is the general method that is used to determine what colour the
	// resistance bands should be based on the resistance integer given.
	// We can return an array index instead of colour string as long as all 
	// colours are in set order.
	private void determineBandColours() {
		band[0] = colourCode[Integer.parseInt(resistance.substring(0, 1))];
		band[1] = colourCode[Integer.parseInt(resistance.substring(1, 2))];
		band[2] = colourCode[determineCountMultiplier(resistance)];
		switch (tolerance) {
		case 5:
			band[3] = colourCode[10];
			break;
		case 10:
			band[3] = colourCode[11];
			break;
		case 20:
			band[3] = colourCode[12];
		}
	}
	
	// Used for the third band by counting the number of 0s to determine what
	// multiplier is applied to the resistance.
	private int determineCountMultiplier(String resistance) {
		char[] resistanceAsCharArray = resistance.toCharArray();
		int count = 0;
		for (int i = 2; i < resistanceAsCharArray.length; ++i) {
			if (resistanceAsCharArray[i] == '0') {
				count++;
			}
		}
		return count;
	}

	// Called by the activity, returns the band colours as an array.
	public String[] getBandColours() {
		determineBandColours();
		return band;
	}
}
