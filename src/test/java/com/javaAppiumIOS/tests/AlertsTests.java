package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @Test
    public void verifyModal()
    {
        String messageExpected = "This is a modal view";
        AlertsPage alertsPage = new AlertsPage();

        alertsPage.clickMoreMenu();
        alertsPage.clickAlertsMenu();
        alertsPage.clickModalButton();
        String messageReturned = alertsPage.getModalText();

        Assert.assertEquals(messageReturned, messageExpected);
    }

    @Test
    public void verifyAlerts()
    {
        String messageExpected = "This is an alert";
        AlertsPage alertsPage = new AlertsPage();

        alertsPage.clickMoreMenu();
        alertsPage.clickAlertsMenu();
        alertsPage.clickAlertButton();
        String messageReturned = alertsPage.getAlertText();

        Assert.assertEquals(messageReturned, messageExpected);
    }
}
