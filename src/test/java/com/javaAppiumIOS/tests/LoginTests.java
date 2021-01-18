package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void verifyAccessDenied_Bug()
    {
        String login = "testLogin";
        String password = "testPassword";
        String messageExpected = "PERMISSION DENIED";

        LoginPage loginPage = new LoginPage();

        loginPage.clickMoreMenu();
        loginPage.clickLoginMenu();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        String messageLoginDenied = loginPage.getDeniedMessage();

        Assert.assertEquals(messageLoginDenied, messageExpected);
    }

    @Test
    public void verifyTryAgainButton_Bug()
    {
        String login = "testLogin";
        String password = "testPassword";

        LoginPage loginPage = new LoginPage();

        loginPage.clickMoreMenu();
        loginPage.clickLoginMenu();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        boolean ifTryAgainExists = loginPage.returnIfTryAgainExists();

        Assert.assertTrue(ifTryAgainExists);
    }
    @Test
    public void verifyActionsOfTryAgainButton_Bug()
    {
        String login = "testLogin";
        String password = "testPassword";

        LoginPage loginPage = new LoginPage();

        loginPage.clickMoreMenu();
        loginPage.clickLoginMenu();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        loginPage.clickTryAgainButton();
        boolean ifLoginExists = loginPage.returnIfLoginExists();

        Assert.assertTrue(ifLoginExists);
    }
}
