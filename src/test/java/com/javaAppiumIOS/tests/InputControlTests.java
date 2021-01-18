package com.javaAppiumIOS.tests;

import com.javaAppiumIOS.bases.TestBase;
import com.javaAppiumIOS.pages.inputControl.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputControlTests extends TestBase {

    //region first menu text view
    @Test
    public void verifyTextView()
    {
        String textExpected = "I am a textview";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        TextViewPage textViewPage = new TextViewPage();

        inputControlSwipeMenuPage.clickInputMenu();
        boolean tst = textViewPage.returnIfTexviewExists();

        Assert.assertTrue(tst);
    }
    //endregion

    //region second menu More Info
    @Test
    public void verifyMoreInfoBeforeClick()
    {
        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        MoreInfoPage moreInfoPage = new MoreInfoPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(2);
        boolean beforeState = moreInfoPage.returnIfElementBeforeExists();
        boolean afterState = moreInfoPage.returnIfElementAfterExists();

        Assert.assertTrue(beforeState);
        Assert.assertFalse(afterState);
    }

    @Test
    public void verifyMoreInfoAfterClick()
    {

        String messageMoreInfoExpected = "More Info";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        MoreInfoPage moreInfoPage = new MoreInfoPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(2);
        moreInfoPage.clickMoreInfo();
        String messageMoreInfoAfterClick = moreInfoPage.getNameInfoAfter();

        Assert.assertEquals( messageMoreInfoAfterClick, messageMoreInfoExpected);
    }

    @Test
    public void verifyMoreInfoDisappears()
    {
        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        MoreInfoPage moreInfoPage = new MoreInfoPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(2);
        moreInfoPage.clickMoreInfo();
        moreInfoPage.clickMoreInfoAfter();
        boolean beforeState = moreInfoPage.returnIfElementBeforeExists();
        boolean afterState = moreInfoPage.returnIfElementAfterExists();

        Assert.assertTrue(beforeState);
        Assert.assertFalse(afterState);
    }
    //endregion

    //region third menu Calendar
    @Test
    public void selectMonth()
    {
        String month = "April";
        String monthAbb = month.substring(0,3);

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        CalendarPage calendarPage = new CalendarPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(3);
        calendarPage.clickMonthPicker(month);
        String dateSelected = calendarPage.returnDateSelect();

        Assert.assertTrue(dateSelected.contains(monthAbb));
    }

    @Test
    public void selectDay()
    {
        String day = "19";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        CalendarPage calendarPage = new CalendarPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(3);
        calendarPage.clickDayPicker(day);
        String dateSelected = calendarPage.returnDateSelect();

        Assert.assertTrue(dateSelected.contains(day+","));
    }

    @Test
    public void selectYear()
    {
        String year = "2025";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        CalendarPage calendarPage = new CalendarPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(3);
        calendarPage.clickYearPicker(year);
        String dateSelected = calendarPage.returnDateSelect();

        Assert.assertTrue(dateSelected.contains(year));
    }
    //endregion
    //region Labels
    @Test
    public void verifyLabelOne()
    {
        String labelOneExpected = "I am label 1";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        LabelPage labelPage = new LabelPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(4);
        String labelOneReceived = labelPage.getLabelOneText();

        Assert.assertEquals(labelOneReceived, labelOneExpected);
    }
    @Test
    public void verifyLabelTwo()
    {
        String labelTwoExpected = "I am label 2";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        LabelPage labelPage = new LabelPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(4);
        String labelTwoReceived = labelPage.getLabelTwoText();

        Assert.assertEquals(labelTwoReceived, labelTwoExpected);
    }
    @Test
    public void verifyHowManyLabelsAre()
    {
        int qtdLabelsExpected = 2;

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        LabelPage labelPage = new LabelPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(4);
        int qtdLabelsReturned = labelPage.returnHowManylabelsExists();

        Assert.assertEquals(qtdLabelsReturned, qtdLabelsExpected);
    }
    //endregion
    //region Swipe to get the date
    @Test
    public void swipeToRefreshAndSeeTheTime_BugIphone11()
    {
        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        RefreshPage refreshPage = new RefreshPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(5);
        refreshPage.swipeToRefresh();
        boolean dateExists = refreshPage.getDateAfterRefresh();

        Assert.assertTrue(dateExists);
    }
    //endregion
    //region ToggleButton
    @Test
    public void verifyToggleButtonOff()
    {
        String toggleStatesExpected = "0";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        TogglePage togglePage = new TogglePage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(6);
        String toggleStatesReturned = togglePage.getValueToggleButton();

        Assert.assertEquals(toggleStatesReturned, toggleStatesExpected);
    }

    @Test
    public void verifyToggleButtonOn()
    {
        String toggleStatesExpected = "1";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        TogglePage togglePage = new TogglePage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(6);
        togglePage.clickToggleButton();
        String toggleStatesReturned = togglePage.getValueToggleButton();

        Assert.assertEquals(toggleStatesReturned, toggleStatesExpected);
    }
    @Test
    public void verifyToggleButtonOffAfterOn()
    {
        String toggleStatesExpected = "0";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        TogglePage togglePage = new TogglePage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(6);
        togglePage.clickToggleButton();
        togglePage.clickToggleButton();
        String toggleStatesReturned = togglePage.getValueToggleButton();

        Assert.assertEquals(toggleStatesReturned, toggleStatesExpected);
    }
    //endregion
    //region Text Field
    @Test
    public void verifyTextField()
    {
        String textExpected = "Test text field";

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        TextFieldPage textFieldPage = new TextFieldPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(7);
        textFieldPage.typeInTextField(textExpected);
        String textReturned = textFieldPage.getTextFromTextView();

        Assert.assertEquals(textReturned, textExpected);
    }
    //endregion
    //region Selection Picker
    @Test(dataProvider = "testData")
    public void ChooseSelectionDataDriven(String option)
    {
        String textExpected = option;

        InputControlSwipeMenuPage inputControlSwipeMenuPage = new InputControlSwipeMenuPage();
        SelectionPickerPage selectionPickerPage = new SelectionPickerPage();

        inputControlSwipeMenuPage.clickInputMenu();
        inputControlSwipeMenuPage.swipe(9);
        selectionPickerPage.clickSelectionPicker(textExpected);
        String textReturned = selectionPickerPage.getSelecionName();

        Assert.assertEquals(textReturned, textExpected);

    }


    //-----------------------------
    @DataProvider(name = "testData")
    public Object[] testDataCSV() throws IOException {

        String fileNameRoot = "/Users/base2/Desktop/testesApium/AutomacaoIOS2/src/test/resources/selections.csv";

        List<Object[]> records= new ArrayList<Object[]>();
        String record;
// set the UTF-8 character set, using the character input buffer with the read contents of the file stream BufferedReader
        BufferedReader file= new BufferedReader(new InputStreamReader(new FileInputStream(fileNameRoot),"UTF-8"));
// Ignore read the header row of the CSV file (first line)
        //file.readLine();
// Traverse read the file in everything else except for the first line and stored in the ArrayList named records, the object of each line records stored as an array of String
        while((record=file.readLine())!=null){
            String fields[]=record.split( ";");
            records.add(fields);
        }
// close the file object
        file.close();
// convert the List of storing test data into a two-dimensional array of Object
        Object[][] results= new Object[records.size()][];
// set two bits set values ​​in each row, each row is an Object Object
        for(int i=0;i<records.size();i++){
            results[i]=records.get(i);
        }
        return results;
    }
}
