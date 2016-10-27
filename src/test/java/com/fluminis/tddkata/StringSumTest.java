package com.fluminis.tddkata;

import org.junit.Assert;
import org.junit.Test;

import com.fluminis.tddkata.StringSum;

public class StringSumTest {

	@Test
	public void shouldReturnZeroForEmptyStrings() {
		StringSum stringSum = new StringSum();
		Assert.assertEquals("0", stringSum.sum("", ""));
	}
	
	@Test
	public void shouldReturnFirstNumberIfSecondIsEmpty() {
		StringSum stringSum = new StringSum();
		Assert.assertEquals("1", stringSum.sum("1", ""));
	}
	
	@Test
	public void shouldReturnSecondNumberIfFirstIsEmpty() {
		StringSum stringSum = new StringSum();
		Assert.assertEquals("2", stringSum.sum("", "2"));
	}
	
	@Test
	public void shouldReturnSumOfTwoNumbersIfNotEmpty() {
		StringSum stringSum = new StringSum();
		Assert.assertEquals("3", stringSum.sum("1", "2"));
	}
	
	@Test
	public void shouldReturnSumOfTwoNumbersIfNotEmpty2() {
		StringSum stringSum = new StringSum();
		Assert.assertEquals("5", stringSum.sum("2", "3"));
	}
}
