package com.softlond.akdevmy.models;

public class Test {
	private String greetings;
	private String text;

	public Test() {
	}

	public Test(String greetings, String text) {
		super();
		this.greetings = greetings;
		this.text = text;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
