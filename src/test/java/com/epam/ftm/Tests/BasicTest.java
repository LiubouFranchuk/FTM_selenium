package com.epam.ftm.Tests;

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
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }




}
