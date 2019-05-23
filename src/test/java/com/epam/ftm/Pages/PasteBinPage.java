package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;


public class PasteBinPage extends BasicPage {

    public static final String pasteBinUrl = "https://pastebin.com";
    

    protected By newPaste = By.id("paste_code");
    protected By pasteExpArrow = By.xpath("//div[contains(text(),'Paste Expiration')]/..//span[@class='select2-selection__arrow']");
    protected By syntaxHighArrow = By.xpath("//div[contains(text(),'Syntax Highlighting')]/..//span[@class='select2-selection__arrow']");
    protected By pasteName = By.name("paste_name");
    protected By createButton = By.id("submit");


    public void accessUrl(){
        driver.get(pasteBinUrl);
    }

    String enteredCode;

    public void pasteCode(String newPasteInput){
        WebElement newPasteWe = driver.findElement(newPaste);
        newPasteWe.sendKeys(newPasteInput);
        this.enteredCode = newPasteInput;
    }

    public void setExpiration(String expInput){
        WebElement pasteExpArrowWe = driver.findElement(pasteExpArrow);
        pasteExpArrowWe.click();
        WebElement expInputWe = waitElementVisibility(By.xpath("//li[contains(text(),'" + expInput + "')]"));
        expInputWe.click();
    }


    public void setSyntaxHigh(String syntaxHighInput){
        WebElement syntaxHighArrowWe = driver.findElement(syntaxHighArrow);
        syntaxHighArrowWe.click();
        WebElement syntaxHighWe = waitElementVisibility(By.xpath("//li[contains(text(),'" + syntaxHighInput + "')]"));
        syntaxHighWe.click();
    }

    String enteredTitle;

    public void setPasteName(String pasteNameInput) {
        WebElement pasteNameWe = driver.findElement(pasteName);
        pasteNameWe.sendKeys(pasteNameInput);
        this.enteredTitle = pasteNameInput;
    }

    public void createNewPaste(){
        WebElement createButtonWe = driver.findElement(createButton);
        createButtonWe.click();
    }

    public void checkTitle(){
        String title = driver.getTitle();
        System.out.println("Title = " + title);
        Assert.assertTrue(title.contains(enteredTitle));
    }

    public void checkHighlightedSyntax(){
        WebElement elmToCheck = driver.findElement(By.xpath("//ol[@class='bash']/li/div/span[1]"));
        String color = elmToCheck.getCssValue("color");
        System.out.println("RGB color = " + color);
        String hex = Color.fromString(color).asHex();
        System.out.println("Hex color = " + hex);
        Assert.assertEquals(hex, "#c20cb9");
        //REMINDER - 1 actual, 2 expected
    }

    public void checkCode(){
        String code = driver.findElement(By.id("paste_code")).getText();
        Assert.assertEquals(code, enteredCode);
    }



}

//NOTE - please, disregard the below code. That's only for my future reference. Thanks.

/*
   WebElement pasteExpWe = driver.findElement(pasteExp);
        Select select = new Select(pasteExpWe);
        select.deselectAll();
        select.selectByVisibleText(pasteExpInput);


 */

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var x = $(\'"+"//div[contains(text(),'Paste Expiration')]/..//span[@class='select2-selection__arrow']"+"\');");
        stringBuilder.append("x.click();");
        js.executeScript(stringBuilder.toString());
        */
