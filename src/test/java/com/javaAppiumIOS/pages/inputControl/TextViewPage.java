package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class TextViewPage extends PageBase {


    By textView = By.xpath("//*[@type='XCUIElementTypeTextView']");

    public boolean returnIfTexviewExists()
    {
        return returnElementDisplayed(textView);
    }


}
