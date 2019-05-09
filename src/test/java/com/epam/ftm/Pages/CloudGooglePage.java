package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

public class CloudGooglePage extends BasicPage{

    public static String cloudGoogleUrl = "https://cloud.google.com";

    protected By instances = By.xpath("//label[contains(text(),'Number of instances')]/../input");


    public void accessUrl(){
        driver.get(cloudGoogleUrl);
    }

    public void goToPage(String page){
        driver.findElement(By.linkText(page)).click();
    }

    public void selectGoogleCloudPlatform(String platform){
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[contains(text(),'" + platform + "')]/..")).click();
        //TODO platform selection doesn't work - incorrect frame #? etc? I have no clue
    }

    public void selectSubPlatform(String subPlatform) throws Exception {
        driver.switchTo().frame(0);
        WebElement dropdown = driver.findElement(By.id("input-0"));
        dropdown.click();

        int seqNum;
        if (subPlatform == "Compute Engine"){
            seqNum = 1;
        } else if (subPlatform == "App Engine"){
            seqNum = 2;
        } else {
            throw new Exception("Requested option is not available.");
        }

        WebElement option = driver.findElement(By.xpath("//ul[@id='ul-0']/li["+ seqNum + "]"));
        option.click();

        //TODO subplatform selection doesn't work - tried frames, action builder, etc. See Task3 - smoke1
    }


    public void setInstances(String num){
        driver.switchTo().frame(0);
        WebElement elm = driver.findElement(instances);
        elm.click();
        elm.sendKeys(num);
        //TODO - frame0 no longer works for this page

    }

    public void method(){

    }



}
