package org.practice.roman_number;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToDecimalConverterTest {
	
	private RomanToDecimalConverter subject = new RomanToDecimalConverter();

	@Test
	public void test_MMMMMCDXXXII() {
		assertThat(subject.convert("MMMMMCDXXXII"), equalTo(5432));
	}
	
	@Test
	public void test_MMMMCCCXII() {
		assertThat(subject.convert("MMMMCCCXII"), equalTo(4312));
	}
	
	@Test
	public void test_CXXIII() {
		assertThat(subject.convert("CXXIII"), equalTo(123));
	}
	
	@Test
	public void test_XIX() {
		assertThat(subject.convert("XIX"), equalTo(19));
	}
	
	//With Relax conversion
	@Test
	public void test_XM() {
		assertThat(subject.convert("XM"), equalTo(990));
	}
	
	@Test
	public void test_IIIII() {
		assertThat(subject.convert("IIIII"), equalTo(5));
	}

}
