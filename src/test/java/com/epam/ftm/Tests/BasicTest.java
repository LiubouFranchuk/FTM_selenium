package com.epam.ftm.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasicTest {

    protected WebDriver driver;


    @BeforeTest
    public void setupBrowser(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
//        driver.close();
    }



    public void checkDataPresense(String data){
        assert driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]")).isDisplayed();
    }




}
