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
   driver.get("https://dodo.quantumnique.tech/");
    Thread.sleep(5000);

    WebElement name = driver.findElement(By.name("username"));
    name.sendKeys("717822P153");
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("Student@123");


    Map<String, String> menuList = new HashMap<>();
    menuList.put("ASSESSMENTS", "assessments");
    menuList.put("COURSES", "courses");
    menuList.put("CODE", "code-compiler");
    menuList.put("PRACTICE", "practice");
    menuList.put("LSRW", "lsrw");
    menuList.put("BLOGS", "blog");

    menuList.forEach((menuName,url)->{
      WebElement menu = driver.findElement(By.linkText(menuName));
      menu.click();
      String expUrl = "https://dodo.quantumnique.tech/" + url + "/";
      String currUrl = driver.getCurrentUrl() + "/";
      System.out.println("Expected URL: " + expUrl);
      System.out.println("Current URL: " + currUrl);
      if (currUrl.equals(expUrl)) {
          System.out.println("Test passed for " + menuName);
      } else {
          System.out.println("Test failed for " + menuName);
      }
    });




}

@AfterTest
public void afterTest() {
  driver.quit();
}

}
