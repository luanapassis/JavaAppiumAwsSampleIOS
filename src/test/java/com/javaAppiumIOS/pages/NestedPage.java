package com.javaAppiumIOS.pages;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class NestedPage extends PageBase {

    By moreMenu = By.xpath("//*[@name='More']");
    By nestedMenu = By.xpath("//*[@name='Nested']");
    By nextButton = By.xpath("//*[@name='Next']");
    By nestedText = By.xpath("//*[@type='XCUIElementTypeStaticText']");

    //This is the first view until fourth

    public void clickMoreMenu()
    {
        click(moreMenu);
    }
    public void clickNestedMenu()
    {
        click(nestedMenu);
    }
    public void clickNextPage()
    {
        click(nextButton);
    }
    public String getNestedMessage()
    {
        return getText(nestedText);
    }



}
