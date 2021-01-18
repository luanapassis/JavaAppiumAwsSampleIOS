package com.javaAppiumIOS.bases;

import com.javaAppiumIOS.GlobalParameters;
import com.javaAppiumIOS.utils.DriveFactory;
import com.javaAppiumIOS.utils.ExtentReportUtils;
import com.javaAppiumIOS.utils.Utils;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.time.StopWatch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class PageBase {
    private AppiumDriver driver = null;
    private WebDriverWait wait = null;

    public PageBase(){
        driver = DriveFactory.getDriver();
        wait = new WebDriverWait (driver, 90);
    } //fim construtor

    //mobile elements
    protected void waitForElement(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(MobileElement element){
        waitForElement(element);
        element.click();
    }

    protected void sendKeys(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(text);
    }

    protected String getText(MobileElement element){
        waitForElement(element);
        String text = element.getText();
        return text;
    }
    public void littleSwipeByElement(By locator, String direction)
    {
        MobileElement element = waitForElement(locator);

        String action = "";
        double endXPercen = 0.72;
        int startX, startY, endX, endY;

        //Coleta a largura da tela
        int screenWidth = driver.manage().window().getSize().width;

        //Coleta a altura da tela
        int screenHeight = driver.manage().window().getSize().height;

        switch (direction) {
            case "TOP":
                //Coleta o centro eixo x do elemento
                startX = element.getCenter().getX();
                //Coleta a altura do elemento
                startY = element.getSize().getHeight();

                endX = startX;

                //Calculo do limite do eixo Y (altura - percentil de altura aceitavel)
                endY = screenHeight - (int) (screenHeight * endXPercen);
                action = "TOP";
                break;

            case "RIGHT":
                //Coleta o centro eixo x do elemento
                startX = element.getCenter().getX();
                //Coleta a altura do elemento
                startY = element.getCenter().getY();

                //Calcula o ponto final do eixo X: baseando-se na largura da tela x percentil
                endX = (int) (screenWidth * endXPercen);
                endY = startY;
                action = "RIGHT";
                break;

            case "LEFT":
                //Coleta o centro eixo x do elemento
                startX = element.getSize().getWidth();
                //Coleta a altura do elemento
                startY = element.getCenter().getY();

                //Calcula o ponto final do eixo X: largura - percentil do elemento
                endX = screenWidth - (int) (screenWidth * endXPercen);
                endY = startY;
                action = "LEFT";
                break;

            default:
                //Coleta o centro eixo x do elemento
                startX = element.getCenter().getX();
                //Coleta a altura do elemento
                startY = element.getLocation().getY();

                endX = startX;

                //Calcula o ponto final do eixo X: baseando-se na altura da tela x percentil
                endY = (int) (screenHeight * endXPercen);
                action = "DOWN";
                break;
        }

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startX , startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY)).release().perform();

    }

    public void swipeElementWithDirection(By locator, String direction) {

        MobileElement element = waitForElement(locator);

        String action = "";
        double endXPercen = 0.9;
        int startX, startY, endX, endY;

        //Coleta a largura da tela
        int screenWidth = driver.manage().window().getSize().width;

        //Coleta a altura da tela
        int screenHeight = driver.manage().window().getSize().height;

        switch (direction) {
            case "TOP":
                //Coleta o centro eixo x do elemento
                startX = element.getCenter().getX();
                //Coleta a altura do elemento
                startY = element.getSize().getHeight();

                endX = startX;

                //Calculo do limite do eixo Y (altura - percentil de altura aceitavel)
                endY = screenHeight - (int) (screenHeight * endXPercen);
                action = "TOP";
                break;

            case "RIGHT":
                //Coleta o centro eixo x do elemento
                startX = element.getCenter().getX();
                //Coleta a altura do elemento
                startY = element.getCenter().getY();

                //Calcula o ponto final do eixo X: baseando-se na largura da tela x percentil
                endX = (int) (screenWidth * endXPercen);
                endY = startY;
                action = "RIGHT";
                break;

            case "LEFT":
                //Coleta o centro eixo x do elemento
                startX = element.getSize().getWidth();
                //Coleta a altura do elemento
                startY = element.getCenter().getY();

                //Calcula o ponto final do eixo X: largura - percentil do elemento
                endX = screenWidth - (int) (screenWidth * endXPercen);
                endY = startY;
                action = "LEFT";
                break;

            default:
                //Coleta o centro eixo x do elemento
                startX = element.getCenter().getX();
                //Coleta a altura do elemento
                startY = element.getLocation().getY();

                endX = startX;

                //Calcula o ponto final do eixo X: baseando-se na altura da tela x percentil
                endY = (int) (screenHeight * endXPercen);
                action = "DOWN";
                break;
        }
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startX , startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY)).release().perform();

    }



