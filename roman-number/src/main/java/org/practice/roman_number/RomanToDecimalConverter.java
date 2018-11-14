package org.practice.roman_number;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanToDecimalConverter implements Converter<String, Integer> {
	
	private static Map<String, Integer> ROMAN_DECIMAL_MAPPING = Arrays.stream(ROMAN_NUMERALS.values())
			.collect(Collectors.toMap(ROMAN_NUMERALS::name, ROMAN_NUMERALS::getDecimalValue));

	@Override
	public Integer convert(String romanNumber) {
		int number = 0;
		
		for (int i=0; i<romanNumber.length(); i++) {
			if (!ROMAN_DECIMAL_MAPPING.containsKey(String.valueOf(romanNumber.charAt(i)))) {
				throw new IllegalArgumentException("Unknown Roman number");
			}
			
			if (i == romanNumber.length() - 1) {
				number += ROMAN_DECIMAL_MAPPING.get(String.valueOf(romanNumber.charAt(i)));
			}
			else {
				String currentNumber = String.valueOf(romanNumber.charAt(i));
				String nextNumber = String.valueOf(romanNumber.charAt(i + 1));
				
				if (ROMAN_DECIMAL_MAPPING.get(currentNumber) >= ROMAN_DECIMAL_MAPPING.getOrDefault(nextNumber, 0)) {
					number += ROMAN_DECIMAL_MAPPING.get(currentNumber);
				} 
				else if (ROMAN_DECIMAL_MAPPING.containsKey(romanNumber.substring(i, i + 2))) {
					number += ROMAN_DECIMAL_MAPPING.get(romanNumber.substring(i, i + 2));
					i++;
				}
				else {
					//Strict implementation to match the reverse way (decimal to roman)
//					throw new IllegalArgumentException("Unknown Roman number");
					
					//In case relax implementation needed
					number += ROMAN_DECIMAL_MAPPING.get(nextNumber) - ROMAN_DECIMAL_MAPPING.get(currentNumber);
					i++;
				}
			}
		}

		return number;
	}

}
