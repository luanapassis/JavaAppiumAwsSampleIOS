package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class RefreshPage extends PageBase {

    By refreshField = By.xpath("//*[@name='Refresh to get the time']");
    By dateAfterRefresh = By.xpath("//*[contains(@value,'GMT-3')]");

    public void swipeToRefresh()
    {
        swipeElementWithDirection(refreshField, "DOWN");
    }
    public boolean getDateAfterRefresh()
    {
        return returnIfElementExists(dateAfterRefresh);
    }

}
