package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.nativeInteraction.NativeComponentPage;
import com.javaAppiumIOS.pages.nativeInteraction.NativeGalleryPage;
import com.javaAppiumIOS.pages.nativeInteraction.NativePage;
import com.javaAppiumIOS.pages.nativeInteraction.NativeTableOfElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NativeTests extends TestBase {

    @Test
    public void verifyNumberOfPicInGallery()
    {
        int numberExpected = 8;

        NativePage nativePage = new NativePage();
        NativeGalleryPage nativeGalleryPage = new NativeGalleryPage();

        nativePage.clickNativeButton();
        nativeGalleryPage.clickMenuGallery();
        int numberReturned = nativeGalleryPage.getNumberOfImagesFromGallery();

        Assert.assertEquals(numberReturned, numberExpected);
    }
    @Test
    public void verifyElementsInAlIst()
    {
        String elementExpected = "38";
        NativePage nativePage = new NativePage();
        NativeTableOfElementsPage tableOfElementsPage = new NativeTableOfElementsPage();

        nativePage.clickNativeButton();
        tableOfElementsPage.clickMenuTableElementsMenu();
        tableOfElementsPage.scrollUntilElement38();
        tableOfElementsPage.scrollUntilElement38();

        String elementReturned = tableOfElementsPage.getTextElement38();

        Assert.assertEquals(elementReturned, elementExpected);
    }
    @Test
    public void verifyIfHidenElementIsShown()
    {
        NativePage nativePage = new NativePage();
        NativeComponentPage nativeComponentPage = new NativeComponentPage();

        nativePage.clickNativeButton();
        nativeComponentPage.clickMenuComponent();
        boolean elementExists = nativeComponentPage.scrollUntilElementIsShown();

        Assert.assertTrue(elementExists);
    }

}
