package org.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
    
	public static WebDriver browser_Launch(String name) {
		
		if (name.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
		}else if (name.equals("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("private");
			driver = new EdgeDriver(option);
		}
		return driver;
		

	}
	
	public static void url_Launch(WebDriver driver , String url) {
		
		driver.get(url);

	}
	
	public static void maximize_screen(WebDriver driver) {
		
		driver.manage().window().maximize();

	}
	
	public static void quit_browser(WebDriver driver) {
		
		driver.quit();

	}
	
	public static void close_browser(WebDriver driver) {
		
		driver.close();

	}
	
	public static void back_page(WebDriver driver) {
		
		driver.navigate().back();

	}
	
	public static void forward_page(WebDriver driver) {
		
		driver.navigate().forward();

	}
	
	public static void refresh_page(WebDriver driver) {
		
		driver.navigate().refresh();

	}
	
	public static void get_window_size(WebDriver driver) {
	
		driver.manage().window().getSize();
		
	}
	
	public static void element_click(WebElement element) {
		
		element.click();

	}
	
	public static void set_value(WebElement element, String value) {
		
		element.sendKeys(value);

	}
	
	public static void clear_value(WebElement element) {
		
		element.clear();
		
	}
	
	public static void fetch_value(WebElement element) {
		
		String text = element.getText();
		System.out.println(text);

	}
	
	public static void element_visible(WebElement element) {
		
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);

	}
	
	public static void element_enable(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println(enabled);
		
	}
	
	public static void element_selected(WebElement element) {
		
		boolean enabled = element.isEnabled();
		System.out.println(enabled);

	}
	
	public static void screenshot(WebDriver driver, String location) throws IOException {
		
		TakesScreenshot pic = (TakesScreenshot) driver;
		File screenshotAs = pic.getScreenshotAs(OutputType.FILE);
		File des = new File(location);
		FileUtils.copyFile(screenshotAs, des);

	}
	
	public static void select_option_index(WebElement element, int num) {
		
		Select s = new Select(element);
		s.selectByIndex(num);

	}
	
	public static void select_option_value(WebElement element, String value) {
		
		Select s = new Select(element);
		s.selectByValue(value);

	}
	
	public static void select_option_text(WebElement element, String value) {
		
		Select s = new Select(element);
		s.selectByVisibleText(value);

	}
	
	public static void get_dropdown_options(WebElement element) {

		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement options : allSelectedOptions) {
			System.out.println(options);
		}
		
	}
	
	public static void deselect_option_index(WebElement element, int num) {
		
		Select s = new Select(element);
		s.deselectByIndex(num);

	}
	
	public static void deselect_option_value(WebElement element, String value) {
		
		Select s = new Select(element);
		s.deselectByValue(value);

	}
	
	public static void deselect_option_text(WebElement element, String value) {
		
		Select s = new Select(element);
		s.deselectByVisibleText(value);

	}
	
	public static void check_option_multiple(WebElement element) {
		
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);

	}
	
	
	public static void fetch_all_options(WebElement element) {
		
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement value : options) {
			System.out.println(value);
		}
	}
	
	public static void alert_control(WebDriver driver) {
		
		Alert ok = driver.switchTo().alert();
		ok.accept();

	}
	
	public static void alert_dismiss(WebDriver driver) {
		
		Alert reject = driver.switchTo().alert();
		reject.dismiss();

	}
	
	public static void handleFrame(WebDriver driver, WebElement element) {
		
		driver.switchTo().frame(element);
		
	}
	
	public static void frame_default_content(WebDriver driver) {
		
		driver.switchTo().defaultContent();
		
	}
	
	public static void js_Click(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}
	
	public static void js_ScrollPage(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView()", element);

	}
	
	public static void right_click(WebDriver driver, WebElement element) {
		
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();

	}
	
	public static void action_click(WebDriver driver, WebElement element) {
		
		Actions a = new Actions(driver);
		a.click(element).build().perform();

	}
	
	public static void double_click(WebDriver driver, WebElement element) {
		
		Actions a = new Actions(driver);
		a.doubleClick(element).build().perform();

	}
	
	public static void move_the_mouse(WebDriver driver, WebElement element) {
		
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}
	
	public static void key_down() throws AWTException {
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}
	
	public static void key_enter() throws AWTException {
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
	
	public static void implicitWait(WebDriver driver, int value) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));

	}
	
 
	
	
	
	
	
	
	
	
	
	
	
}
