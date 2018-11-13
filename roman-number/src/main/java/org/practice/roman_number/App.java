package org.practice.roman_number;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DecimalToRomanConverter decimalToRomanConverter = new DecimalToRomanConverter();
        IntStream.rangeClosed(1, 10000)
        	.forEach(n -> System.out.println(n + " = " + decimalToRomanConverter.convert(n)));
    }
}
