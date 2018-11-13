package org.practice.roman_number;

/**
 * Convert data of type T to type R
 *
 * @param <T> Data type to be converted
 * @param <R> Return type
 */
public interface Converter<T, R> {

	R convert(T t);
}
