package com.metacube;

/**
 * Class implementing functionality of Text Editor.
 */
public class TextEditor {

	private SpellChecker spellChecker;
	private String word;
	
	public String getWord() {
		return word;
	}

	public TextEditor(SpellChecker spellChecker, String word) {
		this.spellChecker = spellChecker;
		this.word = word;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void check() {
		System.out.println(spellChecker.spellChecking()+  " of " + getWord());
	}
}
