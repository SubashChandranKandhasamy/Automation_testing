package com.example;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.time.Duration;
import java.io.IOException;
// import org.testng.Assert;
import org.testng.annotations.AfterTest;
public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;


  @BeforeTest
  public void beforeTest() {
 WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

  }


@Test
public void loginTest() throws InterruptedException, IOException {
   driver.get("https://demoqa.com/browser-windows");

    String mainWindowHandle = driver.getWindowHandle();
    
    WebElement newTabButton = driver.findElement(By.id("tabButton"));
    newTabButton.click();
    Set<String> windowHandles = driver.getWindowHandles();
    for(String i: windowHandles) {
        if(!i.equals(mainWindowHandle)) {
            driver.switchTo().window(i);
            System.out.println("Switched to new tab: " + i);
            Thread.sleep(2000);
            break;
        }
    }
    Thread.sleep(2000);

    driver.switchTo().window(mainWindowHandle);
    WebElement newWindow = driver.findElement(By.id("windowButton"));
    newWindow.click();
    windowHandles = driver.getWindowHandles();
    for(String i: windowHandles) {
        if(!i.equals(mainWindowHandle)) {
            driver.switchTo().window(i);
            System.out.println("Switched to new window: " + i);
            Thread.sleep(2000);
            break;
        }
    }
    Thread.sleep(2000);
    driver.switchTo().window(mainWindowHandle);

    WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
    newWindowMessage.click();
    windowHandles = driver.getWindowHandles();
    for(String i: windowHandles) {
        if(!i.equals(mainWindowHandle)) {
            driver.switchTo().window(i);
            System.out.println("Switched to new message window: " + i);
            Thread.sleep(2000);
            break;
        }
    }
    Thread.sleep(2000);
    driver.switchTo().window(mainWindowHandle);



}

@AfterTest
public void afterTest() {
  driver.quit();
}

}