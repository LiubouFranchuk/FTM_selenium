package com.epam.ftm.Tests;

import com.epam.ftm.Pages.PasteBinPage;
import org.testng.annotations.Test;

public class Task1 extends BasicTest {

    @Test
    public void Task1Test(){
        PasteBinPage pasteBinPage = new PasteBinPage();
        pasteBinPage.accessUrl();
        pasteBinPage.pasteCode("Hello from WebDriver");
        pasteBinPage.setExpiration("10 Minutes");
        pasteBinPage.setPasteName("helloweb");
    }

}
