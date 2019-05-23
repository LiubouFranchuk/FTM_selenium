package com.epam.ftm.Tests;

import com.epam.ftm.Pages.CloudGooglePage;
import org.testng.annotations.Test;



public class Task3 extends BasicTest  {


    private String VMClass = "Regular";
    private String instanceType = "n1-standard-8";
    private String region = "Frankfurt";
    private String localSSD = "2x375";
    private String commitTerm = "1 Year";

    @Test
    public void Task3Test() throws Exception {

        CloudGooglePage cloudGooglePage = new CloudGooglePage();
        cloudGooglePage.accessUrl();
        cloudGooglePage.goToPage("Products");
        cloudGooglePage.goToPage("Pricing");
        cloudGooglePage.selectGoogleCloudPlatform("Calculators");
        cloudGooglePage.selectSubPlatform("Compute Engine");
        cloudGooglePage.setInstances("4");
        cloudGooglePage.selectOperatingSystem("Free: Debian");
        cloudGooglePage.selectMachineClass(VMClass);
        cloudGooglePage.selectMachineType(instanceType);
        cloudGooglePage.addGPUs("1", "Tesla V100");
        cloudGooglePage.selectSSD(localSSD);
        cloudGooglePage.selectDataCenterLocation(region);
        cloudGooglePage.selectCommitedUsage(commitTerm);
        cloudGooglePage.addtoEstimate();


        checkDataPresense("VM class: " + VMClass);
        checkDataPresense("Instance type: " + instanceType);
        checkDataPresense("Region: " + region);
        checkDataPresense("Total available local SSD space " + localSSD);
        checkDataPresense("Commitment term: " + commitTerm);


        checkDataPresense("USD 1,187.77");

    }


}
