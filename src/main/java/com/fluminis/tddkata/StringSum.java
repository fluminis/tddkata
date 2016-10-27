package com.fluminis.tddkata;

import java.text.ParseException;

public class StringSum {

	public String sum(String num1, String num2) {
		int n1 = 0;
		int n2 = 0;
		try {
			n1 = Integer.parseInt(num1);
		} catch (NumberFormatException e) {
		}
		try {
			n2 = Integer.parseInt(num2);
		} catch (NumberFormatException e) {
		}
		int sum = n1 + n2;
		return String.valueOf(sum);
	}

}
