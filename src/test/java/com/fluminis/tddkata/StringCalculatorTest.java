package com.fluminis.tddkata;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import com.fluminis.tddkata.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroForEmptyString() {
		StringCalculator s = new StringCalculator("");
		assertThat(s.add()).isEqualTo(0);
	}

	@Test
	public void shouldReturnSameNumberWhenOnlyOneNumber() {
		StringCalculator s = new StringCalculator("1");
		assertThat(s.add()).isEqualTo(1);
	}

	@Test
	public void shouldAddNumbersWhenTwoNumbers() {
		StringCalculator s = new StringCalculator("1,2");
		assertThat(s.add()).isEqualTo(3);
	}

	@Test
	public void shouldAddNumbersWhenArbitraryNumbers() {
		StringCalculator s = new StringCalculator("1,2,3");
		assertThat(s.add()).isEqualTo(6);
	}

	@Test
	public void shouldAllowNewLineAsSeparator() {
		StringCalculator s = new StringCalculator("1\n2,3");
		assertThat(s.add()).isEqualTo(6);
	}

	@Test
	public void shouldChangeDelimiter() {
		StringCalculator s = new StringCalculator(";\n1;2;3");
		assertThat(s.add()).isEqualTo(6);
	}

	@Test
	public void shouldThrowIfNegativeNumber() {
		StringCalculator s = new StringCalculator("-1");
		try {
			s.add();
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assertions.assertThat(e.getMessage()).contains("[-1]");
		}
	}

	@Test
	public void shouldThrowIfTwoNegativeNumbers() {
		StringCalculator s = new StringCalculator("2,-1,3,-8");
		try {
			s.add();
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assertions.assertThat(e.getMessage()).contains("[-1]", "[-8]");
		}
	}

	@Test
	public void shouldHandleNonDigitCaracterCorrectly() {
		StringCalculator s = new StringCalculator("2,a");
		try {
			s.add();
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assertions.assertThat(e.getMessage()).contains("[a]");
		}
	}

	@Test
	public void testAdd() throws Exception {
		// TODO not yet implemented
	}

}
