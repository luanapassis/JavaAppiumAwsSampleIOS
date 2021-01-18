package com.javaAppiumIOS.bases;

import com.javaAppiumIOS.GlobalParameters;
import com.javaAppiumIOS.utils.BuilderAppium;
import com.javaAppiumIOS.utils.DriveFactory;
import com.javaAppiumIOS.utils.ExtentReportUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    private static String log4jConfigurationPath = System.getProperty("user.dir")+"/src/test/java/com.javaAppiumIOS/";
    private WebDriverWait wait;
    private AppiumDriverLocalService service;
    private BuilderAppium builder;


    @BeforeSuite (alwaysRun=true)
    public void beforeSuite(){
        new GlobalParameters();
        ExtentReportUtils.createReport();
        System.setProperty("log4j.configurationFile",log4jConfigurationPath);
    }

    @BeforeMethod (alwaysRun=true)
    public void beforeTest(Method method) throws Exception {
        ExtentReportUtils.addTest(method.getName(), method.getDeclaringClass().getSimpleName());
        DriveFactory.InitApp(method.getName());
        wait = new WebDriverWait(DriveFactory.getDriver(), 10);
    }

    @AfterMethod (alwaysRun=true)
    public void afterTest(ITestResult result){
        ExtentReportUtils.addTestResult(result);
        DriveFactory.getDriver().quit();
    }

    @AfterSuite (alwaysRun=true)
    public void afterSuite(){
        ExtentReportUtils.generateReport();
    }

}

