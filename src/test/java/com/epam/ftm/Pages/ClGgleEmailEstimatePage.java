package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ClGgleEmailEstimatePage extends BasicPage {

    protected By emailEstBtn = By.id("email_quote");



    public void getEmailEstimate(){
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

        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.sendKeys(generatedEmail);

        WebElement sendBtn = driver.findElement(By.xpath("//button[@aria-label='Send Email']"));
        sendBtn.click();

        driver.switchTo().window(parentWindowHandler);

    }


    public void openReceivedEmail(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement receivedEmail = driver.findElement(By.xpath("//span[contains(text(),'Google Cloud Sales')]"));
        receivedEmail.click();


    }





}
