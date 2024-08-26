package RunnerClass_Folder;

 
import org.BaseClass.BaseClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\DELL\\eclipse-workspace\\Parveen\\src\\test\\java\\Features\\Sample.feature",
				glue ="org.stepDefinition",
				monochrome = true,
				dryRun = false,
				publish = true,
				plugin = { "pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"html:CucumberReports",
							"json:reports/result.json",
							"junit:reports/result.xml"	} 
			
		
		)

public class Runner_Class {

	
	public static WebDriver driver;
	
	
	@BeforeClass
	public static void start() {
		
		driver = BaseClass.browser_Launch("edge");

	}
	
	@AfterClass
	public static void end() {
		
		driver.quit();

	}
	
	
	
	
}
