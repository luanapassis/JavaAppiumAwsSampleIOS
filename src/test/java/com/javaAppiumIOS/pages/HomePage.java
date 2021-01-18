package com.javaAppiumIOS.pages;

import com.javaAppiumIOS.bases.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;

public class HomePage extends PageBase {

    By messageHome = By.xpath("//XCUIElementTypeStaticText[@name='AWS Device Farm Sample app']");
    By versionHome = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Version')]");

    public String returnMessageHome()
    {
        return getValue(messageHome);
    }
    public String returnVersionHome()
    {
        return getText(versionHome);
    }

}
