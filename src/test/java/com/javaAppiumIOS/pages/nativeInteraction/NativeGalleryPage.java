package com.javaAppiumIOS.pages.nativeInteraction;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class NativeGalleryPage extends PageBase {

    By menuGallery= By.xpath("//*[@name='Image Gallery']");
    By imagensOnGallery = By.xpath("//*[@type='XCUIElementTypeImage']");

    public void clickMenuGallery()
    {
        click(menuGallery);
    }
    public int getNumberOfImagesFromGallery()
    {
        //exists 8
        return returnHowManyElementsExists(imagensOnGallery);
    }

}
