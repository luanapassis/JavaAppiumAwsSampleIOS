package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class LabelPage extends PageBase {

    By labelOne = By.xpath("//*[@name='I am label 1']");
    By labelTwo= By.xpath("//*[@name='I am label 2']");
    By labels = By.xpath("//*[@type='XCUIElementTypeStaticText']");

    public String getLabelOneText()
    {
        return getText(labelOne);
    }

    public String getLabelTwoText()
    {
        return getText(labelTwo);
    }

    public int returnHowManylabelsExists()
    {
        return returnHowManyElementsExists(labels);
    }

}
