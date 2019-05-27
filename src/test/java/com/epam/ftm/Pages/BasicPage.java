package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

    protected WebDriver driver;
    public BasicPage() {
        this.driver = new FirefoxDriver();
//        this.driver = new ChromeDriver();
    }


    public WebElement waitElementVisibility(By elm){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(elm));

        return webElement;
    }


    public void scrollPage(){
//        JavascriptExecutor jse = ((JavascriptExecutor)driver);
//        jse.executeScript("scroll(0, -250);");
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        //TODO - none of these works for me
    }



}
