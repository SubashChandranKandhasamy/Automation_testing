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
    driver.get("https://demoqa.com/automation-practice-form");

    WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
    firstname.sendKeys("Subash");
    Thread.sleep(2000);
    WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
    lastname.sendKeys("Chandran");
    Thread.sleep(2000);
    WebElement email = driver.findElement(By.xpath("//div[@id='userEmail-wrapper']//input[@id='userEmail']"));
    email.sendKeys("717822p153@kce.ac.in");
    Thread.sleep(2000);
    WebElement gender = driver.findElement(By.xpath("//div[@id='genterWrapper']//label[@for='gender-radio-1']"));
    gender.click();
    Thread.sleep(2000);
    WebElement mobile = driver.findElement(By.xpath("//div[@id='userNumber-wrapper']//input[@id='userNumber']"));
    mobile.sendKeys("9025590798");
    Thread.sleep(2000);
    WebElement dateOfBirth = driver.findElement(By.xpath("//div[@id='dateOfBirth-wrapper']//input[@id='dateOfBirthInput']"));
    dateOfBirth.click();
    Thread.sleep(2000);
    WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    month.click();
    month.sendKeys("April");
    Thread.sleep(2000);
    WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    year.click();
    year.sendKeys("2005");
    Thread.sleep(2000);
    WebElement day = driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[@class='react-datepicker__day react-datepicker__day--030']"));
    day.click();
    Thread.sleep(2000);
    WebElement subject = driver.findElement(By.xpath("//div[@id='subjectsInput-wrapper']//input[@id='subjectsInput']"));
    subject.sendKeys("Software Testing");
    subject.sendKeys(Keys.ENTER);
    Thread.sleep(2000);

    WebElement hobbies = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']//label[@for='hobbies-checkbox-1']"));
    hobbies.click();
    Thread.sleep(2000);

    WebElement picture = driver.findElement(By.xpath("//div[@id='uploadPicture-wrapper']//input[@id='uploadPicture']"));
    picture.sendKeys("C:\\Users\\Subash Chandran K\\Pictures\\God of War Ragnarök\\ScreenShot-2025-5-27_10-57-33.png");
    Thread.sleep(2000);
    WebElement address = driver.findElement(By.xpath("//div[@id='currentAddress-wrapper']//textarea[@id='currentAddress']"));
    address.sendKeys("Karpagam College of Engineering");
    Thread.sleep(2000);
    WebElement state = driver.findElement(By.xpath("//div[@id='state-wrapper']//div[@id='state']"));
    state.click();
    Thread.sleep(2000);
    WebElement stateInput = driver.findElement(By.xpath("//div[@id='state-wrapper']//input[@id='react-select-3-input']"));
    stateInput.sendKeys("Tamil Nadu");
    Thread.sleep(2000);
    WebElement city = driver.findElement(By.xpath("//div[@id='city-wrapper']//div[@id='city']"));
    city.click();
    Thread.sleep(2000);
    WebElement cityInput = driver.findElement(By.xpath("//div[@id='city-wrapper']//input[@id='react-select-4-input']"));
    cityInput.sendKeys("Coimbatore");
    Thread.sleep(2000);
    WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
    submitButton.click();
    Thread.sleep(2000);


}

@AfterTest
public void afterTest() {
  driver.quit();
}

}