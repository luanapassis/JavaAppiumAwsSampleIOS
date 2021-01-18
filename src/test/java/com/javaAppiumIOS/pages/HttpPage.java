package com.javaAppiumIOS.pages;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class HttpPage extends PageBase {

    By menuHttp = By.xpath("//XCUIElementTypeButton[@name='HTTP']");
    By urlField = By.xpath("//XCUIElementTypeTextField[@name='navigation bar']");
    By goButton = By.xpath("//XCUIElementTypeButton[@name='Go']");
    By amazonLogoSite = By.xpath("(//XCUIElementTypeLink[@name='Amazon'])[2]");
    By messageText = By.xpath("//XCUIElementTypeStaticText[contains(@name,'The url')]");
    By okMessage = By.xpath("//XCUIElementTypeButton[@name='OK']");

    public void clickMenuHttp()
    {
        click(menuHttp);
    }

    public void typeUrl(String url)
    {
        sendKeys(urlField, url);
    }

    public void clickGoButton()
    {
        click(goButton);
    }
    public boolean returnIfLogoAmazonExists()
    {
        waitLoadingScreen(amazonLogoSite);
        return returnElementDisplayed(amazonLogoSite);
    }

    public String returnContentAlert()
    {
        return getText(messageText);
    }

    public void clickOkMessage()
    {
        click(okMessage);
    }
}
