package org.pages;

import org.BaseClass.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Pages extends BaseClass {

    WebDriver driver;

    public Pages(WebDriver driver) {
        this.driver = driver;
    }

    // 1. Method to handle HTTP Basic Authentication pop-up
    
    public void loginWithAuthPopup(String username, String password, String url) {
        driver.get("http://" + username + ":" + password + "@" + url);
    }

    // 2. Method to click on a hyperlink by link text
    
    public void clickHyperlinkByText(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    // 3.Method to perform drag-and-drop operation
    
    public void dragAndDrop(String sourceId, String targetId) {
        WebElement sourceElement = driver.findElement(By.id(sourceId));
        WebElement targetElement = driver.findElement(By.id(targetId));

        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement, targetElement).perform();
    }

    // 4. Method to handle different Selenium navigation commands
    
    public void navigateCommands() {
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    // 5. Method to handle an alert
    
    public void handleAlert(String action, String text) {
        Alert alert = driver.switchTo().alert();
        switch (action.toLowerCase()) {
            case "accept":
                alert.accept();
                break;
            case "dismiss":
                alert.dismiss();
                break;
            case "sendkeys":
                alert.sendKeys(text);
                break;
            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }
    }
}
