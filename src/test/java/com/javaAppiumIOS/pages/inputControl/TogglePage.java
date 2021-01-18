package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class TogglePage extends PageBase {

    By toggleButton = By.xpath("//*[@type = 'XCUIElementTypeSwitch']");

    public void clickToggleButton()
    {
        click(toggleButton);
    }
    public String getValueToggleButton()
    {
        return getValue(toggleButton);
    }

}
