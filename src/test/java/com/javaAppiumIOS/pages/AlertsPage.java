package com.javaAppiumIOS.pages;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class AlertsPage extends PageBase {

    By moreMenu = By.xpath("//*[@name='More']");
    By alertsMenu = By.xpath("//*[@name='Alerts']");
    By modalButton = By.xpath("//*[@name='Modal'][@type='XCUIElementTypeButton']");
    By alertButton = By.xpath("//*[@name='Alert'][@type = 'XCUIElementTypeButton']");
    By modalTextField = By.xpath("//*[@name='This is a modal view']");
    By modalOkButton = By.xpath("//*[@type='XCUIElementTypeButton']");
    By alertMessage = By.xpath("//XCUIElementTypeStaticText[@name='This is an alert']");
    By alertOk = By.xpath("//XCUIElementTypeButton[@name='OK']");

    public void clickMoreMenu()
    {
        click(moreMenu);
    }
    public void clickAlertsMenu()
    {
        click(alertsMenu);
    }
    public void clickModalButton()
    {
        click(modalButton);
    }
    public void clickAlertButton()
    {
        click(alertButton);
    }
    public String getModalText()
    {
        //This is a modal view
        return getText(modalTextField);
    }
    public void clickModalOk()
    {
        click(modalOkButton);
    }
    public String getAlertText()
    {
        //This is an alert
        return getText(alertMessage);
    }
    public void clickAlertOk()
    {
        click(alertOk);
    }

}
