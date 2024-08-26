package org.stepDefinition;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import RunnerClass_Folder.Runner_Class;
import io.cucumber.java.en.Given;

public class StepFile extends BaseClass {
	
	public static WebDriver driver = Runner_Class.driver;
	
	
	@Given("Launch the browser")
	public void launch_the_browser() {
	   
		url_Launch(driver, "https://www.facebook.com/");
	}
	
	
	

}
