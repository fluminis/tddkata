package com.fluminis.tddkata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private String string;
	private String delimiter;

	public StringCalculator(String string) {
		this.string = string != null ? string : "";
		this.delimiter = calculateDelimiter();
	}

	public int add() {
		if ("".equals(string)) {
			return 0;
		}
		String[] numbers = string.split(delimiter);
		int sum = 0;
		List<String> invalidNumbers = new ArrayList<>();
		for (String number : numbers) {
			try {
				int value = Integer.parseInt(number, 10);
				if (value < 0) {
					invalidNumbers.add("[" + number + "]");
				}
				sum += value;
			} catch (NumberFormatException e) {
				invalidNumbers.add("[" + number + "]");
			}
		}
		if (invalidNumbers.size() > 0) {
			throw new IllegalArgumentException(
					"Following numbers not allowednfinite: " + String.join(", ", invalidNumbers));
		}
		return sum;
	}

	private String calculateDelimiter() {
		String delimiter = ",";
		if (string.length() > 0) {
			char firstChar = string.charAt(0);
			if (!Character.isDigit(firstChar) && string.charAt(1) == '\n') {
				delimiter = "" + firstChar;
				string = string.substring(2);
			}
			string = string.replace("\n", delimiter);
		}
		return delimiter;
	}
}
