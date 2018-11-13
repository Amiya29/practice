package org.practice.roman_number;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DecimalToRomanConverter implements Converter<Integer, String> {
	
	private static int MAX_DECIMAL_LIMIT = 10000;
	private static String ERROR_MSG_NUMBER_TOO_LONG = "Error, Number Too Long";
	
	private static final Map<Integer, String> DECIMAL_ROMAN_MAPPING = Arrays.stream(ROMAN_NUMERALS.values())
			.sorted(Comparator.comparing(ROMAN_NUMERALS::getDecimalValue).reversed()) //desc sort by decimal value
			.collect(toMap(ROMAN_NUMERALS::getDecimalValue, ROMAN_NUMERALS::name, (n1, n2) -> n1, LinkedHashMap::new)); //use linked hashmap to preserve order
			
	public String convert(Integer t) {
		if (t > MAX_DECIMAL_LIMIT) {
			return ERROR_MSG_NUMBER_TOO_LONG;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Entry<Integer, String> entry : DECIMAL_ROMAN_MAPPING.entrySet()) {
			
			while(t >= entry.getKey()) {
				sb.append(entry.getValue());
				t -= entry.getKey();
			}
			
			if (t < 1) {
				break;
			}
		}
		
		return sb.toString();
	}

}
