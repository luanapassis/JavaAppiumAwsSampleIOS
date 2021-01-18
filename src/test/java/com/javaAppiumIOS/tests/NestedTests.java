package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.NestedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedTests extends TestBase {

    @Test
    public void verifySecondLevelOfView()
    {
        String messageExpected = "This is the second view";

        NestedPage nestedPage = new NestedPage();
        nestedPage.clickMoreMenu();
        nestedPage.clickNestedMenu();
        nestedPage.clickNextPage();
        String messageReturned = nestedPage.getNestedMessage();

        Assert.assertEquals(messageReturned, messageExpected);

    }
    @Test
    public void verifyFourthLevelOfView()
    {
        String messageExpected = "This is the fourth view";

        NestedPage nestedPage = new NestedPage();
        nestedPage.clickMoreMenu();
        nestedPage.clickNestedMenu();
        nestedPage.clickNextPage();
        nestedPage.clickNextPage();
        nestedPage.clickNextPage();
        String messageReturned = nestedPage.getNestedMessage();

        Assert.assertEquals(messageReturned, messageExpected);

    }
}
