package org.practice.create_words;

import static java.util.stream.Collectors.joining;

import java.util.LinkedHashSet;
import java.util.Set;

public class WordCreator {
    
    /**
     * Create distinct words of same size of input characters
     * 
     * @param chars Distinct characters
     * @return all distinct words
     */
    public Set<String> createWords(Set<Character> chars) {
    	return createWords(new LinkedHashSet<>(), new LinkedHashSet<>(chars));
    }
    
    private LinkedHashSet<String> createWords(LinkedHashSet<Character> usedChars, LinkedHashSet<Character> remainingChars) {
    	LinkedHashSet<String> results = new LinkedHashSet<>();
    	
    	//If there is no remaining chars we found a word
    	if (remainingChars.isEmpty()) {
    		results.add(usedChars.stream()
		    			.map(String::valueOf)
		    			.collect(joining()));
    	}
    	
    	for (Character c : remainingChars) {
    		if (!usedChars.contains(c)) {
    			LinkedHashSet<Character> updatedUsedChars = getUpdatedUsedChars(usedChars, c); 
    			LinkedHashSet<Character> updatedRemainingChars = getUpdatedRemainingChars(remainingChars, c);  
    					
    			results.addAll(createWords(updatedUsedChars, updatedRemainingChars));
    		}
    	}
    	
    	return results;
    }

	private static LinkedHashSet<Character> getUpdatedUsedChars(LinkedHashSet<Character> existingChars, Character charToBeAdded) {
		LinkedHashSet<Character>  result = new LinkedHashSet<Character>(existingChars);
		result.add(charToBeAdded);
		
		return result;
	}
	
	private static LinkedHashSet<Character> getUpdatedRemainingChars(LinkedHashSet<Character> existingChars, Character charToBeRemoved) {
		LinkedHashSet<Character>  result = new LinkedHashSet<Character>(existingChars);
		result.remove(charToBeRemoved);
		
		return result;
	}
    
}
