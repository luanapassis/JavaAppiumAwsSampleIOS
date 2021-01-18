package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class MoreInfoPage extends PageBase {

    By moreInfoBefore = By.xpath("//XCUIElementTypeButton[@name='plus.circle']");

    By moreInfoAfter = By.xpath("//XCUIElementTypeButton[@name='More Info']");

    public void clickMoreInfo()
    {
        click(moreInfoBefore);
    }
    public void clickMoreInfoAfter()
    {
        click(moreInfoAfter);
    }

    public String getNameInfoAfter()
    {
        return getName(moreInfoAfter);
    }
    public boolean returnIfElementAfterExists()
    {
        return returnIfElementExists(moreInfoAfter);

    }
    public boolean returnIfElementBeforeExists()
    {
        return returnIfElementExists(moreInfoBefore);

    }
}
