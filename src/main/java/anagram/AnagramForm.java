package anagram;

import java.util.HashSet;

public class AnagramForm {

	private String word;
	private String message;
	private HashSet<String> anagrams;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HashSet<String> getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(HashSet<String> anagrams) {
		this.anagrams = anagrams;
	}

}
