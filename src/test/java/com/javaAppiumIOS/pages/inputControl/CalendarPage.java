package com.javaAppiumIOS.pages.inputControl;

import com.javaAppiumIOS.bases.PageBase;
import org.openqa.selenium.By;

public class CalendarPage extends PageBase {

    By monthPicker = By.xpath("//*[@type='XCUIElementTypePickerWheel'][1]");
    By dayPicker = By.xpath("//*[@type='XCUIElementTypePickerWheel'][2]");
    By yearPicker = By.xpath("//*[@type='XCUIElementTypePickerWheel'][3]");
    By dateSelected = By.xpath("//*[@type = 'XCUIElementTypeStaticText']");

    public void clickMonthPicker(String monthDisired){
        String month;
        littleSwipeByElement(monthPicker, "TOP");
        do{
            littleSwipeByElement(monthPicker, "TOP");
            month = getValue(monthPicker);

        }while (!monthDisired.contains(month));
    }

    public void clickDayPicker(String dayDisired){
        String day;
        littleSwipeByElement(dayPicker, "TOP");
        do{
            littleSwipeByElement(dayPicker, "TOP");
            day = getValue(dayPicker);

        }while (!dayDisired.contentEquals(day));
    }

    public void clickYearPicker(String yearDisired){
        String year;
        littleSwipeByElement(yearPicker, "TOP");
        do{
            littleSwipeByElement(yearPicker, "TOP");
            year = getValue(yearPicker);

        }while (!yearDisired.contentEquals(year));
    }

    public String returnDateSelect()
    {
        return getText(dateSelected);
    }

}
