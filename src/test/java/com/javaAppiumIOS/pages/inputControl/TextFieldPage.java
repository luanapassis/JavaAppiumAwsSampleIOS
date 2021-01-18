package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class TextFieldPage extends PageBase {

    By textView = By.xpath("//*[@type = 'XCUIElementTypeTextField']");

    public void typeInTextField(String text)
    {
        sendKeys(textView, text);
    }
    public String getTextFromTextView()
    {
        return getText(textView);
    }
}
