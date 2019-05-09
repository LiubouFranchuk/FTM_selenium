package com.epam.ftm.Tests;

import com.epam.ftm.Pages.CloudGooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task3 extends BasicTest  {

    @Test
    public void Task3Test() throws Exception {

        CloudGooglePage cloudGooglePage = new CloudGooglePage();
        cloudGooglePage.accessUrl();
        cloudGooglePage.goToPage("Products");
        cloudGooglePage.goToPage("Pricing");
        cloudGooglePage.selectGoogleCloudPlatform("Calculators");
        cloudGooglePage.selectSubPlatform("Compute Engine");
        cloudGooglePage.setInstances("4");

    }


    @Test
    public void smoke1() {
        driver.get("https://cloud.google.com/products/calculator/");

        driver.switchTo().frame(0);
        WebElement dropdown = driver.findElement(By.id("input-0"));
        dropdown.click();
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//ul[@id='ul-0']/li[3]"))).click().perform();


//        CloudGooglePage cloudGooglePage = new CloudGooglePage();
//        cloudGooglePage.selectSubPlatform("App Engine");

//        driver.switchTo().frame(0);
//        driver.findElement(By.id("input-0")).click();
//        driver.findElement(By.xpath(""));

//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[contains(text(),'App Engine')]/../../.."))).click().perform();
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Number of instances')]/../input"))).click().perform();

    }


    @Test
    public void smoke2() {
        driver.get("https://cloud.google.com/products/calculator/");

        CloudGooglePage cloudGooglePage = new CloudGooglePage();
        cloudGooglePage.setInstances("4");

    }



}
