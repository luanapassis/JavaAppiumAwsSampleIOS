package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HomeTests extends TestBase {

    HomePage homePage;

    @Test
    public void verifyWellcomeMessage()
    {
        String messageExpected = "AWS Device Farm Sample app";

        homePage = new HomePage();

        String messageReturned = homePage.returnMessageHome();

        Assert.assertEquals(messageReturned,messageExpected);
    }

    @Test
    public void verifyVersionApplication()
    {
        String messageExpected = "Version 1";

        homePage = new HomePage();

        String messageReturned = homePage.returnVersionHome();

        Assert.assertEquals(messageReturned,messageExpected);
    }
}
