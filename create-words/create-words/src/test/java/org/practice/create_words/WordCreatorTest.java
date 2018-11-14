package org.practice.create_words;

import static java.util.stream.Collectors.toSet;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;

public class WordCreatorTest {
	
	private WordCreator subject = new WordCreator();
	
	@Test
	public void create_with_ab() {
		//GIVEN
		Set<Character> chars = Arrays.asList('a', 'b').stream().collect(toSet());
		
		//WHEN
		Collection<String> results = subject.createWords(chars);
		
		//THEN
		assertThat(results, hasSize(2));
		assertThat(results, containsInAnyOrder("ab", "ba"));
	}
	
	@Test
	public void create_with_abc() {
		//GIVEN
		Set<Character> chars = Arrays.asList('a', 'b', 'c').stream().collect(toSet());
		
		//WHEN
		Collection<String> results = subject.createWords(chars);
		
		//THEN
		assertThat(results, hasSize(6));
		assertThat(results, containsInAnyOrder("abc", "acb",
												"bac", "bca",
												"cab", "cba"));
	}
	
}
