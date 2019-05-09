package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

    protected WebDriver driver;
    public BasicPage() {
        this.driver = new FirefoxDriver();
    }


    public WebElement waitElementVisibility(By elm){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(elm));

        return webElement;
    }



}
