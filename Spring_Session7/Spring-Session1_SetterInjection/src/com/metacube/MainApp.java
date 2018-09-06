package com.metacube;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String args[]){
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.check();
	}

}
