package com.epam.ftm.Tests;

import com.epam.ftm.Pages.PasteBinPage;
import org.testng.annotations.Test;

public class Task2 extends BasicTest  {

    String codeToPaste = "git config --global user.name  \"New Sheriff in Town\" \n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\") \n" +
            "git push origin master --force";
    //TODO NOTE: I didn't manage to read this from a file. My resultless attempts are stored in Helpers.CustomFileReader

    @Test
    public void Task2Test(){
        PasteBinPage pasteBinPage = new PasteBinPage();
        pasteBinPage.accessUrl();
        pasteBinPage.pasteCode(codeToPaste);
        pasteBinPage.setSyntaxHigh("Bash");
        pasteBinPage.setExpiration("10 Minutes");
        pasteBinPage.setPasteName("how to gain dominance among developers");
        pasteBinPage.createNewPaste();
        pasteBinPage.checkTitle();
        pasteBinPage.checkHighlightedSyntax();
        pasteBinPage.checkCode();
    }





}
