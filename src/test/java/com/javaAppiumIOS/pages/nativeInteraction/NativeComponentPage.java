package com.javaAppiumIOS.pages.nativeInteraction;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class NativeComponentPage extends PageBase {

    By menuComponent= By.xpath("//*[@name='Out of View Component']");
    By hidenElement = By.xpath("//*[@name='This is hidden text' and @visible = 'true']");

    public void clickMenuComponent()
    {
        click(menuComponent);
    }

    public boolean scrollUntilElementIsShown(){
        boolean elementExist;
        do{
            topToBottonSwipe();
            elementExist = returnIfElementExists(hidenElement);

        }while (!elementExist);
        return elementExist;
    }



}
