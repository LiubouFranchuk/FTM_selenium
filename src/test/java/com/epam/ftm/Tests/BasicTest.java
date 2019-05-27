package com.epam.ftm.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasicTest {

    protected WebDriver driver;

    private static String currentOS = System.getProperty("os.name").toLowerCase();

    public static boolean isMac(){
        return (currentOS.indexOf("mac") >= 0);
    }

    public static boolean isWindows(){
        return (currentOS.indexOf("win") >= 0);
    }


    @BeforeTest
    public void setupBrowser() {
        if (isMac()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        }

        if (isWindows()) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        }

        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
//        driver = new ChromeDriver();

    }

    @AfterTest
    public void tearDown(){
//        driver.close();
    }



    public void checkDataPresense(String data){
        assert driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]")).isDisplayed();
    }




}
