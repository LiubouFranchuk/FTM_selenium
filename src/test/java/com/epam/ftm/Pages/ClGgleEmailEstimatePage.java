package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ClGgleEmailEstimatePage extends BasicPage {

    protected By emailEstBtn = By.id("email_quote");



    public void getEmailEst(){
        driver.findElement(emailEstBtn).click();
    }

    String generatedEmail;


    public void generateEmail(){

/*        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
        driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
        //TODO find more info on Keys class and tabs interactions*/

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://temp-mail.org/");

        WebElement email = driver.findElement(By.id("mail"));
        generatedEmail = email.getAttribute("value");

        driver.switchTo().window(tabs.get(0));

    }


    public void sendEmail(){

    }


    public void checkEmailContent(){

    }

    //TODO windowHandler / switchTo / tabs shifting




}