//By locator

    protected void waitForBy(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected MobileElement waitForElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    protected void click(By locator){
        waitForElement(locator).click();
    }

    protected void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        return text;
    }

    protected boolean returnElementDisplayed(By locator){
        return waitForElementBeVisible(locator).isDisplayed();
    }


    protected MobileElement waitForElementBeVisible(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);

        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void waitLoadingScreen(By locator){

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);

        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        try
        {
            do
            {
                if (element.getAttribute("hidden") == "true")
                {
                    timeOut.stop();
                    return;
                }
            } while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT);
        }
        catch (WebDriverException e)
        {
        }
    }

    public void swipeToLeft() {
        Dimension dim= driver.manage().window().getSize();
        int height=(int) dim.getHeight();
        int width=(int) dim.getWidth();

        //int startx=(int) (width - ( width * 0.1));
        int startx=(int) (width - ( width * 0.01));
        int endx=(int) ( width * 0.1);
        int startY= (int) (height*0.80);
        int endY=(int) (height*0.80);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startx , startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(endx, endY)).release().perform();

    }

    protected String getValue(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);

        waitForElement(element);
        String text = element.getAttribute("value");
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        return text;
    }

    protected String getName(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);

        waitForElement(element);
        String text = element.getAttribute("name");
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        return text;
    }

    protected boolean returnIfElementExists(By locator)
    {
        boolean result = false;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        }
        catch (Exception e)
        {

        }
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + result);
        return  result;
    }

    protected int returnHowManyElementsExists(By locator)
    {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        List<WebElement> result = driver.findElements(locator);
        return result.size();
    }

    public void topToBottonSwipe() {
        Dimension dim= driver.manage().window().getSize();
        int height=(int) dim.getHeight();
        int width=(int) dim.getWidth();
        int x= width/2;
        int startY=(int) (height*0.80);
        int endY=(int) (height*0.20);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(x,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(x,endY)).release().perform();
    }

    /*
    Page Base antigo
    //Variaveis globals
    protected AppiumDriver driver = null;
    protected WebDriverWait wait = null;
    protected JavascriptExecutor javaScriptExecutor = null;

    //Construtor
    public PageBase(){
        PageFactory.initElements(new AppiumFieldDecorator(DriveFactory.getDriver()),this);
        driver = DriveFactory.getDriver();
        wait = new WebDriverWait (driver, GlobalParameters.TIMEOUT_DEFAULT);
    }

    protected  void hideKeyboard()
    {
        driver.hideKeyboard();
    }
    protected boolean returnIfElementExists(MobileElement element){
        boolean result = false;

        try
        {
            waitForElement(element);
            result = true;
        }
        catch (Exception e)
        {

        }
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }

    //region Sincronização
    protected void waitLoadingScreen(MobileElement element){

        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        try
        {
            do
            {
                if (element.getAttribute("hidden") == "true")
                {
                    timeOut.stop();
                    return;
                }

            } while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT);
        }
        catch (WebDriverException e)
        {

        }
    }

    protected void waitForElement(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected  boolean waitForTextPresentElement(MobileElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected MobileElement waitForElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    //endregion


    //region Mobile Element Methods
    protected void waitForElementToBeClickeable(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementByTime(MobileElement element, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementByTimeAndScreenShot(MobileElement element, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.visibilityOf(element));
        ExtentReportUtils.addTestInfo(2, "");
    }

    protected void click(MobileElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            //WebElement element = null;
            try
            {
                waitForElement(element);
                element.click();
                ExtentReportUtils.addTestInfo(3, "");
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e) {
                continue;
            }
            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }
                throw e;
            }
        }
        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void sendKeys(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }
    protected  void sendKeysUsingActions(MobileElement element, String text)
    {
        waitForElement(element);
        click(element);
        Actions a = new Actions(driver);
        a.sendKeys(text);
        a.perform();
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }

    protected void sendKeysWithoutWaitVisible(MobileElement element, String text){
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }
    protected void clear(MobileElement element){
        waitForElement(element);
        element.clear();
        ExtentReportUtils.addTestInfo(3, "");
    }
    protected void clearAndSendKeys(MobileElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "");
    }
    protected void clearAndSendKeysAlternative(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }
    protected String getText(MobileElement element){
        waitForElement(element);
        String text = element.getText();
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        return text;
    }

    protected String getValue(MobileElement element){
        waitForElement(element);
        String text = element.getAttribute("value");
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        return text;
    }
    protected String getContentDescription(MobileElement element){
        waitForElement(element);
        String text = element.getAttribute("contentDescription");
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        return text;
    }
    protected boolean returnIfElementIsDisplayed(MobileElement element){
        waitForElement(element);
        boolean result = element.isDisplayed();
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + result);
        return result;
    }

    protected boolean returnIfElementIsEnabled(MobileElement element){
        waitForElement(element);
        boolean result = element.isEnabled();
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + result);
        return result;
    }
    protected boolean returnIfElementIsSelected(MobileElement element){
        waitForElement(element);
        boolean result = element.isSelected();
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + result);
        return result;
    }
    protected void scrollUsingTouchActions_ByElements(MobileElement startElement, MobileElement endElement, int seconds) {
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startElement.getLocation().x,startElement.getLocation().y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .moveTo(PointOption.point(endElement.getLocation().x,endElement.getLocation().y)).release().perform();
    }
    protected void scrollUsingTouchActions(int startX,int startY, int endX, int endY, int seconds) {
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .moveTo(PointOption.point(endX,endY)).release().perform();
        ExtentReportUtils.addTestInfo(3, "");
    }
    protected void scrollUsingPressTouchActions(int startX,int startY, int endX, int endY) {
        TouchAction actions = new TouchAction(driver);
        actions.longPress(PointOption.point(startX,startY))
                .moveTo(PointOption.point(endX,endY)).release().perform();
        ExtentReportUtils.addTestInfo(3, "");
    }


    protected void longPressOld(MobileElement element) {
        waitForElement(element);
        TouchActions action = new TouchActions(driver);
        action.longPress(element);
        action.perform();
        ExtentReportUtils.addTestInfo(3,"");
    }

    protected void tapOld(MobileElement element){
        waitForElement(element);
        TouchActions action = new TouchActions(driver);
        action.singleTap(element);
        action.perform();
    }

    protected void tap(MobileElement element){
        waitForElement(element);
        TouchAction actions = new TouchAction(driver);
        actions.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)));
        actions.perform();
    }
    protected void doubleTapOld(MobileElement element){
        waitForElement(element);
        TouchActions action = new TouchActions(driver);
        action.doubleTap(element);
        action.perform();
        ExtentReportUtils.addTestInfo(3, "");
    }

    protected void doubleTap(MobileElement element){
        waitForElement(element);
        TouchAction actions = new TouchAction(driver);
        actions.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2));
        actions.perform();
    }

    protected void doubleTapPress(int x, int y){
        //protected void doubleTapPress(Point points){
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(x, y)).release().perform()
                .press(PointOption.point(x,y)).release().perform();

    }

    protected void longPress(MobileElement element){
        waitForElement(element);
        TouchAction actions = new TouchAction(driver);
        actions.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)));
        actions.perform();
    }

    //endregion Mobile Element Methods


    //region List Mobile Elements Methods
    protected String[] returnTextListMobileElements(List<MobileElement> elementList){
        int i = 0;
        String[] allText = new String[elementList.size()];

        for (MobileElement element : elementList) {
            allText[i++] = element.getText();
        }
        return allText;
    }

    protected int returnCountMobileElements(List<MobileElement> elementList){
        return elementList.size();
    }

    protected void clickFirstElementList(List<MobileElement> listElement, String textNotContains){
        waitForElement(listElement.get(0));
        String textElement = "";

        for (MobileElement element : listElement) {
            if(!element.getText().contains(textNotContains)){
                click(element);
                break;
            }
        }
    }

    protected void clickElementInList(List<MobileElement> listElement, int position){
        waitForElement(listElement.get(position));
        click(listElement.get(position));
    }

    protected String clickRandomElementList(List<MobileElement> listElement){
        String textElement = "";

        waitForElement(listElement.get(0));
        Random rand = new Random();
        int position = rand.nextInt(listElement.size());
        MobileElement elementRandom = listElement.get(position);
        textElement = getText(elementRandom);
        click(elementRandom);

        return textElement;
    }

    protected String clickElementList(List<MobileElement> listElement, String textElement){
        waitForElement(listElement.get(0));

        for (MobileElement element : listElement) {
            if(element.getText().equals(textElement)){
                textElement = element.getText();
                click(element);
                break;
            }
        }
        return textElement;
    }

    protected String returnTextFirstElementList(List<MobileElement> listElement, String textNotContains){
        waitForElement(listElement.get(0));
        String textElement = "";

        for (MobileElement element : listElement) {
            if(!element.getText().contains(textNotContains)){
                textElement = element.getText();
                break;
            }
        }
        return textElement;
    }

    //endregion List Mobile Elements Methods


    //region By Locator Methods

    protected int returnCountMobileElements(By locator){
        waitForElement(locator);
        List<MobileElement> mobileElementList = (List<MobileElement>) driver.findElements(locator);
        return mobileElementList.size();
    }

    protected String[] returnTextListMobileElements(By locator){
        int i = 0;
        waitForElement(locator);
        List<MobileElement> mobileElementList = (List<MobileElement>) driver.findElements(locator);
        String[] allText = new String[mobileElementList.size()];

        for (MobileElement element : mobileElementList) {
            allText[i++] = element.getText();
        }

        return allText;
    }

    protected String clickFirstElementList(By locator){
        waitForElement(locator);
        MobileElement mobileElement = (MobileElement) driver.findElements(locator).get(0);
        click(mobileElement);
        return mobileElement.getText();
    }

    protected String clickFirstElementList(By locator, String textNotContains){
        waitForElement(locator);
        String textElement = "";

        List<MobileElement> mobileElementList = (List<MobileElement>) driver.findElements(locator);
        for (MobileElement element : mobileElementList) {
            if(!element.getText().contains(textNotContains)){
                textElement = element.getText();
                click(element);
                break;
            }
        }
        return textElement;
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return text;
    }

    //endregion By Locator Methods


    //region General Methods
    protected void scrolling(String direction){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: scroll", scrollObject);
    }

    protected  void scrollingEntire(){
        MobileElement element = (MobileElement) driver.findElementByClassName("android.widget.ListView");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        scrollObject.put("text", "AUDI");
        js.executeScript("mobile: scrollTo", scrollObject);
    }

    public void topToBottonSwipe() {
        Dimension dim= driver.manage().window().getSize();
        int height=(int) dim.getHeight();
        int width=(int) dim.getWidth();
        int x= width/2;
        int startY=(int) (height*0.80);
        int endY=(int) (height*0.20);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(x,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(x,endY)).release().perform();
    }
    public void swipeToLeft() {
        Dimension dim= driver.manage().window().getSize();
        int height=(int) dim.getHeight();
        int width=(int) dim.getWidth();

        //int startx=(int) (width - ( width * 0.1));
        int startx=(int) (width - ( width * 0.01));
        int endx=(int) ( width * 0.1);
        int startY= (int) (height*0.80);
        int endY=(int) (height*0.80);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startx , startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(endx, endY)).release().perform();

    }
    public void swipeToLeft2() {
        Dimension dim= driver.manage().window().getSize();
        int height=(int) dim.getHeight();
        int width=(int) dim.getWidth();

        //int startx=(int) (width - ( width * 0.1));
        int startx=(int) (width - ( width * 0.01));
        int endx=(int) ( width * 0.1);
        int startY= (int) (height*0.80);
        int endY=(int) (height*0.80);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startx , startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(endx, endY)).release().perform();
    }

    protected boolean ReturnIfTextExistsOnScreen(String text)
    {
        boolean existe = driver.getPageSource().contains(text);
        ExtentReportUtils.addTestInfo(3,"Return: "+existe);
        return existe;
    }

    //Função para realizar scroll somente em Android
    protected MobileElement scrollToElementAndroid(String string){
        return ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+string+"\").instance(0))");
    }



    public String takeScreenShot() {

        String scrShotDir = "screenshots";
        File scrShotDirPath = new File(Utils.returnPathProject()+"\\"+scrShotDir+"\\");
        String destFile;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(scrShotDir).mkdirs();
        destFile = dateFormat.format(new Date()) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile));
        } catch (IOException e) {
            System.out.println("Image not transfered to screenshot folder");
            e.printStackTrace();
        }
        return destFile;
    }

    //endregion General Methods
*/
}
