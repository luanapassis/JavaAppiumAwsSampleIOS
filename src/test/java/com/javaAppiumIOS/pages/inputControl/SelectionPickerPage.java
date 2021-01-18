package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class SelectionPickerPage extends PageBase {

    By selectionPicker = By.xpath("//*[@type = 'XCUIElementTypePickerWheel']");

    public void clickSelectionPicker(String selectionDesired){
        String selection;
        selection = getValue(selectionPicker);
        if(selectionDesired.contains(selection))
        {}
        else {
            do {
                littleSwipeByElement(selectionPicker, "TOP");
                selection = getValue(selectionPicker);
            } while (!selectionDesired.contains(selection));
        }
    }
    public String getSelecionName()
    {
        return getValue(selectionPicker);
    }
}
