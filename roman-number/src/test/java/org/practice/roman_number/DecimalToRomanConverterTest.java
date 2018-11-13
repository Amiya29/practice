package org.practice.roman_number;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DecimalToRomanConverterTest {
	
	private DecimalToRomanConverter subject = new DecimalToRomanConverter();
	
	@Test
	public void test_5432() {
		assertThat(subject.convert(5432), equalTo("MMMMMCDXXXII"));
	}
	
	@Test
	public void test_4312() {
		assertThat(subject.convert(4312), equalTo("MMMMCCCXII"));
	}
	
	@Test
	public void test_123() {
		assertThat(subject.convert(123), equalTo("CXXIII"));
	}
	
	@Test
	public void test_10001() {
		assertThat(subject.convert(10001), equalTo("Error, Number Too Long"));
	}

}
