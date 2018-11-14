package org.practice.roman_number;

import java.util.stream.IntStream;

public class App 
{
	private static DecimalToRomanConverter decimalToRomanConverter = new DecimalToRomanConverter();
	private static RomanToDecimalConverter romanToDecimalConverter = new RomanToDecimalConverter();
	
    public static void main( String[] args )
    {
    	printRomanToDecimal();
    	printDecimalToRoman();
    }
    
    private static void printRomanToDecimal() {
    	
        IntStream.rangeClosed(1, 100)
        	.forEach(n -> System.out.println(n + " = " + decimalToRomanConverter.convert(n)));
    }
    
    private static void printDecimalToRoman() {
    	
    	IntStream.rangeClosed(1, 100)
    		.mapToObj(decimalToRomanConverter::convert)
    		.forEach(n -> System.out.println(n + " = " + romanToDecimalConverter.convert(n)));
    }
}
