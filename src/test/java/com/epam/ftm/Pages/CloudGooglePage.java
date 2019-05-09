package com.epam.ftm.Pages;

import org.openqa.selenium.By;

public class CloudGooglePage extends BasicPage{

    public static String cloudGoogleUrl = "https://cloud.google.com";


    public void accessUrl(){
        driver.get(cloudGoogleUrl);
    }

    public void goToPage(String page){
        driver.findElement(By.linkText(page)).click();
    }

    public void selectGoogleCloudPlatform(String platform){
        driver.findElement(By.xpath("//span[contains(text(),'" + platform + "')]/..")).click();
    }

    public void selectSubPlatform(String subPlatform){
        driver.findElement(By.xpath("//div[@title='" + subPlatform + "']")).click();
        //TODO - to implement. Elements can't be found. Probably frames issue
    }



}
