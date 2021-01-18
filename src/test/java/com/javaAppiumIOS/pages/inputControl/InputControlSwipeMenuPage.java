package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class InputControlSwipeMenuPage extends PageBase {

    By inputMenu = By.xpath("//XCUIElementTypeButton[@name='Inputs']");

    By pageNumber = By.xpath("//*[@type='XCUIElementTypePageIndicator']");
    public void clickInputMenu()
    {
        click(inputMenu);
    }

    public String returnNumberPage()
    {
        //page 2 of 10
        return getValue(pageNumber);
    }

    public void swipe(int qtdSwipe) {
        waitLoadingScreen(pageNumber);
       for (int i =1; i < qtdSwipe; i++) {

           swipeToLeft();

       }



    }



}
