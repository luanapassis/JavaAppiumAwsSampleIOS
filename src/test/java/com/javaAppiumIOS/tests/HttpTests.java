package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.HttpPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HttpTests extends TestBase {
    @Test
    public void verifyHttpSearchValidFormat_bugIphone11()
    {
        HttpPage httpPage = new HttpPage();

        httpPage.clickMenuHttp();
        httpPage.typeUrl("http://www.amazon.com");
        httpPage.clickGoButton();
        boolean logoExists = httpPage.returnIfLogoAmazonExists();

        Assert.assertTrue(logoExists);
    }

    @Test
    public void verifyHttpSearchInvalidFormat()
    {
        String site = "amazon";
        String messageExpected = "The url that you inputed: "+site+" is not in the right format. Please put in a url with the correct format. For example http://www.amazon.com";

        HttpPage httpPage = new HttpPage();

        httpPage.clickMenuHttp();
        httpPage.typeUrl(site);
        httpPage.clickGoButton();
        String msgReturned = httpPage.returnContentAlert();
        httpPage.clickOkMessage();

        Assert.assertEquals(msgReturned, messageExpected);
    }

    @Test
    public void verifyHttpSearchSecondInvalidFormat_bug()
    {
        String site = "http://amazon.com.br";
        String messageExpected = "The url that you inputed: "+site+" is not in the right format. Please put in a url with the correct format. For example http://www.amazon.com";

        HttpPage httpPage = new HttpPage();

        httpPage.clickMenuHttp();
        httpPage.typeUrl(site);
        httpPage.clickGoButton();
        String msgReturned = httpPage.returnContentAlert();
        httpPage.clickOkMessage();

        Assert.assertEquals(msgReturned, messageExpected);
    }

}
