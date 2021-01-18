package com.javaAppiumIOS.pages.nativeInteraction;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class NativeTableOfElementsPage extends PageBase {

    By tableElementsMenu = By.xpath("//*[@name='Table of elements']");
    By element38 = By.xpath("//XCUIElementTypeStaticText[@name='38']");

    public void clickMenuTableElementsMenu()
    {
        click(tableElementsMenu);
    }

    public void scrollUntilElement38()
    {
        topToBottonSwipe();
    }
    public String getTextElement38()
    {
        click(element38);
        return getText(element38);
    }

}
