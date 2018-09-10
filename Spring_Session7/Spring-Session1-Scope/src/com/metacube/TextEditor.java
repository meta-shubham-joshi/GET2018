package com.metacube;

/**
 * class containing methods for texteditor functionality
 */
public class TextEditor {

	private SpellChecker spellChecker = null;
	private String word = "";

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void check() {
		System.out.println(spellChecker.checkSpelling() + " of " + getWord());
	}

}
