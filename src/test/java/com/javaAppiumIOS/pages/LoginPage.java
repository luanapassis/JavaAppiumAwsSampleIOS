package com.javaAppiumIOS.pages;

import com.javaAppiumIOS.bases.PageBase;
import com.javaAppiumIOS.bases.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    By moreMenu = By.xpath("//*[@name='More']");
    By loginMenu = By.xpath("//*[@name='Login']");
    By loginField = By.xpath("//*[@value = 'Username']");
    By passwordField = By.xpath("//*[@value = 'Password']");
    By loginButton = By.xpath("//*[@name = 'Login' ][@type='XCUIElementTypeButton']");
    By deniedLabel = By.xpath("//*[@name='PERMISSION DENIED']");
    By tryAgainButton = By.xpath("//*[@name='try again'][@type = 'XCUIElementTypeButton']");

    public void clickMoreMenu()
    {
        click(moreMenu);
    }
    public void clickLoginMenu()
    {
        click(loginMenu);
    }
    public void typeLogin(String login)
    {
        sendKeys(loginField, login);
    }
    public boolean returnIfLoginExists()
    {
        return returnIfElementExists(loginField);
    }
    public void typePassword(String password)
    {
        sendKeys(passwordField, password);
    }
    public void clickLogin()
    {
        click(loginButton);
    }
    public String getDeniedMessage()
    {
        return getText(deniedLabel);
    }
    public boolean returnIfTryAgainExists()
    {
        return returnIfElementExists(tryAgainButton);
    }
    public void clickTryAgainButton()
    {
        click(tryAgainButton);
    }

}
