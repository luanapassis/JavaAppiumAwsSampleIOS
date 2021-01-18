package com.javaAppiumIOS.pages.nativeInteraction;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class NativePage extends PageBase {

    By menuNative = By.xpath("//*[@name='Native']");

    public void clickNativeButton()
    {
        click(menuNative);
    }

}
