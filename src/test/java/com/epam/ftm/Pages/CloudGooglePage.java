package com.epam.ftm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CloudGooglePage extends BasicPage{

    public static final String cloudGoogleUrl = "https://cloud.google.com";

    protected By mainFrame = By.xpath("//iframe[@src='https://cloudpricingcalculator.appspot.com']");

    public String dropdownByVariable(String dropdown){
        return "//label[contains(text(),'" + dropdown + "')]/../input";
    }

    protected By instances = By.xpath("//label[contains(text(),'Number of instances')]/../input");
    protected By operatingSystem = By.xpath("//label[contains(text(),'Operating System')]/../md-select");
    protected By machineClass = By.xpath("//label[contains(text(),'Machine Class')]/../md-select");
    protected By machineType = By.xpath("//label[contains(text(),'Machine Type')]/../md-select");
    protected By GPUbox = By.xpath("//div[contains(text(),'Add GPUs')]/..");
    protected By numOfGPU = By.xpath("//label[contains(text(),'Number of GPUs')]/../md-select");
    protected By typeOfGPU = By.xpath("//label[contains(text(),'GPU type')]/../md-select");
    protected By LocalSSD = By.xpath("//label[contains(text(),'Local SSD')]/../md-select");
    protected By DataCenterLocation = By.xpath("//label[contains(text(),'Datacenter location')]/../md-select");
    protected By commitedUsage = By.xpath("//label[contains(text(),'Committed usage')]/../md-select");
    protected By estimateButton = By.xpath("//button[contains(text(),'Add to Estimate')]");

    //TODO refactor this - concat strings

/*    public Task2 test() {
        return new Task2();
    } <---- This is a sample of new page return. Method type and return type shold always be THE SAME. */




    public void accessUrl(){
        driver.get(cloudGoogleUrl);
    }

    public void goToPage(String page){
        driver.findElement(By.linkText(page)).click();
    }

    public void selectGoogleCloudPlatform(String platform){
        driver.findElement(By.xpath("//span[contains(text(),'" + platform + "')]/..")).click();
    }

    public void selectSubPlatform(String subPlatform) throws Exception {
        driver.switchTo().frame(driver.findElement(mainFrame));

        int seqNum;
        if (subPlatform == "Compute Engine"){
            seqNum = 1;
        } else if (subPlatform == "App Engine"){
            seqNum = 2;
        } else {
            throw new Exception("Requested option is not available.");
        }

        WebElement subPlfmIcon = driver.findElement(By.xpath("//md-tab-item[" + seqNum + "]//div[@class='hexagon-in2']"));
        subPlfmIcon.click();
    }


    public void setInstances(String num){
        WebElement elm = driver.findElement(instances);
        elm.click();
        elm.sendKeys(num);
    }

    private void selectOption (String option){
        driver.findElement(By.xpath("//div[contains(text(),'" + option + "')]")).click();
    }

    public void selectOperatingSystem(String system){
        driver.findElement(operatingSystem).click();
        selectOption(system);
    }


    public void selectMachineClass(String VMClass){
        driver.findElement(machineClass).click();
        selectOption(VMClass);
    }

    public void selectMachineType(String VMType){
        driver.findElement(machineType).click();
        selectOption(VMType);
    }


    public void addGPUs (String number, String type){
        driver.findElement(GPUbox).click();
        waitElementVisibility(numOfGPU).click();
        selectOption(number);
        waitElementVisibility(typeOfGPU).click();
        selectOption(type);
    }

    public void selectSSD(String SSD){
        driver.findElement(LocalSSD).click();
        selectOption(SSD);
    }

    public void selectDataCenterLocation(String location){
        driver.findElement(DataCenterLocation).click();
        selectOption(location);
    }

    public void selectCommitedUsage(String usage){
        driver.findElement(commitedUsage).click();
        selectOption(usage);
    }

    public void addtoEstimate(){
        driver.findElement(estimateButton).click();
    }









}
