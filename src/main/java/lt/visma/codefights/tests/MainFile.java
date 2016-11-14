package main.java.lt.visma.codefights.tests;

import java.util.Arrays;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import main.java.lt.visma.codefights.tests.FightMe.TestFightMe;
import main.java.lt.visma.codefights.tests.Instructions.TestEmptyInput;

public class MainFile {

	public static void main(String[] args) {
		
		String text = Arrays.toString(args);
		text = text.replaceAll(",", "");
		
		TestFightMe.setStartText(text.substring(1, text.length()-1) + " --fight-me");
		TestEmptyInput.setStartText(text.substring(1, text.length()-1));
		
		Result result = JUnitCore.runClasses(TestFightMe.class, TestEmptyInput.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
			
		System.out.println(result.wasSuccessful());
    }
}