package com.epam.ftm.Tests;

import com.epam.ftm.Pages.CloudGooglePage;
import com.epam.ftm.Pages.PasteBinPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 extends BasicTest  {

    @Test
    public void smoke(){
        driver.get("https://pastebin.com/pfp5CUBk");
        WebElement elmToCheck = driver.findElement(By.xpath("//span[contains(text(),'git push')]"));
        String color = elmToCheck.getCssValue("color");
        Assert.assertEquals("#c20cb9", color);

    }

    @Test
    public void Task3Test(){

        CloudGooglePage cloudGooglePage = new CloudGooglePage();
        cloudGooglePage.accessUrl();
        cloudGooglePage.goToPage("Products");
        cloudGooglePage.goToPage("Pricing");
        cloudGooglePage.selectGoogleCloudPlatform("Calculator");
        cloudGooglePage.selectSubPlatform("Compute Engine"); //NOT working so far



    }



}
