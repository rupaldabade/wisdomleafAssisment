package com.speaking.clock.model;

public class SpeakingClockModel {

	private int hours;
    private int minutes;

    public final String[] TENS = {
    		"","","twenty ", "thirty ", "forty ", "fifty "
    };

    public final String[] ONES = {
            "twelve ", "one ", "two ", "three ", "four ", "five ",
            "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
            "twelve ", "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ", "nineteen "
    };

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String[] getTENS() {
		return TENS;
	}

	public String[] getONES() {
		return ONES;
	}
}
